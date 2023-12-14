package kr.co.green.donate.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.donate.model.dao.DonateDAO;
import kr.co.green.donate.model.dto.DonateDTO;

public class DonateServiceImpl implements DonateService{
	
	private Connection con;
    private DatabaseConnection dc;
    private DonateDAO donateDAO;

    public DonateServiceImpl() {
    	donateDAO = new DonateDAO();
        dc = new DatabaseConnection();
        con = dc.connDB();
    }

//    후원 성공 시 후원자 테이블 등록
	@Override
	public int donateEnroll(DonateDTO donateDTO) {
		return donateDAO.donateEnroll(con, donateDTO);
	}

	//상품 배송을 위한 후원자 정보 조회
	@Override
	public ArrayList<DonateDTO> getSponserInfo(int projectNo) {
		return donateDAO.getSponserInfo(con, projectNo);
	}

	
}
