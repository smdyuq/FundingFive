package kr.co.green.search.model.service;

import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.search.model.dto.SearchDTO;

public interface SearchService {

	//회원 검색내역 조회
	public abstract SearchDTO[] getSearchHistory(int memberNo);

	//인기검색어 조회
	public abstract SearchDTO[] getPopularSearch();

	//선택한 회원 검색기록 삭제
	public abstract int deleteSearchHistory(int searchNo);

	//프로젝트 검색
	public abstract void getSearchedProject(String searchWord, ArrayList<ProjectDTO> searchedProjectList);

	//검색된 프로젝트 수 조회
	public abstract int getSearchedCount(String searchWord);

	//검색어 테이블에 등록
	public abstract void searchWordEnroll(String searchWord, int memberNo);
}
