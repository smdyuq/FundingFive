package kr.co.green.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.search.model.dto.SearchDTO;

public class SearchDAO {
	private PreparedStatement pstmt;

	//회원 검색기록 조회
	public SearchDTO[] getMemberSearch(Connection con, int memberNo) {
		String query = "SELECT SEARCH_NO, "
				+ "			   SEARCH_WORD"
				+ "		FROM SEARCHING"
				+ "		WHERE MEMBER_NO = ?"
				+ "		AND SEARCH_STATUS = 'N'"
				+ "		AND ROWNUM <= 5"
				+ "		ORDER BY SEARCH_DATE DESC";
		SearchDTO[] arr = new SearchDTO[5];
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			
			int index = 0;
			while(rs.next() && index < 5) {
				SearchDTO searchDTO = new SearchDTO();
				searchDTO.setSearchNo(rs.getInt("SEARCH_NO"));
				searchDTO.setSearchWord(rs.getString("SEARCH_WORD"));
				arr[index] = searchDTO;
				index++ ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
		
	}

	public String[] getPopularSearch(Connection con) {
		String query = "SELECT SEARCH_WORD FROM "
					+ " ( SELECT SEARCH_WORD, COUNT(SEARCH_WORD) AS cnt "
					+ " FROM SEARCHING "
					+ " GROUP BY SEARCH_WORD "
					+ " ORDER BY cnt DESC ) " 
					+ " WHERE ROWNUM <= 10 ";
		String[] arr = new String[10];
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			int index = 0;
			while(rs.next() && index < 10){
				arr[index] = rs.getString("SEARCH_WORD");
				index++ ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}









