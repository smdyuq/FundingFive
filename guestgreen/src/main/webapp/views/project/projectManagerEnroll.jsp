<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="project-manager-enroll-form">
				<h2>창작자 등록</h2>
				<form action="/projectManagerEnroll.do" method="post">


					<label for="project-manager-name">프로젝트 매니저 이름 :</label> <input
						type="text" id=" project-manager-name" name="project-manager-name"
						required> <br> <label for="project-manager-introduce">프로젝트
						매니저 소개 :</label> <input type="text" id="project-manager-introduce"
						name="project-manager-introduce" required> <br> <label
						for="project-manager-account">프로젝트 매니저 입금계좌 :</label> <input
						type="text" id="project-manager-account"
						name="project-manager-account" required> <br>

					<button type="submit">프로젝트 등록</button>
				</form>
			</div>
		</section>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>