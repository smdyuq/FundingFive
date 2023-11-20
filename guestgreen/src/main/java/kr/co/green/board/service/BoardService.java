package kr.co.green.board.service;

import java.util.ArrayList;

import kr.co.green.board.dto.BoardDTO;


public interface BoardService {
	//게시판 목록 조회
	public ArrayList<BoardDTO> boardList(PageInfo pi,String searchText);

}
