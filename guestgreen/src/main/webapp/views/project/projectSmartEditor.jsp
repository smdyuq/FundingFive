<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp" %>
<script type="text/javascript" src="/resources/js/common/smarteditor.js" 
charset="utf-8"></script>
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
	<form action="/smartEditor.do" method="post">
		<input type="hidden" name="project-name" value="${projectDTO.projectName}">
		<input type="hidden" name="project-introduce" value="${projectDTO.projectIntroduce}">
		<input type="hidden" name="project-kind" value="${projectDTO.projectKind}">
		<input type="hidden" name="project-price" value="${projectDTO.projectPrice}">
		<input type="hidden" name="project-target-amount" value="${projectDTO.projectTargetAmount}">
		<input type="hidden" name="project-end-date" value="${projectDTO.projectEndDate}">
		<input type="hidden" name="project-outer-image-name" value="${projectDTO.projectOuterImageName}">
		<input type="hidden" name="project-outer-image-path" value="${projectDTO.projectOuterImagePath}">
		<input type="hidden" name="project-inner-image-name" value="${projectDTO.projectInnerImageName}">
		<input type="hidden" name="project-inner-image-path" value="${projectDTO.projectInnerImagePath}">
		<h2>프로젝트 스토리</h2>
		<hr>
		<div id="smarteditor">
			<textarea name ="editorTxt" id="editorTxt" rows="13" cols="10" placeholder="내용을 입력해주세요"
			style="width:500px"></textarea>
		</div>
			<button type="submit" class="btn btn-primary" onclick="save()">등록</button>
	</form>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>