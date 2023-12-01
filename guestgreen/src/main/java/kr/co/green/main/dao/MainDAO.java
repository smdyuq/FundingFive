package kr.co.green.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.main.dto.MainDTO;

public class MainDAO {

	private PreparedStatement pstmt;

	public int mainListCount(Connection con) {
		String query = "SELECT count(*) AS cnt FROM project WHERE PROJECT_CONFIRM_STATUS = 'Y'";

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

	public ArrayList<MainDTO> mainSelect(Connection con, PageInfo pi) {
		
		ArrayList<MainDTO> list = new ArrayList<>();

	      String query = "SELECT PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_INTRODUCE FROM PROJECT WHERE PROJECT_CONFIRM_STATUS = 'Y' ORDER BY PROJECT_REGISTER_DATE DESC OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

	      try {
	         pstmt = con.prepareStatement(query);

	         pstmt.setInt(1, pi.getOffset()); // 0, 10, 20
	         pstmt.setInt(2, pi.getBoardLimit());

	         ResultSet rs = pstmt.executeQuery();

	         while (rs.next()) {
	            int projectNo = rs.getInt("PROJECT_NO");
	            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
	            String projectKind = rs.getString("PROJECT_KIND");
	            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");

	            MainDTO mainDTO = new MainDTO();
	            mainDTO.setProjectNo(projectNo);
	            mainDTO.setProjectOuterImageName(projectOuterImageName);
	            mainDTO.setProjectKind(projectKind);
	            mainDTO.setProjectIntroduce(projectIntroduce);

	            list.add(mainDTO);
	         }

	         pstmt.close();
	         con.close();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return list;
		
		
	}

}
