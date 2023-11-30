package kr.co.green.donate.model.service;

import kr.co.green.donate.model.dto.DonateDTO;

public interface DonateService {

	//후원 성공 시 후원자 테이블 등록
	public abstract int donateEnroll(DonateDTO donateDTO);

}
