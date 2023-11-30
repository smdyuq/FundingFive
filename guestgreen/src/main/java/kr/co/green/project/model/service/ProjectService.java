package kr.co.green.project.model.service;

import kr.co.green.project.model.dto.ProjectDTO;

public interface ProjectService {

	//프로젝트 상세페이지 요소 조회
	public abstract ProjectDTO getProjectDetail(int projectNo);
	
	//프로젝트 마감일 조회(쿼리문에서 DATE타입을 형변환 시켜와야함)
	public abstract void getProjectDday(ProjectDTO projectDTO);
	
	//프로젝트 창작자 정보 조회
	public abstract void getProjectManagerDetail(ProjectDTO projectDTO);
	
	//api로 넘겨주기 위한 프로젝트 이름, 가격 조회
	public abstract ProjectDTO getProjectBasicInfo(int projectNo);

	//후원 시 PROjECT테이블의 후원자 수, 후원 금액 업데이트
	public abstract int projectUpdate(ProjectDTO projectDTO);

}
