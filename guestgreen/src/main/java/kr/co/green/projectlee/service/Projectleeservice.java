package kr.co.green.projectlee.service;

import java.util.ArrayList;

import kr.co.green.projectlee.PageInfo;
import kr.co.green.projectlee.dto.ProjectleeDTO;

public interface Projectleeservice {

//	프로젝트 등록 페이지

//	프로젝트 등록
	public int projectEnroll(ProjectleeDTO projectleeDTO);

//	상세 페이지 이미지 등록
	public int innerimageEnroll(ProjectleeDTO projectleeDTO2, int projectNo);

//	프로젝트 스토리(상세내용) 페이지

//	프로젝트 스토리(상세내용) 등록
	public int projectContentUpdate(ProjectleeDTO projectleeDTO, int projectNo);

//	창작자 등록 페이지

//	프로젝트 번호 조회
	public int projectManagerNoSelect();

//	창작자 등록
	public int projectManagerEnroll(ProjectleeDTO projectleeDTO, int no, int projectNo);

//	관리자 승인 페이지

//	전체 게시글 수
	public int projectListCount();

//	프로젝트 조회
	public ArrayList<ProjectleeDTO> projectSelect(PageInfo pi);

//	승인페이지 상세보기 페이지

//	승인페이지 상세보기 프로젝트 조회
	public void projectDetail(ProjectleeDTO leeDTO);

//	승인 버튼 누를시 업데이트
	public int projectUpdate(int projectNo);

//	거절 버튼 누를시 업데이트
	public int projectDelete(int projectNo);
	
//	거절 사유 메시지 등록
	public int deleteReason(String reason, int projectNo);

}
