package kr.co.green.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.search.model.dto.SearchDTO;
import kr.co.green.search.model.service.SearchService;
import kr.co.green.search.model.service.SearchServiceImpl;

@WebServlet("/searchForm.do")
public class SearchFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchFormController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		SearchService searchService = new SearchServiceImpl();
		//검색어 테이블에서 검색기록 가져오기
		int memberNo = 0;
		if(session.getAttribute("memberNo") != null) {			//세션에 memberNo가 있다면 검색기록을 가져옴
			memberNo = (int)session.getAttribute("memberNo");
			
			// 검색어 옆 x 누르면 자바스크립트에서 status를 변수로 보냄
			if(request.getParameter("status").equals("delete")) {
				int result = searchService.deleteSearchHistory(Integer.parseInt(request.getParameter("searchNo")));
				if(result>0) {
					return;
				}
				else {
					System.out.println("오류");
				}
			}
			ArrayList<SearchDTO> memberSearchArr = searchService.getSearchHistory(memberNo);
			request.setAttribute("memberSearchArr", memberSearchArr);
		}
		
		//프로젝트 테이블에서 인기검색어 가져오기
		SearchDTO[] popularSearchArr = searchService.getPopularSearch();
		request.setAttribute("popularSearchArr", popularSearchArr);
		RequestDispatcher view = request.getRequestDispatcher("/views/project/projectSearchForm.jsp");
		view.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
