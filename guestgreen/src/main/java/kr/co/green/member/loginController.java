package kr.co.green.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;


@WebServlet("/login.do")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loginController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		// 1. 유저가 입력한 데이터 받기
        String id = request.getParameter("member-id");
        String pwd = request.getParameter("member-pwd");

        // 2. 받은 데이터(아이디,패스워드)가 일치하는지 
        MemberServiceImpl memberService = new MemberServiceImpl();

        // 패스워드 확인 
        MemberDTO member = memberService.memberLogin(id);

        if (member.getId() != null && pwd.equals(member.getPwd())) {
            System.out.println("로그인 성공");
            HttpSession session = request.getSession();   
            session.setAttribute("no", member.getNo());

            request.setAttribute("member", member);           

            RequestDispatcher view = request.getRequestDispatcher("/");
            view.forward(request, response);
        } else {
            AlertAndRedirect.alertRedirect(response, "회원정보를 불러오지 못했습니다. 다시 시도해주세요.", "views/member/login.jsp");
        }
        
    }
}