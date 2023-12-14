package kr.co.green.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.common.PageInfo;
import kr.co.green.common.Pagination;
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/administratorOk.do")
public class projectAdministratorOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public projectAdministratorOkController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String menu = request.getParameter("menu");

		int listCount = 0;

		// 페이지 코드
		int cpage = Integer.parseInt(request.getParameter("cpage"));

		ProjectService projectService = new ProjectServiceImpl();

//		전체 게시글 수 (승인대기/완료/실패)
		if (menu.equals("first")) {
			listCount = projectService.projectListCount();
		} else if (menu.equals("second")) {
			listCount = projectService.succcessfulCount();
		} else if (menu.equals("third")) {
			listCount = projectService.failCount();
		}

		// 보여질 페이지 수
		int pageLimit = 5;

		// 한 페이지에 들어갈 게시글 수 (0~4) 5개
		// 10 = 0~9 10개
		int boardLimit = 5;

		// 페이징 처리
		Pagination page = new Pagination();
		PageInfo pi = page.getPageInfo(listCount, cpage, pageLimit, boardLimit);

		// 등록 요청된 프로젝트 조회
		ArrayList<ProjectDTO> list = new ArrayList<>();
		if (menu.equals("first")) {
			list = projectService.projectSelect(pi);

		}
		// 기한 만료된 프로젝트 중 달성률 100이상 조회
		else if (menu.equals("second")) {

			list = projectService.getSuccessfulProjects(pi);

		}
		// 기한 만료된 프로젝트 중 달성률 100미만 조회
		else if (menu.equals("third")) {
			list = projectService.getFailedProjects(pi);

		}
		request.setAttribute("menu", menu);
		request.setAttribute("list", list);
		// 나머지 페이징 처리는 common
		request.setAttribute("pi", pi);

		RequestDispatcher view = request.getRequestDispatcher("/views/project/administratorOk.jsp");
		view.forward(request, response);
	}

}
