package kr.co.green.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

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

//   인기 프로젝트 조회
   @Override
   public ArrayList<ProjectDTO> projectPopularity() {
      return mainDAO.projectPopularity(con);
   }

// 좋아요 눌렀던 프로젝트 가져오기
public void getLikedProject(int memberNo, HashMap<Integer, String> userLikeMap) {
	mainDAO.getLikedProject(con, memberNo, userLikeMap);
}


}