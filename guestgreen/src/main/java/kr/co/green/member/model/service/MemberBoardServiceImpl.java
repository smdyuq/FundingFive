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
	//회원 본인이 등록한 프로젝트 중 승인된 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyApprovedProject(int memberNo) {
		return memberBoardDAO.getMyApprovedProject(con, memberNo);
	}

	//회원 본인이 등록한 프로젝트 중 승인되지않은 프로젝트 조회
	@Override
	public ArrayList<MemberBoardDTO> getMyRejectedProject(int memberNo) {
		return memberBoardDAO.getMyRejectedProject(con, memberNo);
	}

	//보류된 프로젝트 조회
	@Override
	public ArrayList<MemberBoardDTO> getMyPendingProject(int memberNo) {
		return memberBoardDAO.getMyPendingProject(con, memberNo);
	}
}
