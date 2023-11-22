<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<div>
		<!-- <img scr="" alt="로고"> 이미지로 바꿀거임-->
		<a href="/">로고</a>
	</div>

	<div>

		<c:if test="${empty sessionScope.name}">
			<a id="member-information"> 로그인을 해주세요.</a>
		</c:if>
		<c:if test="${not empty sessionScope.name}">
			<c:if test="${sessionScope.userType == 1}">
				<a id="member-information"> ${sessionScope.name}님 안녕하세요.</a>
			</c:if>
			<c:if test="${sessionScope.userType == 0}">
				<a id="member-information"> 관리자님 안녕하세요.</a>
			</c:if>
		</c:if>
	</div>
	<div>
		<p>|</p>
	</div>
	<div>
		<c:if test="${empty sessionScope.name}">
    <div>
        <a class="gnb-button-style" href="/form/loginform.do">로그인</a>
        <a class="gnb-button-style" href="/form/signupform.do">회원가입</a>
    </div>
</c:if>
<c:if test="${not empty sessionScope.name}">
    <c:if test="${sessionScope.userType == 1}">
        <div>
            <a class="gnb-button-style" href="/form/projectEnrollForm.do">프로젝트 등록</a>
            <a class="gnb-button-style" href="/form/mypageform.do">마이페이지</a>
            <a class="gnb-button-style" href="/logout.do">로그아웃</a>
        </div>
    </c:if>
    <c:if test="${sessionScope.userType == 0}">
        <div>
            <a class="gnb-button-style" href="/form/administratorOkForm.do">프로젝트 관리</a>
            <a class="gnb-button-style" href="/logout.do">로그아웃</a>
        </div>
    </c:if>
</c:if>
		</div>
</header>