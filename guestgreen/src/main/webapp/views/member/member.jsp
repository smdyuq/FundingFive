<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>


<link rel="stylesheet" href="/resources/css/member/member.css">
<style>
main {
	padding: 10px;
}
</style>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>



	<main onload="showTabContent('information');">
		<div class="information-div">
			<h2>마이 페이지</h2>

			<!-- <div class="all"> -->
			<div class="tabs">
				<input id="information" type="radio" name="tab_item" checked
					onchange="showTabContent('information')"> <label
					class="tab_item" for="information">내 정보</label> <input
					id="sponsorship" type="radio" name="tab_item"
					onchange="showTabContent('sponsorship')"> <label
					class="tab_item" for="sponsorship">후원</label> <input id="project"
					type="radio" name="tab_item" onchange="showTabContent('project')">
				<label class="tab_item" for="project">프로젝트</label>
			</div>

			<div class="tab_content" id="information_content">
				<div class="member-information-div">
				<form id="update-form" action="/Update.do" method="post">
					<div class="signup-input">
						<label for="member-id">아이디</label> <input type="text"
							id="member-id" name="member-id" onkeyup="duplicateId()"
							value="${member.id}" required><br> <span id="idMsg"></span>
					</div>
					<br>
					<div class="signup-input">
						<label for="member-pwd">비밀번호 </label> <input type="password"
							id="member-pwd" name="member-pwd" onkeyup="validatePassword()"
							placeholder="******" disabled> <br> <span
							id="passwordMsg"></span>
					</div>
					<br>
					<div class="signup-input">
						<label for="member-name">이름 </label> <input type="text"
							id="member-name" name="member-name" onkeyup="validateName() "
							value="${member.name}" required><br> <span
							id="nameMsg"></span>
					</div>
					<br>
					<div class="signup-input">
						<label for="member-phone">휴대폰 번호:</label> <input type="number"
							value="${member.phone}" id="member-phone" name="member-phone"
							onkeyup="" required><br> <span id="phonekMsg"></span>
					</div>
					<br>
					<div class="signup-input">
						<label for="member-addr">주소</label> <input type="text"
							value="${member.addr}" id="member-addr" name="member-addr"
							onkeyup="" required><br> <span id="addrMsg"></span>
					</div>
					<br>
					<div class="signup-input">
						<label for="member-addr">가입일</label> <input type="text"
							value="${member.createDate}" id="member-addr" name="member-addr"
							onkeyup="" disabled><br> <span id="addrMsg"></span>
					</div>
					<br>
					<div class="signup-input">
						<label for="member-addr">최종 수정일</label> <input type="text"
							value="${member.updateDate}" id="member-addr" name="member-addr"
							onkeyup="" disabled><br> <span id="addrMsg"></span>
					</div>
					<br>
					<button type="submit">수정하기</button>
					<button type="submit" onclick="deleteBtn()">탈퇴하기</button>
				</div>
			</div>
		
		<!-- </div> -->

		<div class="tab_content" id="sponsorship_content">
			<p>후원한 내용이 없습니다.</p>
		</div>
		<div>
			<div class="tab_content" id="project_content">Thanks a lot</div>

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

	function showTabContent(tabId) {
		// 모든 탭 컨텐츠 숨김
		var tabContents = document.querySelectorAll('.tab_content');
		tabContents.forEach(function(content) {
			content.style.display = 'none';
		});

		// 선택한 탭 컨텐츠 표시
		var selectedTabContent = document.getElementById(tabId + '_content');
		if (selectedTabContent) {
			selectedTabContent.style.display = 'block';
		}
	}

	window.onload = function() {
		showTabContent('information');
	};
	
</script>