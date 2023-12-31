package kr.co.green.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.board.model.dao.BoardDAO;
import kr.co.green.board.model.dto.BoardDTO;
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
		//게시글 내용 보기
		public void boardSelect(BoardDTO board) {
			boardDAO.boardSelect(con,board);
			
		}
		//게시글 삭제
		public int boardDelete(int idx) {
			return boardDAO.boardDelete(con, idx);
		}
		//게시글 수정(이미지까지 수정)
		public int boardUpdate(int idx, String title, String content, String fileName, String uploadDirectory) {
			return boardDAO.boardUpdate(con, idx, title, content, fileName, uploadDirectory);
		}
		//게시글 수정(제목,내용만)
		public int boardUpdate2(int idx, String title, String content) {
			return boardDAO.boardUpdate2(con, idx, title, content);
		}
		//조회수 증가
		public int boardView(int idx) {
			return boardDAO.boardView(con,idx);
		}
		
	
}
