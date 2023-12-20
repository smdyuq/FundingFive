package kr.co.green.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/projectUpdate.do")
public class ProjectYesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectYesController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProjectService projectService = new ProjectServiceImpl();

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		

//		승인 버튼 누를시 업데이트
		if (projectService.projectUpdate(projectNo) > 0) {
			System.out.println(projectService.projectUpdate(projectNo));
			response.sendRedirect("/administratorOk.do?menu=first&cpage=1");
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}
	}

}
