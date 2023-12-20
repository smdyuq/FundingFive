<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/views/common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp"%>
<script type="text/javascript"
	src="/resources/smarteditor/js/common/smarteditor.js" charset="utf-8"></script>


<style>
.post-form {
	display: flex;
	flex-direction: column;
	align-items: stretch;
	width: 80%;
	margin: 0 auto;
	background-color: red;
}

.buttons {
	margin-top: 3%;
	margin-bottom: 5%;
	display: flex;
	height: auto;
	justify-content: center;
}

.buttons>button, .buttons>input {
	cursor: pointer;
	background-color: #00E7AF;
	color: black;
	box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 8px;
	border: none;
	border-radius: 10px;
	width: 20%;
	padding-top: 10px;
	padding-bottom: 10px;
	margin-right: 2px;
	margin-left: 2px;
	transition: background-color 0.3s ease;
	min-height: 30px;
	padding-top: 10px;
	padding-bottom: 10px; /* 트랜지션 효과 추가 */
}

.buttons>button:hover {
	background-color: rgba(0, 231, 175, 0.6); /* 흐려진 색상으로 변경 */
}

.buttons>input:hover {
	background-color: rgba(0, 231, 175, 0.6); /* 흐려진 색상으로 변경 */
}

.title-info {
	display: flex;
	align-items: baseline;
	border-bottom: 1px solid #000;
	margin-bottom: 0px;
	height: 50px;
}

.post-form-title {
	margin-rigth: 5px;
}

#title {
	border: none;
	border-bottom: 1px solid black;
}
</style>
</head>
<body>

	<%@include file="/views/common/header.jsp"%>
	<%@include file="/views/common/nav.jsp"%>
	<main>
		<section id="post-form">
			<h2>새 글 작성</h2>
			<!-- 파일 업로드시 써야하는 것 -->
			<form action="/boardEnroll.do" method="post"
				enctype="multipart/form-data">
				<div class="title-info">
					<label for="title class="post-form-title">제목 | </label> <input
						type="text" id="title" name="title"
						style="width: 30%; margin-left: 20px;" required>
				</div>
				<div id="smarteditor">
					<textarea name="content" id="editorTxt" rows="30" cols="10"
						placeholder="내용을 입력해주세요" style="width: 100%;"></textarea>
				</div>

				<div class="buttons">
					<button type="submit" onclick="save()">작성</button>
					<button type="reset" onclick="javascript:history.back(-1)">취소</button>
				</div>

			</form>
		</section>

	</main>

	<%@include file="/views/common/footer.jsp"%>
</body>
</html>