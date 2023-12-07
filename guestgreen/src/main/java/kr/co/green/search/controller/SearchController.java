package kr.co.green.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.search.model.service.SearchService;
import kr.co.green.search.model.service.SearchServiceImpl;

@WebServlet("/projectSearch.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord");
		SearchService searchService = new SearchServiceImpl();
//		ArrayList<ProjectDTO> searchedProjectList = searchService.getSearchedProject(searchWord);
		
//		request.setAttribute("list", searchedProjectList);
//		RequestDispatcher view = request.getRequestDispatcher("/");
//		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
