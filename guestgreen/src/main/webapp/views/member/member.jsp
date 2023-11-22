<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>

<!-- 부트스트랩 5 CSS 파일 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- 부트스트랩 5 JavaScript 및 팝퍼 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="/resources/css/member/member.css">
   <style>
    main{
        padding: 20px;
        margin-top: auto;
        flex: 1; 
        align-self: flex-start; 
        width: 100%;
    }
   </style>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	


	<main>
		<h2>마이 페이지</h2>

    <div class="a">
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <button class="nav-link active" id="information-label" data-bs-toggle="tab" data-bs-target="#nav-home"
                    type="button" role="tab" aria-controls="nav-home" aria-selected="true">내 정보</button>
                <button class="nav-link" id="sponsorship-label" data-bs-toggle="tab" data-bs-target="#nav-profile"
                    type="button" role="tab" aria-controls="nav-profile" aria-selected="false">내 후원 현황</button>
                <button class="nav-link" id="project-label" data-bs-toggle="tab" data-bs-target="#nav-contact"
                    type="button" role="tab" aria-controls="nav-contact" aria-selected="false">내 프로젝트 현황</button>
            </div>
        </nav>
        <div class="tab-content">
            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="member-information-div">
                    <form id="update-form" action="/Update.do" method="post">
                        <div class="signup-input">
                            <label for="member-id">아이디</label>
                            <input type="text" id="member-id" name="member-id" value="${member.id}" required><br>
                            <span id="idMsg"></span>
                        </div>
                        <br>
                        <div class="signup-input">
                            <label for="member-pwd">비밀번호</label>
                            <input type="password" id="member-pwd" name="member-pwd" value="${member.pwd}" disabled><br>
                            <span id="passwordMsg"></span>
                        </div>
                        <br>
                        <div class="signup-input">
                            <label for="member-name">이름</label>
                            <input type="text" id="member-name" name="member-name" value="${member.name}" required><br>
                            <span id="nameMsg"></span>
                        </div>
                        <br>
                        <div class="signup-input">
                            <label for="member-phone">휴대폰 번호</label>
                            <input type="number" id="member-phone" name="member-phone" value="${member.phone}" required><br>
                            <span id="phoneMsg"></span>
                        </div>
                        <br>
                        <div class="signup-input">
                            <label for="member-addr">주소</label>
                            <input type="text" id="member-addr" name="member-addr" value="${member.addr}" required><br>
                            <span id="addrMsg"></span>
                        </div>
                        <br>
                        <div class="signup-input">
                            <label for="member-createDate">가입일</label>
                            <input type="text" id="member-createDate" name="member-createDate" value="${member.createDate}" disabled><br>
                            <span id="createDateMsg"></span>
                        </div>
                        <br>
                        <div class="signup-input">
                            <label for="member-updateDate">최종 수정일</label>
                            <input type="text" id="member-updateDate" name="member-updateDate" value="${member.updateDate}" disabled><br>
                            <span id="updateDateMsg"></span>
                        </div>
                        <br>
                        <button type="submit">수정하기</button>
                        <button type="button" onclick="deleteBtn()">탈퇴하기</button>
                    </form>
                </div>
            </div>
            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                <p>후원한 내용이 없습니다.</p>
            </div>
            <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                <p>등록한 프로젝트가 없습니다.</p>
            </div>
        </div>
    </div>

	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
<script>
	function deleteBtn() {
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			let form = document.getElementById("update-form");
			form.action = "/memberDelete.do";
			form.submit();
		}
	}
</script>