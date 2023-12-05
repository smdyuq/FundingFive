package kr.co.green.donate.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.green.donate.model.dto.DonateDTO;

public class DonateDAO {

	private PreparedStatement pstmt;

	//후원 성공 시 후원자 테이블 등록
	public int donateEnroll(Connection con, DonateDTO donateDTO) {
		String query = "INSERT INTO donate"
				+ "		VALUES(?, ?, ?, ?, ?, ?)";
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
}
