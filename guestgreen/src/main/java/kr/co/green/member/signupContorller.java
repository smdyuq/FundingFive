package kr.co.green.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/signup.do")
public class signupContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signupContorller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 폼 데이터 수집
		String id = request.getParameter("member-id");
		String pwd = request.getParameter("member-pwd");
		String name = request.getParameter("member-name");
		String phone = request.getParameter("member-phone");
		String addr = request.getParameter("member-addr");


		// 이름 유효성 검사
		String namePattern = "^[가-힣]+$";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher matcher = pattern.matcher(name);

		// 패스워드
		String pwdPattern = "^(?=.*[a-zA-Z])(?=.*[@$!%*?&\\#])[A-Za-z\\d@$!%*?&\\#]{6,20}$";
		Pattern passwordPattern = Pattern.compile(pwdPattern);
		Matcher passwordMatcher = passwordPattern.matcher(pwd);

		MemberDTO memberDTO = new MemberDTO(id, pwd, name, phone, addr);

		if (matcher.matches() && passwordMatcher.matches()) {
			// 서비스 호출
			MemberServiceImpl memberService = new MemberServiceImpl();
			int result = memberService.signUp(memberDTO);

			// 리다이렉트
			if (result > 0) {
			// 회원가입 성공
				RequestDispatcher view = request.getRequestDispatcher("/");
				view.forward(request, response);
			} else {
				// 회원가입 실패
				request.setAttribute("errorMessage", "회원가입에 실패했습니다.");

				RequestDispatcher view = request.getRequestDispatcher("/form/signupform.do");
				view.forward(request, response);
			}
			

		} else if (!matcher.matches()) { // matcher.matches() 정규표현식 통과 true, 실패 false
			validationAlert(response, "이름은 한글만 가능합니다.");
			

		} else if (!passwordMatcher.matches()) {
			validationAlert(response, "비밀번호가 정책에 맞지 않습니다.");

				
		}
	}

	private void validationAlert(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>" + "   location.href='/form/signupform.do';" + "   alert('" + msg + "');" + "   </script>");
		out.flush();
		out.close();
	}

}