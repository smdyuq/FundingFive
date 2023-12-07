
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/project/projectDetail.js"></script>


<%@include file="./views/common/head.jsp"%>
</head>

<style>
/* 주목할 만한 프로젝트 */
.FrontCard_Container {
	margin: 0px;
	padding: 0px;
	list-style: none;
	display: flex;
	flex-wrap: wrap;
}

body {
	margin: 0px;
	padding: 0px;
	overflow-x: hidden;
	min-width: 320px;
	font-size: 14px;
	line-height: 1.7em;
}

.popula-img {
	display: -webkit-box;
}

.slider-1 {
	height: 400px;
	position: relative;
}

/* 슬라이더 1 - 페이지 버튼 */
.slider-1.slidesimg {
	overflow: hidden;
	width: 760px;
	display: flex;
	height: 280px;
}

.slider-1>.page-btns {
	text-align: center;
	position: absolute;
	bottom: 20px;
	left: 0;
	width: 100%;
}

.slider-1>.page-btns>div {
	width: 20px;
	height: 20px;
	background-color: rgba(255, 255, 255, .5);
	border-radius: 4px;
	display: inline-block;
	cursor: pointer;
}

.slider-1>.page-btns>div.active {
	background-color: rgba(255, 255, 255, 1);
}

/* 슬라이더 1 - 슬라이드 */
.slider-1>.slides>div {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	opacity: 0;
	transition: opacity 0.3s;
	background-position: center;
	background-size: cover;
	background-repeat: no-repeat;
}

.slider-1>.slides>div.active {
	opacity: 1;
}

/* 슬라이더 좌우 버튼 */
.slider-1>.side-btns>div {
	position: absolute;
	top: 0;
	left: 0;
	width: 25%;
	height: 100%;
	cursor: pointer;
}

.slider-1>.side-btns>div:last-child {
	left: auto;
	right: 0;
}

.slider-1>.side-btns>div>span {
	position: absolute;
	top: 50%;
	left: 20px;
	transform: translatey(-50%);
	background-color: white;
	opacity: 0.5;
	padding: 1px 13px;
	border-radius: 50px;
	font-size: 25px;
}

.slider-1>.side-btns>div:last-child>span {
	left: auto;
	right: 20px;
}

/* 슬라이더 1 끝 */
.slidesimg {
	width: 98%;
	height: 35%;
}

.slides_show {
	width: 1200px;
	height: 280px;
	overflow: hidden;
	margin: auto;
}

.slides_show .slides_list {
	position: relative;
	overflow: hidden;
	width: 330%; /* 3300px*/
	height: 280px;
}

.slides_show .slides_list>div {
	float: left;
	width: 290px;
	padding: 5px;
	height: 174px;
	box-sizing: content-box;
	position: relative;
}

.slides_show .slides_list>div:before {
	position: absolute;
	left: 10px;
	top: 10px;
	color: #fff;
	font-family: 'RIDIBatang';
}

.slides_list>div:nth-child(3n+1)::before 
.slides_list>div:nth-child(3n+2)::before
.slides_list>div:nth-child(3n+3)::before

.slides_show .slides_list>div img {
	width: 100%;
}

.slides_btn {
	display: flex;
	justify-content: space-between;
	position: absolute;
	width: 108%;
	top: 30%;
	left: -4%;
	/* 	position: absolute;
	bottom: 5%;
	left: 50%;
	align-text: center;
	transform: translatex(-250%);
	transform: translatey(1750%); */
}

.slides_btn button {
	border: 1px solid rgba(255, 255, 255, 0.4);
	border-radius: 50%;
	width: 40px;
	box-shadow: aliceblue;
	height: 40px;
	color: gray;
	cursor: pointer;
}

.slides_btn button:hover {
	background: rgba(0, 0, 0, .8);;
}

.slides_btn .prev {
	/* position: absolute;
    left: -1600%;
    top: -350%; */
	font-weight: 500;
	font-size: larger;
}

