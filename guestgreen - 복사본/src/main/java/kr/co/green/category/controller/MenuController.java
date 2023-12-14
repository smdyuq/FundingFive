package kr.co.green.category.controller;

import java.io.IOException;
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
