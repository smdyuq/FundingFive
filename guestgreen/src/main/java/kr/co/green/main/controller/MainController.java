package kr.co.green.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.main.service.MainServiceImpl;
import kr.co.green.project.model.dto.ProjectDTO;

@WebServlet("/main.do")
public class MainController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MainController() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      MainServiceImpl mainService = new MainServiceImpl();

      ProjectDTO projectDTO = new ProjectDTO();

//      배너 조회      
      ArrayList<ProjectDTO> banner = mainService.bannerSelect();

//      주목할만한 프로젝트 조회
      ArrayList<ProjectDTO> noteworthy = mainService.noteworthySelect();

//      인기 프로젝트 조회
      ArrayList<ProjectDTO> popularity = mainService.popularitySelect();

//      마감 임박 프로젝트 조회
      ArrayList<ProjectDTO> Deadline = mainService.DeadlineSelect();

//      최근 본 프로젝트 조회
      ArrayList<ProjectDTO> recentProject = mainService.recentProjectSelect();

//      이런 프로젝트 어때요 조회
      ArrayList<ProjectDTO> Recommended = mainService.RecommendedSelect();

//      신규 프로젝트 조회
      ArrayList<ProjectDTO> newProject = mainService.newProjectSelect();

//      공개예정 프로젝트 조회
      ArrayList<ProjectDTO> soonProject = mainService.soonProjectSelect();

//      오늘 오픈한 프로젝트 조회
      ArrayList<ProjectDTO> todayProject = mainService.todayProjectSelect();

      // list

//       배너 조회 list   
      request.setAttribute("banner", banner);

//       주목할만한 프로젝트 조회 list      
      request.setAttribute("noteworthy", noteworthy);

//      인기 프로젝트 조회 list
      request.setAttribute("popularity", popularity);

//      마감 임박 프로젝트 조회 list
      request.setAttribute("Deadline", Deadline);

//      최근 본 프로젝트 조회 list
      request.setAttribute("recentProject", recentProject);

//      이런 프로젝트 어때요 조회 list
      request.setAttribute("Recommended", Recommended);

//      신규 프로젝트 조회 list
      request.setAttribute("newProject", newProject);

//      공개 예정 프로젝트 조회 list
      request.setAttribute("soonProject", soonProject);

//      오늘 오픈한 프로젝트 조회 list
      request.setAttribute("todayProject", todayProject);

      RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
      view.forward(request, response);

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

   }

}