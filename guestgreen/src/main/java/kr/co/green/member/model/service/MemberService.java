package kr.co.green.member.model.service;



import kr.co.green.member.model.dto.MemberDTO;

public interface MemberService {

	// 회원가입
	public int memberSignUp(MemberDTO memberDTO);

	//id중복 체크 
	boolean duplicateMemberId(String memberId);
	
	//로그인
	MemberDTO memberLogin(String memberId);
	
	//회원조회 
	MemberDTO memberSelect(int memberNo);

	//회원 정보 수정 
	int memberUpdate(MemberDTO memberDTO, int memberNo);

	//회원 탈퇴 
	int memberDelete(int memberNo);

	//좋아요 메소드
	public int memberLike(int memberNo, int projectNo);



}