package kr.co.green.projectlee.service;

import java.sql.Connection;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.projectlee.dao.ProjectleeDAO;
import kr.co.green.projectlee.dto.ProjectleeDTO;

public class ProjectleeserviceImpl implements Projectleeservice {
	private Connection con;
	private DatabaseConnection dc;
	private ProjectleeDAO projectleeDAO;

	public ProjectleeserviceImpl() {
		projectleeDAO = new ProjectleeDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

//	프로젝트 등록
	@Override
	public int projectEnroll(ProjectleeDTO projectleeDTO) {
		return projectleeDAO.projectEnroll(con, projectleeDTO);
	}

//	창작자 등록
	@Override
	public int projectManagerEnroll(ProjectleeDTO projectleeDTO, int no) {
		return projectleeDAO.projectManagerEnroll(con, projectleeDTO, no);
	}

//	프로젝트 번호 조회
	@Override
	public ProjectleeDTO projectManagerNoSelect(ProjectleeDTO projectleeDTO) {
		return projectleeDAO.projectManagerNoSelect(con, projectleeDTO);
	}

}
