package kr.co.green.search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.search.model.service.SearchService;
import kr.co.green.search.model.service.SearchServiceImpl;

@WebServlet("/deleteSearchHistory.do")
public class SearchHistoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchHistoryDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchNo = Integer.parseInt(request.getParameter("searchNo"));
		
		SearchService searchService = new SearchServiceImpl();
		if(searchService.deleteSearchHistory(searchNo) > 0) {
			response.sendRedirect("/searchForm.do");
		}else {
			System.out.println("검색어 삭제 실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
