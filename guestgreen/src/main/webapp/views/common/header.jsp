<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div>
		<a href="/form/home.do"><img src="/resources/uploads/로고.png"
			alt="로고"> </a>
	</div>

	<div>
		<c:if test="${empty sessionScope.memberNo}">
			<a id="member-information"> 로그인을 해주세요.</a>
		</c:if>
		<c:if test="${not empty sessionScope.memberNo}">
			<c:if test="${sessionScope.memberType == 1}">
				<a id="member-information"> ${sessionScope.memberName}님 안녕하세요.</a>
			</c:if>
			<c:if test="${sessionScope.memberType == 0}">
				<a id="member-information"> 관리자님 안녕하세요.</a>
			</c:if>
		</c:if>
	</div>
	<div>
		<p>|</p>
	</div>
	<div>
		<c:if test="${empty sessionScope.memberNo}">


			<div>
				<a class="gnb-button-style" href="/form/loginform.do">로그인</a> <a
					class="gnb-button-style" href="/form/signupform.do">회원가입</a>
			</div>
		</c:if>

		<c:if test="${not empty sessionScope.memberNo}">
			<c:if test="${sessionScope.memberType == 1}">
				<div>
					<a class="gnb-button-style" href="/form/projectEnrollForm.do">프로젝트
						등록</a> <a class="gnb-button-style" href="myPage.do?cpage=1">마이페이지</a>
					<a class="gnb-button-style" href="/logout.do">로그아웃</a>
				</div>
			</c:if>
			<c:if test="${sessionScope.memberType == 0}">
				<div>
					<a class="gnb-button-style" href="/administratorOk.do?cpage=1">프로젝트
						관리</a> <a class="gnb-button-style" href="/logout.do">로그아웃</a>
				</div>
			</c:if>
		</c:if>
	</div>

	<div id="google_translate_element" style="display: none;"></div>
	<select class="translation-links">
		<option value="ko" data-lang="ko">한국어</option>
		<option value="en" data-lang="en">영어</option>
		<option value="ja" data-lang="ja">일본어</option>
	</select>
	</div>

</header>
<script src="/resources/js/common/nav.js"></script>
<script
	src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {
		new google.translate.TranslateElement({
			pageLanguage : 'ko',
			autoDisplay : true
		}, 'google_translate_element');
	}

	document.querySelector('.translation-links').addEventListener('change',
			function(event) {
				const tolang = event.target.value;
				const gtcombo = document.querySelector('.goog-te-combo');
				if (gtcombo == null) {
					alert("Error: Could not find Google translate Combolist.");
					return false;
				}
				gtcombo.value = tolang;
				gtcombo.dispatchEvent(new Event('change'));
			});
</script>

