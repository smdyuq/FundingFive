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

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/signup.do")
public class SignupContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupContorller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 폼 데이터 수집
		String id = request.getParameter("member-id");
		String pwd = request.getParameter("member-pwd");
		String name = request.getParameter("member-name");
		String phone = request.getParameter("member-phone");
		String addr = request.getParameter("member-addr");

		//id유효성 검사 
		String idRegex = "^[a-zA-Z0-9]{4,12}$";
		Pattern idpattern = Pattern.compile(idRegex);
		Matcher idMatcher = idpattern.matcher(id);

		// 이름 유효성 검사
		String nameRegex = "^[가-힣]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);

		// 패스워드
		String pwdRegex = "^(?=.*[a-zA-Z])(?=.*[@$!%*?&\\#])[A-Za-z\\d@$!%*?&\\#]{6,20}$";
		Pattern passwordPattern = Pattern.compile(pwdRegex);
		Matcher passwordMatcher = passwordPattern.matcher(pwd);

		if (idMatcher.matches() && nameMatcher.matches() && passwordMatcher.matches()) {
			//패스워드 암호화
			String salt = BCrypt.gensalt(12);
			String hashedPassword = BCrypt.hashpw(pwd, salt);
			
			MemberDTO memberDTO = new MemberDTO(id, hashedPassword, name, phone, addr);
			
			// 서비스 호출
			MemberServiceImpl memberService = new MemberServiceImpl();
			int result = memberService.memberSignUp(memberDTO);

			if (result > 0) {
				// 회원가입 성공
				AlertAndRedirect.alertRedirect(response, "회원가입에 성공했습니다.", "/");
			} else {
				// 회원가입 실패
				AlertAndRedirect.alertRedirect(response, "회원가입에 실패했습니다.", "/form/signupform.do");
			}

		}else if(!idMatcher.matches()) {
			AlertAndRedirect.alertRedirect(response, "아이디가 정책에 맞지 않습니다.", "/form/signupform.do");			
		} else if (!nameMatcher.matches()) { 
			AlertAndRedirect.alertRedirect(response, "이름은 한글만 가능합니다.", "/form/signupform.do");			

		} else if (!passwordMatcher.matches()) {
			AlertAndRedirect.alertRedirect(response, "비밀번호가 정책에 맞지 않습니다.", "/form/signupform.do");				
		} 
	}


}