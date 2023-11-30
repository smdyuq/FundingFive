package kr.co.green.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.member.model.dto.MemberBoardDTO;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberBoardService;
import kr.co.green.member.model.service.MemberBoardServiceImpl;
import kr.co.green.member.model.service.MemberService;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/myPage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MypageController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 로그인한 사용자 정보
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("memberNo");
		
		MemberService memberService = new MemberServiceImpl();
		MemberDTO memberDTO = memberService.memberSelect(memberNo);

		// 관리자가 승인한 프로젝트 목록
		MemberBoardService memberBoardService = new MemberBoardServiceImpl();
		ArrayList<MemberBoardDTO> projectApprovedList = memberBoardService.getMyApprovedProject(memberNo);
		
		// 관리자가 보류/거절한 프로젝트 목록
		ArrayList<MemberBoardDTO> projectRejectedList = memberBoardService.getMyRejectedProject(memberNo);
		
		if(!Objects.isNull(memberDTO)) {
			//프로젝트 리스트가 비어있어도 보냄
				request.setAttribute("projectApprovedList", projectApprovedList);
				request.setAttribute("projectRejectedList", projectRejectedList);
				request.setAttribute("memberDTO", memberDTO);
				RequestDispatcher view = request.getRequestDispatcher("/views/member/myPage.jsp");
				view.forward(request, response);
		}
		else {
			AlertAndRedirect.alertRedirect(response, "마이페이지로 이동하는데 실패했습니다.", "/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
