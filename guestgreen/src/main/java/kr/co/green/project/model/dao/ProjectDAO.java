package kr.co.green.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.project.model.dto.ProjectDTO;

public class ProjectDAO {
	private PreparedStatement pstmt;

	//상세페이지 요소 조회
	public void getProjectDetail(Connection con, ProjectDTO projectDTO) {
		String query =  "SELECT p.PROJECT_NO, p.PROJECT_NAME, p.PROJECT_INTRODUCE, p.PROJECT_CONTENT, p.PROJECT_KIND, "
				+ "				p.PROJECT_PRICE, p.PROJECT_TARGET_AMOUNT, p.PROJECT_CURRENT_AMOUNT, p.PROJECT_SPONSER_NUMBER, "
				+ "				p.PROJECT_REGISTER_DATE, p.PROJECT_END_DATE, p.PROJECT_OUTER_IMAGE_NAME, "
				+ "				p.PROJECT_OUTER_IMAGE_PATH, pii.PROJECT_INNER_IMAGE_NAME, pii.PROJECT_INNER_IMAGE_PATH"
				+ "		FROM project p"
				+ "		JOIN PROJECT_INNER_IMAGE pii"
				+ "		ON p.PROJECT_NO = pii.PROJECT_NO "
				+ "		WHERE p.PROJECT_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, projectDTO.getProjectNumber());
			ResultSet rs = pstmt.executeQuery();
			ProjectDTO retrievedProjectDTO = new ProjectDTO();

	        if (rs.next()) {
	            // ResultSet의 값을 가져와서 retrievedProjectDTO에 setter를 사용하여 넣습니다.
	            retrievedProjectDTO.setProjectNumber(rs.getInt("PROJECT_NO"));
	            retrievedProjectDTO.setProjectName(rs.getString("PROJECT_NAME"));
	            retrievedProjectDTO.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
	            retrievedProjectDTO.setProjectContent(rs.getString("PROJECT_CONTENT"));
	            retrievedProjectDTO.setProjectKind(rs.getString("PROJECT_KIND"));
	            retrievedProjectDTO.setProjectPrice(rs.getInt("PROJECT_PRICE"));
	            retrievedProjectDTO.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
	            retrievedProjectDTO.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
	            retrievedProjectDTO.setProjectSponserNumber(rs.getInt("PROJECT_SPONSER_NUMBER"));
	            retrievedProjectDTO.setProjectRegisterDate(rs.getString("PROJECT_REGISTER_DATE"));
	            retrievedProjectDTO.setProjectEndDate(rs.getString("PROJECT_END_DATE"));
	            retrievedProjectDTO.setProjectInnerImageName(rs.getString("PROJECT_INNER_IMAGE_NAME"));
	            retrievedProjectDTO.setProjectInnerImagePath(rs.getString("PROJECT_INNER_IMAGE_PATH"));
	            retrievedProjectDTO.setProjectInnerImageName(rs.getString("PROJECT_INNER_IMAGE_NAME"));
	            retrievedProjectDTO.setProjectInnerImagePath(rs.getString("PROJECT_INNER_IMAGE_PATH"));

	            projectDTO = retrievedProjectDTO;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getProjectManagerDetail(Connection con, ProjectDTO projectDTO) {
		String query = "SELECT  PROJECT_MANAGER_ID, PROJECT_MANAGER_NAME,"
				+ "			    PROJECT_MANAGER_INTRODUCE, PROJECT_MANAGER_IMAGE_NAME, "
				+ "				PROJECT_MANAGER_IMAGE_PATH, MEMBER_NO "
				+ "FROM PROJECT_MANAGER "
				+ "WHERE PROJECT_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, projectDTO.getProjectNumber());
			ResultSet rs = pstmt.executeQuery();
			ProjectDTO retrievedProjectDTO = new ProjectDTO();
			
			while(rs.next()) {
				retrievedProjectDTO.setProjectManagerId(rs.getString("PROJECT_MANAGER_ID"));
				retrievedProjectDTO.setProjectManagerName(rs.getString("PROJECT_MANAGER_NAME"));
				retrievedProjectDTO.setProjectManagerIntroduce(rs.getString("PROJECT_MANAGER_INTRODUCE"));
				retrievedProjectDTO.setProjectManagerImageName(rs.getString("PROJECT_MANAGER_IMAGE_NAME"));
				retrievedProjectDTO.setProjectManagerImagePath(rs.getString("PROJECT_MANAGER_IMAGE_PATH"));
				
				projectDTO = retrievedProjectDTO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}







