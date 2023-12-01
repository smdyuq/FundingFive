package kr.co.green.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/smartEditor.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 5 * 5 // 25MB
)
public class projectSmartEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public projectSmartEditor() {
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

		int memberNo = (int) session.getAttribute("memberNo");
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberDTO memberDTO = memberService.memberSelect(memberNo);
		request.setAttribute("memberDTO", memberDTO);

		String projectContent = request.getParameter("editorTxt");

		ProjectService projectservice = new ProjectServiceImpl();

		ProjectDTO projectleeDTO = new ProjectDTO();
		projectleeDTO.setProjectContent(projectContent);

		int projectNo = projectservice.projectManagerNoSelect();

//		프로젝트 스토리(상세내용) 등록
		int result = projectservice.projectContentUpdate(projectleeDTO, projectNo);

		if (result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/project/projectManagerEnroll.jsp");

			view.forward(request, response);
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}

	}

}
