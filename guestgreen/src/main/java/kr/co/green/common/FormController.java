package kr.co.green.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.MemberDTO;
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

		if (action.equals("/loginform.do")) { // 홈>로그인페이지 이동
			nextPage = "/views/member/login.jsp";
		} else if (action.equals("/signupform.do")) {
			nextPage = "/views/member/signup.jsp"; // 홈>회원가입페이지 이동
		} else if (action.equals("/memberform.do")) {

			int no = (int) session.getAttribute("no");

			MemberServiceImpl memberService = new MemberServiceImpl();

			MemberDTO memberDTO = memberService.selectMember(no);

			request.setAttribute("member", memberDTO);
			nextPage = "/views/member/member.jsp"; // 홈>마이페이지 이동
		}
//		else if(action.equals("/homeform.do")) {
//			
//			Integer no = (Integer) session.getAttribute("no");
//		    if (no != null) {
//		        int intValue = no.intValue();
//		        MemberServiceImpl memberService = new MemberServiceImpl();
//		        MemberDTO memberDTO = memberService.selectMember(intValue);
//		        request.setAttribute("member", memberDTO);
//		    }
//		    nextPage = "/";  //홈으로 이동 
//		}
		
		// 페이지 포워딩
		if (!nextPage.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
