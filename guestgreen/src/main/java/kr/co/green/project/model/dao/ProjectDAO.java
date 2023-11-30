package kr.co.green.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.project.model.dto.ProjectDTO;

public class ProjectDAO {
	private PreparedStatement pstmt;

	// 상세페이지 프로젝트 요소 조회
	public ProjectDTO getProjectDetail(Connection con, int projectNo) {

			String query = "SELECT p.PROJECT_NO, p.PROJECT_NAME, p.PROJECT_INTRODUCE, p.PROJECT_CONTENT, p.PROJECT_KIND, "
					+ "				p.PROJECT_PRICE, p.PROJECT_TARGET_AMOUNT, p.PROJECT_CURRENT_AMOUNT, p.PROJECT_SPONSER_NUMBER, "
					+ "				p.PROJECT_OUTER_IMAGE_NAME, p.PROJECT_OUTER_IMAGE_PATH, p.PROJECT_CURRENT_PERCENTAGE"
					+ "				pii.PROJECT_INNER_IMAGE_NAME, pii.PROJECT_INNER_IMAGE_PATH" 
					+ "				FROM project p"
					+ "		JOIN PROJECT_INNER_IMAGE pii "
					+ "		ON p.PROJECT_NO = pii.PROJECT_NO "
					+ "		WHERE p.PROJECT_NO = ?";
			
			ProjectDTO projectDTO = new ProjectDTO();
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, projectNo);
		
				ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						projectDTO.setProjectNo(rs.getInt("PROJECT_NO"));
						projectDTO.setProjectName(rs.getString("PROJECT_NAME"));
						projectDTO.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
						projectDTO.setProjectContent(rs.getString("PROJECT_CONTENT"));
						projectDTO.setProjectKind(rs.getString("PROJECT_KIND"));
						projectDTO.setProjectPrice(rs.getInt("PROJECT_PRICE"));
						projectDTO.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
						projectDTO.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
						projectDTO.setProjectSponserNumber(rs.getInt("PROJECT_SPONSER_NUMBER"));
						projectDTO.setProjectInnerImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
						projectDTO.setProjectInnerImagePath(rs.getString("PROJECT_OUTER_IMAGE_PATH"));
						projectDTO.setProjectCurrentPercentage(rs.getInt("PROJECT_CURRENT_PERCENTAGE"));
						projectDTO.setProjectInnerImageName(rs.getString("PROJECT_INNER_IMAGE_NAME"));
						projectDTO.setProjectInnerImagePath(rs.getString("PROJECT_INNER_IMAGE_PATH"));
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
		return projectDTO;
		
	}

	// 프로젝트 시작일, 마감일 조회(쿼리문에서 DATE타입을 형변환 시켜와야함)
	public void getProjectDday(Connection con, ProjectDTO projectDTO) {
		String query = "SELECT  TO_CHAR(PROJECT_END_DATE, 'YYYY/MM/DD') AS PROJECT_END_DATE,"
				+ "				TO_CHAR(PROJECT_REGISTER_DATE, 'YYYY/MM/DD) AS PROJECT_REGISTER_DATE "
				+ " 	FROM PROJECT"
				+ "		WHERE project_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, projectDTO.getProjectNo());
			ResultSet rs = pstmt.executeQuery();		
			while (rs.next()) {
				projectDTO.setProjectEndDate(rs.getString("PROJECT_END_DATE"));
				projectDTO.setProjectRegisterDate(rs.getString("PROJECT_REGISTER_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 상세페이지 해당프로젝트 창작자 정보 조회
	public void getProjectManagerDetail(Connection con, ProjectDTO projectDTO) {
		String query = "SELECT  PROJECT_MANAGER_NAME,"
				+ "			    PROJECT_MANAGER_INTRODUCE, PROJECT_MANAGER_IMAGE_NAME, "
				+ "				PROJECT_MANAGER_IMAGE_PATH, MEMBER_NO  "
				+ "		FROM PROJECT_MANAGER "
				+ "		WHERE PROJECT_NO = ?";
		try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, projectDTO.getProjectNo());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			projectDTO.setProjectManagerName(rs.getString("PROJECT_MANAGER_NAME"));
			projectDTO.setProjectManagerIntroduce(rs.getString("PROJECT_MANAGER_INTRODUCE"));
			projectDTO.setProjectManagerImageName(rs.getString("PROJECT_MANAGER_IMAGE_NAME"));
			projectDTO.setProjectManagerImagePath(rs.getString("PROJECT_MANAGER_IMAGE_PATH"));
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	// API에 넘긴 후에 DONATE테이블에 저장하기 위한 기본적인 프로젝트 정보 조회
	public ProjectDTO getProjectBasicInfo(Connection con, int projectNo) {
		String query = "SELECT project_name, project_price FROM project"
				+ "		WHERE project_no = ?";

		ProjectDTO projectDTO = new ProjectDTO();
		try(PreparedStatement pstmt = con.prepareStatement(query)){	
			pstmt.setInt(1, projectNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				projectDTO.setProjectName(rs.getString("PROJECT_NAME"));
				projectDTO.setProjectPrice(rs.getInt("PROJECT_PRICE"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectDTO;
	}	

	// 후원 성공 시 PROJECT테이블 후원자 수, 현재 후원 금액, 현재 후원 퍼센트 업데이트
	public int projectUpdate(Connection con, ProjectDTO projectDTO) {
		String query = "UPDATE project" 
				+ "		SET project_sponser_number = project_sponser_number + 1, "
				+ "			project_current_amount = project_current_amount + ? "
				+ "	    WHERE project_no = ?";
		int result = 0;
		int projectCurrentPercentage = projectDTO.getProjectCurrentAmount()/projectDTO.getProjectTargetAmount() * 100;
		projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, projectDTO.getProjectPrice());
			pstmt.setInt(2, projectDTO.getProjectNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}