.slides_btn .next {
	font-weight: 500;
	font-size: larger;
}

img {
	width: 100%;
	height: auto;
}

/* 이미지 */
.popular_img {
	width: 150px;
	height: 120px;
}

.eximg {
	position: relative;
	width: 180px;
	height: 153px;
}

/* 구분선 */
dd>span::before {
	content: "|";
	display: inline-block;
	margin: 0px 6px;
	position: relative;
	z-index: 1;
	top: -1px;
	font-size: 7px;
	color: rgb(208, 208, 208);
}

/* 전체 페이지 */
.FrontPage_HomeWrapper {
	display: flex;
	margin-right: 4%;
	margin-bottom: 3%;
	width: 1450px;
}

/* 상단 왼쪽 (주목할만한 프로젝트)*/
.FrontPage_StyleHero {
	/*	height: auto;
	margin-left: 60px; */
	margin: 0px;
	padding: 0px;
	list-style: none;
	flex-wrap: wrap;
	font-size: 14px;
	line-height: 24px;
	letter-spacing: -0.015em;
	font-weight: 400;
	color: #3d3d3d;
	min-width: 766px;
	max-width: 766px;
	max-height: 880px;
	width: 70%;
}

.FrontPage_StyleHero>img {
	width: 100%;
	height: 280px;
	margin-bottom: 3%;
}

.FrontPage_StyleHero>p {
	font-weight: bold;
	font-size: 1.5em;
}

