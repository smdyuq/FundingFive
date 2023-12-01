<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<%@include file="./views/common/head.jsp"%>
</head>

<style>
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

.slider-1 {
	height: 400px;
	position: relative;
}

/* 슬라이더 1 - 페이지 버튼 */
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
	/* position: absolute;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0; */
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

/* 이미지 슬라이드  */
/* .slider {
	width: 100%;
	overflow: hidden;
	position: relative;
}

.slide {
	float: left;
	width: 98%;
	position: relative; */
}
img {
	width: 100%;
	height: auto;
}

/* 좋아요 버튼  */
.eximg {
	position: relative;
}

.LikeBtn {
	border: none;
	background-color: transparent;
	position: absolute;
	transform: translate(560%, -120%);
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
	width: 100%;
}

/* 상단 왼쪽 (주목할만한 프로젝트)*/
.FrontPage_StyleHero {
	width: 70%;
	height: auto;
	margin-left: 60px;
}

.FrontPage_StyleHero>img {
	width: 100%;
	height: 280px;
	margin-bottom: 3%;
}

.FrontPage_StyleHero>p {
	/*    text-align: center; */
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
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	overflow: hidden;
	text-overflow: ellipsis;
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
	width: 100%;
	padding-right: 2%;
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
	width: auto;
}

/* 상단 오른쪽 (인기 프로젝트) */
.FrontPage_StylePopularProjectsSection {
	float: right;
	width: 30%;
	height: auto;
	margin-left: 3.5%;
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
	display: flex;
	align-items: flex-start;
	justify-content: space-between;
	flex-basis: 300px;
}

.Popula-card-wrapper>div {
	width: 45%;
}

.ProjectCardNumber {
	flex-basis: 4%;
	overflow: hidden;
	font-weight: 900;
}

.ProjectCardNumbertop {
	color: rgba(240, 80, 62, 0.9);
	flex-basis: 4%;
	overflow: hidden;
	font-weight: 900;
}

.popula-project_Introduce {
	font-weight: bold;
	font-size: 1.5em;
	font-style: nomal;
	color: black;
	text-overflow: ellipsis;
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
}

.FrontPage_viewTotal {
	padding-top: 3%;
	font-size: small;
}

.popular-project-header {
	display: flex;
	justify-content: space-between;
	padding: 1%;
	margin-bottom: 8%;
}

.Project_ViewMore {
	display: inline-block;
	box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 8px;
	border: 1px solid rgb(230, 230, 230);
	color: rgb(61, 61, 61);
	-webkit-box-pack: center;
	justify-content: center;
	-webkit-box-align: center;
	align-items: center;
	border-radius: 22px;
	display: flex;
	width: 204px;
	height: 44px;
	font-size: 13px;
	margin-top: 10%;
	margin: 0 auto;
}

div.card-wrapper>div {
	/* display: inline-block; */
	
}

.card-wrapper>a, img {
	width: 100%;
	height: auto;
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
}

/* 베너 */
.banner {
	width: 100%;
}

/* 최근본 */
.row_frontPage_Card {
	display: flex;
	/* 	background-color: aqua; */
	width: auto;
	position: relative;
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
	width: 90%;
	height: auto;
	display: flex;
}

.ContentInfo_Container {
	width: 50%;
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
						<div class="active">
							<img src="resources/image/배너이미지1.jpg">
						</div>
						<div>
							<img src="resources/image/배너이미지2.jpg">
						</div>
						<div>
							<img src="resources/image/배너이미지3.jpg">
						</div>
						<div>
							<img src="resources/image/배너이미지4.jpg">
						</div>
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

				<!-- <div class="slider">
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

					<div class="frontPageCard_Row">

						<div class="card-wrapper">
							<a href="#"><img class="eximg"
								src="http://placehold.it/180x145"></a>

							<div class=Likebtn_Wrapper>
								<button class="LikeBtn">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-suit-heart"
										viewBox="0 0 16 16">
  										<path
											d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
</svg>
								</button>
							</div>

							<span class="projectCardDetail">
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
						</div>


					</div>

					<div class="frontPageCard_Row">

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


					</div>




				</div>
			</div>



			<div class="FrontPage_StylePopularProjectsSection">
				<div class="popular-project-header">
					<p class="FrontPage_ListTitle">인기 프로젝트</p>
					<a href="#" class=FrontPage_viewTotal>전체보기</a>
				</div>


				<div class="Project_Container">


					<div class="Popula-card-wrapper">
						<div class="popula-img">
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>
						<div class="ProjectCardNumbertop">1</div>
						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><span><a href="#">브랜드명</a></span>
							</dd>
							<dt>
								<a href="#" class="popula-project_Introduce">프로젝트 소개(테스트
									텍스트ㅎㅎㅎㅎㅎㅎ</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>
					</div>

					<div class="Popula-card-wrapper">
						<div class="popula-img">
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>
						<div class="ProjectCardNumbertop">2</div>
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
						<div class="ProjectCardNumbertop">3</div>
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

					<a href="#" title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
				</div>
			</div>
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
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>
			</div>
			<br> <br>
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
								<div class="card-wrapper">
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
								<div class="card-wrapper">
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
								<div class="card-wrapper">
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
								<div class="card-wrapper">
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
								<div class="card-wrapper">
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
								<div class="card-wrapper">
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
								<div class="card-wrapper">
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
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
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
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
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
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
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
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
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

		</div>


		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">에디터의 PICK</div>
			<br>
			<div class="row_frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>
			</div>

		</div>




		<br> <img class="banner"
			src="https://tumblbug-assets.imgix.net/main_banners/pc_images/000/000/011/original/0db28a55-2b32-4966-b078-7e400c0dd528.jpg?q=80"
			width="1160px" height="181.1px">
		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">내가 본 프로젝트와 비슷해요</div>
			<br>
			<div class="row_frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>
			</div>

		</div>

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

		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">신규 프로젝트</div>
			<br>
			<div class="row_frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>
			</div>
		</div>
		<br>

		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">공개예정 프로젝트</div>
			<br>
			<div class="row_frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>
			</div>

		</div>
		<br> <br>

		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">오늘 오픈한 프로젝트</div>
			<br>
			<div class="row_frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a> <span
						class="projectCardDetail">
						<dd>
							<a href="#">카테고리</a><span><a href="#">작성자명</a></span>
						</dd>
						<dt>
							<a href="#" class="Project_Introduce">프로젝트 소개 </a>
						</dt> <span class="percentage">798% 달성</span>
				</div>
			</div>

		</div>
		<br> <br>



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
