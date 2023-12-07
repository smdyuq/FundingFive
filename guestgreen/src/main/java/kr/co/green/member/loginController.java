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
import kr.co.green.member.model.service.MemberService;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/login.do")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 유저가 입력한 데이터 받기
		String memberId = request.getParameter("member-id");
		String memberPwd = request.getParameter("member-pwd");
		
		// 2. 받은 데이터(아이디,패스워드)가 일치하는지
		MemberService memberService = new MemberServiceImpl();

		// 패스워드 확인
		MemberDTO memberDTO = memberService.memberLogin(memberId);
		if (BCrypt.checkpw(memberPwd, memberDTO.getMemberPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("memberNo", memberDTO.getMemberNo());
			session.setAttribute("memberName", memberDTO.getMemberName());
			session.setAttribute("memberType", memberDTO.getMemberType());
			request.setAttribute("memberDTO", memberDTO);
		
			response.sendRedirect("/");
		} else {
			AlertAndRedirect.alertRedirect(response, "로그인에 실패했습니다.", "/");
		}
	}
}