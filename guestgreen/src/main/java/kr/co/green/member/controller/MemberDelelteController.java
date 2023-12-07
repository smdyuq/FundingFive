package kr.co.green.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberService;
import kr.co.green.member.model.service.MemberServiceImpl;


@WebServlet("/memberDelete.do")
public class MemberDelelteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDelelteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("memberNo");
		
		MemberService memberService = new MemberServiceImpl();
		
		if(memberService.memberDelete(memberNo) > 0) {
			session.removeAttribute("memberNo");
			session.invalidate();
			AlertAndRedirect.alertRedirect(response, "회원 탈퇴에 성공했습니다.", "/");
		}else {
			AlertAndRedirect.alertRedirect(response, "회원 탈퇴에 실패했습니다.", "/");
		}
		
	}
}
