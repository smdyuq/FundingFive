package kr.co.green.projectlee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.projectlee.dto.ProjectleeDTO;
import kr.co.green.projectlee.service.ProjectleeserviceImpl;

@WebServlet("/projectManagerEnroll.do")
public class ProjectManagerEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectManagerEnrollController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		String projectManagerName = request.getParameter("project-manager-name");
		String projectManagerIntroduce = request.getParameter("project-manager-introduce");
		String projectManagerAccount = request.getParameter("project-manager-account");
		int no = (int) session.getAttribute("no");

		ProjectleeDTO projectleeDTO = new ProjectleeDTO();

		projectleeDTO.setManagerName(projectManagerName);
		projectleeDTO.setManagerIntroduce(projectManagerIntroduce);
		projectleeDTO.setManagerAccount(projectManagerAccount);

		ProjectleeserviceImpl projectleeservice = new ProjectleeserviceImpl();

//		프로젝트 번호 조회
		projectleeDTO = projectleeservice.projectManagerNoSelect(projectleeDTO);

//		창작자 등록
		int result2 = projectleeservice.projectManagerEnroll(projectleeDTO, no);

		if (result2 > 0) {
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/views/common/error.jsp");

		}
	}

}