.frontPageCard_Container {
	height: auto;
	margin-top: 3%;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.frontPage_Card {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	float: left;
}

.projectCardDetail {
	flex-direction: column;
	align-items: center;
	justify-content: center;
	font-size: 0.8em;
	overflow: hidden;
	text-overflow: ellipsis;
	flex: 0 1 auto;
	width: calc(100% - 151px);
}

.category-brand {
	display: flex;
	justify-content: center;
}

.frontPageCard_Row {
	display: flex;
	overflow: hidden;
	padding-bottom: 2%;
	justify-content: space-between;
}

.card-wrapper {
	position: relative;
	width: 23%;
	height: 25%;
	padding-right: 2%;
	padding-bottom: 2%;
}

.card-wrapper-last {
	position: relative;
	width: 100%;
}

.Project_Introduce {
	font-weight: bold;
	font-size: 1.5em;
	font-style: nomal;
	color: black;
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	width: 180px;
	height: 50px;
}

/* 상단 오른쪽 (인기 프로젝트) */
.FrontPage_StylePopularProjectsSection {
	float: right;
	width: 30%;
	height: auto;
	margin-left: 3.5%;
	padding: 0px;
	min-width: 314px;
	max-height: 860px;
}

.FrontPage_StylePopularProjectsSection>p, a {
	display: inline;
}

.Project_Container {
	width: 100%;
	height: 100%;
	flex-direction: column;
	display: block;
	/* margin-top: 10%; */
}

.Popula-card-wrapper {
	height: auto;
	margin-bottom: 20px;
	display: -webkit-box;
	align-items: flex-start;
	justify-content: space-between;
	flex-basis: 300px;
	-webkit-box-orient: vertical;
}

.Popula-card-wrapper>div {
	width: 100%;
}

.ProjectCardNumber {
	flex-basis: 4%;
	overflow: hidden;
	font-weight: 900;
}

.ProjectCardNumbertop {
	color: rgba(240, 80, 62, 0.9);
	overflow: hidden;
	display: flex;
	flex: 0 0 auto;
	-webkit-box-align: center;
	-webkit-box-pack: center;
	justify-content: center;
	width: 42px;
	font-weight: 700;
	font-size: 16px !important;
}

.popula-project_Introduce {
	font-weight: bold;
	font-size: 1.2em;
	font-style: nomal;
	color: black;
	text-overflow: ellipsis;
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	width: 60%
}

.FrontPage_viewTotal {
	/* 	padding-top: 3%;
 */
	font-size: small;
}

.popular-project-header {
	display: flex;
	justify-content: space-between;
	padding: 1%;
	margin-bottom: 8%;
}

.Project_ViewMore {
	display: flex;
	width: 204px;
	height: 44px;
	font-size: 13px;
	line-height: 20px;
	letter-spacing: -0.015em;
	border: 1px solid rgb(230, 230, 230);
	box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 8px;
	text-align: center;
	color: rgb(61, 61, 61);
	-webkit-box-pack: center;
	justify-content: center;
	-webkit-box-align: center;
	align-items: center;
	border-radius: 22px;
	margin: 30px auto 0px;
}

.card-wrapper>a, img {
	width: 100%;
	height: 100%;
}

.Card_img {
	width: 80%
}

.Card_image {
	width: auto;
	height: auto;
}

.Collection_Contents {
	width: auto;
	display: flex;
	flex-wrap: wrap;
	margin-left: 50px;
	justify-content: space-between;
}

.Container {
	width: 90%;
	height: 100%;
	padding-left: 0px;
}

a {
	text-decoration: none;
}

dd {
	margin: auto;
	width: 100%;
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	word-break: normal;
	white-space: nowrap;
	padding: 0px 0px 1px;
	font-size: 11px;
	letter-spacing: -0.005em;
	line-height: 16px;
	color: rgb(109, 109, 109);
}

/* 베너 */
.banner {
	width: 100%;
}

/* 최근본 */
.row_frontPage_Card {
	display: flex;
	/* 	background-color: aqua; */
	width: 100%;
	height: 100%;
	position: relative;
	flex-wrap: wrap;
}

.row_card-wrapper_img {
	width: 90%;
	height: auto;
	padding-right: 10%;
}

.row_Project_Introduce {
	font-weight: bold;
	font-size: 1.5em;
	font-style: nomal;
	color: black;
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	width: 150px;
}

.row_percentage {
	color: rgb(255, 87, 87);
}

/* 크리스마스 */
.Content_TextInfo {
	margin-bottom: 10px;
	font-size: 0.9em;
}

.lines_Collection_Contents_div {
	width: 100%;
	height: 100%;
}

.Content_Title {
	margin-top: 15px;
	margin-bottom: 15px;
	font-weight: bold;
	font-size: 1.2em;
	font-style: nomal;
	color: black;
}

.Container_1page {
	width: 100%;
	height: auto;
	display: flex;
}

.ContentInfo_Container {
	width: 280px;
	height: 250px;
	padding-right: 5%;
}

.Collection_Contents_all {
	height: auto;
	margin-top: 5%;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.lines_Collection_Contents {
	display: flex;
	overflow: hidden;
	padding-bottom: 2%;
	justify-content: space-between;
}

.lines_card-wrapper_img {
	width: 90%;
	height: 70%;
	padding-right: 25px;
}

.line_Project_Introduce {
	font-weight: bold;
	font-size: 1.5em;
	font-style: nomal;
	color: black;
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	width: 150px;
}

/* 마감 임박 */
#countdown {
	margin-bottom: 1%;
}

#count-time {
	font-size: 1em;
	font-weight: bold;
	color: grey;
}

#counttime {
	padding: 1rem 0;
	font-size: 3.5rem;
	font-weight: 700;
	color: rgb(248, 100, 83);
	margin-right: 3px;
	font-size: 20px !important;
}

.jb-division-line {
	border-top: 1px solid #444444;
	margin: 30px 0px;
	width: 100%;
}

.percentage {
	color: rgb(255, 87, 87);
	display: flex;
	align-items: flex-end;
	font-weight: bold;
	padding-top: 2px;
	font-size: 13px;
	letter-spacing: -0.015em;
	line-height: 28px;
}

.FrontPage_ListTitle {
	font-weight: bold;
	font-size: 1.4em;
	margin: unset;
	/* margin-bottom: 2%; */
}

