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

	//좋아요 눌렀을 때 db에 이미 있는지 확인 후 없으면 넣고, 있으면 제거
	public void memberLikeCheck(int memberNo, int projectNo);
}