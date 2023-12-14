package kr.co.green.member.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.member.model.dto.MemberBoardDTO;

public interface MemberBoardService {

	//회원 본인이 등록한 프로젝트 중 승인된 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyApprovedProject(int memberNo);
	
	//회원 본인이 등록한 프로젝트 중 승인되지않은 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyRejectedProject(int memberNo);

	//보류된 프로젝트 조회
	public ArrayList<MemberBoardDTO> getMyPendingProject(int memberNo);

	//좋아요 누른 프로젝트 조회
	public ArrayList<MemberBoardDTO> getLikedProject(int memberNo);
	
}
