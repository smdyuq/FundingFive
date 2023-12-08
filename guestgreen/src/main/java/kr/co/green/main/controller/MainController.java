package kr.co.green.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.main.model.service.MainServiceImpl;
import kr.co.green.project.model.dto.ProjectDTO;

@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MainServiceImpl mainService = new MainServiceImpl();
		
		String[] nameArr = {"banner", "noteWorthy", "popularity", "deadLine", "recentProject", 
				"recommended", "newProject", "completeProject", "todayProject"};
		
		ArrayList<ProjectDTO>[] arr = new ArrayList[9];
		
		for(int i=0; i<arr.length; i++ ) {
			arr[i] = new ArrayList<ProjectDTO>();
		}
		
		mainService.projectSelect(arr);
		
		for(int i=0; i<arr.length; i++) {
			request.setAttribute(nameArr[i], arr[i]);
		}
		
		
		
		
		// list

////       배너 조회 list   
//		request.setAttribute("banner", banner);
//
////       주목할만한 프로젝트 조회 list      
//		request.setAttribute("noteworthy", noteworthy);
//
////      인기 프로젝트 조회 list
//		request.setAttribute("popularity", popularity);
//
////      마감 임박 프로젝트 조회 list
//		request.setAttribute("Deadline", Deadline);
//
////      최근 본 프로젝트 조회 list
//		request.setAttribute("recentProject", recentProject);
//
////      이런 프로젝트 어때요 조회 list
//		request.setAttribute("Recommended", Recommended);
//
////      신규 프로젝트 조회 list
//		request.setAttribute("newProject", newProject);
//
////      공개 예정 프로젝트 조회 list
//		request.setAttribute("completeProject", completeProject);
//
////      오늘 오픈한 프로젝트 조회 list
//		request.setAttribute("todayProject", todayProject);

		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}