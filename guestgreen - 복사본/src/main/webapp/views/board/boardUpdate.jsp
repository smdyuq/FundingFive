<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/views/common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp"%>
<script src="/resources/js/board/board.js"> </script>

</head>
<body>

   <%@include file="/views/common/header.jsp"%>
   <%@include file="/views/common/nav.jsp"%>
   <main>
         <form action="/boardUpdate.do" method="post" enctype="multipart/form-data">
            <input type="hidden" name="idx" value="${board.idx }"/>
          <label for="title">제목:</label>
          <input type="text" id="title" name="title" value="${board.title }" required ${sessionScope.name eq board.writer ? '': 'readonly' }>
          
           <label for="content">작성자:</label>
          <input type="text" id="writer" name="writer" value="${board.writer }" required disabled>
          
           <label for="content">조회수:</label>
          <input type="text" id="views" name="views" value="${board.views }" required disabled>
   
           <label for="content">작성일:</label>
          <input type="text" id="in-date" name="in-date" value="${board.inDate }" required disabled>
          <div id="smarteditor">
          <label for="content">내용:</label>
          <textarea id="editorTxt" name="content" rows="13"  required ${sessionScope.name eq board.writer ? '': 'readonly' }>${board.content }</textarea>
          </div>
          
<%--            <img src="/resources/uploads/${board.fileName }">
          <input type="file" id="file" name="file"> <br> --%>
          
          <button type="submit" onclick="save()">확인</button>
          <input type=button value="취소" OnClick="javascript:history.back(-1)">
      </form>
   </main>

   <%@include file="/views/common/footer.jsp"%>
</body>
</html>