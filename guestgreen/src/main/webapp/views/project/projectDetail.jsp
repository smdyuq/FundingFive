<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>funding(수정예정)</title>
<link rel="stylesheet" href="/resources/css/project/projectDetail.css">
<script src="/resources/js/project/projectDetail.js"></script>
<!--css 주소 수정-->

</head>

<body>
	<header>
		<%@include file="../../views/common/header.jsp"%>
		<%@include file="../../views/common/nav.jsp"%>
		<div>
			<!-- <img scr="" alt="로고"> -->
			<a href="#">로고</a>
		</div>
		<div>
			<a id="member-information"> 회원 가입을 해주세요.</a>
			<!-- <a id="member-information"> ()님 안녕하세요.</a> 
            <a id="member-information"> 관리자님 안녕하세요.</a>  -->
		</div>
		<div class="gnb-buttons">
			<div>
				<a class="gnb-button-style" href="#">로그인</a> <a
					class="gnb-button-style" href="#">회원가입</a>
			</div>
		</div>
	</header>
	<nav>
		<div class="nav-menu">
			<div>
				<ul class="nav-menu-list">
					<li class="lnb-category-expansion"><a
						onclick="lnbCategoryClose()">메뉴</a>
						<div class="lnb-category">
							<a href="#">카테고리1</a> <a href="#">카테고리2</a> <a href="#">카테고리3</a>
							<a href="#">카테고리4</a> <a href="#">카테고리4</a>
						</div></li>
					<li><a href="#">홈</a></li>
					<li><a href="#">진행중인 프로젝트</a></li>
					<li><a href="#">공개예정 프로젝트</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- ------------------------------------------------------------------------------- -->
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
								</div>
								<p class="project-text">남은 기간</p>
								<div>
									<a class="project-value">projectEndDate-projectRegisterDate
										<p class="project-text-unit">일</p>
									</a>
								</div>
								<p class="project-text">후원자 수</p>
								<div>
									<a class="project-value">${projectDTO.projectSponserNumber}
										<p class="project-text-unit">명</p>
									</a>
								</div>
							</div>
							<div class="sponsor-button">
								<!-- <div> -->
								<button class="btn btn-dark me-md-2" type="button" 
									onclick="projectDonate(${projectDTO.getProjectNumber})">후원하기</button>
								<!-- </div> -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="product-div">
				<div class="product-description">
					<p>제품 상세 설명(이미지, 글)</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>

					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
					<p>테스트입니다아아아아아아아ㅏ아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
				</div>
				<div class="originator-div">
					<p>창작자 소개</p>
					<div>
						<a class="project-manager-name">${projectDTO.projectManagerName}
						</a>
					</div>
					<p>여기는 창작자
						소개입니다아아아아아ㅏ아아아아아아아아아아아아아아아아ㅏ아아아아아아아아아ㅏ아아아아아아ㅏ아아아아아아ㅏ아아ㅏ아아아아아</p>
					<p>ㅓ세ㅔ로정렬좀 돼라아아ㅏ아아ㅏ아아아아아아아아아</p>
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
	<!-- ------------------------------------------------------------------------------- -->

	<%@include file="../../views/common/footer.jsp"%>

</body>

</html>

