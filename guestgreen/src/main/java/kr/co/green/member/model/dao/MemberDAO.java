package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.member.model.dto.MemberDTO;


public class MemberDAO {

	private PreparedStatement pstmt;
	
	// 회원가입
	public int signUp(Connection con, MemberDTO memberDTO) {
		
		String query = "INSERT INTO member "
				+ "		VALUES(member_no_seq.nextval, ?, ?, ?, ?, ?, sysdate, NULL, 1)";
	
		try {
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getPhone());
			pstmt.setString(5, memberDTO.getAddr());
			
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//id중복 체크 
	public boolean duplicateId(Connection con, String id) {
		String query ="SELECT member_id FROM member "
				+"     WHERE member_id = ? ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			
			return rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	//로그인 
	public MemberDTO memeberLogin(Connection con, String id) {
		String query = "SELECT *" 
				+ "    FROM member" 
				+ "    WHERE member_Id= ?";

		MemberDTO result = new MemberDTO(); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			// 쿼리 실행
			ResultSet rs = pstmt.executeQuery(); 

			while (rs.next()) {
				int resultNo = rs.getInt("MEMBER_NO");
				String resultId = rs.getString("MEMBER_ID"); 
				String resultPwd = rs.getString("MEMBER_PWD");
				String resultName = rs.getString("MEMBER_NAME");
				String resultPhone = rs.getString("MEMBER_PHONE");
				String resultaddr = rs.getString("MEMBER_ADDR");
				String resultCreateDate= rs.getString("MEMBER_Create_Date");
				String resultUpdateDate= rs.getString("MEMBER_Update_Date");
				int resultType = rs.getInt("MEMBER_TYPE");

				
				result.setId(resultId);
				result.setPwd(resultPwd);
				result.setName(resultName);
				result.setPhone(resultPhone);
				result.setAddr(resultaddr);
				result.setCreateDate(resultCreateDate);
				result.setUpDate(resultUpdateDate);
				result.setType(resultType);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
			return result;
	}

	public MemberDTO memberSelect(Connection con, int no) {
		String query = "SELECT member_phone, member_name FROM MEMBER"
				+ "		WHERE member_no = ?";
		MemberDTO result = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.setPhone(rs.getString("MEMBER_PHONE"));
				result.setName(rs.getString("MEMBER_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}








