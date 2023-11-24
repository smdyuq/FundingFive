package kr.co.green.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.common.PageInfo;
import kr.co.green.common.Pagination;
import kr.co.green.member.model.dto.MemberBoardDTO;
import kr.co.green.member.model.service.MemberBoardServiceImpl;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/projectList.do")
public class ProjectContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object memberBoardService;

	public ProjectContorller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		MemberBoredDTO mb = new MemberBoredDTO();
//		
//		// 페이지 번호를 가져옵니다. 페이지 번호가 없는 경우 기본값은 1입니다.
//		int cpage = Integer.parseInt(request.getParameter("cpage"));	
//        
//        // 검색 텍스트를 가져옵니다. 검색 텍스트가 없는 경우 기본값은 빈 문자열입니다.
//		String searchText = request.getParameter("searchText");
//		MemberBoardServiceImpl memberBoardServiceImpl = new MemberBoardServiceImpl();
//        
//        // 전체 프로젝트 수를 가져옵니다.
//        int listCount = memberBoardService.boardProjecYtListCount(searchText);
//
//        // 보여질 페이지 수
//        int pageLimit = 5;
//
//        // 한 페이지에 들어갈 프로젝트 수
//        int projectLimit = 5;
//        
//        // 페이징 처리
//        Pagination page = new Pagination();
//
//        PageInfo pi = page.getPageInfo(listCount, cpage, pageLimit, projectLimit);
//
//        // 프로젝트 목록을 DB에서 가져옵니다.
//        ArrayList<MemberBoredDTO> list = memberBoardService.boardProjecYtList(pi, searchText);
//
//        int row = listCount - (cpage-1) * projectLimit;
//        request.setAttribute("row", row);
//        
//        request.setAttribute("searchText", searchText);
//        request.setAttribute("pi", pi);
//        request.setAttribute("list", list);
        RequestDispatcher view = request.getRequestDispatcher("/views/project/projectList.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
