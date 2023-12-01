package kr.co.green.project.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.project.model.dto.ProjectDTO;

public interface ProjectService {

//	프로젝트 등록 페이지

//	프로젝트 등록
	public int projectEnroll(ProjectDTO projectleeDTO);

//	상세 페이지 이미지 등록
	public int innerimageEnroll(ProjectDTO projectleeDTO2, int projectNo);

//	프로젝트 스토리(상세내용) 페이지

//	프로젝트 스토리(상세내용) 등록
	public int projectContentUpdate(ProjectDTO projectleeDTO, int projectNo);

//	창작자 등록 페이지

//	프로젝트 번호 조회
	public int projectManagerNoSelect();

//	창작자 등록
	public int projectManagerEnroll(ProjectDTO projectleeDTO, int memberNo, int projectNo);

//	관리자 승인 페이지

//	전체 게시글 수
	public int projectListCount();

//	프로젝트 조회
	public ArrayList<ProjectDTO> projectSelect(PageInfo pi);

//	승인페이지 상세보기 페이지

//	승인페이지 상세보기 프로젝트 조회
	public void projectDetail(ProjectDTO leeDTO);

//	승인 버튼 누를시 업데이트
	public int projectUpdate(int projectNo);

//	거절 버튼 누를시 업데이트
	public int projectDelete(int projectNo);

//	거절 사유 메시지 등록
	public int deleteReason(String reason, int projectNo);

	// 프로젝트 상세페이지 요소 조회
	public abstract ProjectDTO getProjectDetail(int projectNo);

	// 프로젝트 마감일 조회(쿼리문에서 DATE타입을 형변환 시켜와야함)
	public abstract void getProjectDday(ProjectDTO projectDTO);

	// 프로젝트 창작자 정보 조회
	public abstract void getProjectManagerDetail(ProjectDTO projectDTO);

	// api로 넘겨주기 위한 프로젝트 이름, 가격 조회
	public abstract ProjectDTO getProjectBasicInfo(int projectNo);

	// 후원 시 PROjECT테이블의 후원자 수, 후원 금액 업데이트
	public abstract int projectUpdate(ProjectDTO projectDTO);

}
