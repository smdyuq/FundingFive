<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
	<%@include file="../../views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/login.css">
</head>
<body>
	<%@include file="../../views/common/header.jsp" %>
	<%@include file="../../views/common/common.jsp"%>

	<main>
		<section>
			<div class="container_div">
				<div class="login-form">
					<h2>로그인</h2>
					<form action="/login.do" method="post">
						<div class="id-div">

							<input type="text" id="member-id" name="member-id"
								placeholder="id" required> <span></span>
						</div>
						<div class="pwd-div">

							<input type="password" id="member-pwd" name="member-pwd"
								placeholder="password" required> <span></span> <br>
						</div>
						<button class="login-btn" type="submit">로그인</button>
					</form>
				</div>
			</div>
		</section>

	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
<script>
    /* 로그인 실패 팝업 */
        <%String errorMessage = (String) request.getAttribute("loginErrorMessage");
if (errorMessage != null && !errorMessage.isEmpty()) {%>
            alert('<%=errorMessage%>
	');
<%}%>
	
</script>