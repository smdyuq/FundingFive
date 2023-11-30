package kr.co.green.projectlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.projectlee.PageInfo;
import kr.co.green.projectlee.dto.ProjectleeDTO;

public class ProjectleeDAO {
	private PreparedStatement pstmt;

//	프로젝트 등록 페이지

//	프로젝트 등록
	public int projectEnroll(Connection con, ProjectleeDTO projectleeDTO) {

		String query = "INSERT INTO PROJECT(PROJECT_NO, PROJECT_NAME, PROJECT_INTRODUCE, PROJECT_CONTENT, PROJECT_KIND, PROJECT_PRICE, PROJECT_TARGET_AMOUNT, PROJECT_CURRENT_AMOUNT, PROJECT_SPONSER_NUMBER, PROJECT_CONFIRM_STATUS, PROJECT_SALE_STATUS, PROJECT_REGISTER_DATE, PROJECT_END_DATE, PROJECT_OUTER_IMAGE_NAME, PROJECT_OUTER_IMAGE_PATH, PROJECT_CURRENT_PERCENTAGE) "
				+ " VALUES(project_no_seq.nextval, ?, ?, '임시값', ?, ?, ?,default, default, default, default, default, TO_DATE(?,'YYYY-MM-DD'), ?, ?, default)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, projectleeDTO.getProjectName());
			pstmt.setString(2, projectleeDTO.getProjectIntroduce());
			pstmt.setString(3, projectleeDTO.getProjectKind());
			pstmt.setInt(4, projectleeDTO.getProjectPrice());
			pstmt.setInt(5, projectleeDTO.getProjectTargetAmount());
			pstmt.setString(6, projectleeDTO.getProjectEndDate());
			pstmt.setString(7, projectleeDTO.getProjectOuterImageName());
			pstmt.setString(8, projectleeDTO.getProjectOuterImagePath());

			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

//	상세 페이지 이미지 등록
	public int innerimageEnroll(Connection con, ProjectleeDTO projectleeDTO2, int projectNo) {
		String query = "INSERT INTO PROJECT_INNER_IMAGE(PROJECT_INNER_IMAGE_NAME, PROJECT_INNER_IMAGE_PATH, PROJECT_NO) VALUES(?,?,?)";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, projectleeDTO2.getProjectInnerImageName());
			pstmt.setString(2, projectleeDTO2.getProjectInnerImagePath());
			pstmt.setInt(3, projectNo);

			int result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

//	프로젝트 스토리(상세내용) 페이지

//	프로젝트 스토리(상세내용) 등록
	public int projectContentUpdate(Connection con, ProjectleeDTO projectleeDTO, int projectNo) {
		String query = "update project set project_content = ? where project_no = ? ";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, projectleeDTO.getProjectContent());
			pstmt.setInt(2, projectNo);

			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

//	창작자 등록 페이지

// 	프로젝트 번호 조회
	public int projectManagerNoSelect(Connection con) {
		String query = "SELECT PROJECT_NO FROM (SELECT PROJECT_NO FROM PROJECT ORDER BY PROJECT_REGISTER_DATE DESC) WHERE ROWNUM = 1";

		int projectNo = 0;
		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				projectNo = rs.getInt("PROJECT_NO");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return projectNo;
	}

//	창작자 등록
	public int projectManagerEnroll(Connection con, ProjectleeDTO projectleeDTO, int no, int projectNo) {
		String query = "INSERT INTO PROJECT_MANAGER(PROJECT_MANAGER_NAME, PROJECT_MANAGER_INTRODUCE, PROJECT_MANAGER_IMAGE_NAME, PROJECT_MANAGER_IMAGE_PATH, PROJECT_MANAGER_ACCOUNT, MEMBER_NO, PROJECT_NO)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, projectleeDTO.getManagerName());
			pstmt.setString(2, projectleeDTO.getManagerIntroduce());
			pstmt.setString(3, projectleeDTO.getManagerImageName());
			pstmt.setString(4, projectleeDTO.getManagerImagePath());
			pstmt.setString(5, projectleeDTO.getManagerAccount());
			pstmt.setInt(6, no);
			pstmt.setInt(7, projectNo);

			int result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

//	관리자 승인 페이지

//	전체 게시글 수
	public int projectListCount(Connection con) {
		String query = "SELECT count(*) AS cnt FROM project WHERE PROJECT_CONFIRM_STATUS = 'C'";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

//	프로젝트 조회
	public ArrayList<ProjectleeDTO> projectSelect(Connection con, PageInfo pi) {
		ArrayList<ProjectleeDTO> list = new ArrayList<>();

		String query = "SELECT p1.PROJECT_NO, PROJECT_NAME, PROJECT_REGISTER_dATE, project_manager_name FROM PROJECT p1 join project_manager p2 on p1.project_no = p2.project_no WHERE PROJECT_CONFIRM_STATUS = 'C' ORDER BY PROJECT_REGISTER_DATE DESC OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, pi.getOffset()); // 0, 10, 20
			pstmt.setInt(2, pi.getBoardLimit());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int projectNo = rs.getInt("PROJECT_NO");
				String projectName = rs.getString("PROJECT_NAME");
				String projectRegisterDate = rs.getString("PROJECT_REGISTER_dATE");
				String managerName = rs.getString("project_manager_name");

				ProjectleeDTO projectleeDTO = new ProjectleeDTO();
				projectleeDTO.setProjectNo(projectNo);
				projectleeDTO.setProjectName(projectName);
				projectleeDTO.setProjectRegisterDate(projectRegisterDate);
				projectleeDTO.setManagerName(managerName);

				list.add(projectleeDTO);
			}

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

//	승인페이지 상세보기 페이지

//	승인페이지 상세보기 프로젝트 조회
	public void projectDetail(Connection con, ProjectleeDTO leeDTO) {
		String query = "SELECT p1.PROJECT_NO ,PROJECT_NAME, PROJECT_INTRODUCE, PROJECT_CONTENT, PROJECT_KIND, PROJECT_PRICE, PROJECT_TARGET_AMOUNT, PROJECT_END_DATE, PROJECT_OUTER_IMAGE_NAME, PROJECT_MANAGER_NAME, PROJECT_MANAGER_INTRODUCE, PROJECT_MANAGER_ACCOUNT, PROJECT_MANAGER_IMAGE_NAME FROM PROJECT p1 join project_manager p2 on p1.project_no = p2.project_no WHERE p1.PROJECT_NO = ?";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, leeDTO.getProjectNo());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				leeDTO.setProjectNo(rs.getInt("PROJECT_NO"));
				leeDTO.setProjectName(rs.getString("PROJECT_NAME"));
				leeDTO.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
				leeDTO.setProjectContent(rs.getString("PROJECT_CONTENT"));
				leeDTO.setProjectKind(rs.getString("PROJECT_KIND"));
				leeDTO.setProjectPrice(rs.getInt("PROJECT_PRICE"));
				leeDTO.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
				leeDTO.setProjectEndDate(rs.getString("PROJECT_END_DATE"));
				leeDTO.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
				leeDTO.setManagerName(rs.getString("PROJECT_MANAGER_NAME"));
				leeDTO.setManagerIntroduce(rs.getString("PROJECT_MANAGER_INTRODUCE"));
				leeDTO.setManagerAccount(rs.getString("PROJECT_MANAGER_ACCOUNT"));
				leeDTO.setManagerImageName(rs.getString("PROJECT_MANAGER_IMAGE_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	승인 버튼 누를시 업데이트
	public int projectUpdate(Connection con, int projectNo) {
		String query = "UPDATE PROJECT SET PROJECT_CONFIRM_STATUS = 'Y' WHERE PROJECT_CONFIRM_STATUS = 'C' AND PROJECT_NO =?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, projectNo);

			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

//	거절 버튼 누를시 업데이트
	public int projectDelete(Connection con, int projectNo) {
		String query = "UPDATE PROJECT SET PROJECT_CONFIRM_STATUS = 'N' WHERE PROJECT_CONFIRM_STATUS = 'C' AND PROJECT_NO =?";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, projectNo);

			int result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

//	거절 사유 메시지 등록
	public int deleteReason(Connection con, String reason, int projectNo) {
		String query = "INSERT INTO DELETE_REASON(REASON, PROJECT_NO) VALUES(?,?)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reason);
			pstmt.setInt(2, projectNo);

			int result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

}
