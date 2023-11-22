package kr.co.green.project.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/ProjectDetailController")
public class ProjectDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int projectNumber = Integer.parseInt(request.getParameter("project-no"));
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectNumber(projectNumber);
		
		//프로젝트 상세페이지에 들어갈 요소 불러오기
		ProjectService projectService = new ProjectServiceImpl();
		projectService.getProjectDetail(projectDTO);
		
		if(!Objects.isNull(projectDTO.getProjectName())) {
			projectService.getProjectManagerDetail(projectDTO);
			if(!Objects.isNull(projectDTO.getProjectManagerName())) {
				System.out.println("project, project_inner_image, project_manager테이블 갖고오기 성공");
				request.setAttribute("projectDTO", projectDTO);
				RequestDispatcher view = request.getRequestDispatcher("/views/project/projectDetail.jsp");
				view.forward(request, response);
			}else {
				AlertAndRedirect.alertRedirect(response, "project_manager테이블 갖고오기 실패", "메인페이지로 보내기");
			}
		}else {
			AlertAndRedirect.alertRedirect(response, "project테이블또는 project_inner_image테이블 갖고오기 실패", "메인페이지로 보내기");
		}
		
		
	}

}







