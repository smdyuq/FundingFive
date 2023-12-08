package kr.co.green.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberService;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/form/*")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		String nextPage = "";

		if (action.equals("/loginform.do")) { // 홈>로그인페이지 이동
			nextPage = "/views/member/login.jsp";
		} else if (action.equals("/signupform.do")) {
			nextPage = "/views/member/signup.jsp"; // 홈>회원가입페이지 이동

		} else if (action.equals("/projectEnrollForm.do")) {

			nextPage = "/views/project/projectEnroll.jsp";
		}
		else if(action.equals("/home.do")){
			HttpSession session = request.getSession();
			if(session.getAttribute("memberNo") != null) {
			}
			nextPage = "/"; // 홈으로 이동
		}


		// 페이지 포워딩
		if(!nextPage.isEmpty()){
			response.sendRedirect(nextPage);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
