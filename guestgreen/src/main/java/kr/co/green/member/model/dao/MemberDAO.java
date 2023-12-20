package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.member.model.dto.MemberDTO;


public class MemberDAO {

	private PreparedStatement pstmt;
	
	// 회원가입
	public int memberSignUp(Connection con, MemberDTO memberDTO) {
		
		String query = "INSERT INTO member "
				+ "		VALUES(member_no_seq.nextval, ?, ?, ?, ?, ?, sysdate, NULL, 1, NULL)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, memberDTO.getMemberId());
			pstmt.setString(2, memberDTO.getMemberPwd());
			pstmt.setString(3, memberDTO.getMemberName());
			pstmt.setString(4, memberDTO.getMemberPhone());
			pstmt.setString(5, memberDTO.getMemberAddr());
			
			result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//id중복 체크 
	public boolean duplicateMemberId(Connection con, String memberId) {
		String query ="SELECT member_id FROM member "
				+"     WHERE member_id = ? ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//로그인 
	public MemberDTO memberLogin(Connection con, String memberId) {
		String query = "SELECT member_no, member_pwd, member_name, member_type" 
				+ "    FROM member" 
				+ "    WHERE member_Id= ?";

		MemberDTO result = new MemberDTO(); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			// 쿼리 실행
			ResultSet rs = pstmt.executeQuery(); 

			while (rs.next()) {
				result.setMemberNo(rs.getInt("MEMBER_NO"));
				result.setMemberPwd(rs.getString("MEMBER_PWD"));
				result.setMemberName(rs.getString("MEMBER_NAME"));
				result.setMemberType(rs.getInt("MEMBER_TYPE"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return result;
	}

	//회원정보 조회
	public MemberDTO memberSelect(Connection con, int mebmerNo) {
		String query = "SELECT * "
				+"	   FROM member"
				+"     WHERE member_no = ?";  
		
		MemberDTO result = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(query); 
			pstmt.setInt(1, mebmerNo);
			
			ResultSet rs = pstmt.executeQuery(); 
			
			while(rs.next()) { 
				result.setMemberNo(rs.getInt("MEMBER_NO"));
				result.setMemberId(rs.getString("MEMBER_ID")); 
				result.setMemberPwd(rs.getString("MEMBER_PWD"));
				result.setMemberName(rs.getString("MEMBER_NAME"));
				result.setMemberPhone(rs.getString("MEMBER_PHONE"));
				result.setMemberAddr(rs.getString("MEMBER_ADDR"));
				result.setMemberCreateDate(rs.getString("MEMBER_Create_Date"));
				result.setMemberUpdateDate(rs.getString("MEMBER_Update_Date"));
				result.setMemberType(rs.getInt("MEMBER_TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//회원 정보 수정 
	public int memberUpdate(Connection con, MemberDTO memberDTO, int no) {
	    String query = "UPDATE MEMBER "
	            + "SET member_id = ?,"
	            + "    member_name = ?,"
	            + "    member_phone = ?,"
	            + "    member_addr = ?, "
	            + "    MEMBER_UPDATE_DATE = SYSDATE"
	            + "    WHERE member_no = ?";
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        pstmt.setString(1, memberDTO.getMemberId());
	        pstmt.setString(2, memberDTO.getMemberName());
	        pstmt.setString(3, memberDTO.getMemberPhone());
	        pstmt.setString(4, memberDTO.getMemberAddr());
	        pstmt.setInt(5, no);
	        
	        int result = pstmt.executeUpdate();
	        return result;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

	//회원탈퇴 
	public int memberDelete(Connection con, int memberNo) {
		
		String query = "DELETE FROM MEMBER"
				+ "     WHERE member_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//좋아요 눌렀을 때 db에 이미 있는지 확인 후 없으면 넣고, 있으면 제거
	public void memberLikeCheck(Connection con, int memberNo, int projectNo) {
		String query = "SELECT like_no from user_likes"
				+ "		WHERE member_no = ? AND project_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, projectNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberLikeDelete(con, memberNo, projectNo);
			}else {
				memberLikeInsert(con, memberNo, projectNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//관심프로젝트 추가 메소드
	public int memberLikeInsert(Connection con, int memberNo, int projectNo) {
		String query = "INSERT INTO USER_LIKES "
				+ "		VALUES(USER_LIKES_NO_SEQ.nextval, ?, ?)";
		
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, projectNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//관심프로젝트 제거 메소드
	public int memberLikeDelete(Connection con, int memberNo, int projectNo) {
		String query = "DELETE USER_LIKES "
				+ "		WHERE member_no = ? AND project_NO = ?";
		
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, projectNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}








