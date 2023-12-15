package kr.co.green.category.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.category.model.service.CategoryServiceImpl;
import kr.co.green.project.model.dto.ProjectDTO;

@WebServlet("/menu.do")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryServiceImpl categoryService = new CategoryServiceImpl();

		String menu = request.getParameter("menu");

		ArrayList<ProjectDTO> list = new ArrayList<>();

		String title = "";

		if (menu.equals("proceeding")) {
			list = categoryService.proceedingProject();
			title = "진행중인 프로젝트";
		} else if (menu.equals("complete")) {
			list = categoryService.completeProject();
			title = "달성완료 프로젝트";
		} else if (menu.equals("popularity")) {
			list = categoryService.popularityProject();
			title = "인기 프로젝트";
		} else if (menu.equals("noteworthy")) {
			list = categoryService.noteworthyProject();
			title = "주목할 만한 프로젝트";
		}

		for (int i = 0; i < list.size(); i++) {
			String endDate = list.get(i).getProjectEndDate(); // 가져온 날짜 문자열

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

			LocalDate endDateLocalDateType = LocalDate.parse(endDate, formatter);
			LocalDate currentDate = LocalDate.now();

			long dDay = ChronoUnit.DAYS.between(currentDate, endDateLocalDateType);

			list.get(i).setProjectRemainDate(dDay);
		}

		request.setAttribute("title", title);

		request.setAttribute("list", list);

		RequestDispatcher view = request.getRequestDispatcher("/views/category/projectMenu.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
