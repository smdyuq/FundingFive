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

//  프로젝트 조회
	@Override
	public void projectSelect(ArrayList<ProjectDTO>[] list) {
		mainDAO.projectSelect(con, list);
	}

//	인기 프로젝트 조회
	@Override
	public ArrayList<ProjectDTO> projectPopularity() {
		return mainDAO.projectPopularity(con);
	}

}