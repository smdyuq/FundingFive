package kr.co.green.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import kr.co.green.project.model.dto.ProjectDTO;

public class MainDAO {

	private PreparedStatement pstmt;

	String[] queryArr = {
			"SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
					+ " ORDER BY PROJECT_VIEWS DESC FETCH FIRST 4 ROWS ONLY",
			"SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ " FROM (SELECT PROJECT.*, ROW_NUMBER() OVER (ORDER BY PROJECT_VIEWS DESC) as RANK FROM PROJECT WHERE PROJECT_CONFIRM_STATUS = 'Y') P1"
					+ " JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE P1.RANK BETWEEN 5 AND 12 ORDER BY PROJECT_VIEWS desc",
			"SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
					+ " AND PROJECT_END_DATE BETWEEN SYSDATE AND SYSDATE + 1 FETCH FIRST 4 ROWS ONLY",
			"SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE, MAX(P3.RECENT_PROJECT_DATE)"
					+ " FROM RECENT_PROJECT P3 JOIN PROJECT P1 ON P3.PROJECT_NO = P1.PROJECT_NO"
					+ " JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
					+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y'"
					+ " GROUP BY P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ " ORDER BY MAX(P3.RECENT_PROJECT_DATE) DESC" + " FETCH FIRST 10 ROWS ONLY",
			"SELECT * FROM (SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ "  FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
					+ "  WHERE P1.PROJECT_CONFIRM_STATUS = 'Y'"
					+ "  ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= 10 FETCH FIRST 4 ROWS ONLY",
			"SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
					+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' ORDER BY P1.PROJECT_REGISTER_DATE DESC FETCH FIRST 4 ROWS ONLY",
			"SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
					+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' AND PROJECT_CURRENT_PERCENTAGE >= 100 FETCH FIRST 4 ROWS ONLY",
			"SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
					+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' AND TRUNC(P1.PROJECT_REGISTER_DATE) = TRUNC(SYSDATE) order by project_register_date desc FETCH FIRST 4 ROWS ONLY",
			"SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
					+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
					+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' AND P1.PROJECT_KIND = '크리스마스'"
					+ " ORDER BY PROJECT_REGISTER_DATE DESC FETCH FIRST 8 ROWS ONLY" };

	// 프로젝트 조회 공통 메소드
	public void projectSelect(Connection con, ArrayList<ProjectDTO>[] arr) {

		for (int i = 0; i < arr.length; i++) {
			try {
				pstmt = con.prepareStatement(queryArr[i]);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					ProjectDTO projectDTO = new ProjectDTO();
					projectDTO.setProjectNo(rs.getInt("PROJECT_NO"));
					projectDTO.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
					projectDTO.setProjectKind(rs.getString("PROJECT_KIND"));
					projectDTO.setProjectManagerName(rs.getString("PROJECT_MANAGER_NAME"));
					projectDTO.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
					projectDTO.setProjectCurrentPercentage(rs.getInt("PROJECT_CURRENT_PERCENTAGE"));

					arr[i].add(projectDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

//   인기 프로젝트 조회
	public ArrayList<ProjectDTO> projectPopularity(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT RANK() OVER (ORDER BY PROJECT_CURRENT_PERCENTAGE DESC) AS RANK_NUMBER,"
				+ " P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE"
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
				+ " WHERE PROJECT_CONFIRM_STATUS = 'Y' ORDER BY RANK_NUMBER FETCH FIRST 6 ROWS ONLY";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectRankNumber(rs.getInt("RANK_NUMBER"));
				projectDTO.setProjectNo(rs.getInt("PROJECT_NO"));
				projectDTO.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
				projectDTO.setProjectKind(rs.getString("PROJECT_KIND"));
				projectDTO.setProjectManagerName(rs.getString("PROJECT_MANAGER_NAME"));
				projectDTO.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
				projectDTO.setProjectCurrentPercentage(rs.getInt("PROJECT_CURRENT_PERCENTAGE"));

				list.add(projectDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	//좋아요 눌렀던 프로젝트 가져오기(하트 빨간색 유지하기 위함)
	public void getLikedProject(Connection con, int memberNo, HashMap<Integer, String> userLikeMap) {
		String query = "SELECT project_no from user_likes"
				+ "		WHERE member_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				userLikeMap.put(projectNo, "asd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}





