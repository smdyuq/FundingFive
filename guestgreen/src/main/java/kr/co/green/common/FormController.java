package kr.co.green.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/form/*")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		String nextPage = ""; 
		HttpSession session = request.getSession();
		 
		
		if (action.equals("/loginform.do")) { //홈>로그인페이지 이동 
	        nextPage = "/views/member/login.jsp";
	    }else if(action.equals("/signupform.do")){
	    	nextPage = "/views/member/signup.jsp"; //홈>회원가입페이지 이동
	    }else if(action.equals("/mypageform.do")) {
	    	nextPage = "/views/member/Mypage.jsp"; //홈>마이페이지 이동
	    }

	    
	    
	    // 페이지 포워딩
	    if (!nextPage.isEmpty()) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
	        dispatcher.forward(request, response);
	    }
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    doGet(request, response);
	}

}
