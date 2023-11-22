package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.MemberDTO;

public interface MemberService {

	// 회원가입
	public int signUp(MemberDTO memberDTO);

	//id중복 체크 
	boolean duplicateId(String id);
	
	//로그인
	MemberDTO memberLogin(String id);
	
	//후원 버튼 클릭 시 로그인 된 회원 정보 가져오기
	MemberDTO memberSelect(int no);
}