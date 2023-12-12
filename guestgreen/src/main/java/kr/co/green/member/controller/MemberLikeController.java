package kr.co.green.member.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.member.model.service.MemberService;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/MemberLikeController")
public class MemberLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLikeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int memberNo = (int)request.getAttribute("memberNo");
		int projectNo = (int)request.getAttribute("projectNo");
		
		//memberNo 비어있으면 로그인 페이지로 속성값 넣어서 리다이렉트
		if(Objects.isNull(session.getAttribute("memberNo"))) {
			session.setAttribute("click", "like");
			session.setAttribute("projectNo", projectNo);
			response.sendRedirect("/views/member/login.jsp");
		}
		MemberService memberService = new MemberServiceImpl();
		if(memberService.memberLike(memberNo, projectNo) > 0) {
			//후에 하트 빨간색으로 변하는 로직 추가
			AlertAndRedirect.alertRedirect(response, "관심프로젝트에 추가되었습니다.", "/");
		}else {System.out.println("MemberLikeController 37번 라인 if문 못들어감");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
