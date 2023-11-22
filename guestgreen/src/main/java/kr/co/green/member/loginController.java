package kr.co.green.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

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
            session.setAttribute("name", member.getName());
            session.setAttribute("id", member.getId());
            session.setAttribute("userType", member.getType());

            RequestDispatcher view = request.getRequestDispatcher("/");
            view.forward(request, response);
        } else {
            System.out.println("로그인 실패");

            // 실패 메시디 띄우고 로그인창으로 보냄
            AlertAndRedirect.alertRedirect(response, "로그인에 실패하였습니다.", "/views/member/login.jsp");

        }
    }
}