package kr.co.green.search.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//검색 테이블에 검색결과 저장
		HttpSession session = request.getSession();
		//로그인 / 비로그인 구분
		int memberNo = 0;
		if(!Objects.isNull(session.getAttribute("memberNo"))) {
			memberNo = (int)session.getAttribute("memberNo");
		}
		
		SearchService searchService = new SearchServiceImpl();

		
		searchService.searchWordEnroll(searchWord, memberNo);
		
		ArrayList<ProjectDTO> searchedProjectList = new ArrayList<>();
		searchService.getSearchedProject(searchWord, searchedProjectList);
		
		//디데이 계산
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate currentDate = LocalDate.now();
		
		for(int i=0; i<searchedProjectList.size(); i++) {
			String endDate = searchedProjectList.get(i).getProjectEndDate();
			LocalDate endDateLocalDateType = LocalDate.parse(endDate, formatter);
			long dDay = ChronoUnit.DAYS.between(currentDate, endDateLocalDateType);
			searchedProjectList.get(i).setProjectEndDate(endDate);
			searchedProjectList.get(i).setProjectRemainDate(dDay);
		}
		
		int searchCount = searchService.getSearchedCount(searchWord);
		
		request.setAttribute("searchedProjectList", searchedProjectList);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("searchCount", searchCount);
		RequestDispatcher view = request.getRequestDispatcher("/views/project/projectSearchResult.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
