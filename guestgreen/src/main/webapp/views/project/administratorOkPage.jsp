<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="/resources/js/project/administratorOk.js"></script>
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
		<h2>상세보기</h2>
		<hr>
		<form id="project-administratorok-form">

			<h3>프로젝트 정보</h3>
			<div class="mb-3">
				<input type="hidden" name="projectNo" value="${leeDTO.projectNo }">


				<label for="exampleFormControlInput1" class="form-label">프로젝트
					이름 </label> <input type="text" class="form-control"
					id="exampleFormControlInput1" name="project-name"
					value="${ leeDTO.projectName}" disabled> <label
					for="exampleFormControlInput1" class="form-label">프로젝트 소개 </label>
				<input type="text" class="form-control"
					id="exampleFormControlInput1" name="project-introduce"
					value="${ leeDTO.projectIntroduce}" disabled> <label
					for="exampleFormControlInput1" class="form-label">프로젝트 내용 </label>
				<div name="project-content">${leeDTO.projectContent }</div>
				<label for="exampleFormControlInput1" class="form-label">프로젝트
					카테고리 </label> <input type="text" class="form-control"
					id="exampleFormControlInput1" name="project-kind"
					value="${ leeDTO.projectKind}" disabled> <label
					for="exampleFormControlInput1" class="form-label">프로젝트 가격 </label>
				<input type="text" class="form-control"
					id="exampleFormControlInput1" name="project-price"
					value="${ leeDTO.projectPrice}" disabled> <label
					for="exampleFormControlInput1" class="form-label">프로젝트 목표
					후원금액 </label> <input type="text" class="form-control"
					id="exampleFormControlInput1" name="project-target_amount"
					value="${ leeDTO.projectTargetAmount}" disabled> <label
					for="exampleFormControlInput1" class="form-label">프로젝트 마감일
				</label> <input type="text" class="form-control"
					id="exampleFormControlInput1" name="project-end-date"
					value="${ leeDTO.projectEndDate}" disabled> <label
					for="exampleFormControlInput1" class="form-label">프로젝트 이미지
				</label> <br> <img
					src="/resources/uploads/${leeDTO.projectOuterImageName }"><br>

				<hr>

				<h3>창작자 정보</h3>
				<label for="exampleFormControlInput1" class="form-label">창작자명
				</label> <input type="text" class="form-control"
					id="exampleFormControlInput1" name="manager-name"
					value="${ leeDTO.projectManagerName}" disabled> <label
					for="exampleFormControlInput1" class="form-label">창작자 소개 </label> <input
					type="text" class="form-control" id="exampleFormControlInput1"
					name="manager-introduce" value="${ leeDTO.projectManagerIntroduce}"
					disabled> <label for="exampleFormControlInput1"
					class="form-label">창작자 계좌 </label> <input type="text"
					class="form-control" id="exampleFormControlInput1"
					name="manager-account" value="${ leeDTO.projectMangerAccount}" disabled>
				<label for="exampleFormControlInput1" class="form-label">창작자
					프로필 사진 </label> <br> <img
					src="/resources/uploads/${leeDTO.projectManagerImageName }"><br>
				<br>
			
				<button class="btn btn-primary" type="button" onclick="yesButton()">승인</button>
				<button class="btn btn-primary" type="button" onclick="noButton()">거절</button>
		</form>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>