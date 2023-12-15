package kr.co.green.category.model.service;

import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;

public interface CategoryService {

//	카테고리 전체 조회
	public ArrayList<ProjectDTO> categoryEntire();

//	카테고리 가전 조회
	public ArrayList<ProjectDTO> categoryAppliances();

//	카테고리 의류 조회
	public ArrayList<ProjectDTO> categoryClothes();

//	카테고리 향수, 뷰티 조회
	public ArrayList<ProjectDTO> categoryBeauty();

//	카테고리 푸드 조회
	public ArrayList<ProjectDTO> categoryFood();

//	카테고리 주얼리 조회
	public ArrayList<ProjectDTO> categoryJewelry();

//	카테고리 크리스마스 조회
	public ArrayList<ProjectDTO> categoryChristmas();

//	진행중인, 달성완료, 인기 프로젝트 조회

//	진행중인 프로젝트 조회
	public ArrayList<ProjectDTO> proceedingProject();

//	달성완료 프로젝트 조회
	public ArrayList<ProjectDTO> completeProject();

//	인기 프로젝트 조회
	public ArrayList<ProjectDTO> popularityProject();

//	주목할만한 프로젝트 조회
	public ArrayList<ProjectDTO> noteworthyProject();
}
