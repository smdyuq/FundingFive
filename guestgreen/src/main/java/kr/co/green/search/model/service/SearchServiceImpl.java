package kr.co.green.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.search.model.dao.SearchDAO;
import kr.co.green.search.model.dto.SearchDTO;

public class SearchServiceImpl implements SearchService {
	private DatabaseConnection dc;
	private Connection con;
	private SearchDAO searchDAO;
	
	public SearchServiceImpl() {
		dc = new DatabaseConnection();
		con = dc.connDB();
		searchDAO = new SearchDAO();
	}
	
	//회원 검색기록 조회
	@Override
	public ArrayList<SearchDTO> getSearchHistory(int memberNo) {
		return searchDAO.getSearchHistory(con, memberNo);
	}

	//인기검색어 조회
	@Override
	public SearchDTO[] getPopularSearch() {
		return searchDAO.getPopularSearch(con);
	}

	//선택한 회원 검색기록 삭제
	@Override
	public int deleteSearchHistory(int searchNo) {
		return searchDAO.deleteSearchHistory(con, searchNo);
	}

	//프로젝트 검색
	@Override
	public void getSearchedProject(String searchWord, ArrayList<ProjectDTO> searchedProjectList) {
		searchDAO.getSearchedProject(con, searchWord, searchedProjectList);
	}

	//검색결과 수 조회
	@Override
	public int getSearchedCount(String searchWord) {
		return searchDAO.getSearchedCount(con, searchWord);
	}

	//검색어 테이블에 등록
	@Override
	public void searchWordEnroll(String searchWord, int memberNo) {
		searchDAO.searchWordEnroll(con, searchWord, memberNo);
	}

}
