package kr.co.green.donate.model.service;

import java.util.ArrayList;

import kr.co.green.donate.model.dto.DonateDTO;

public interface DonateService {

	//후원 성공 시 후원자 테이블 등록
	public abstract int donateEnroll(DonateDTO donateDTO);

	//상품 배송을 위한 후원자 정보 조회
	public abstract ArrayList<DonateDTO> getSponserInfo(int projectNo);

}
