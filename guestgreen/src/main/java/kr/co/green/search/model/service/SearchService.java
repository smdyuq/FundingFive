package kr.co.green.search.model.service;

import kr.co.green.search.model.dto.SearchDTO;

public interface SearchService {

	//회원 검색내역 조회
	public abstract SearchDTO[] getSearchHistory(int memberNo);

	//인기검색어 조회
	public abstract SearchDTO[] getPopularSearch();

	//선택한 회원 검색기록 삭제
	public abstract int deleteSearchHistory(int searchNo);
}
