<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div>
		<!-- <img scr="" alt="로고"> 이미지로 바꿀거임-->
		<a href="/form/home.do">로고</a>
	</div>

	<div>
		<c:if test="${empty sessionScope.memberNo}">
			<a id="member-information"> 로그인을 해주세요.</a>
		</c:if>
		<c:if test="${not empty sessionScope.memberNo}">
			<c:if test="${memberDTO.memberType == 1}">
				<a id="member-information"> ${memberDTO.memberName}님 안녕하세요.</a>
			</c:if>
			<c:if test="${memberDTO.memberType == 0}">
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
			<c:if test="${memberDTO.memberType == 1}">
				<div>
					<a class="gnb-button-style" href="/form/projectEnrollForm.do">프로젝트 등록</a> <a
						class="gnb-button-style" href="myPage.do?cpage=1">마이페이지</a> <a
						class="gnb-button-style" href="/logout.do">로그아웃</a>
				</div>
			</c:if>
			<c:if test="${memberDTO.memberType == 0}">
				<div>
					<a class="gnb-button-style" href="/administratorOk.do?cpage=1">프로젝트 관리</a> <a
						class="gnb-button-style" href="/logout.do">로그아웃</a>
				</div>
			</c:if>
		</c:if>
	</div>


</header>