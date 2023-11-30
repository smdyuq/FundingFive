package kr.co.green.search.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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
		
		//검색어 테이블에서 검색기록 가져오기
		int memberNo = (int)session.getAttribute("memberNo");
		
		SearchService searchService = new SearchServiceImpl();
		SearchDTO[] memberSearchArr = searchService.getSearchHistory(memberNo);
		
		//프로젝트 테이블에서 인기검색어 가져오기
		String[] popularSearchArr = searchService.getPopularSearch();
		
		request.setAttribute("memberSearchArr", memberSearchArr);
		request.setAttribute("popularSearchArr", popularSearchArr);
		RequestDispatcher view = request.getRequestDispatcher("/views/project/projectSearchResult.jsp");
		view.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}