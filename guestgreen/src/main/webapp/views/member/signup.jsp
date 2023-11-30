<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="/resources/js/member/signup.js"></script>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>

	<main>

		<h2>회원가입</h2>
		<form action="/signup.do" method="POST">

			<div class="signup-input"></div>
			<div class="signup-input">
				<label for="member-id">아이디:</label> <input type="text"
					id="member-id" name="member-id" onkeyup="duplicateId()"
					placeholder="사용하실 id를 입력해주세요." required><br> <span
					id="idMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-pwd">비밀번호:</label> <input type="password"
					id="member-pwd" name="member-pwd" onkeyup="validatePassword()"
					placeholder="비밀번호를 입력해주세요." required> <br> <span
					id="passwordMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-pwdCheck">비밀번호 확인:</label> <input type="password"
					id="member-pwdCheck" name="member-pwdCheck"
					onkeyup="validatePassword()" placeholder="비밀번호를 확인합니다." required>
				<br> <span id="passwordChkMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-name">이름:</label> <input type="text"
					id="member-name" name="member-name" onkeyup="validateName() "
					placeholder="이름을 입력해주세요." required><br> <span
					id="nameMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-phone">휴대폰 번호:</label> <input type="number"
					id="member-phone" name="member-phone" onkeyup=""
					placeholder="숫자만 입력해주세요." required>
				<button type="button" id="sendPhoneNumber">인증요청</button>
				<br>
				<!-- 인증 요청 성공하면 보이게  -->
				<div id="verificationSection" style="display: none;">
					<input type="number" placeholder="인증번호를 입력해주세요."
						id="verificationCode">
					<button type="button" onclick="randomExample()">인증하기</button>
				</div>
				<br>
				<div class="signup-input">
					<label for="member-addr">주소:</label> <input type="text"
						id="member-addr" name="member-addr" onkeyup=""
						placeholder="주소를 입력해주세요." required> <span id="addrMsg"></span>
				</div>
				<br>
					<input type="submit" id="signupBtn" value="회원가입" disabled>
			</div>
		</form>

	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
