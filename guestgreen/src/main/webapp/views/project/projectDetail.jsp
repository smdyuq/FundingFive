<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>funding(수정예정)</title>

<link href="/resources/css/common/common.css" rel="stylesheet" />
<link href="/resources/css/project/projectDetail.css" rel="stylesheet" />


<%@include file="../../views/common/head.jsp"%>



<style>
.originator-div {
	display: flex;
	align-items: center;
}

.profile-container {
	display: flex;
	align-items: center;
	margin-right: 20px;
}

.profile-image img {
	width: 130px; /* 프로필 사진의 너비 설정 */
	height: 130px; /* 프로필 사진의 높이 설정 */
}

.profile-details {
	margin-left: 20px;
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>

	<main>
		<div class="container">
			<div class="project-div">
				<div class="project-name">${projectDTO.projectName}</div>
				<div class="project-information">
					<div class="project-img">
						<img
							src="/resources/uploads/innerimage/${projectDTO.projectInnerImageName}"
							alt="">
					</div>
					<div class="project-description">
						<div class="project-text-alignment">
							<div>
								<p class="project-text">모인 금액</p>
								<div>
									<a class="project-value">${projectDTO.projectCurrentAmount}
										<p class="project-text-unit">원</p>
									</a> <a class="project-value">${projectDTO.projectCurrentPercentage}
										<p class="project-text-unit">%</p>
									</a>
								</div>
								<p class="project-text">남은 기간</p>
								<div>
									<c:if test="${projectDTO.projectRemainDate>0}">
										<a class="project-value">${projectDTO.projectRemainDate}
											<p class="project-text-unit">일</p>
										</a>
									</c:if>
									<c:if test="${projectDTO.projectRemainDate<=0}">
										<p class="project-text-unit">종료된 프로젝트입니다.</p>
									</c:if>
								</div>
								<p class="project-text">후원자 수</p>
								<div>
									<a class="project-value">${projectDTO.projectSponserNumber}
										<p class="project-text-unit">명</p>
									</a>
								</div>
								<div>
									<a class="project-value">${projectDTO.projectTargetAmount}
										<p class="project-text-unit">원</p>
									</a> <a class="project-value">${projectDTO.projectRegisterDate}
										~ ${projectDTO.projectEndDate}
										<p class="project-text-unit">펀딩기간</p>
									</a> <a class="project-value">
								</div>
							</div>
							<div class="sponsor-button">


								<button class="btn btn-dark me-md-2" type="button"
									onclick="projectDonate(${projectDTO.projectNo})">후원하기</button>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="product-div">
				<div class="product-description">${projectDTO.projectContent}
				</div>
				<div class="originator-div">
					<p>창작자 소개</p>
					<div class="profile-container">
						<div class="profile-image">
							<img
								src="resources/uploads/managerimage/${projectDTO.projectManagerImageName}"
								alt="프로필 사진">
						</div>
						<div class="profile-details">

							<a class="project-manager-name">${projectDTO.projectManagerName}</a>
							<br> <br> <a class="project-manager-introduce">${projectDTO.projectManagerIntroduce}</a>
						</div>
					</div>
					<div class="project-button">
						<a href="#">이전 프로젝트 보기</a>
					</div>
				</div>
			</div>
	</main>

	<%@include file="../../views/common/common.jsp"%>
	<%@include file="../../views/common/footer.jsp"%>


</body>

<script src="/resources/js/common/nav.js"></script>
<script src="/resources/js/project/projectDetail.js"></script>
<script src="/resources/js/common/common.js"></script>
</html>



