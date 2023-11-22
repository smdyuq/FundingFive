<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<section>
			<div class="project-administratorok-form">
				<h2>프로젝트 승인</h2>
				<form action="/administratorOk.do" method="post">

					<label for="project-name">프로젝트 :</label>
					<button type="submit" id="yesButton">승인</button>
					<button type="submit" id="noButton">거절</button>
				</form>
			</div>
		</section>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>