package kr.co.green.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.main.model.dao.MainDAO;
import kr.co.green.project.model.dto.ProjectDTO;

public class MainServiceImpl implements MainService {

	private MainDAO mainDAO;
	private DatabaseConnection dc;
	private Connection con;

	public MainServiceImpl() {
		mainDAO = new MainDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

//   배너 조회
	@Override
	public ArrayList<ProjectDTO> bannerSelect() {
		return mainDAO.bannerSelect(con);
	}

//	주목할만한 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> noteworthySelect() {
		return mainDAO.noteworthySelect(con);
	}

//	인기 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> popularitySelect() {
		return mainDAO.popularitySelect(con);
	}

//	마감 임박 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> DeadlineSelect() {
		return mainDAO.DeadlineSelect(con);
	}

//	최근 본 프로젝트 조회
	public ArrayList<ProjectDTO> recentProjectSelect() {
		return mainDAO.recentProjectSelect(con);
	}

//	이런 프로젝트 어때요 조회
	@Override
	public ArrayList<ProjectDTO> RecommendedSelect() {
		return mainDAO.RecommendedSelect(con);
	}

//	신규 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> newProjectSelect() {
		return mainDAO.newProjectSelect(con);
	}

//	달성 완료 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> completeProjectSelect() {
		return mainDAO.completeProjectSelect(con);
	}

//	오늘 오픈한 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> todayProjectSelect() {
		return mainDAO.todayProjectSelect(con);
	}

}