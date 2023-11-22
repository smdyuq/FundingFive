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

@WebServlet("/Update.do")
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("member-id");
		
		String name = request.getParameter("member-name");
		String phone = request.getParameter("member-phone");
		String addr = request.getParameter("member-addr");
		String updateDate = request.getParameter("updateDate");

		HttpSession session = request.getSession();
		int no = (int) session.getAttribute("no");

		MemberDTO memberDTO = new MemberDTO();

		memberDTO.setId(id);

		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setAddr(addr);
		memberDTO.setUpdateDate(updateDate);

		MemberServiceImpl memberService = new MemberServiceImpl();
		
		int result = memberService.updateMember(memberDTO, no);

		System.out.println("result: " + result);

		if (result > 0) {
		    String message = "회원정보를 수정했습니다.";
		    // session.setAttribute("no", no);
		    AlertAndRedirect.alertRedirect(response, message, "/form/memberform.do");
		} else {
		    String errorMessage = "회원정보를 수정하지 못했습니다. 다시 시도해주세요.";
		    request.setAttribute("errorMessage", errorMessage);
		    RequestDispatcher view = request.getRequestDispatcher("/views/member/member.jsp");
		    view.forward(request, response);
		}

		System.out.println("id: " + id);

		System.out.println("name: " + name);
		System.out.println("phone: " + phone);
		System.out.println("addr: " + addr);
		System.out.println("updateDate: " + updateDate);
		System.out.println("no: " + no);
	}
}