package kr.co.green.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.MemberBoardDTO;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberBoardServiceImpl;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/form/*")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object MemberDTO = null;

	public FormController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String action = request.getPathInfo();
		String nextPage = "";
		HttpSession session = request.getSession();
		MemberServiceImpl memberService = new MemberServiceImpl();


		if (action.equals("/loginform.do")) { // 홈>로그인페이지 이동
			nextPage = "/views/member/login.jsp";
		} else if (action.equals("/signupform.do")) {
			nextPage = "/views/member/signup.jsp"; // 홈>회원가입페이지 이동
		} else if (action.equals("/memberform.do")) {
			// 로그인한 사용자 정보
			int no = (int) session.getAttribute("no");
			MemberDTO memberDTO = memberService.selectMember(no);
			
			
			// 프로젝트 정보
			// 페이지 번호를 가져옵니다. 페이지 번호가 없는 경우 기본값은 1입니다.
			int cpage = Integer.parseInt(request.getParameter("cpage"));	
	        
	        // 검색 텍스트를 가져옵니다. 검색 텍스트가 없는 경우 기본값은 빈 문자열입니다.
			String searchText = request.getParameter("searchText");
			MemberBoardServiceImpl memberBoardService = new MemberBoardServiceImpl();
	        
	        // 전체 프로젝트 수를 가져옵니다.
			// 컴펌 STATUS = 'Y' 
	        int listCount = memberBoardService.boardProjecYtListCount(searchText, no);

	        // 보여질 페이지 수
	        int pageLimit = 5;

	        // 한 페이지에 들어갈 프로젝트 수
	        int projectLimit = 5;
	        
	        // 페이징 처리
	        Pagination page = new Pagination();

	        PageInfo pi = page.getPageInfo(listCount, cpage, pageLimit, projectLimit);

	        // 프로젝트 목록을 DB에서 가져옵니다.
	        ArrayList<MemberBoardDTO> list = memberBoardService.boardProjecYtList(pi, searchText, no);

	        int row = listCount - (cpage-1) * projectLimit;
	        request.setAttribute("row", row);
	        request.setAttribute("searchText", searchText);
	        request.setAttribute("pi", pi);
	        request.setAttribute("projectList", list);
	        
			request.setAttribute("member", memberDTO);
			nextPage = "/views/member/member.jsp"; // 홈>마이페이지 이동
			
			
		}else if(action.equals("/homeform.do")) {
			
			Integer no = (Integer) session.getAttribute("no");
		    if (no != null) {
		        int intValue = no.intValue();
		 
		        MemberDTO memberDTO = memberService.selectMember(intValue);
		        request.setAttribute("member", memberDTO);
		    }
		    nextPage = "/";  //홈으로 이동 
		}
		
		// 페이지 포워딩
		if (!nextPage.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
	}
	
	
	//클래스 생성해서 메서드로 빼기 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
