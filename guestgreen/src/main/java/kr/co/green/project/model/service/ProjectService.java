package kr.co.green.project.model.service;

import kr.co.green.project.model.dto.ProjectDTO;

public interface ProjectService {

	//프로젝트 상세페이지 요소 조회
	public abstract void getProjectDetail(ProjectDTO projectDTO);
	
	//프로젝트 창작자 정보 조회
	public abstract void getProjectManagerDetail(ProjectDTO projectDTO);


}
