package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.member.model.dto.MemberBoardDTO;

public class MemberBoardDAO {

	private PreparedStatement pstmt;

	//회원 본인이 등록한 프로젝트 중 승인된 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyApprovedProject(Connection con, int memberNo) {
		ArrayList<MemberBoardDTO> myList = new ArrayList<>();

		String query = "SELECT P.PROJECT_NAME," + "       P.PROJECT_INTRODUCE," + "       P.PROJECT_CONTENT,"
				+ "       P.PROJECT_KIND," + "       P.PROJECT_TARGET_AMOUNT," + "       P.PROJECT_CURRENT_AMOUNT,"
				+ "       P.PROJECT_SPONSER_NUMBER," + "       P.PROJECT_CONFIRM_STATUS,"
				+ "       P.PROJECT_REGISTER_DATE," + "       P.PROJECT_END_DATE,"
				+ "       P.PROJECT_OUTER_IMAGE_NAME," + "       P.PROJECT_OUTER_IMAGE_PATH" + " FROM PROJECT P"
				+ " JOIN PROJECT_MANAGER PM" + " ON P.PROJECT_NO = PM.PROJECT_NO " + " WHERE PM.MEMBER_NO = ?"
				+ " AND P.PROJECT_CONFIRM_STATUS = 'Y'" 
				+ " ORDER BY P.PROJECT_REGISTER_DATE DESC";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, memberNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberBoardDTO dto = new MemberBoardDTO();

				dto.setProjectName(rs.getString("PROJECT_NAME"));
				dto.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
				dto.setProjectContent(rs.getString("PROJECT_CONTENT"));
				dto.setProjectKind(rs.getString("PROJECT_KIND"));
				dto.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
				dto.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
				dto.setProjectSponserNumber(rs.getInt("PROJECT_SPONSER_NUMBER"));
				dto.setProjectConfirmStatus(rs.getString("PROJECT_CONFIRM_STATUS"));
				dto.setProjectRegisterDate(rs.getDate("PROJECT_REGISTER_DATE"));
				dto.setProjectEndDate(rs.getDate("PROJECT_END_DATE"));
				dto.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
				dto.setProjectOuterImagePath(rs.getString("PROJECT_OUTER_IMAGE_PATH"));

				myList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myList;
	}
	
	//회원 본인이 등록한 프로젝트 중 거절된 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyRejectedProject(Connection con, int memberNo) {
		ArrayList<MemberBoardDTO> myList = new ArrayList<>();
		
		String query =  "SELECT  P.PROJECT_NAME, P.PROJECT_INTRODUCE, P.PROJECT_CONTENT, "
				 + "			 P.PROJECT_KIND, P.PROJECT_TARGET_AMOUNT, P.PROJECT_CURRENT_AMOUNT, "
				 + " 			 P.PROJECT_SPONSER_NUMBER, P.PROJECT_CONFIRM_STATUS, "
				 + " 			 P.PROJECT_REGISTER_DATE, P.PROJECT_END_DATE, "
				 + " 			 P.PROJECT_OUTER_IMAGE_NAME, P.PROJECT_OUTER_IMAGE_PATH "
				 + "	 FROM PROJECT P "
				 + "	 JOIN PROJECT_MANAGER PM "
				 + "	 ON P.PROJECT_NO = PM.PROJECT_NO "
				 + "	 WHERE PM.MEMBER_NO = ? AND P.PROJECT_CONFIRM_STATUS IN ('N') "
				 + "	 ORDER BY P.PROJECT_REGISTER_DATE DESC ";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberBoardDTO dto = new MemberBoardDTO();
				
				dto.setProjectName(rs.getString("PROJECT_NAME"));
				dto.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
				dto.setProjectContent(rs.getString("PROJECT_CONTENT"));
				dto.setProjectKind(rs.getString("PROJECT_KIND"));
				dto.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
				dto.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
				dto.setProjectSponserNumber(rs.getInt("PROJECT_SPONSER_NUMBER"));
				dto.setProjectConfirmStatus(rs.getString("PROJECT_CONFIRM_STATUS"));
				dto.setProjectRegisterDate(rs.getDate("PROJECT_REGISTER_DATE"));
				dto.setProjectEndDate(rs.getDate("PROJECT_END_DATE"));
				dto.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
				dto.setProjectOuterImagePath(rs.getString("PROJECT_OUTER_IMAGE_PATH"));
				
				myList.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myList;
	}
	
	//회원 본인이 등록한 프로젝트 중 보류된 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyPendingProject(Connection con, int memberNo) {
		ArrayList<MemberBoardDTO> myList = new ArrayList<>();
		
		String query =  "SELECT  P.PROJECT_NAME, P.PROJECT_INTRODUCE, P.PROJECT_CONTENT, "
				+ "			 P.PROJECT_KIND, P.PROJECT_TARGET_AMOUNT, P.PROJECT_CURRENT_AMOUNT, "
				+ " 			 P.PROJECT_SPONSER_NUMBER, P.PROJECT_CONFIRM_STATUS, "
				+ " 			 P.PROJECT_REGISTER_DATE, P.PROJECT_END_DATE, "
				+ " 			 P.PROJECT_OUTER_IMAGE_NAME, P.PROJECT_OUTER_IMAGE_PATH "
				+ "	 FROM PROJECT P "
				+ "	 JOIN PROJECT_MANAGER PM "
				+ "	 ON P.PROJECT_NO = PM.PROJECT_NO "
				+ "	 WHERE PM.MEMBER_NO = ? AND P.PROJECT_CONFIRM_STATUS IN ('C') "
				+ "	 ORDER BY P.PROJECT_REGISTER_DATE DESC ";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberBoardDTO dto = new MemberBoardDTO();
				
				dto.setProjectName(rs.getString("PROJECT_NAME"));
				dto.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
				dto.setProjectContent(rs.getString("PROJECT_CONTENT"));
				dto.setProjectKind(rs.getString("PROJECT_KIND"));
				dto.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
				dto.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
				dto.setProjectSponserNumber(rs.getInt("PROJECT_SPONSER_NUMBER"));
				dto.setProjectConfirmStatus(rs.getString("PROJECT_CONFIRM_STATUS"));
				dto.setProjectRegisterDate(rs.getDate("PROJECT_REGISTER_DATE"));
				dto.setProjectEndDate(rs.getDate("PROJECT_END_DATE"));
				dto.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
				dto.setProjectOuterImagePath(rs.getString("PROJECT_OUTER_IMAGE_PATH"));
				
				myList.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myList;
	}

}
