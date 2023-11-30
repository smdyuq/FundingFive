package kr.co.green.projectlee.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.projectlee.PageInfo;
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

//	프로젝트 등록 페이지

//	프로젝트 등록
	@Override
	public int projectEnroll(ProjectleeDTO projectleeDTO) {
		return projectleeDAO.projectEnroll(con, projectleeDTO);
	}

//	상세 페이지 이미지 등록
	@Override
	public int innerimageEnroll(ProjectleeDTO projectleeDTO2, int projectNo) {
		return projectleeDAO.innerimageEnroll(con, projectleeDTO2, projectNo);
	}

//	프로젝트 스토리(상세내용) 페이지

//	프로젝트 스토리(상세내용) 등록
	@Override
	public int projectContentUpdate(ProjectleeDTO projectleeDTO, int projectNo) {
		return projectleeDAO.projectContentUpdate(con, projectleeDTO, projectNo);
	}

//	창작자 등록 페이지

//	프로젝트 번호 조회
	@Override
	public int projectManagerNoSelect() {
		return projectleeDAO.projectManagerNoSelect(con);
	}

//	창작자 등록
	@Override
	public int projectManagerEnroll(ProjectleeDTO projectleeDTO, int no, int projectNo) {
		return projectleeDAO.projectManagerEnroll(con, projectleeDTO, no, projectNo);
	}

//	관리자 승인 페이지

//	전체 게시글 수
	@Override
	public int projectListCount() {
		return projectleeDAO.projectListCount(con);
	}

//	프로젝트 조회
	@Override
	public ArrayList<ProjectleeDTO> projectSelect(PageInfo pi) {
		return projectleeDAO.projectSelect(con, pi);
	}

//	승인페이지 상세보기 페이지

//	승인페이지 상세보기 프로젝트 조회
	@Override
	public void projectDetail(ProjectleeDTO leeDTO) {
		projectleeDAO.projectDetail(con, leeDTO);
	}

//	승인 버튼 누를시 업데이트
	@Override
	public int projectUpdate(int projectNo) {
		return projectleeDAO.projectUpdate(con, projectNo);
	}

//	거절 버튼 누를시 업데이트
	@Override
	public int projectDelete(int projectNo) {
		return projectleeDAO.projectDelete(con, projectNo);
	}

//	거절 사유 메시지 등록
	@Override
	public int deleteReason(String reason, int projectNo) {
		return projectleeDAO.deleteReason(con, reason, projectNo);
	}
}
