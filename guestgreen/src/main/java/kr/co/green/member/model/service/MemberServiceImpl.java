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
		return memberDAO.memeberLogin(con, id);
	}
	
	//후원 버튼 클릭 시 로그인 된 회원 정보 가져오기
	@Override
	public MemberDTO memberSelect(int no) {
		return memberDAO.memberSelect(con, no);
	} 
}