/* 상단 이동 버튼 */
#toTop {
	position: fixed;
	right: 100px;
	bottom: 100px;
	display: none;
	z-index: 9999;
	color: inherit;
	border: none;
	width: 50px;
	height: 50px;
	border-radius: 40px;
	text-align: center;
	font-weight: 180;
	cursor: pointer;
}
</style>

<body>


	<%@include file="./views/common/header.jsp"%>
	<%@include file="./views/common/nav.jsp"%>
	<%@include file="./views/common/common.jsp"%>

	<main>



		<div class="FrontPage_HomeWrapper">
			<div class="FrontPage_StyleHero">

				<div class="slider-1 slidesimg">
					<div class="slides">
						<c:forEach var="item" items="${banner }">
							<div class="active" width="760px" height="280px">
								<img
									src="resources/uploads/outerimage/760x280/${item.projectOuterImageName }">
							</div>
						</c:forEach>
					</div>
					<div class="page-btns">
						<div class="active"></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="side-btns">
						<div>
							<span><i class="fas fa-angle-left"></i></span>
						</div>
						<div>
							<span><i class="fas fa-angle-right"></i></span>
						</div>
					</div>
				</div>

				<!-- 자동 슬라이드 -->

				<!--	<div class="slider">
					<div class="slide">
						<img src="/resources/image/배너이미지1.jpg" alt="배너이미지1" width="760px"
							height="280px">
					</div>
					<div class="slide">
						<img src="/resources/image/배너이미지2.jpg" alt="배너이미지2" width="760px"
							height="280px">
					</div>
					<div class="slide">
						<img src="/resources/image/배너이미지3.jpg" alt="배너이미지3" width="760px"
							height="280px">
					</div>
					<div class="slide">
						<img src="/resources/image/배너이미지4.jpg" alt="배너이미지4" width="760px"
							height="280px">
					</div>
				</div> -->

				<p>주목할 만한 프로젝트</p>
				<div class="frontPageCard_Container">

					<div class="FrontCard_Container">
						<c:forEach var="item" items="${noteworthy }">
							<div class="card-wrapper">
								<a href="#"><img class="eximg"
									src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>

								<span class="projectCardDetail">
									<dd>

										<input type="hidden" value=${item.projectNo }> <a
											href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
									</dd>
									<dt>
										<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
									</dt> <span class="percentage">${item.projectCurrentPercentage }%
										달성</span>
								</span>
							</div>
						</c:forEach>

						<!-- <div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>

						<div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>

						<div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
 -->


						<!-- <div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>

						<div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>

						<div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>

						<div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a> <span
								class="projectCardDetail">
								<dd>
									<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개 </a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div> -->


					</div>




				</div>
			</div>



			<div class="FrontPage_StylePopularProjectsSection">

				<div class="popular-project-header">
					<p class="FrontPage_ListTitle">인기 프로젝트</p>
					<a href="#" class=FrontPage_viewTotal>전체보기</a>
				</div>

				<div class=populaPage_List>
					<div class="Popula-card-wrapper">
						<c:forEach var="item" items="${popularity }">
							<div class="popula-img" onclick="projectDetail(${item.projectNo})">
								<a href="#"><img class="popular_img"
									src="/resources/uploads/outerimage/130x105/${item.projectOuterImageName }"></a>
								<div class="ProjectCardNumbertop">1</div>
								<div class="projectCardDetail">
									<dd>

										<input type="hidden" value=${item.projectNo }> <a
											href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
									</dd>
									<dt>
										<a href="#" class="popula-project_Introduce">${item.projectIntroduce }</a>
									</dt>
									<span class="percentage">${item.projectCurrentPercentage }%
										달성</span>
								</div>
							</div>
						</c:forEach>
					</div>
					<a href="#" title="프로젝트 더보기" class="Project_ViewMore">인기 프로젝트
						전체보기</a>



					<div class="Popula-card-wrapper">
						<div class="popula-img">
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>
						<div class="ProjectCardNumber">1</div>
						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><span><a href="#">브랜드명</a></span>
							</dd>
							<dt>
								<a href="#" class="popula-project_Introduce">프로젝트 소개(테스트
									텍스트)</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>
					</div>

					<div class="Popula-card-wrapper">
						<div class="popula-img">
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>
						<div class="ProjectCardNumber">1</div>
						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><span><a href="#">브랜드명</a></span>
							</dd>
							<dt>
								<a href="#" class="popula-project_Introduce">프로젝트 소개(테스트
									텍스트)</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>
					</div>

					<a href="/menu.do?menu=popularity" title="프로젝트 더보기"
						class="Project_ViewMore">프로젝트 더보기</a>

				</div>
			</div>
		</div>

		<br>
		</div>

		<img class="banner"
			src="https://tumblbug-assets.imgix.net/main_banners/pc_images/000/000/009/original/9a5878ad-bf48-4144-b07e-b04ed3b0baf9.jpg?q=80"
			width="1160px" height="181.1px">


		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">마감임박! 마지막 기회</div>
			<div id="countdown">
				<Strong id="counttime"></Strong><span id="count-time">남았어요</span>
			</div>


			<div class="row_frontPage_Card">

				<c:forEach var="item" items="${Deadline }">

					<div class="card-wrapper">
						<a href="#"><img class="eximg"
							src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>

						<span class="projectCardDetail">
							<dd>

								<input type="hidden" value=${item.projectNo }> <a
									href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
							</dt> <span class="percentage">${item.projectCurrentPercentage }%
								달성</span>
						</span>
					</div>
				</c:forEach>
			</div>

		</div>







		<div class="jb-division-line"></div>
		<br>

		<div class="Container">
			<div class="FrontPage_ListTitle">최근 본 프로젝트</div>
			<br>

			<div class="row_frontPage_Card">

				<div class="slides_wrap">
					<div class="slides_show">
						<div class="slides_list">


							<div class="slides">
								<c:forEach var="item" items="${recentProject }">
									<div class="card-wrapper1" onclick="projectDetail()">
									<form id="detail-form">
										<a href="#"><img class="Card_img"
											src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>
										<span class="projectCardDetail">
											<dd>
												<input type="hidden" value=${item.projectNo }> <a
													href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
											</dd>
											<dt>
												<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
											</dt> <span class="percentage">${item.projectCurrentPercentage }%
												달성</span>
										</span>
									</form>
									</div>
								</c:forEach>

							</div>

							<div class="slides">
								<div class="card-wrapper1">
									<a href="#"><img class="Card_img"
										src="http://placehold.it/180x145"></a> <span
										class="projectCardDetail">
										<dd>
											<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
										</dd>
										<dt>
											<a href="#" class="Project_Introduce">프로젝트 소개 </a>
										</dt> <span class="percentage">798% 달성</span>
									</span>
								</div>
							</div>

							<div class="slides">
								<div class="card-wrapper1">
									<a href="#"><img class="Card_img"
										src="http://placehold.it/180x145"></a> <span
										class="projectCardDetail">
										<dd>
											<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
										</dd>
										<dt>
											<a href="#" class="Project_Introduce">프로젝트 소개 </a>
										</dt> <span class="percentage">798% 달성</span>
									</span>
								</div>
							</div>
							<div class="slides">
								<div class="card-wrapper1">
									<a href="#"><img class="Card_img"
										src="http://placehold.it/180x145"></a> <span
										class="projectCardDetail">
										<dd>
											<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
										</dd>
										<dt>
											<a href="#" class="Project_Introduce">프로젝트 소개 </a>
										</dt> <span class="percentage">798% 달성</span>
									</span>
								</div>
							</div>
							<div class="slides">
								<div class="card-wrapper1">
									<a href="#"><img class="Card_img"
										src="http://placehold.it/180x145"></a> <span
										class="projectCardDetail">
										<dd>
											<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
										</dd>
										<dt>
											<a href="#" class="Project_Introduce">프로젝트 소개 </a>
										</dt> <span class="percentage">798% 달성</span>
									</span>
								</div>
							</div>
							<div class="slides">
								<div class="card-wrapper1">
									<a href="#"><img class="Card_img"
										src="http://placehold.it/180x145"></a> <span
										class="projectCardDetail">
										<dd>
											<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
										</dd>
										<dt>
											<a href="#" class="Project_Introduce">프로젝트 소개 </a>
										</dt> <span class="percentage">798% 달성</span>
									</span>
								</div>
							</div>
							<div class="slides">
								<div class="card-wrapper1">
									<a href="#"><img class="Card_img"
										src="http://placehold.it/180x145"></a> <span
										class="projectCardDetail">
										<dd>
											<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
										</dd>
										<dt>
											<a href="#" class="Project_Introduce">프로젝트 소개 </a>
										</dt> <span class="percentage">798% 달성</span>
									</span>
								</div>
							</div>
							-->

						</div>
					</div>
					<div class="slides_btn">
						<button class="prev"><</button>
						<button class="next">></button>
					</div>
				</div>
			</div>
		</div>


		<div class="jb-division-line"></div>
		<div class="Container">
			<div class="FrontPage_ListTitle">이런 프로젝트 어때요?</div>
			<br>
			<div class="row_frontPage_Card">
				<c:forEach var="item" items="${Recommended }">
					<div class="card-wrapper">
						<a href="#"><img class="eximg"
							src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>

						<span class="projectCardDetail">
							<dd>
								<input type="hidden" value=${item.projectNo }> <a
									href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
							</dt> <span class="percentage">${item.projectCurrentPercentage }%
								달성</span>
						</span>
					</div>
				</c:forEach>
			</div>

		</div>


		<div class="jb-division-line"></div>



		<br> <img class="banner"
			src="https://tumblbug-assets.imgix.net/main_banners/pc_images/000/000/011/original/0db28a55-2b32-4966-b078-7e400c0dd528.jpg?q=80"
			width="1160px" height="181.1px">


		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">신규 프로젝트</div>
			<br>
			<div class="row_frontPage_Card">
				<c:forEach var="item" items="${newProject }">


					<div class="card-wrapper">
						<a href="#"><img class="eximg"
							src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>

						<span class="projectCardDetail">
							<dd>
								<input type="hidden" value=${item.projectNo }> <a
									href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
							</dt> <span class="percentage">${item.projectCurrentPercentage }%
								달성</span>
						</span>
					</div>
				</c:forEach>
			</div>
		</div>
		<br>

		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">공개예정 프로젝트</div>
			<br>
			<div class="row_frontPage_Card">
				<c:forEach var="item" items="${soonProject }">


					<div class="card-wrapper">
						<a href="#"><img class="eximg"
							src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>

						<span class="projectCardDetail">
							<dd>
								<input type="hidden" value=${item.projectNo }> <a
									href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
							</dt> <span class="percentage">${item.projectCurrentPercentage }%
								달성</span>
						</span>
					</div>
				</c:forEach>
			</div>
		</div>




		<!-- 배너 -->
		<br> <img class="banner" src="/resources/image/t1.png"
			width="1160px" height="181.1px">

		<div class="jb-division-line"></div>
		<!-- /배너 -->


		<div class="Container">
			<div class="FrontPage_ListTitle">오늘 오픈한 프로젝트</div>
			<br>
			<div class="row_frontPage_Card">
				<c:forEach var="item" items="${todayProject }">


					<div class="card-wrapper">
						<a href="#"><img class="eximg"
							src="/resources/uploads/outerimage/180x153/${item.projectOuterImageName }"></a>

						<span class="projectCardDetail">
							<dd>
								<input type="hidden" value=${item.projectNo }> <a
									href="#">${item.projectKind }</a><span><a href="#">${item.projectManagerName }</a></span>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">${item.projectIntroduce }</a>
							</dt> <span class="percentage">${item.projectCurrentPercentage }%
								달성</span>
						</span>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="ContentInfo_Container">
				<img src="resources/image/크리스마스">


				<div class="Content_TextInfobox">
					<div class="Content_Title">크리스마스 선물상점</div>
					<a>
						<div class="Content_TextInfo">손꼽아 기다린 크리스마스! 포근한 연말을 위해 텀블벅이
							준비한 크리스마스 선물 상점을 둘러보세요. 후원자를 위한 특별한 선물, 럭키박스와 40만원 상당의 어드벤트
							캘린더까지!</div>
				</div>
				</a> <a href="#" title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
			</div>

			<div class="lines_Collection_Contents_div">
				<div class="lines_Collection_Contents">

					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>
				</div>

				<div class="lines_Collection_Contents">
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>

					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br> <br>

		<div class="jb-division-line"></div>

		<div class="Container_1page">
			<div class="ContentInfo_Container">
				<img src="resources/image/크리스마스.jpg">


				<div class="Content_TextInfobox">
					<div class="Content_Title">크리스마스 선물상점</div>
					<a>
						<div class="Content_TextInfo">손꼽아 기다린 크리스마스! 포근한 연말을 위해 텀블벅이
							준비한 크리스마스 선물 상점을 둘러보세요. 후원자를 위한 특별한 선물, 럭키박스와 40만원 상당의 어드벤트
							캘린더까지!</div>
				</div>
				</a> <a href="#" title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
			</div>
			<div class="lines_Collection_Contents_div">
				<div class="lines_Collection_Contents">

					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>
				</div>

				<div class="lines_Collection_Contents">
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>

					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a> <span class="percentage">585%
								달성</span>
						</div>
					</div>
					<div class="lines_card-wrapper">
						<a href="#"><img class="lines_card-wrapper_img"
							src="http://placehold.it/180x145"></a><br>
						<div class=projectCardDetail>
							<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
								class="Project_Introduce">프로젝트 소개</a><span class="percentage">585%
								달성</span>
						</div>
					</div>
				</div>
			</div>
		</div>



		<button id="toTop">Top</button>





	</main>
	<%@include file="./views/common/footer.jsp"%>
