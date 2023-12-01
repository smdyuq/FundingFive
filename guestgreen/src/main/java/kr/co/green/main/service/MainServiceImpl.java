package kr.co.green.main.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;
import kr.co.green.main.dao.MainDAO;
import kr.co.green.main.dto.MainDTO;

public class MainServiceImpl implements MainService {

	private Connection con;
	private DatabaseConnection dc;
	private MainDAO mainDAO;

	public MainServiceImpl() {
		mainDAO = new MainDAO();
	      dc = new DatabaseConnection();
	      con = dc.connDB();
	   }

	@Override
	public int mainListCount() {

		return mainDAO.mainListCount(con);
	}

	@Override
	public ArrayList<MainDTO> mainSelect(PageInfo pi) {

		return mainDAO.mainSelect(con, pi);
	}

}
