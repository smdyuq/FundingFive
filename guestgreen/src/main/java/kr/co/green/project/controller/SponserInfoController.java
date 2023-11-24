package kr.co.green.project.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/getSponserInfo.do")
public class SponserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SponserInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int memberNumber = (int)(session.getAttribute("no"));
		int projectNumber = Integer.parseInt(request.getParameter("projectNumber"));
		
		//로그인 된 유저 정보 가져오기
		MemberService memberService = new MemberServiceImpl();
		MemberDTO memberDTO = memberService.selectMember(memberNumber);
		
		if(!Objects.isNull(memberDTO)) {
			request.setAttribute("memberDTO", memberDTO);
			request.setAttribute("projectNumber", projectNumber);
			RequestDispatcher view = request.getRequestDispatcher("/views/project/projectDonation.jsp");
			view.forward(request, response);
		}else {
			AlertAndRedirect.alertRedirect(response, "회원정보를 불러오지 못했습니다. 다시 시도해주세요.", "/views/project/projectDetail.jsp");
		}
		
	}

}










