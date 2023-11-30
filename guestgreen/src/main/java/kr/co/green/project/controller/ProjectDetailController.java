package kr.co.green.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

@WebServlet("/projectAdministrator.do")
public class ProjectDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int projectNo = Integer.parseInt(request.getParameter("project-no"));
		ProjectDTO projectDTO;
		
		//프로젝트 상세페이지에 들어갈 요소 불러오기
		ProjectService projectService = new ProjectServiceImpl();
		projectDTO = projectService.getProjectDetail(projectNo);
		
		if(!Objects.isNull(projectDTO)) {
			
			projectService.getProjectDday(projectDTO);
			if(!Objects.isNull(projectDTO.getProjectEndDate())) {
				
				String registerDate = projectDTO.getProjectRegisterDate(); // 가져온 날짜 문자열
				String endDate = projectDTO.getProjectEndDate(); // 가져온 날짜 문자열

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		        LocalDate endDateLocalDateType = LocalDate.parse(endDate, formatter);
		        LocalDate currentDate = LocalDate.now();

		        long dDay = ChronoUnit.DAYS.between(currentDate, endDateLocalDateType);
		        
		        projectDTO.setProjectRegisterDate(registerDate);
		        projectDTO.setProjectEndDate(endDate);
		        projectDTO.setProjectRemainDate(dDay);
				
				projectService.getProjectManagerDetail(projectDTO);
				
				if(!Objects.isNull(projectDTO.getProjectManagerName())) {
					request.setAttribute("projectDTO", projectDTO);
					RequestDispatcher view = request.getRequestDispatcher("/views/project/projectDetail.jsp");
					view.forward(request, response);
				}
			}
		}
		AlertAndRedirect.alertRedirect(response, "프로젝트 상세페이지 조회 실패", "/");
	}

}







