package kr.co.green.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;


@WebServlet("/memberDelete.do")
public class memberDelelteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public memberDelelteController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("member-name");
		String id = request.getParameter("member-id");
		String pwd = request.getParameter("member-pwd");
		int sessionId = (int)session.getAttribute("no");
		
		MemberDTO memberDTO = new MemberDTO(id, name, pwd);
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.deleteUpdate(memberDTO, sessionId);
		
		if(result == 0) {
			DeleteAlert(response, "회원 탈퇴에 실패 했습니다."); 
			session.removeAttribute("no");
			session.invalidate();

		}else {
			session.removeAttribute("no");
			DeleteAlert(response, "회원 탈퇴에 성공 했습니다.");
		
		}
		
	}
		private void DeleteAlert(HttpServletResponse response, String msg) throws IOException {
			PrintWriter out = response.getWriter();
			out.println("<script>" 
					+"   location.href='/';"
					+"   alert('" + msg + "');"
					+"   </script>");
			out.flush(); 
			out.close();
		}

}
