<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp"%>
<script type="text/javascript" src="/resources/js/common/smarteditor.js"
   charset="utf-8"></script>
<style>
.smarteditor_div {
	width: 80%;
	margin: 0 auto;
}

.form-label {
   font-size: 17px;
}

/* 텍스트 인풋박스 */
.project_content_div>div>input {
   width: 100%;
   height: 30px;
   margin-top: 2%;
   margin-bottom: 2%;
}

.form-select {
   width: 100%;
   height: 30px;
   margin-top: 2%;
   margin-bottom: 2%;
}

/* 파일 인풋박스 */
input[type=file]::file-selector-button {
   width: 150px;
   height: 30px;
   background: #fff;
   border: 1px solid rgb(77, 77, 77);
   border-radius: 10px;
   cursor: pointer; &: hover { background : rgb( 77, 77, 77);
   color: #fff;
}

}

/* 다음 버튼 */
.next_btn_div {
	margin-top: 3%;
	margin-bottom: 3%;
	display: flex;
	height: auto;
	justify-content: center;
}

.next_btn {
	font-style:;
	background-color: #00E7AF;
	color: black;
	box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 8px;
	border: none;
	border-radius: 10px;
	width: 20%;
	padding-top: 10px;
	padding-bottom: 10px;
	transition: background-color 0.3s ease;
	min-height: 30px; /* 트랜지션 효과 추가 */
}

.next_btn:hover {
	background-color: rgba(0, 231, 175, 0.6); /* 흐려진 색상으로 변경 */
}
</style>
</head>
<body>


	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<div class="smarteditor_div">
			<form action="/smartEditor.do" method="post">
				<input type="hidden" name="project-name"
					value="${projectDTO.projectName}"> <input type="hidden"
					name="project-introduce" value="${projectDTO.projectIntroduce}">
				<input type="hidden" name="project-kind"
					value="${projectDTO.projectKind}"> <input type="hidden"
					name="project-price" value="${projectDTO.projectPrice}"> <input
					type="hidden" name="project-target-amount"
					value="${projectDTO.projectTargetAmount}"> <input
					type="hidden" name="project-end-date"
					value="${projectDTO.projectEndDate}"> <input type="hidden"
					name="project-outer-image-name"
					value="${projectDTO.projectOuterImageName}"> <input
					type="hidden" name="project-outer-image-path"
					value="${projectDTO.projectOuterImagePath}"> <input
					type="hidden" name="project-inner-image-name"
					value="${projectDTO.projectInnerImageName}"> <input
					type="hidden" name="project-inner-image-path"
					value="${projectDTO.projectInnerImagePath}">

				<h2>프로젝트 스토리</h2>
				<hr>
				<div id="smarteditor">
					<textarea name="editorTxt" id="editorTxt" rows="50" cols="10"
						placeholder="내용을 입력해주세요" style="width: 100%"></textarea>
				</div>
				<div class="next_btn_div">
					<button type="submit" class="next_btn" onclick="save()">다음</button>
				</div>
			</form>
		</div>
	</main>

   <%@include file="../../views/common/footer.jsp"%>
</body>
</html>