<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/views/common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp" %>
<script type="text/javascript" src="/resources/smarteditor/js/common/smarteditor.js" 
charset="utf-8"></script>
</head>
<body>

	<%@include file="/views/common/header.jsp"%>
	<%@include file="/views/common/nav.jsp"%>
	<main>
		<section id="post-form">
			<h2>새 글 작성</h2>
			<!-- 파일 업로드시 써야하는 것 -->
			<form action="/boardEnroll.do" method="post" enctype="multipart/form-data">
				<label for="title">제목:</label>
				<input type="text" id="title"name="title" style="width: 1035px" required> 
				<div id="smarteditor">
					<label for="editorTxt">내용:</label>
					<textarea name="content" id="editorTxt" rows="13" cols="10"
						placeholder="내용을 입력해주세요" style="width: 1000px"></textarea>
				</div>
				<!-- 파일 업로드(스마트 에디터로 해결)
				<input type="file" id="file" name="file"> <br>
				<input type="file" id="file2" name="file2"> <br>
				<br> -->


				<button type="submit" onclick="save()">작성</button>
				<button type="reset" onclick="javascript:history.back(-1)">취소</button>


			</form>
		</section>

	</main>

	<%@include file="/views/common/footer.jsp"%>
</body>
</html>