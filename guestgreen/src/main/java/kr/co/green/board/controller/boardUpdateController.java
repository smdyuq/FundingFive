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
import javax.servlet.http.Part;

import kr.co.green.board.service.BoardServiceImpl;

@WebServlet("/boardUpdate.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024,  //1MB
		maxFileSize = 1024*1024*5,		//파일 한개의 최대사이즈 5MB
		maxRequestSize = 1024*1024*5*5	//여러파일을 보낼때 한번에 보낼수 있는 용량 25MB
		)
public class boardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boardUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      
	    //값 받기(idx,제목,내용)
			int idx = Integer.parseInt(request.getParameter("idx"));
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(content);			
//			System.out.println("idx: " +idx);
//			System.out.println("title: " +title);
//			System.out.println("content: " +content);
			
			//파일 업로드
			Collection<Part> parts = request.getParts();
			String uploadDirectory = "C:\\Users\\jaeyun\\git\\guestgreen\\guestgreen\\src\\main\\webapp\\resources\\uploads";
			
			
			//파일 업로드 디렉토리(폴더)가 없으면 생성
			File filePath = new File(uploadDirectory);
			if(!filePath.exists()) {
				filePath.mkdirs();
			}

			boolean flag = false;	
			
			String fileName = "";
			for(Part part : parts) {
				if(getFileName(part) != null || !Objects.isNull(getFileName(part))) {
					fileName = getFileName(part);
					if(!fileName.equals("")) { // 파일 업로드를 새로 했을 때(수정)
						flag = true;
						part.write(filePath + File.separator + fileName);
					}
				}
			}
			
			
			//서비스 호출(DTO or 매개변수)
			BoardServiceImpl boardService = new BoardServiceImpl();
			int result; 
			
			if(flag) { // 파일 업로드를 새로 했을 때 (수정)
				result = boardService.boardUpdate(idx,title,content,fileName,uploadDirectory);
			}else { // 파일 업로드를 하지 않았을 때 (파일쪽 수정X, 원본 데이터 그대로 냅둬야함)
				result = boardService.boardUpdate2(idx, title, content);
			}
			
			
			
			if(result > 0) {
				//이미지 수정 추가
//				if (fileName != null && !fileName.isEmpty()) {
//					response.sendRedirect("/boardList.do?cpage=1");
					RequestDispatcher view = request.getRequestDispatcher("/boardList.do?cpage=1");
					view.forward(request, response);
					
//				}sysout
//				response.sendRedirect("/boardList.do?cpage=1");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("/views/common/error.jsp");
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
