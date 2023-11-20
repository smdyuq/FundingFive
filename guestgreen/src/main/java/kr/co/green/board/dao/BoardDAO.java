package kr.co.green.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.service.PageInfo;

public class BoardDAO {

	private PreparedStatement pstmt;
	
	public ArrayList<BoardDTO> boardList(Connection con, PageInfo pi,String searchText){
		
		ArrayList<BoardDTO> list = new ArrayList<>();
		String query = "select BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_IN_DATE, BOARD_UPDATE_DATE, BOARD_VIEWS, MEMBER_NO"
				+ "			from BOARD "
				+ "			where BOARD_DELETE_DATE is null"
				+ "			and BOARD_TITLE like '%'||?||'%'"
				+ "			order by BOARD_IN_DATE desc"
				+ "			offset ? row fetch first ? row only";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, searchText);
			pstmt.setInt(2, pi.getOffSet());
			pstmt.setInt(3, pi.getBoardLimit());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int board_no = rs.getInt("BOARD_NO");
				String board_title = rs.getString("BOARD_TITLE");
				String board_indate = rs.getString("BOARD_IN_DATE");
				int views = rs.getInt("BOARD_VIEWS");
				String writer = rs.getString("MEMBER_NO");
				
				BoardDTO board = new BoardDTO();
				board.setIdx(board_no);
				board.setTitle(board_title);
				board.setInDate(board_indate);
				board.setViews(views);
				board.setWriter(writer);
				
				list.add(board);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int boardListCount(Connection con, String searchText) {
		String query = "SELECT count(*) AS cnt FROM BOARD WHERE BOARD_DELETE_DATE IS NULL"
				+ " 										AND BOARD_TITLE LIKE '%' || ? || '%'";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("cnt");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
