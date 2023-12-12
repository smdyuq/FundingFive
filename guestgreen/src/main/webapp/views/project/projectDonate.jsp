<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/resources/js/project/apiKey.js"></script>

<script src="/resources/js/common/common.js"></script>
<title>Insert title here</title>
<link href="/resources/css/common/common.css" rel="stylesheet" />
<link href="/resources/css/project/projectDonate.css" rel="stylesheet" />
<%@include file="../../views/common/head.jsp"%>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>

	<main>

		<div class="main-container">
			<div class="top-container">
				<div class="main-div">
					<div class="main-img">
						<img src="" alt="이미지">
					</div>
					<div class="main-text">
						<div class="main-cartegory">${projectDTO.projectKind}</div>
						<div class="main-project-name">${projectDTO.projectName}</div>
						<div class="main-price">
							<p>${projectDTO.projectPrice}원</p>
							<p class="main-percent">${projectDTO.projectCurrentPercentage}%</p>
						</div>
					</div>
				</div>
			</div>
			<div class="bottom-container">
				<div class="project-information-all">
					<div>
						<p class="project-information">후원자 정보</p>
						<div class="project-information-div">
							<p class="project-information-name">이름</p>
							<p>${memberDTO.memberName}</p>
							<br>
							<p class="project-information-name">연락처</p>
							<p>${memberDTO.memberPhone}</p>
							<br>
						</div>
					</div>
					<div>
						<p class="project-information">프로젝트 정보</p>
						<div class="project-information-div">
							<p class="project-information-name">프로젝트 명</p>
							<p>${projectDTO.projectName}</p>
							<br>
							<p class="project-information-name">가격</p>
							<p>${projectDTO.projectPrice}</p>
							<br>
						</div>
					</div>
					<div>
						<p class="project-information">배송지 정보</p>
						<div class="project-information-div">
							<p class="project-information-name">이름</p>
							<p>${memberDTO.memberName}</p>
							<br>
							<p class="project-information-name">연락처</p>
							<p>${memberDTO.memberPhone}</p>
							<br>
							<p class="project-information-name">배송지</p>
							<p>${memberDTO.memberAddr}</p>
							<br>
							<p class="instructions">* 연락처 및 배송지 변경은 마이페이지에서 설정에서 가능합니다.</p>
						</div>
					</div>
				</div>
				<div class="payment-information">
					<div class="payment-information-div">
						<p class="payment-information-name">최종 후원 금액 :</p>
						<p>${projectDTO.projectPrice}원</p>
					</div>
					<button class="donateButton" id="donateButton" onclick="requestPay('${projectDTO.projectName}', '${projectDTO.projectPrice}',
		                '${memberDTO.memberName}', '${memberDTO.memberPhone}', '${memberDTO.memberAddr}',
		                '${projectDTO.projectNo}', '${memberDTO.memberNo}', '${projectDTO.projectCurrentAmount}', '${projectDTO.projectTargetAmount}')">카카오톡으로 후원하기</button>
				</div>
			</div>
		</div>

	</main>

	<%@include file="../../views/common/common.jsp"%>
	<%@include file="../../views/common/footer.jsp"%>

</body>
	<script src="/resources/js/project/projectDonate.js"></script>
</html>



