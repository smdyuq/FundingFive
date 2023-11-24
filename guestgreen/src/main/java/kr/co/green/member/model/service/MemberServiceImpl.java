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
    public int signUp(MemberDTO memberDTO) {
        return memberDAO.signUp(con, memberDTO);
    }
   
	//아이디 중복검사 
	@Override
	public boolean duplicateId(String id) {
		return memberDAO.duplicateId(con, id);
		
	}

	//로그인 
	@Override
	public MemberDTO memberLogin(String id) {
		return memberDAO.memberLogin(con, id);
	}
	
	
	//회원 정보 조회
	@Override
	public MemberDTO selectMember(int no) {
		return memberDAO.selectMember(con, no);
	}

	
	//회원 정보 수정
	@Override
	public int updateMember(MemberDTO memberDTO, int no) {
		return memberDAO.updateMember(con, memberDTO, no);
	}
	
	//회원 탈퇴 
	@Override
	public int deleteUpdate(MemberDTO memberDTO, int sessionId) {
		return memberDAO.deleteUpdate(con, memberDTO, sessionId);
	}
	

}










