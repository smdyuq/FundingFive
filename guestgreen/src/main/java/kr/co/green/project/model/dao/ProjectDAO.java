package kr.co.green.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.project.model.dto.ProjectDTO;

public class ProjectDAO {
	private PreparedStatement pstmt;

//	프로젝트 등록 페이지

//	프로젝트 등록
	public int projectEnroll(Connection con, ProjectDTO projectleeDTO) {

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
	public int innerimageEnroll(Connection con, ProjectDTO projectleeDTO2, int projectNo) {
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
	public int projectContentUpdate(Connection con, ProjectDTO projectleeDTO, int projectNo) {
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
	public int projectManagerEnroll(Connection con, ProjectDTO projectleeDTO, int no, int projectNo) {
		String query = "INSERT INTO PROJECT_MANAGER(PROJECT_MANAGER_NAME, PROJECT_MANAGER_INTRODUCE, PROJECT_MANAGER_IMAGE_NAME, PROJECT_MANAGER_IMAGE_PATH, PROJECT_MANAGER_ACCOUNT, MEMBER_NO, PROJECT_NO)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, projectleeDTO.getProjectManagerName());
			pstmt.setString(2, projectleeDTO.getProjectIntroduce());
			pstmt.setString(3, projectleeDTO.getProjectManagerImageName());
			pstmt.setString(4, projectleeDTO.getProjectManagerImagePath());
			pstmt.setString(5, projectleeDTO.getProjectMangerAccount());
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
	public ArrayList<ProjectDTO> projectSelect(Connection con, PageInfo pi) {
		ArrayList<ProjectDTO> list = new ArrayList<>();

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

				ProjectDTO projectleeDTO = new ProjectDTO();
				projectleeDTO.setProjectNo(projectNo);
				projectleeDTO.setProjectName(projectName);
				projectleeDTO.setProjectRegisterDate(projectRegisterDate);
				projectleeDTO.setProjectManagerName(managerName);

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
	public void projectDetail(Connection con, ProjectDTO leeDTO) {
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
				leeDTO.setProjectManagerName(rs.getString("PROJECT_MANAGER_NAME"));
				leeDTO.setProjectManagerIntroduce(rs.getString("PROJECT_MANAGER_INTRODUCE"));
				leeDTO.setProjectMangerAccount(rs.getString("PROJECT_MANAGER_ACCOUNT"));
				leeDTO.setProjectManagerImageName(rs.getString("PROJECT_MANAGER_IMAGE_NAME"));
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

	// 상세페이지 프로젝트 요소 조회
	public ProjectDTO getProjectDetail(Connection con, int projectNo) {

		String query = "SELECT p.PROJECT_NO, p.PROJECT_NAME, p.PROJECT_INTRODUCE, p.PROJECT_CONTENT, p.PROJECT_KIND, "
				+ "				p.PROJECT_PRICE, p.PROJECT_TARGET_AMOUNT, p.PROJECT_CURRENT_AMOUNT, p.PROJECT_SPONSER_NUMBER, "
				+ "				p.PROJECT_OUTER_IMAGE_NAME, p.PROJECT_OUTER_IMAGE_PATH, p.PROJECT_CURRENT_PERCENTAGE"
				+ "				pii.PROJECT_INNER_IMAGE_NAME, pii.PROJECT_INNER_IMAGE_PATH"
				+ "				FROM project p" + "		JOIN PROJECT_INNER_IMAGE pii "
				+ "		ON p.PROJECT_NO = pii.PROJECT_NO " + "		WHERE p.PROJECT_NO = ?";

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectDTO;

	}

	// 프로젝트 시작일, 마감일 조회(쿼리문에서 DATE타입을 형변환 시켜와야함)
	public void getProjectDday(Connection con, ProjectDTO projectDTO) {
		String query = "SELECT  TO_CHAR(PROJECT_END_DATE, 'YYYY/MM/DD') AS PROJECT_END_DATE,"
				+ "				TO_CHAR(PROJECT_REGISTER_DATE, 'YYYY/MM/DD) AS PROJECT_REGISTER_DATE "
				+ " 	FROM PROJECT" + "		WHERE project_no = ?";
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
				+ "				PROJECT_MANAGER_IMAGE_PATH, MEMBER_NO  " + "		FROM PROJECT_MANAGER "
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// API에 넘긴 후에 DONATE테이블에 저장하기 위한 기본적인 프로젝트 정보 조회
	public ProjectDTO getProjectBasicInfo(Connection con, int projectNo) {
		String query = "SELECT project_name, project_price FROM project" + "		WHERE project_no = ?";

		ProjectDTO projectDTO = new ProjectDTO();
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
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
		String query = "UPDATE project" + "		SET project_sponser_number = project_sponser_number + 1, "
				+ "			project_current_amount = project_current_amount + ? " + "	    WHERE project_no = ?";
		int result = 0;
		int projectCurrentPercentage = projectDTO.getProjectCurrentAmount() / projectDTO.getProjectTargetAmount() * 100;
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
