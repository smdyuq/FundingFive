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
	//게시글 목록
	public ArrayList<BoardDTO> boardList(Connection con, PageInfo pi, String searchText) {

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
	//게시글 전체 갯수
	public int boardListCount(Connection con, String searchText) {
		String query = "SELECT count(*) AS cnt FROM BOARD WHERE BOARD_DELETE_DATE IS NULL"
				+ " 										AND BOARD_TITLE LIKE '%' || ? || '%'";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int result = rs.getInt("cnt");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	//게시글 등록
	public int boardEnroll(Connection con, String title, String content, String writer, String fileName,
			String uploadDirectory) {
		String query = "INSERT INTO board VALUES(board_no_SEQ.nextval," // 게시글 번호
				+ "									?," // 제목
				+ "									?," // 내용
				+ "									DEFAULT," // 작성일
				+ "									null," // 수정일
				+ "									0," // 조회수
				+ "									1," // 작성자
				+ "									?," // 파일 이름
				+ "									?," // 파일 경로
				+ "									null)"; // 삭제일

		try {
			// 쿼리 사용 준비
			pstmt = con.prepareStatement(query);
			System.out.println("asd");

			// 물음표 값
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, fileName);
			pstmt.setString(4, uploadDirectory);

			// 쿼리 실행
			int result = pstmt.executeUpdate();
			System.out.println(result);

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	//게시글 상세보기
	public void boardSelect(Connection con, BoardDTO board) {
		String query="SELECT board_no, board_title, board_views, board_in_date, board_content, BOARD_IMAGE_NAME"
				+ " 		FROM board"
				+ " 		WHERE board_no=?";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1,board.getIdx());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = rs.getInt("board_no");
				String title = rs.getString("board_TITLE");
				int views = rs.getInt("board_VIEWS");
				String indate = rs.getString("board_IN_DATE");
				String content = rs.getString("board_CONTENT");
				String fileName = rs.getString("BOARD_IMAGE_NAME");
				
				board.setIdx(idx);
				board.setTitle(title);
				board.setViews(views);
				board.setInDate(indate);
				board.setContent(content);
				board.setFileName(fileName);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//게시글 삭제
	public int boardDelete(Connection con, int idx) {
		String query = "UPDATE board SET board_delete_date = sysdate"
				+ "				WHERE board_no = ?";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, idx);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	//게시글 수정(제목,내용만)
	public int boardUpdate2(Connection con, int idx, String title, String content) {
		String query = "UPDATE board SET board_title = ?,"
				+ "						 board_content = ?,"
				+ "						 board_update_date = sysdate"
				+ "						 WHERE board_no =?";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setInt(3,idx);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	//게시글 수정(제목,내용,이미지)
	public int boardUpdate(Connection con, int idx, String title, String content, String fileName, String uploadDirectory) {
		String query = "UPDATE board SET board_title = ?,"
				+ "						 board_content = ?,"
				+ "						 board_update_date = sysdate,"
				+ "						 board_image_name = ?,"
				+ "						 board_image_path = ? "
				+ "						 WHERE board_no =?";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,fileName);
			pstmt.setString(4,uploadDirectory);
			pstmt.setInt(5,idx);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	//조회수 증가
	public int boardView(Connection con, int idx) {
		String query = "UPDATE board"
				+ "		SET board_views = board_views+1"
				+ "		WHERE board_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, idx);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
