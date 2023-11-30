package kr.co.green.projectlee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.projectlee.service.ProjectleeserviceImpl;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ProjectleeserviceImpl projectleeservice = new ProjectleeserviceImpl();

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

//		거절 버튼 누를시 업데이트
		int result1 = projectleeservice.projectDelete(projectNo);

		String reason = request.getParameter("reason");

//		거절 사유 메시지 등록
		int result2 = projectleeservice.deleteReason(reason, projectNo);

		if (result1 > 0 && result2 > 0) {
			response.sendRedirect("/administratorOk.do?cpage=1");
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}

	}

}
