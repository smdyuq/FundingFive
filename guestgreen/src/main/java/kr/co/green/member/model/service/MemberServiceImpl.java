package kr.co.green.member.model.service;

import java.sql.Connection;
import kr.co.green.common.DatabaseConnection;
import kr.co.green.member.model.dao.MemberDAO;
import kr.co.green.member.model.dto.MemberDTO;


public class MemberServiceImpl implements MemberService {

    private Connection con;
    private DatabaseConnection dc;
    private MemberDAO memberDAO;

    public MemberServiceImpl() {
        memberDAO = new MemberDAO();
        dc = new DatabaseConnection();
        con = dc.connDB();
    }
    
    // 회원가입
    @Override
    public int memberSignUp(MemberDTO memberDTO) {
        return memberDAO.memberSignUp(con, memberDTO);
    }
   
	//아이디 중복검사 
	@Override
	public boolean duplicateMemberId(String memberId) {
		return memberDAO.duplicateMemberId(con, memberId);
	}

	//로그인 
	@Override
	public MemberDTO memberLogin(String memberId) {
		return memberDAO.memberLogin(con, memberId);
	}
	
	//회원 정보 조회
	@Override
	public MemberDTO memberSelect(int mebmerNo) {
		return memberDAO.memberSelect(con, mebmerNo);
	}
	
	//회원 정보 수정
	@Override
	public int memberUpdate(MemberDTO memberDTO, int no) {
		return memberDAO.memberUpdate(con, memberDTO, no);
	}
	
	//회원 탈퇴 
	@Override
	public int memberDelete(int memberNo) {
		return memberDAO.memberDelete(con, memberNo);
	}

	//좋아요 메소드
	@Override
	public int memberLike(int memberNo, int projectNo) {
		return memberDAO.memberLike(con, memberNo, projectNo);
	}

}










