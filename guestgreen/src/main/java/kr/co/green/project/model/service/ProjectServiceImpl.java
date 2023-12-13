package kr.co.green.project.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;
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

//	프로젝트 등록 페이지

//	프로젝트 등록
	@Override
	public int projectEnroll(ProjectDTO projectDTO) {
		return projectDAO.projectEnroll(con, projectDTO);
	}

//	상세 페이지 이미지 등록
	@Override
	public int innerimageEnroll(ProjectDTO projectDTO, int projectNo) {
		return projectDAO.innerimageEnroll(con, projectDTO, projectNo);
	}

//	창작자 등록 페이지

//	프로젝트 번호 조회
	@Override
	public int projectNoSelect() {
		return projectDAO.projectNoSelect(con);
	}

//	창작자 등록
	@Override

	public int projectManagerEnroll(ProjectDTO projectDTO, int memberNo, int projectNo) {
		return projectDAO.projectManagerEnroll(con, projectDTO, memberNo, projectNo);

	}

//	관리자 승인 페이지

//	전체 게시글 수
	@Override
	public int projectListCount() {
		return projectDAO.projectListCount(con);
	}

//	프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> projectSelect(PageInfo pi) {
		return projectDAO.projectSelect(con, pi);
	}

//	승인페이지 상세보기 페이지

//	승인페이지 상세보기 프로젝트 조회
	@Override
	public void projectDetail(ProjectDTO projectDTO) {
		projectDAO.projectDetail(con, projectDTO);
	}

//	승인 버튼 누를시 업데이트
	@Override
	public int projectUpdate(int projectNo) {
		return projectDAO.projectUpdate(con, projectNo);
	}

//	거절 버튼 누를시 업데이트
	@Override
	public int projectDelete(int projectNo) {
		return projectDAO.projectDelete(con, projectNo);
	}

//	거절 사유 메시지 등록
	@Override
	public int deleteReason(String reason, int projectNo) {
		return projectDAO.deleteReason(con, reason, projectNo);
	}

	// 프로젝트 상세페이지 요소 조회
	@Override
	public ProjectDTO getProjectDetail(int projectNo) {
		return projectDAO.getProjectDetail(con, projectNo);
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
	public ProjectDTO getProjectBasicInfo(int projectNo) {
		return projectDAO.getProjectBasicInfo(con, projectNo);
	}

	// 후원 성공 시 PROJECT테이블 후원자 수, 후원 금액 업데이트
	@Override
	public int projectUpdate(ProjectDTO projectDTO) {
		return projectDAO.projectUpdate(con, projectDTO);
	}

	//기한 만료된 프로젝트 중 달성률 100 미만 조회(관리자)
	@Override
	public ArrayList<ProjectDTO> getFailedProjects(PageInfo pi) {
		return projectDAO.getFailedProjects(con, pi);
	}

	//기한 만료된 프로젝트 중 달성률 100 이상 조회(관리자)
	@Override
	public ArrayList<ProjectDTO> getSuccessfulProjects(PageInfo pi) {
		return projectDAO.getSuccessfulProjects(con, pi);
	}

	//프로젝트 창작자 이메일 조회
	@Override
	public String getProjectManagerEmail(int projectNo) {
		return projectDAO.getProjectManagerEmail(con, projectNo);
	}

	//만료된 프로젝트 승인유무 'N'
	@Override
	public void projectExpire(int projectNo) {
		projectDAO.projectExpire(con, projectNo);
	}
	// 조회수 증가
	@Override
	public int projectUpdateViews(int projectNo) {
		return projectDAO.projectUpdateViews(con, projectNo);
	}

	// 최근 프로젝트 등록
	@Override
	public int recentProject(int projectNo, int memberNo) {
		return projectDAO.recentProject(con, projectNo, memberNo);
	}

	//찜한 프로젝트 조회
	@Override
	public void getUserWishList(int memberNo, ArrayList<ProjectDTO> projectLikedList) {
		projectDAO.getUserWhisList(con, memberNo, projectLikedList);
	}

}
