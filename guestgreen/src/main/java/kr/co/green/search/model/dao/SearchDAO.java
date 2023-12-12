package kr.co.green.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.search.model.dto.SearchDTO;

public class SearchDAO {
	private PreparedStatement pstmt;

	//회원 검색기록 조회
	public SearchDTO[] getSearchHistory(Connection con, int memberNo) {
		String query = "SELECT SEARCH_NO, "
				+ "			   SEARCH_WORD"
				+ "		FROM SEARCHING"
				+ "		WHERE MEMBER_NO = ?"
				+ "		AND SEARCH_STATUS = 'Y'"
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
		boolean isEmpty = true;
		for (SearchDTO dto : arr) {
		    if (dto != null) {
		        isEmpty = false;
		        break;
		    }
		}
		if(isEmpty) {
		    return new SearchDTO[0];
		}else {
		    return arr;
		}
	}

	//인기 검색어 조회
	public SearchDTO[] getPopularSearch(Connection con) {
		String query = "SELECT ROWNUM, SEARCH_WORD FROM "
					+ " ( SELECT SEARCH_WORD, COUNT(SEARCH_WORD) AS cnt "
					+ " FROM SEARCHING "
					+ " GROUP BY SEARCH_WORD "
					+ " ORDER BY cnt DESC ) " 
					+ " WHERE ROWNUM <= 10 ";
		SearchDTO[] arr = new SearchDTO[10];
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			int index = 0;
			while(rs.next() && index < 10){
				SearchDTO searchDTO = new SearchDTO();
				searchDTO.setRowNum(rs.getInt("ROWNUM"));
				searchDTO.setSearchWord(rs.getString("SEARCH_WORD"));
				arr[index] = searchDTO;
				index++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean isEmpty = true;
		for (SearchDTO dto : arr) {
		    if (dto != null) {
		        isEmpty = false;
		        break;
		    }
		}
		if(isEmpty) {
		    return new SearchDTO[0];
		}else {
		    return arr;
		}
		
	}

	//선택한 검색기록 삭제
	public int deleteSearchHistory(Connection con, int searchNo) {
		String query = "DELETE FROM searching"
				+ "		WHERE search_no = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, searchNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}









