package kr.co.green.project.model.service;

import java.sql.Connection;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.project.model.dao.ProjectDAO;
import kr.co.green.project.model.dto.ProjectDTO;

public class ProjectServiceImpl implements ProjectService {
	private ProjectDAO projectDAO;
	private DatabaseConnection dc;
	private Connection con;

	public ProjectServiceImpl() {
		projectDAO = new ProjectDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	// 프로젝트 상세페이지 요소 조회
	@Override
	public ProjectDTO getProjectDetail(int projectNumber) {
		return projectDAO.getProjectDetail(con, projectNumber);
	}

	// 프로젝트 마감일 조회(쿼리문에서 DATE타입을 형변환 시켜와야함)
	@Override
	public void getProjectDday(ProjectDTO projectDTO) {
				projectDAO.getProjectDday(con, projectDTO);
	}

	// 프로젝트 창작자 정보 조회
	@Override
	public void getProjectManagerDetail(ProjectDTO projectDTO) {
				projectDAO.getProjectManagerDetail(con, projectDTO);
	}

	// api에 보내기 위한 프로젝트 기본정보 조회
	@Override
	public ProjectDTO getProjectBasicInfo(int projectNumber) {
				return projectDAO.getProjectBasicInfo(con, projectNumber);
	}

	// 후원 성공 시 PROJECT테이블 후원자 수, 후원 금액 업데이트
	@Override
	public int projectUpdate(ProjectDTO projectDTO) {
				return projectDAO.projectUpdate(con, projectDTO);
	}
}
