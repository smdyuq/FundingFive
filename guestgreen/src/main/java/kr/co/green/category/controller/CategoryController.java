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

@WebServlet("/category.do")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryServiceImpl categoryService = new CategoryServiceImpl();

		String category = request.getParameter("category");

		ArrayList<ProjectDTO> list = new ArrayList<>();

		String title = "";

		if (category.equals("entire")) {
			list = categoryService.categoryEntire();
			title = "전체";
		} else if (category.equals("Appliances")) {
			list = categoryService.categoryAppliances();
			title = "가전";
		} else if (category.equals("Clothes")) {
			list = categoryService.categoryClothes();
			title = "의류";
		} else if (category.equals("Beauty")) {
			list = categoryService.categoryBeauty();
			title = "향수·뷰티";
		} else if (category.equals("Food")) {
			list = categoryService.categoryFood();
			title = "푸드";
		} else if (category.equals("Jewelry")) {
			list = categoryService.categoryJewelry();
			title = "주얼리";
		} else if (category.equals("Christmas")) {
			list = categoryService.categoryChristmas();
			title = "크리스마스";
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

		RequestDispatcher view = request.getRequestDispatcher("/views/category/category.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
