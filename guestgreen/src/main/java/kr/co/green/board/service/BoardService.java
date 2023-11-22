package kr.co.green.board.service;

import java.util.ArrayList;

import kr.co.green.board.dto.BoardDTO;


public interface BoardService {
	//게시판 목록 조회
	public ArrayList<BoardDTO> boardList(PageInfo pi,String searchText);
	//게시판 등록
	int boardEnroll(String title, String content, String writer, String fileName, String uploadDirectory);
	//게시판 전체 글수
	int boardListCount(String searchText);

}