</body>


<script>
	// 최상단 이동 버튼

	$(function() { // 보이기 | 숨기기 
		$(window).scroll(function() {
			if ($(this).scrollTop() > 250) {
				$('#toTop').fadeIn();
				$('#toTop').css('left', $('#sidebar').offset().left);
			} else {
				$('#toTop').fadeOut();
			}
		});
		// 버튼 클릭시 
		$("#toTop").click(function() {
			$('html, body').animate({
				scrollTop : 0

			}, 400);
		});
	});

	// 슬라이드
	let slidesWrap = $(".slides_wrap"), slidesShow = slidesWrap
			.find(".slides_show"), slidesList = slidesShow.find(".slides_list"), slides = slidesList
			.find(".slides"), slidesBtn = slidesWrap.find(".slides_btn");

	let slidesCount = slides.length, slidesWidth = slides.innerWidth(), showNum = 3, num = 0, currentIndex = 0,

	slidesCopy = $(".slides:lt(" + showNum + ")").clone();
	slidesList.append(slidesCopy);

	//이미지 움직이기
	function backShow() {
		if (num == 0) {
			//시작
			num = slidesCount;
			slidesList.css("left", -num * slidesWidth + "px");
		}
		num--;
		slidesList.stop().animate({
			left : -slidesWidth * num + "px"
		}, 400);
	}

	function nextShow() {
		if (num == slidesCount) {
			//마지막
			num = 0;
			slidesList.css("left", num);
		}
		num++;
		slidesList.stop().animate({
			left : -slidesWidth * num + "px"
		}, 400);
	}

	//왼쪽, 오른쪽 버튼 설정
	slidesBtn.on("click", "button", function() {
		if ($(this).hasClass("prev")) {
			//왼쪽 버튼을 클릭
			backShow();
		} else {
			//오른쪽 버튼을 클릭
			nextShow();
		}
	});

	$('.slider-1 > .page-btns > div').click(function() {
		var $this = $(this);
		var index = $this.index();

		$this.addClass('active');
		$this.siblings('.active').removeClass('active');

		var $slider = $this.parent().parent();

		var $current = $slider.find(' > .slides > div.active');

		var $post = $slider.find(' > .slides > div').eq(index);

		$current.removeClass('active');
		$post.addClass('active');
	});

	// 좌/우 버튼 추가 슬라이더
	$('.slider-1 > .side-btns > div').click(function() {
		var $this = $(this);
		var $slider = $this.closest('.slider-1');

		var index = $this.index();
		var isLeft = index == 0;

		var $current = $slider.find(' > .page-btns > div.active');
		var $post;

		if (isLeft) {
			$post = $current.prev();
		} else {
			$post = $current.next();
		}
		;

		if ($post.length == 0) {
			if (isLeft) {
				$post = $slider.find(' > .page-btns > div:last-child');
			} else {
				$post = $slider.find(' > .page-btns > div:first-child');
			}
		}
		;

		$post.click();
	});

	setInterval(function() {
		$('.slider-1 > .side-btns > div').eq(1).click();
	}, 3000);

	/* let currentSlide = 0;
	const slide = document.querySelectorAll('.slide');
	const slideCount = slide.length;

	function showSlide(n) {
	    slide.forEach(slide => slide.style.display = 'none');
	    slide[n].style.display = 'block';
	}

	function nextSlide() {
	    currentSlide = (currentSlide + 1) % slideCount;
	    showSlide(currentSlide);
	}

	function prevSlide() {
	    currentSlide = (currentSlide - 1 + slideCount) % slideCount;
	    showSlide(currentSlide);
	}

	document.addEventListener('DOMContentLoaded', () => {
	    showSlide(currentSlide);
	    setInterval(nextSlide, 3000); // 3초마다 자동 슬라이드
	});
	 
	let num1 = 1;
	
	function change1(idx) {
		if(idx) {
			if(num1 == 8) return;
			num1++;
		} else {
			if(num1 == 1) return;
			num1--;
		}
		let imgTag = document.getElementById("photo");
		imgTag.setAttribute("src=","images/img0" + num1 + ".jpg");
		
	} */

	setInterval(function time() {
		//시간 초기화
		var d = new Date();
		var hours = 24 - d.getHours();
		var min = 60 - d.getMinutes();
		var sec = 60 - d.getSeconds();
		//분이 있으면 시 반올림
		if (min == '00') {
			hours = 24 - d.getHours();
		} else {
			hours = 23 - d.getHours();
		}
		//초가 있으면 분 반올림        
		if (sec == '00') {
			min = 60 - d.getMinutes();
		} else {
			min = 59 - d.getMinutes();
		}
		//1자리수라면 0을 붙혀라
		if ((hours + '').length == 1) {
			hours = '0' + hours;
		}
		if ((min + '').length == 1) {
			min = '0' + min;
		}
		if ((sec + '').length == 1) {
			sec = '0' + sec;
		}
		//날짜를 표기하고 딜레이는 1초(1000)마다 바뀌겠금
		jQuery('#countdown Strong').html(
				'<Strong class="t_hour">' + hours + '</Strong>'
						+ '<Strong class="t_colon">:</Strong>'
						+ '<Strong class="t_min">' + min + '</Strong>'
						+ '<Strong class="t_colon">:</Strong>'
						+ '<Strong class="t_sec">' + sec + '</Strong>')
	}, 1000);
</script>
</html>
