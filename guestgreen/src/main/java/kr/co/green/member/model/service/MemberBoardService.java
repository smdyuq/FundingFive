package kr.co.green.member.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.member.model.dto.MemberBoardDTO;

public interface MemberBoardService {

	//프로젝트 목록 조회
	public ArrayList<MemberBoardDTO> boardProjecYtList(PageInfo pi, String searchText, int no);
	
	//전체 게시글 수
	public int boardProjecYtListCount(String searchText, int no);
	
}
