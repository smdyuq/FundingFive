package kr.co.green.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.search.model.dto.SearchDTO;

public class SearchDAO {
	private PreparedStatement pstmt;

	//회원 검색기록 조회
	public ArrayList<SearchDTO> getSearchHistory(Connection con, int memberNo) {
		String query = "SELECT SEARCH_NO, "
				+ "			   SEARCH_WORD"
				+ "		FROM SEARCHING"
				+ "		WHERE MEMBER_NO = ?"
				+ "		AND SEARCH_STATUS = 'Y'"
				// + "		AND ROWNUM <= 5"
				+ "		ORDER BY SEARCH_DATE DESC";
		ArrayList<SearchDTO> arr = new ArrayList<>();
		// SearchDTO[] arr = new SearchDTO[5];
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			
			// int index = 0;
			// while(rs.next() && index < 5) {
			while(rs.next()) {
				SearchDTO searchDTO = new SearchDTO();
				searchDTO.setSearchNo(rs.getInt("SEARCH_NO"));
				searchDTO.setSearchWord(rs.getString("SEARCH_WORD"));
				// arr[index] = searchDTO;
				arr.add(searchDTO);
				// index++ ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		boolean isEmpty = true;
//		for (SearchDTO dto : arr) {
//		    if (dto != null) {
//		        isEmpty = false;
//		        break;
//		    }
//		}
//		if(isEmpty) {
//		    return new SearchDTO[0];
//		}else {
//		    return arr;
//		}
		
		return arr;
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
		String query = "UPDATE searching"
				+ "		SET search_status = 'N'"
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

	//프로젝트 검색
	public void getSearchedProject(Connection con, String searchWord, ArrayList<ProjectDTO> searchedProjectList) {
		
		String query = " SELECT p1.*, pm.PROJECT_MANAGER_NAME FROM (SELECT PROJECT_NO, PROJECT_NAME, PROJECT_OUTER_IMAGE_NAME, "
			          + "												  PROJECT_KIND, PROJECT_INTRODUCE, "
			          + "                                                 PROJECT_CURRENT_PERCENTAGE, PROJECT_CURRENT_AMOUNT,"
			          + "												  TO_CHAR(PROJECT_END_DATE, 'YYYY/MM/DD') AS PROJECT_END_DATE"
			          + "                                          FROM project"
					  + "                                          WHERE project_name LIKE '%' || ? || '%')p1 "
					  + " JOIN PROJECT_MANAGER PM "
					  + " ON P1.PROJECT_NO = PM.PROJECT_NO";
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchWord);
				ResultSet rs = pstmt.executeQuery();
			
				while (rs.next()) {
					ProjectDTO projectDTO = new ProjectDTO();
					projectDTO.setProjectNo(rs.getInt("PROJECT_NO"));
					projectDTO.setProjectName(rs.getString("PROJECT_NAME"));
					projectDTO.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
					projectDTO.setProjectKind(rs.getString("PROJECT_KIND"));
					projectDTO.setProjectManagerName(rs.getString("PROJECT_MANAGER_NAME"));
					projectDTO.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
					projectDTO.setProjectCurrentPercentage(rs.getInt("PROJECT_CURRENT_PERCENTAGE"));
					projectDTO.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
					projectDTO.setProjectEndDate(rs.getString("PROJECT_END_DATE"));
					
					searchedProjectList.add(projectDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	//검색결과 수 반환
	public int getSearchedCount(Connection con, String searchWord) {
		String query = "SELECT count(*) AS cnt FROM project "
					 + " WHERE project_name LIKE '%' || ? || '%'";
		
		int searchCount = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				searchCount = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchCount;
	}

	//검색어 테이블 등록
	public void searchWordEnroll(Connection con, String searchWord, int memberNo) {
		String query = "";
		if(memberNo == 0) {
			query = " INSERT INTO searching VALUES(search_no_seq.nextval, ?, 'Y', sysdate, 0)";

		} else {

			query = " INSERT INTO searching VALUES(search_no_seq.nextval, ?, 'Y', sysdate, ?)";
		}
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
	        if (memberNo != 0) {
	            pstmt.setInt(2, memberNo);
	        }
	        System.out.println(memberNo);
	        System.out.println(searchWord);
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}









