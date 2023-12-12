package kr.co.green.board.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.service.BoardServiceImpl;
import kr.co.green.common.AlertAndRedirect;

@WebServlet("/boardDetail.do")
public class boardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boardDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      
	      // idx 받기
	      int idx = Integer.parseInt(request.getParameter("idx"));
	
	      BoardServiceImpl boardService = new BoardServiceImpl();
	      //조회수
	      int result = boardService.boardView(idx);

	      // 3. idx로 게시판 조회(SELECT)
	      BoardDTO board = new BoardDTO();
	      board.setIdx(idx);
	          
	      boardService.boardSelect(board);
	          
	      if(!Objects.isNull(board.getIdx())) {
	         request.setAttribute("board", board);
	         RequestDispatcher view = request.getRequestDispatcher("/views/board/boardDetail.jsp");
	         view.forward(request, response);
	      }else {
	         AlertAndRedirect.alertRedirect(response, "로그인 이 필요합니다.", "views/member/login.jsp");
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
