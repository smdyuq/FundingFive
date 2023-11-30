<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>funding(수정예정)</title>

<link href="/resources/css/project/projectDetail.css" rel="stylesheet" />
<script src="/resources/js/project/projectDetail.js"></script>

		<%@include file="/views/common/head.jsp"%>
</head>

<body>
		<%@include file="/views/common/header.jsp"%>
		<%@include file="/views/common/nav.jsp"%>

	<main>
		<div class="container">
			<div class="project-div">
				<div class="project-name">${projectDTO.projectName}</div>
				<div class="project-information">
					<div class="project-img">
						<img src="${projectDTO.projectOuterImagePath}" alt="">
					</div>
					<div class="project-description">
						<div class="project-text-alignment">
							<div>
								<p class="project-text">모인 금액</p>
								<div>
									<a class="project-value">${projectDTO.projectCurrentAmount}
										<p class="project-text-unit">원</p>
									</a>
									<a class="project-value">${projectDTO.projectCurrentPercentage}
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
									<c:if test="${projectDTO.preojectRemainDate<=0}">
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
									<a class="project-value">${projectDTO.getProjectTargetAmount}
										<p class="project-text-unit">원</p>
									</a>
									<a class="project-value">${projectDTO.getProjectRegisterDate} ~ ${projectDTO.getProjectEndDate}
										<p class="project-text-unit">펀딩기간</p>
									</a>
									<a class="project-value">
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
				<div class="product-description">
					<p>제품 상세 설명(이미지, 글)</p>
					<p>테스트입니다</p>
				</div>
				<div class="originator-div">
					<p>창작자 소개</p>
					<div>
						<a class="project-manager-name">${projectDTO.projectManagerName}
						</a>
					</div>
					<p>${projectDTO.projectManagerName}</p>
					<div>
						<a class="project-manager-introduce">${projectDTO.projectManagerIntroduce}
						</a>
					</div>
					<div class="project-button">
						<a href="#">이전 프로젝트 보기</a>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>

</body>

</html>

