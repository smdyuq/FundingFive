
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<%@include file="../../views/common/head.jsp"%>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>

	<main>
		<section>
			<div class="login-form">
				<h2>로그인</h2>
				<form action="/login.do" method="post">

					<label for="member-id">아이디 :</label> <input type="text"
						id="member-id" name="member-id" required> <br> <label
						for="member-pwd">비밀번호 :</label> <input type="password"
						id="member-pwd" name="member-pwd" required><br>

					<button type="submit">로그인</button>
				</form>
			</div>
		</section>

	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
<script>
    /* 로그인 실패 팝업 */
        <% String errorMessage = (String) request.getAttribute("loginErrorMessage");
        if (errorMessage != null && !errorMessage.isEmpty()) { %>
            alert('<%= errorMessage %>
	');
<% } %>
	
</script>