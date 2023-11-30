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

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectServiceImpl;

@WebServlet("/projectDetail.do")
public class projectAdministratorDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public projectAdministratorDetail() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		int no = (int) session.getAttribute("no");
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberDTO memberDTO = memberService.memberSelect(no);
		request.setAttribute("member", memberDTO);

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		ProjectDTO leeDTO = new ProjectDTO();
		leeDTO.setProjectNo(projectNo);

		ProjectServiceImpl projectleeservice = new ProjectServiceImpl();

//		승인페이지 상세보기 프로젝트 조회
		projectleeservice.projectDetail(leeDTO);

		// 비어있지않을때
		if (!Objects.isNull(leeDTO.getProjectNo())) {
			// administratorOkPage로 포워딩
			request.setAttribute("leeDTO", leeDTO);
			RequestDispatcher view = request.getRequestDispatcher("/views/project/administratorOkPage.jsp");
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
