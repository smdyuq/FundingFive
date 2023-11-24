<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="./views/common/head.jsp"%>
</head>

<style>

.FrontPage_ListTime {
	margin-bottom: 25px;
}

.Time {
	font-weight: 700;
	color: rgb(248, 100, 83);
	margin-right: 3px;
	font-size: 20px !important;
	line-height: 28px !important;
}

.Project_ViewMore {
	display: inline-block;
	box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 8px;
	border: 1px solid rgb(230, 230, 230);
	text-align: center;
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
	line-height: 20px;
	margin-left: 15px;
}

.ProjectCardNumber {
	position: absolute;
}

div.card-wrapper>div {
	display: inline-block;
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

.Container_1page {
	width: 1100px;
	height: auto;
	display: flex;
}

.ContentInfo_Container {
	width: auto;
}

.card-wrapper {
	width: auto;
	height: auto;
	margin-bottom: 20px;
}

.Project_Container {
	width: auto;
	height: 800px;
	flex-direction: column;
	display: block;
}

.Container {
	width: 1000px;
	height: 400px;
	padding-left: 0px;
}

a {
	text-decoration: none;
}

dd {
	margin: auto;
}

.Project_Introduce {
	font-weight: bold;
	font-size: 1.5em;
	font-style: nomal;
	color: black;
}

.FrontPage_viewTotal {
	margin-left: 100px;
	font-size: small;
}

.frontPageCard_Container {
	height: 600px;
	width: 800px;
}

.frontPage_Card {
	float: left;
	margin-right: 20px;
	display: flex;
}

.jb-division-line {
	border-top: 1px solid #444444;
	margin: 30px 0px;
	width: 1300px;
}

.projectCardDetail {
	font-size: 0.8em;
	margin-bottom: 20px;
}

.FrontPage_HomeWrapper {
	display: flex;
	margin-left: 40px;
	width: 100%;
	background-color:
}

.FrontPage_StyleHero {
	width: 850px;
	height: 950.41px;
}

.FrontPage_StylePopularProjectsSection {
	float: right;
	width: 380px;
	height: 950.41px;
	margin-left: 50px;
}

.FrontPage_ListTitle {
	font-weight: bold;
	font-size: 1.5em;
}

.percentage {
	color: rgb(255, 87, 87);
}
</style>

<body>
	<%@include file="./views/common/header.jsp"%>
	<%@include file="./views/common/nav.jsp"%>
	<main>
		<div class="FrontPage_HomeWrapper">


			<div class="FrontPage_StyleHero">
				<img src="/resources/image/이미지3.jpg" width="766" height="280"><br>
				<br>
				<div class="FrontPage_ListTitle">주목할 만한 프로젝트</div>
				<br>
				<div class="frontPageCard_Container">


					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>
					<div class="frontPage_Card">
						<div class="card-wrapper">
							<a href="#"><img src="http://placehold.it/180x145"></a> <span
								class=projectCardDetail>
								<dd>
									<a href="#">카테고리</a><a href="#">브랜드명</a>
								</dd>
								<dt>
									<a href="#" class="Project_Introduce">프로젝트 소개</a>
								</dt> <span class="percentage">798% 달성</span>
							</span>
						</div>
					</div>












				</div>
			</div>



			<div class="FrontPage_StylePopularProjectsSection">
				<div class="FrontPage_ListTitle">
					인기 프로젝트 <a href="#" class=FrontPage_viewTotal>전체보기</a>
				</div>
				<br>

				<div class=Project_Container>

					<div class="card-wrapper">

						<div>
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>

						<div class="ProjectCardNumber">1</div>

						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><a href="#">브랜드명</a>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">프로젝트 소개</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>

					</div>

					<div class="card-wrapper">

						<div>
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>

						<div class="ProjectCardNumber">1</div>

						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><a href="#">브랜드명</a>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">프로젝트 소개</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>

					</div>
					<div class="card-wrapper">

						<div>
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>

						<div class="ProjectCardNumber">1</div>

						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><a href="#">브랜드명</a>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">프로젝트 소개</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>

					</div>
					<div class="card-wrapper">

						<div>
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>

						<div class="ProjectCardNumber">1</div>

						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><a href="#">브랜드명</a>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">프로젝트 소개</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>

					</div>
					<div class="card-wrapper">

						<div>
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>

						<div class="ProjectCardNumber">1</div>

						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><a href="#">브랜드명</a>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">프로젝트 소개</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>

					</div>
					<div class="card-wrapper">

						<div>
							<a href="#"><img src="http://placehold.it/108x87"></a>
						</div>

						<div class="ProjectCardNumber">1</div>

						<div class=projectCardDetail>
							<dd>
								<a href="#">카테고리</a><a href="#">브랜드명</a>
							</dd>
							<dt>
								<a href="#" class="Project_Introduce">프로젝트 소개</a>
							</dt>
							<span class="percentage">798% 달성</span>
						</div>
					</div>
					<a href="#" title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
				</div>
			</div>
		</div>
		<img
			src="https://tumblbug-assets.imgix.net/main_banners/pc_images/000/000/009/original/9a5878ad-bf48-4144-b07e-b04ed3b0baf9.jpg?q=80"
			width="1160px" height="181.1px">

		<div class="jb-division-line"></div>

		<br>

		<div class="Container">
			<div class="FrontPage_ListTitle">최근 본 프로젝트</div>
			<br>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>

		</div>

		<div class="jb-division-line"></div>
		<div class="Container">
			<div class="FrontPage_ListTitle">이런 프로젝트 어때요?</div>
			<br>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>

			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>

		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">에디터의 PICK</div>
			<br>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>

		<br> <img
			src="https://tumblbug-assets.imgix.net/main_banners/pc_images/000/000/011/original/0db28a55-2b32-4966-b078-7e400c0dd528.jpg?q=80"
			width="1160px" height="181.1px">
		<div class="jb-division-line"></div>

		<div class="Container">
			<div class="FrontPage_ListTitle">내가 본 프로젝트와 비슷해요</div>
			<br>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>

		<div class="jb-division-line"></div>

		<div class="Container_1page">
			<div class="ContentInfo_Container">
				<img src="http://placehold.it/274x274">

				<div class="Content_Title">[OPEN] 크리스마스 선물상점</div>
				<a><div class="Content_TextInfo">컨텐츠 내용</div></a> <a href="#"
					title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
			</div>

			<div class="Collection_Contents">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>

		<div class="jb-division-line"></div>

		<div class="Container_1page">
			<div class="ContentInfo_Container">
				<img src="http://placehold.it/274x274">

				<div class="Content_Title">[OPEN] 크리스마스 선물상점</div>
				<a><div class="Content_TextInfo">컨텐츠 내용</div></a> <a href="#"
					title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
			</div>

			<div class="Collection_Contents">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>

		<div class="jb-division-line"></div>

		<div class="Container_1page">
			<div class="ContentInfo_Container">
				<img src="http://placehold.it/274x274">

				<div class="Content_Title">[OPEN] 크리스마스 선물상점</div>
				<a><div class="Content_TextInfo">컨텐츠 내용</div></a> <a href="#"
					title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>


			</div>

			<div class="Collection_Contents">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>

				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/180x145"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>

		<div class="jb-division-line"></div>
		<div class="Container">
			<div class="FrontPage_ListTitle">신규 프로젝트</div>
			<br>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>

			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<a href="#" title="프로젝트 더보기" class="Project_ViewMore">프로젝트 더보기</a>
		</div>



		<div class="jb-division-line"></div>
		<div class="Time_Container">
			<div class="FrontPage_ListTitle">마감임박! 마지막 기회</div>
			<div class="FrontPage_ListTime">
				<Strong class="Time">11:59:34</Strong>남았어요
			</div>

			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>

			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
			<div class="frontPage_Card">
				<div class="card-wrapper">
					<a href="#"><img src="http://placehold.it/220x179"></a><br>
					<div class=projectCardDetail>
						<a href="#">생활 용품</a> <a href="#">코튼샤워</a><br> <a href="#"
							class="Project_Introduce">프로젝트 소개</a><br> <span
							class="percentage">585% 달성</span>
					</div>
				</div>
			</div>
		</div>











	</main>
	<%@include file="./views/common/footer.jsp"%>
</body>
</html>