package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.MemberDTO;

public interface MemberService {

	// 회원가입
	public int signUp(MemberDTO memberDTO);

	//id중복 체크 
	boolean duplicateId(String id);
	
	//로그인
	MemberDTO memberLogin(String id);

	//회원조회 
	MemberDTO selectMember(int no);

	//회원 정보 수정 
	int updateMember(MemberDTO memberDTO, int no);

	//회원 탈퇴 
	int deleteUpdate(MemberDTO memberDTO, int sessionId);


	
	

	
}