<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="/resources/js/board/board.js"> </script>
<link href="/resources/css/board/board.css" rel="stylesheet" />
</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>
	
	<main>
		<h2>게시판 상세</h2>
    <form id="detail-form">
        <input type="hidden" name="idx" value="${board.idx}" />
        <div class="board_main_line"></div>
        <div class="board_main_information">
            <div class="board_title_div">
                <label for="title">TITLE</label>
                <input type="text" id="title" name="title" value="${board.title }" required disabled>
            </div>
            <div class="board_date_div">
                <label for="content">DATE</label>
                <input type="text" id="in-date" name="in-date" value="${board.inDate }" required disabled>
            </div>
        </div>
        <div class="board_sub_line"></div>
        <div class="board_sub_information">
            <div class="board_writer_div">
                <label for="content">작성자</label>
                <input type="text" id="writer" name="writer" value="관리자" required disabled>
            </div>
            <div>
                <label for="content">조회수</label>
                <input type="text" id="views" name="views" value="${board.views }" required disabled>
            </div>
        </div>
        <div class="board_content">
            <!-- <label for="content">내용:</label> -->
            <div id="content">${board.content }</div>
            <img src="/resources/uploads/${board.fileName }">
        </div>
        <div class="board_content_line"></div>


        <!-- 글작성자 수정/삭제 가능 -->
        <div class="board_btn_div">
            <c:if test="${sessionScope.no == 1 }">
                <button type="button" onclick="boardUpdateCheck(${board.idx })">수정</button>
                <button type="submit" onclick="boardDelete()">삭제</button>
            </c:if>
            <button type="reset" onclick="window.location.href = '/boardList.do?cpage=1'">취소</button>
        </div>
    </form>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
