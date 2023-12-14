package kr.co.green.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/projectDelete.do")
public class ProjectNoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectNoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProjectService projectService = new ProjectServiceImpl();

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		String reason = request.getParameter("reason");

//		거절 버튼 누를시 승인상태 업데이트, 거절 사유 메시지 등록
		if (projectService.projectDelete(projectNo) > 0 &&  projectService.deleteReason(reason, projectNo) > 0) {
			response.sendRedirect("/administratorOk.do?cpage=1");
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}

	}

}
