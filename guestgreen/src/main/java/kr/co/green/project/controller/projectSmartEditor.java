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
		
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectName(request.getParameter("project-name"));
		projectDTO.setProjectIntroduce(request.getParameter("project-introduce"));
		projectDTO.setProjectKind(request.getParameter("project-kind"));
		projectDTO.setProjectPrice(Integer.parseInt(request.getParameter("project-price")));
		projectDTO.setProjectTargetAmount(Integer.parseInt(request.getParameter("project-target-amount")));
		projectDTO.setProjectEndDate(request.getParameter("project-end-date"));
		projectDTO.setProjectOuterImageName(request.getParameter("project-outer-image-name"));
		projectDTO.setProjectOuterImagePath(request.getParameter("project-outer-image-path"));
		projectDTO.setProjectInnerImageName(request.getParameter("project-inner-image-name"));
		projectDTO.setProjectInnerImagePath(request.getParameter("project-inner-image-path"));
		projectDTO.setProjectContent(request.getParameter("editorTxt"));
		
		
		request.setAttribute("projectDTO", projectDTO);
		RequestDispatcher view = request.getRequestDispatcher("/views/project/projectManagerEnroll.jsp");
		view.forward(request, response);

	}

}
