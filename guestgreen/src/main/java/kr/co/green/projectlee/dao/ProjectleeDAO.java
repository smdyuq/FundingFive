package kr.co.green.projectlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.projectlee.dto.ProjectleeDTO;

public class ProjectleeDAO {
	private PreparedStatement pstmt;

//	프로젝트 등록
	public int projectEnroll(Connection con, ProjectleeDTO projectleeDTO) {
		String query = "INSERT INTO PROJECT(PROJECT_NO, PROJECT_NAME, PROJECT_INTRODUCE, PROJECT_CONTENT, PROJECT_KIND, PROJECT_PRICE, PROJECT_TARGET_AMOUNT, PROJECT_CURRENT_AMOUNT, PROJECT_SPONSER_NUMBER, PROJECT_CONFIRM_STATUS, PROJECT_SALE_STATUS, PROJECT_REGISTER_DATE, PROJECT_END_DATE) "
				+ " VALUES(project_no_seq.nextval, ?, ?, ?, ?, ?, ?,default, default, default, default, TO_DATE(?,'YYYY-MM-DD'), TO_DATE(?,'YYYY-MM-DD'))";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, projectleeDTO.getProjectName());
			pstmt.setString(2, projectleeDTO.getProjectIntroduce());
			pstmt.setString(3, projectleeDTO.getProjectContent());
			pstmt.setString(4, projectleeDTO.getProjectKind());
			pstmt.setInt(5, projectleeDTO.getProjectPrice());
			pstmt.setInt(6, projectleeDTO.getProjectTargetAmount());
			pstmt.setString(7, projectleeDTO.getProjectRegisterDate());
			pstmt.setString(8, projectleeDTO.getProjectEndDate());

			int result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

//	창작자 등록
	public int projectManagerEnroll(Connection con, ProjectleeDTO projectleeDTO, int no) {
		String query = "INSERT INTO PROJECT_MANAGER(PROJECT_MANAGER_NAME, PROJECT_MANAGER_INTRODUCE, PROJECT_MANAGER_ACCOUNT, MEMBER_NO, PROJECT_NO)"
				+ " VALUES(?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, projectleeDTO.getManagerName());
			pstmt.setString(2, projectleeDTO.getManagerIntroduce());
			pstmt.setString(3, projectleeDTO.getManagerAccount());
			pstmt.setInt(4, no);

			int result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public ProjectleeDTO projectManagerNoSelect(Connection con, ProjectleeDTO projectleeDTO) {
		String query = "SELECT PROJECT_NO FROM PROJECT WHERE PROJECT_NAME = ?";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, projectleeDTO.getProjectName());

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
