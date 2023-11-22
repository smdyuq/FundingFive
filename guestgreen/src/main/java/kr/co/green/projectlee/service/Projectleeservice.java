package kr.co.green.projectlee.service;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.projectlee.dto.ProjectleeDTO;

public interface Projectleeservice {

//	프로젝트 등록
	public int projectEnroll(ProjectleeDTO projectleeDTO);
	
//	창작자 등록
	public int projectManagerEnroll(ProjectleeDTO projectleeDTO, int no);
	
//	프로젝트 번호 조회
	public ProjectleeDTO projectManagerNoSelect(ProjectleeDTO projectleeDTO);
	
}
