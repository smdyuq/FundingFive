package kr.co.green.main.controller;

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
import kr.co.green.main.dto.MainDTO;
import kr.co.green.main.service.MainServiceImpl;

@WebServlet("/homeform.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 페이지 코드
		int cpage = Integer.parseInt(request.getParameter("cpage"));

		MainServiceImpl mainService = new MainServiceImpl();

//			      전체 게시글 수
		int listCount = mainService.mainListCount();

		// 보여질 페이지 수
		int pageLimit = 5;

		// 한 페이지에 들어갈 게시글 수 (0~4) 5개
		// 10 = 0~9 10개
		int boardLimit = 8;

		// 페이징 처리
		Pagination page = new Pagination();
		PageInfo pi = page.getPageInfo(listCount, cpage, pageLimit, boardLimit);

//			       프로젝트 조회
		ArrayList<MainDTO> list = mainService.mainSelect(pi);

		int row = listCount - (cpage - 1) * boardLimit;
		request.setAttribute("row", row);

		// 나머지 페이징 처리는 common
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);

		RequestDispatcher view = request.getRequestDispatcher("/");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		

	}

}
