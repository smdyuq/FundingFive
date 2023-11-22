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
			<div class="project-enroll-form">
				<h2>프로젝트 등록</h2>
				<form action="/projectEnroll.do" method="post">

					<label for="project-name">프로젝트 이름 :</label> <input type="text"
						id="project-name" name="project-name" required> <br>
					<label for="project-introduce">프로젝트 소개 :</label> <input type="text"
						id="project-introduce" name="project-introduce" required><br>
					<label for="project-content">프로젝트 상세내용 :</label> <input type="text"
						id="project-content" name="project-content" required><br>
					<label for="project-kind">프로젝트 종류 :</label> <select
						name="project-kind" id="project-kind">
						<option value="all">전체</option>
						<option value="Home Appliances">가전</option>
						<option value="clothing">의류</option>
						<option value="perfume">향수</option>
						<option value="food">음식</option>
					</select><br> <label for="project-price">프로젝트 가격 :</label> <input
						type="text" id="project-price" name="project-price" required><br>
					<label for="project_target_amount">프로젝트 목표 후원금액 :</label> <input
						type="text" id="project_target_amount"
						name="project_target_amount" required><br> <label
						for="project-end-date">프로젝트 마감일 :</label> <input type="date"
						id="project-end-date" name="project-end-date" required><br>

					<button type="submit">다음</button>
				</form>
			</div>
		</section>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>