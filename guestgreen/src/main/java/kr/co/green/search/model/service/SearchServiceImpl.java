package kr.co.green.search.model.service;

import java.sql.Connection;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.search.model.dao.SearchDAO;
import kr.co.green.search.model.dto.SearchDTO;

public class SearchServiceImpl implements SearchService {
	private DatabaseConnection dc;
	private Connection con;
	private SearchDAO searchDAO;
	
	public SearchServiceImpl() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	//회원 검색기록 조회
	@Override
	public SearchDTO[] getSearchHistory(int memberNo) {
		return searchDAO.getMemberSearch(con, memberNo);
	}

	//인기검색어 조회
	@Override
	public String[] getPopularSearch() {
		return searchDAO.getPopularSearch(con);
	}

}
