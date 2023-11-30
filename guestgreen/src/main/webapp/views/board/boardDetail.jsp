<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="/resources/js/board/board.js"> </script>
</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<h2>상세보기</h2>
		<form id="detail-form">
		
			<input type="hidden" name="idx" value="${board.idx }" /> 
			<label for="title">제목:</label>
			<input type="text" id="title" name="title" value="${board.title }" required disabled>
			<label for="content">작성자:</label>
			<input type="text" id="writer" name="writer" value="관리자" required disabled>
			<label for="content">조회수:</label>
			<input type="text" id="views" name="views" value="${board.views }" required disabled>
			<label for="content">작성일:</label>
			<input type="text" id="in-date" name="in-date" value="${board.inDate }" required disabled>
			<label for="content">내용:</label>
			<div id="content">${board.content }</div>
			<img src="/resources/uploads/${board.fileName }">


			<!-- 글작성자 수정/삭제 가능 -->
			<c:if test="${sessionScope.no == 1 }">
				<button type="button" onclick="boardUpdateCheck(${board.idx })">수정</button>
				<button type="submit" onclick="boardDelete()">삭제</button>
			</c:if>
				<button type="reset" onclick="window.location.href = '/boardList.do?cpage=1'">취소</button>
		</form>




	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
