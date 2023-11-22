package kr.co.green.projectlee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;
import kr.co.green.projectlee.dto.ProjectleeDTO;
import kr.co.green.projectlee.service.ProjectleeserviceImpl;

@WebServlet("/projectEnroll.do")
public class ProjectEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectEnrollController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String projectName = request.getParameter("project-name");
		String projectIntroduce = request.getParameter("project-introduce");
		String projectContent = request.getParameter("project-content");
		String projectKind = request.getParameter("project-kind");
		int projectPrice = Integer.parseInt(request.getParameter("project-price"));
		int projectTargetAmount = Integer.parseInt(request.getParameter("project_target_amount"));

		String projectEndDate = request.getParameter("project-end-date");

		ProjectleeDTO projectleeDTO = new ProjectleeDTO();

		projectleeDTO.setProjectName(projectName);
		projectleeDTO.setProjectIntroduce(projectIntroduce);
		projectleeDTO.setProjectContent(projectContent);
		projectleeDTO.setProjectKind(projectKind);
		projectleeDTO.setProjectPrice(projectPrice);
		projectleeDTO.setProjectTargetAmount(projectTargetAmount);

		projectleeDTO.setProjectEndDate(projectEndDate);

		ProjectleeserviceImpl projectleeservice = new ProjectleeserviceImpl();
		
//		프로젝트 등록
		int result1 = projectleeservice.projectEnroll(projectleeDTO);

		if (result1 > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/project/projectManagerEnroll.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}

	}
}
