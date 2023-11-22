package kr.co.green.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.board.dao.BoardDAO;
import kr.co.green.board.dto.BoardDTO;
import kr.co.green.common.DatabaseConnection;

public class BoardServiceImpl implements BoardService{
	private Connection con;
	private DatabaseConnection dc;
	private BoardDAO boardDAO;
	
	// DB연결
		public BoardServiceImpl() {
			boardDAO = new BoardDAO();
			dc = new DatabaseConnection();
			con = dc.connDB();
		}
		//게시판 목록 조회
		@Override 
		public ArrayList<BoardDTO> boardList(PageInfo pi, String searchText) {
			return boardDAO.boardList(con, pi, searchText);
		}
		//게시판 전체 글수
		@Override
		public int boardListCount(String searchText) {
			return boardDAO.boardListCount(con,searchText);
		}
		//게시판 등록
		@Override
		public int boardEnroll(String title, String content, String writer, String fileName, String uploadDirectory) {
			return boardDAO.boardEnroll(con,title,content,writer,fileName,uploadDirectory);
		}
	
	
}
