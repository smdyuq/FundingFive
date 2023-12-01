package kr.co.green.donate.controller;

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
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/getData.do")
public class ThrowDataToApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThrowDataToApiController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int memberNo = (int)(session.getAttribute("memberNo"));
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		//로그인 된 유저 정보 가져오기
		MemberService memberService = new MemberServiceImpl();
		MemberDTO memberDTO = memberService.memberSelect(memberNo);
		
		
		if(!Objects.isNull(memberDTO)) {
			//프로젝트 정보(이름, 가격) 가져오기
			ProjectService projectService = new ProjectServiceImpl();
			ProjectDTO projectDTO = projectService.getProjectBasicInfo(projectNo);
			if(!Objects.isNull(projectDTO)) {
				request.setAttribute("memberDTO", memberDTO);
				request.setAttribute("projectDTO", projectDTO);
				RequestDispatcher view = request.getRequestDispatcher("/views/project/projectDonate.jsp");
				view.forward(request, response);
			}
			else {
				
			}
		}else {
			AlertAndRedirect.alertRedirect(response, "회원정보를 불러오지 못했습니다. 다시 시도해주세요.", "/views/project/projectDetail.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}










