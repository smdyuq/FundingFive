package kr.co.green.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.green.board.service.BoardServiceImpl;

@WebServlet("/boardEnroll.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024,  //1MB
		maxFileSize = 1024*1024*5,		//파일 한개의 최대사이즈 5MB
		maxRequestSize = 1024*1024*5*5	//여러파일을 보낼때 한번에 보낼수 있는 용량 25MB
		)

public class boardEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boardEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//내용, 제목 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//세션에 있는 name받아오기
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("writer");
		
		//파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "C:\\Users\\jaeyun\\git\\guestgreen\\guestgreen\\src\\main\\webapp\\resources\\uploads";
		
		//파일 업로드 디렉토리(폴더)가 없으면 생성
		File filePath = new File(uploadDirectory);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		
		
		// "C:\\Users\\jaeyun\\git\\guestgreen\\guestgreen\\src\\main\\webapp\\resources\\uploads"+"";
		String fileName = "";
		for(Part part : parts) {
//			System.out.println(getFileName(part));
//			System.out.println(getFileName(part) != null);
//			System.out.println(!Objects.isNull(getFileName(part)));
			if(getFileName(part) != null || !Objects.isNull(getFileName(part))) {
				fileName = getFileName(part);
				if(!fileName.equals("")) {
					part.write(filePath + File.separator + fileName);
				}
			}else {
				fileName = "";
				uploadDirectory = "";
			}
		}

		//서비스 호출
		BoardServiceImpl boardService = new BoardServiceImpl();

		int result = 1;
		System.out.println("title length :" + title.length());
		System.out.println("content length : " + content.length());
		if(title.length() == 0 || content.length() == 0) {
			result = 0;
		}else {
			result = boardService.boardEnroll(title,content,writer,fileName,uploadDirectory);
			
		}
		
		//성공 유무에 따라 처리
		if(result > 0) {
			response.sendRedirect("/boardList.do?cpage=1");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("/test");
			view.forward(request, response);
		}
	}

	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] tokens = contentDisposition.split(";");
		
		for(String token : tokens) {
			if(token.trim().startsWith("filename")) {
				
				return token.substring(token.indexOf('=')+2, token.length()-1);
			}
		}
		return null;
	}

}
