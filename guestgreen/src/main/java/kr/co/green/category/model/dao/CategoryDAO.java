package kr.co.green.category.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;

public class CategoryDAO {

	private PreparedStatement pstmt;

//	카테고리 전체 조회
	public ArrayList<ProjectDTO> categoryEntire(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
				+ "	ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

//	카테고리 가전 조회
	public ArrayList<ProjectDTO> categoryAppliances(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
				+ "	AND P1.PROJECT_KIND = '가전' ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

//	카테고리 의류 조회
	public ArrayList<ProjectDTO> categoryClothes(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
				+ "	AND P1.PROJECT_KIND = '의류' ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

//	카테고리 향수, 뷰티 조회
	public ArrayList<ProjectDTO> categoryBeauty(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
				+ "	AND P1.PROJECT_KIND = '뷰티' ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

//	카테고리 푸드 조회
	public ArrayList<ProjectDTO> categoryFood(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
				+ "	AND P1.PROJECT_KIND = '푸드' ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

//	카테고리 주얼리 조회
	public ArrayList<ProjectDTO> categoryJewelry(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
				+ "	AND P1.PROJECT_KIND = '주얼리' ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

//	진행중인, 달성완료, 인기 프로젝트 조회

//	진행중인 프로젝트 조회
	public ArrayList<ProjectDTO> proceedingProject(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE "
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO "
				+ " WHERE PROJECT_REGISTER_DATE < SYSDATE AND SYSDATE < PROJECT_END_DATE"
				+ " ORDER BY P1.PROJECT_NO DESC";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

//	달성완료 프로젝트 조회
	public ArrayList<ProjectDTO> completeProject(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();
		String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
				+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' AND PROJECT_CURRENT_PERCENTAGE >= 100"
				+ " ORDER BY P1.PROJECT_NO DESC";
		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

//	인기 프로젝트 조회
	public ArrayList<ProjectDTO> popularityProject(Connection con) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

		String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
				+ " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
				+ " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y'" + " ORDER BY PROJECT_CURRENT_PERCENTAGE DESC";
		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
				String projectKind = rs.getString("PROJECT_KIND");
				String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
				String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
				int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectNo(projectNo);
				projectDTO.setProjectOuterImageName(projectOuterImageName);
				projectDTO.setProjectKind(projectKind);
				projectDTO.setProjectManagerName(projectManagerName);
				projectDTO.setProjectIntroduce(projectIntroduce);
				projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

				list.add(projectDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}
