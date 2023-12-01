package kr.co.green.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.service.BoardServiceImpl;
import kr.co.green.board.service.PageInfo;
import kr.co.green.board.service.Pagination;


@WebServlet("/boardList.do")
public class boardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public boardListController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//현재 페이지
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		//검색
		String searchText = request.getParameter("searchText");
				
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		//전체 게시글
		int listCount = boardService.boardListCount(searchText);
		//보여질 페이지 수
		int pageLimit = 5;
		//한페이지에 들어갈 게시글 수
		int boardLimit = 10;
		
		//페이징
		Pagination page = new Pagination();
		PageInfo pi = page.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		//목록 불러오기
	      ArrayList<BoardDTO> list = boardService.boardList(pi,searchText);

	    //글번호
	      int row = listCount - (cpage -1)* boardLimit;
	      request.setAttribute("row", row);
	      
	      request.setAttribute("searchText", searchText);
	      
	      request.setAttribute("pi", pi);
	      request.setAttribute("list", list);
	      
	      RequestDispatcher view = request.getRequestDispatcher("/views/board/boardList.jsp");
	      view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
