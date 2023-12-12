<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/common/common.css" rel="stylesheet" />
<link href="/resources/css/project/projectDonate.css" rel="stylesheet" />
<%@include file="../../views/common/head.jsp"%>
</head>
<style>
body {
	background-color: #efeff0 !important;
}

.jb-division-line {
	border-top: 1px solid #444444;
	margin: 30px 0px;
	width: 100%;
	border: 1px solid #D3D3D3;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
}

.payment_information>p {
	margin-right: 3%;
}

/* .pay1 {
	width: 50%;
}

.pay2 {
	width: 25%;
}

.pay3 {
	width: 25%;
} */
.payment_information {
	display: flex;
}

.payment_container {
	/* 	background-color: skyblue;
 */
	width: 680px;
	height: 1500px;
	margin: 0 auto;
	margin-top: 0px;
	margin-right: auto;
	margin-bottom: 0px;
}

.payment0 {
	width: 100%;
	/* 	background-color: chocolate; */
	text-align: center;
	display: block;
	margin-block-start: 0px;
	margin-block-end: 1em;
	margin-inline-start: 1em;
	margin-inline-end: 1em;
	font-size: XX-large;
}

.payment1 {
	/* background-color: yellow; */
	width: 100%;
}

.payment2 {
	/* background-color: blue; */
	width: 100%;
}

.payment3 {
	/* background-color: red; */
	width: 100%;
}
</style>

<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<div class="payment_container">
			<div class="payment0">후원 상세정보</div>
			<div class="payment1">
				<div>
					<p class="project-information">결제내역</p>
					<div class="project-information-div">
						<p class="project-information-name">프로젝트 명</p>
						<p>${projectDTO.projectName}메리크리스마스</p>
						<br>
						<p class="project-information-name">가격</p>
						<p>${projectDTO.projectPrice}30,000원</p>
						<br>
						<p class="project-information-name">구매일</p>
						<p>${projectDTO.projectDate}2023-12-08</p>
					</div>
				</div>
			</div>
			<div class="payment2">
				<div>
					<p class="project-information">배송지 정보</p>
					<div class="project-information-div">
						<p class="project-information-name">이름</p>
						<p>이윤호</p>
						
						<p class="project-information-name">연락처</p>
						<p>${memberDTO.memberPhone}010-8961-6315</p>
						
						<p class="project-information-name">배송지</p>
						<p>${memberDTO.memberAddr}경기도안양시동안구</p>
						
						<p class="project-information-name">배송메모</p>
						<p>${memberDTO.membermemo}안전하게배송해주세요</p>
						<p class="instructions">* 연락처 및 배송지 변경은 마이페이지에서 설정에서 가능합니다.</p>
					</div>
				</div>
			</div>
			<div class="payment3">
				<p class="project-information">결제 정보</p>
				<div class="project-information-div">
					<p class="project-information-name">신용카드</p>
					<span class="payment_information">
						<p class="pay1">하나은행</p>
						<p class="pay2">512-****-***</p>
						<p>일시불</p>
					</span>
					<div class="jb-division-line"></div>
					<p class="project-information-name">결제금액</p>
					<p>${projectDTO.projectPrice}30,000원</p>
					<br>
				</div>
			</div>
		</div>




	</main>

	<%@include file="../../views/common/common.jsp"%>
	<%@include file="../../views/common/footer.jsp"%>

	<script>
		
	</script>

</body>
</html>