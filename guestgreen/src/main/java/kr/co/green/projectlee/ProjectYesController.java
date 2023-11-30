package kr.co.green.projectlee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.projectlee.service.ProjectleeserviceImpl;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ProjectleeserviceImpl projectleeservice = new ProjectleeserviceImpl();

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

//		승인 버튼 누를시 업데이트
		int result = projectleeservice.projectUpdate(projectNo);

		if (result > 0) {
			response.sendRedirect("/administratorOk.do?cpage=1");
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}
	}

}
