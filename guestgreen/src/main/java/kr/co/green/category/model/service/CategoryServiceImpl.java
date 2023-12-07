package kr.co.green.category.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.category.model.dao.CategoryDAO;
import kr.co.green.common.DatabaseConnection;
import kr.co.green.project.model.dto.ProjectDTO;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;
	private DatabaseConnection dc;
	private Connection con;

	public CategoryServiceImpl() {
		categoryDAO = new CategoryDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

//	카테고리 전체 조회
	@Override
	public ArrayList<ProjectDTO> categoryEntire() {
		return categoryDAO.categoryEntire(con);
	}

//	카테고리 가전 조회
	@Override
	public ArrayList<ProjectDTO> categoryAppliances() {
		return categoryDAO.categoryAppliances(con);
	}

//	카테고리 의류 조회
	@Override
	public ArrayList<ProjectDTO> categoryClothes() {
		return categoryDAO.categoryClothes(con);
	}

//	카테고리 향수, 뷰티 조회
	@Override
	public ArrayList<ProjectDTO> categoryBeauty() {
		return categoryDAO.categoryBeauty(con);
	}

//	카테고리 푸드 조회
	@Override
	public ArrayList<ProjectDTO> categoryFood() {
		return categoryDAO.categoryFood(con);
	}

//	카테고리 주얼리 조회
	@Override
	public ArrayList<ProjectDTO> categoryJewelry() {
		return categoryDAO.categoryJewelry(con);
	}

//	진행중인, 달성완료, 인기 프로젝트 조회

//	진행중인 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> proceedingProject() {
		return categoryDAO.proceedingProject(con);
	}

//	달성완료 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> completeProject() {
		return categoryDAO.completeProject(con);
	}

//	인기 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> popularityProject() {
		return categoryDAO.popularityProject(con);
	}

}
