package kr.co.green.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;
import kr.co.green.member.model.dao.MemberBoardDAO;
import kr.co.green.member.model.dto.MemberBoardDTO;



public class MemberBoardServiceImpl implements MemberBoardService {
	private Connection con;
	private DatabaseConnection dc;
	private MemberBoardDAO memberBoardDAO;

	public MemberBoardServiceImpl() {
		memberBoardDAO = new MemberBoardDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}


	@Override
	// 전체 게시글 수
	public int boardProjecYtListCount(String searchText, int no) {
		return memberBoardDAO.boardProjecYtListCount(con, searchText, no);
	}

	// 프로젝트 목록 조회
	@Override
	public ArrayList<MemberBoardDTO> boardProjecYtList(PageInfo pi, String searchText, int no) {
		return memberBoardDAO.boardProjecYtList(con, pi, searchText, no);
	}
}
