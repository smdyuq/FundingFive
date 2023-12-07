package kr.co.green.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;

public class MainDAO {

   private PreparedStatement pstmt;

//   배너 조회
   public ArrayList<ProjectDTO> bannerSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, p2.PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
            + " ORDER BY PROJECT_VIEWS DESC FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   주목할만한 프로젝트 조회
   public ArrayList<ProjectDTO> noteworthySelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
            + " FROM (SELECT PROJECT.*, ROW_NUMBER() OVER (ORDER BY PROJECT_VIEWS DESC) as RANK FROM PROJECT WHERE PROJECT_CONFIRM_STATUS = 'Y') P1"
            + " JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE P1.RANK BETWEEN 5 AND 12";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   인기 프로젝트 조회
   public ArrayList<ProjectDTO> popularitySelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
            + " ORDER BY PROJECT_CURRENT_PERCENTAGE DESC FETCH FIRST 6 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   마감 임박 프로젝트 조회
   public ArrayList<ProjectDTO> DeadlineSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, PROJECT_OUTER_IMAGE_NAME, PROJECT_KIND, PROJECT_MANAGER_NAME, PROJECT_INTRODUCE, PROJECT_CURRENT_PERCENTAGE FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE PROJECT_CONFIRM_STATUS = 'Y'"
            + " AND PROJECT_END_DATE BETWEEN SYSDATE AND SYSDATE + 1 FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   최근 본 프로젝트 조회
   public ArrayList<ProjectDTO> recentProjectSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE "
            + " FROM RECENT_PROJECT P3 JOIN PROJECT P1 ON P3.PROJECT_NO = P1.PROJECT_NO"
            + " JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO WHERE P1.PROJECT_CONFIRM_STATUS = 'Y'"
            + " ORDER BY P3.RECENT_PROJECT_DATE DESC FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   이런 프로젝트 어때요 조회
   public ArrayList<ProjectDTO> RecommendedSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT * FROM (SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
            + "  FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
            + "  WHERE P1.PROJECT_CONFIRM_STATUS = 'Y'"
            + "  ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= 10 FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   신규 프로젝트 조회
   public ArrayList<ProjectDTO> newProjectSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
            + " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
            + " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' ORDER BY P1.PROJECT_REGISTER_DATE DESC FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   공개 예정 프로젝트 조회   
   public ArrayList<ProjectDTO> soonProjectSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
            + " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
            + " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' AND P1.PROJECT_END_DATE BETWEEN SYSDATE AND SYSDATE + 7 FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

//   오늘 오픈한 프로젝트 조회
   public ArrayList<ProjectDTO> todayProjectSelect(Connection con) {
      ArrayList<ProjectDTO> list = new ArrayList<>();

      String query = "SELECT P1.PROJECT_NO, P1.PROJECT_OUTER_IMAGE_NAME, P1.PROJECT_KIND, P2.PROJECT_MANAGER_NAME, P1.PROJECT_INTRODUCE, P1.PROJECT_CURRENT_PERCENTAGE"
            + " FROM PROJECT P1 JOIN PROJECT_MANAGER P2 ON P1.PROJECT_NO = P2.PROJECT_NO"
            + " WHERE P1.PROJECT_CONFIRM_STATUS = 'Y' AND TRUNC(P1.PROJECT_REGISTER_DATE) = TRUNC(SYSDATE) order by project_register_date desc FETCH FIRST 4 ROWS ONLY";

      try {
         pstmt = con.prepareStatement(query);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int projectNo = rs.getInt("PROJECT_NO");
            String projectOuterImageName = rs.getString("PROJECT_OUTER_IMAGE_NAME");
            String projectKind = rs.getString("PROJECT_KIND");
            String projectManagerName = rs.getString("PROJECT_MANAGER_NAME");
            String projectIntroduce = rs.getString("PROJECT_INTRODUCE");
            int projectCurrentPercentage = rs.getInt("PROJECT_CURRENT_PERCENTAGE");

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectNo(projectNo);
            projectDTO.setProjectOuterImageName(projectOuterImageName);
            projectDTO.setProjectKind(projectKind);
            projectDTO.setProjectManagerName(projectManagerName);
            projectDTO.setProjectIntroduce(projectIntroduce);
            projectDTO.setProjectCurrentPercentage(projectCurrentPercentage);

            list.add(projectDTO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }

}