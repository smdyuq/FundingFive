package kr.co.green.board.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.service.BoardServiceImpl;

@WebServlet("/boardUpdateCheck.do")
public class boardUpdateCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boardUpdateCheckController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// idx 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		
		// 3. idx로 게시판 조회(SELECT)
		BoardDTO board = new BoardDTO();
		board.setIdx(idx);
		
		boardService.boardSelect(board);
		
		if(!Objects.isNull(board.getIdx())) {
			request.setAttribute("board", board);
			RequestDispatcher view = request.getRequestDispatcher("/views/board/boardUpdate.jsp");
			view.forward(request, response);
	}

	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
