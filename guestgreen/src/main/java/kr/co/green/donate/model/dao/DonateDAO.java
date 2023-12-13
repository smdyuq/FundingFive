package kr.co.green.donate.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.donate.model.dto.DonateDTO;

public class DonateDAO {

	private PreparedStatement pstmt;

	//후원 성공 시 후원자 테이블 등록
	public int donateEnroll(Connection con, DonateDTO donateDTO) {
		String query = "INSERT INTO donate"
				+ "		VALUES(?, ?, ?, ?, ?, ?, sysdate)";
		int result=0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, donateDTO.getDonateId());
			pstmt.setInt(2, donateDTO.getMemberNo());
			pstmt.setInt(3, donateDTO.getProjectNo());
			pstmt.setString(4, donateDTO.getMemberAddr());
			pstmt.setString(5, donateDTO.getMemberPhone());
			pstmt.setString(6, donateDTO.getMemberName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//상품 배송을 위한 후원자 정보 조회
	public ArrayList<DonateDTO> getSponserInfo(Connection con, int projectNo) {
		String query = "SELECT p.project_name, p.project_price, d.member_name, d.member_phone, d.member_addr from project p"
				+ "		JOIN donate d"
				+ "		ON p.project_no = d.project_no"
				+ "		WHERE p.project_no = ?";
		ArrayList<DonateDTO> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DonateDTO donateDTO = new DonateDTO();
				donateDTO.setProjectName(rs.getString("PROJECT_NAME"));
				donateDTO.setProjectPrice(rs.getInt("PROJECT_PRICE"));
				donateDTO.setMemberName(rs.getString("MEMBER_NAME"));
				donateDTO.setMemberPhone(rs.getString("MEMBER_PHONE"));
				donateDTO.setMemberAddr(rs.getString("MEMBER_ADDR"));
				list.add(donateDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}








