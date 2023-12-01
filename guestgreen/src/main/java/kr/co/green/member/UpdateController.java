package kr.co.green.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = request.getParameter("member-id");
		
		String memberName = request.getParameter("member-name");
		String memberPhone = request.getParameter("member-phone");
		String memberAddr = request.getParameter("member-addr");
		String memberCreateDate = request.getParameter("member-createDate");
		String memberUpdateDate = request.getParameter("member-updateDate");

		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("memberNo");

		MemberDTO memberDTO = new MemberDTO();

		memberDTO.setMemberId(memberId);

		memberDTO.setMemberName(memberName);
		memberDTO.setMemberPhone(memberPhone);
		memberDTO.setMemberAddr(memberAddr);
		memberDTO.setMemberCreateDate(memberCreateDate);;
		memberDTO.setMemberUpdateDate(memberUpdateDate);

		MemberServiceImpl memberService = new MemberServiceImpl();
		
		int result = memberService.memberUpdate(memberDTO, memberNo);

		if (result > 0) {
			request.setAttribute("memberDTO", memberDTO);
			RequestDispatcher view = request.getRequestDispatcher("/views/member/myPage.jsp");
			view.forward(request, response);
		} else {
			AlertAndRedirect.alertRedirect(response, "회원정보 수정에 실패했습니다.", "/");
		}
	}
}