package kr.co.green.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.service.MemberServiceImpl;


@WebServlet("/duplicateId.do")
public class DuplicateIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DuplicateIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
	       String memberId = request.getParameter("memberId");
	       
	       // 중복 검사 로직
	       MemberServiceImpl memberService = new MemberServiceImpl();
	       boolean isIdDuplicate = memberService.duplicateMemberId(memberId);
	       
	       System.out.println(isIdDuplicate);
	       PrintWriter out = response.getWriter();
	       
	       out.print(isIdDuplicate);
	       out.flush();
	       out.close();
	}

}
