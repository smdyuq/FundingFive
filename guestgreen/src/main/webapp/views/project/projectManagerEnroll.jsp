<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<section>
			<div class="project-manager-enroll-form">
				<h2>창작자 등록</h2>
				<hr>
				<form action="/projectManagerEnroll.do" method="post"
					enctype="multipart/form-data">

					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">프로젝트
							창작자 이름 </label> <input type="text" class="form-control"
							id="exampleFormControlInput1" name="project-manager-name"
							required> <label for="exampleFormControlInput1"
							class="form-label">프로젝트 창작자 소개 </label> <input type="text"
							class="form-control" id="exampleFormControlInput1"
							name="project-manager-introduce" required> <label
							for="exampleFormControlInput1" class="form-label">프로젝트
							창작자 계좌 </label> <input type="text" class="form-control"
							id="exampleFormControlInput1" name="project-manager-account"
							required> <label for="exampleFormControlInput1"
							class="form-label">프로젝트 창작자 프로필 이미지 </label> <input type="file"
							class="form-control" id="exampleFormControlInput1"
							name="project_manager_image" required> <br>

						<button class="btn btn-primary" type="submit">프로젝트 등록</button>
				</form>
			</div>
		</section>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>