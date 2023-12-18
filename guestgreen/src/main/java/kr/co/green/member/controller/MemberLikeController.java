package kr.co.green.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.service.MemberService;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/memberLike.do")
public class MemberLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLikeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		PrintWriter out = response.getWriter();
		
		//memberNo 비어있으면 로그인 페이지로 속성값 넣어서 리다이렉트
		if(Objects.isNull(session.getAttribute("memberNo"))) {
			session.setAttribute("click", "like");
			session.setAttribute("projectNo", projectNo);
			out.print("loginForm");
		}
		else {
			int memberNo = (int)session.getAttribute("memberNo");
			
			MemberService memberService = new MemberServiceImpl();
			memberService.memberLikeCheck(memberNo, projectNo);
			out.print("success");
		}
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
