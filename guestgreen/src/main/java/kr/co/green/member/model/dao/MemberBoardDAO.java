package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.member.model.dto.MemberBoardDTO;

public class MemberBoardDAO {
	
	private PreparedStatement pstmt; 
	
	 public ArrayList<MemberBoardDTO> boardProjecYtList(Connection con, PageInfo pi, String searchText, int no) {
		 ArrayList<MemberBoardDTO> myList = new ArrayList<>();
		 
	        String query = "SELECT P.PROJECT_NAME,"
	                + "       P.PROJECT_INTRODUCE,"
	                + "       P.PROJECT_CONTENT,"
	                + "       P.PROJECT_KIND,"
	                + "       P.PROJECT_TARGET_AMOUNT,"
	                + "       P.PROJECT_CURRENT_AMOUNT,"
	                + "       P.PROJECT_SPONSER_NUMBER,"
	                + "       P.PROJECT_CONFIRM_STATUS,"
	                + "       P.PROJECT_REGISTER_DATE,"
	                + "       P.PROJECT_END_DATE,"
	                + "       P.PROJECT_OUTER_IMAGE_NAME,"
	                + "       P.PROJECT_OUTER_IMAGE_PATH"
	                + " FROM PROJECT P"
	                + " JOIN PROJECT_MANAGER PM"
	                + " ON P.PROJECT_NO = PM.PROJECT_NO "
	                + " WHERE PM.MEMBER_NO = ?"
	                + " AND P.PROJECT_CONFIRM_STATUS = 'Y'"
		    		+ " 	AND P.PROJECT_NAME LIKE '%' || ? || '%'"
	                + " ORDER BY P.PROJECT_REGISTER_DATE DESC"
	                + " OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
	        
	        try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1, no);
				pstmt.setString(2, searchText);
				pstmt.setInt(3, pi.getOffset());
				pstmt.setInt(4, pi.getBoardiLimit());
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					 MemberBoardDTO dto = new MemberBoardDTO();
		                
		                dto.setProjectName(rs.getString("PROJECT_NAME"));
		                dto.setProjectIntroduce(rs.getString("PROJECT_INTRODUCE"));
		                dto.setProjectContent(rs.getString("PROJECT_CONTENT"));
		                dto.setProjectKind(rs.getString("PROJECT_KIND"));
		                dto.setProjectTargetAmount(rs.getInt("PROJECT_TARGET_AMOUNT"));
		                dto.setProjectCurrentAmount(rs.getInt("PROJECT_CURRENT_AMOUNT"));
		                dto.setProjectSponserNumber(rs.getInt("PROJECT_SPONSER_NUMBER"));
		                dto.setProjectConfirmStatus(rs.getString("PROJECT_CONFIRM_STATUS"));
		                dto.setProjectRegisterDate(rs.getDate("PROJECT_REGISTER_DATE"));
		                dto.setProjectEndDate(rs.getDate("PROJECT_END_DATE"));
		                dto.setProjectOuterImageName(rs.getString("PROJECT_OUTER_IMAGE_NAME"));
		                dto.setProjectOuterImagePath(rs.getString("PROJECT_OUTER_IMAGE_PATH"));

		                myList.add(dto);
					
				}
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 
		
		 
		 
		return myList;

		 
	 }

	public int boardProjecYtListCount(Connection con, String searchText, int no) {
		

		    String query = "SELECT  COUNT(*) as c FROM  DONATE d"
		    		+ "		JOIN MEMBER m ON m.member_no = d.member_no"
		    		+ " 	JOIN PROJECT p ON d.project_no = p.PROJECT_NO"
		    		+ " 	WHERE m.member_no = ?"
		    		+ " 	AND P.PROJECT_NAME LIKE '%' || ? || '%'";


		    try {
		        pstmt = con.prepareStatement(query);
		        pstmt.setInt(1, no);
		        pstmt.setString(2, searchText);
		        

		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            int count = rs.getInt("c");
		            return count;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (pstmt != null) {
		            try {
		                pstmt.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    return 0;
		}

}
