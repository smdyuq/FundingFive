<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/views/common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp"%>
<script src="/resources/js/board/board.js"> </script>
 <style>
    .boardForm {
      display: flex;
      flex-direction: column;
      align-items: stretch;
      width: 80%;
      margin: 0 auto;
    }

    .boardForm input[type=text], .boardForm textarea {
      border: none;
      background-color: transparent;
      margin-bottom: 20px;
    }

    .boardForm .title-info, .boardForm .info, .boardForm .content {
      border-bottom: 1px solid #000;
      padding-bottom: 10px;
      margin-bottom: 20px;
    }

    .boardForm .info {
      display: flex;
      justify-content: flex-end;
    }

    .boardForm .buttons {
      display: flex;
      justify-content: center;
    }

    .boardForm button, .boardForm input[type=button] {
      margin: 20px;
    }
    
    .boardForm .title-info {
      display: flex;
    align-items: baseline;
    border-bottom: 1px solid #000;
    margin-bottom: 0px;
    height: 40px;
}
.info{
height: 30px;
  align-items: baseline;
}
#views{
width:30px;
}
#writer{
width:70px;
overflow:hidden;
}

.content{
width:100%;
}

.buttons {
	margin-top: 3%;
	margin-bottom: 5%;
	display: flex;
	height: auto;
	justify-content: center;
}

.buttons>button , input{
	cursor: pointer;
	background-color: #00E7AF;
	color: black;
	
	border: none;
	border-radius: 10px;
	width: 20%; padding-top : 10px; padding-bottom : 10px;
	margin-right:2px;
	margin-left:2px;
	transition: background-color 0.3s ease;
	min-height: 30px;
	padding-top: 10px;
	padding-bottom: 10px; /* 트랜지션 효과 추가 */
	
}

input:focus {outline:none;}
  </style>
</head>
<body>
   <%@include file="/views/common/header.jsp"%>
   <%@include file="/views/common/nav.jsp"%>
   <main>
         <form class="boardForm" action="/boardUpdate.do" method="post" enctype="multipart/form-data">
            <input type="hidden" name="idx" value="${board.idx }"/>
            <div class="title-info">
              <label for="title">TITLE | </label>
              <input type="text" id="title" name="title" value="${board.title }" required ${sessionScope.name eq board.writer ? '': 'readonly' }>
            </div>

            <div class="info">
              <label for="writer">작성자:</label>
              <input type="text" id="writer" name="writer" value="관리자" required disabled>
              <label for="views">조회수:</label>
              <input type="text" id="views" name="views" value="${board.views }" required disabled>
              <label for="in-date">작성일:</label>
              <input type="text" id="in-date" name="in-date" value="${board.inDate }" required disabled>
            </div>

            <div id="smarteditor" class="content">
              <textarea id="editorTxt" name="content" rows="24" style="width: 100%"  required ${sessionScope.name eq board.writer ? '': 'readonly' }>${board.content }</textarea>
            </div>
            
            <div class="buttons">
              <button type="submit" onclick="save()">확인</button>
              <input type=button value="취소" OnClick="javascript:history.back(-1)">
            </div>
         </form>
   </main>

   <%@include file="/views/common/footer.jsp"%>
</body>
</html>