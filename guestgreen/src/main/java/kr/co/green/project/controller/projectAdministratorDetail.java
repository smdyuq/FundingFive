package kr.co.green.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/projectAdministrator.do")
public class projectAdministratorDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public projectAdministratorDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("asd");
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		System.out.println(projectNo);

		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectNo(projectNo);

		ProjectService projectService = new ProjectServiceImpl();

//		승인페이지 상세보기 프로젝트 조회
		projectService.projectDetail(projectDTO);

		// administratorOkPage로 포워딩
		request.setAttribute("projectDTO", projectDTO);
		RequestDispatcher view = request.getRequestDispatcher("/views/project/administratorOkPage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
