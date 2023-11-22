package kr.co.green.project.model.service;

import java.sql.Connection;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.project.model.dao.ProjectDAO;
import kr.co.green.project.model.dto.ProjectDTO;

public class ProjectServiceImpl implements ProjectService{
	
	 private Connection con;
	    private DatabaseConnection dc;
	    private ProjectDAO projectDAO;

	    public ProjectServiceImpl() {
	    	projectDAO = new ProjectDAO();
	        dc = new DatabaseConnection();
	        con = dc.connDB();
	    }

	//프로젝트 상세페이지 요소 조회
	@Override
	public void getProjectDetail(ProjectDTO projectDTO) {
		projectDAO.getProjectDetail(con, projectDTO);
	}

	@Override
	public void getProjectManagerDetail(ProjectDTO projectDTO) {
		projectDAO.getProjectManagerDetail(con, projectDTO);		
	}

}
