<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>

<link rel="stylesheet" href="/resources/css/category/category.css">
</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>

	<main>
		<%-- <div id="menu">
			<div class="nav_menu_left">
				<a href="/category.do?category=entire">전체</a> <a
					href="/category.do?category=Appliances">가전</a> <a
					href="/category.do?category=Clothes">의류</a> <a
					href="/category.do?category=Beauty">향수·뷰티</a> <a
					href="/category.do?category=Food">푸드</a> <a
					href="/category.do?category=Jewelry">주얼리</a> <a
					href="/category.do?category=Christmas" class="Christmas_menu_text">크리스마스</a>
			</div>
			<div class="nav_menu_right">
				<c:if test="${empty sessionScope.memberNo}">
					<div class="nav_menu_right_hover">
						<a href="/form/loginform.do"><img
							src="/resources/image/id.png" alt=""> <span class="subtext">마이페이지</span>
						</a>
					</div>
					<div class="nav_menu_right_hover">
						<a href="/form/loginform.do"><img
							src="/resources/image/project.png" alt=""> <span
							class="subtext">프로젝트 등록</span> </a>
					</div>
					<div class="nav_menu_right_hover">
						<a onclick="getSearchForm()"><img
							src="/resources/image/search.png" alt=""> <span
							class="subtext">검색</span> </a>
					</div>
				</c:if>

				<c:if test="${not empty sessionScope.memberNo}">
					<c:if test="${sessionScope.memberType == 1}">

						<div class="nav_menu_right_hover">

							<a href="/myPage.do?cpage=1"><img
								src="/resources/image/id.png" alt=""> <span
								class="subtext">마이페이지</span> </a>
						</div>
						<div class="nav_menu_right_hover">
							<a href="/form/projectEnrollForm.do"><img
								src="/resources/image/project.png" alt=""> <span
								class="subtext">프로젝트 등록</span> </a>
						</div>
						<div class="nav_menu_right_hover">
							<a onclick="getSearchForm()"><img
								src="/resources/image/search.png" alt=""> <span
								class="subtext">검색</span> </a>
						</div>
					</c:if>

					<c:if test="${sessionScope.memberType == 0}">

						<div class="nav_menu_right_hover">
							<a href="/administratorOk.do?menu=first&cpage=1""><img
								src="/resources/image/project.png" alt=""> <span
								class="subtext">프로젝트 관리</span> </a>
						</div>
						<div class="nav_menu_right_hover">
							<a onclick="getSearchForm()"><img
								src="/resources/image/search.png" alt=""> <span
								class="subtext">검색</span> </a>
						</div>
					</c:if>
				</c:if>
			</div>
		</div> --%>


		<div class="project-cartegory">
			<div>${title }</div>
			<hr>


			<div class="product_container">
				<c:forEach var="item" items="${list }">
					<div class="product">
						<div class="img_div">
							<a class="img_div_a" href=""><img
								src="/resources/uploads/outerimage/300x300/${item.projectOuterImageName }"

								alt="상품 이미지" onclick="projectDetail(${item.projectNo})"></a>
							

							<div class="LikeButton_Wrapper">
								<button class="LikeBtn2">
									<svg class="like" xmlns="http://www.w3.org/2000/svg"
										height="16" width="16" viewBox="0 0 512 512">

											<path

											d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z" /></svg>

								</button>
							</div>


						</div>
						<a href="#" class="category_name">${item.projectKind }</a><a
							class="divide_area">|</a><a href="#" class="manager_name">${item.projectManagerName }</a>

						<a href="#" class="project_title">${item.projectName }</a>
						<p class="project_explanation">${item.projectIntroduce }</p>
						<div class="detail_text">
							<p class="achievement_rate">${item.projectCurrentPercentage }%</p>
							<p class="sponsorship_amount">${item.projectCurrentAmount }원</p>
							<p class="remaining_days">${item.projectRemainDate }일남음</p>

						</div>

					</div>

				</c:forEach>
			</div>

		</div>

	</main>

	<%@include file="../../views/common/footer.jsp"%>
	<script src="/resources/js/category/category.js"></script>
</body>
</html>

<script>

document.addEventListener('DOMContentLoaded', function() {
const menu = document.getElementById('menu');
const titleDiv = document.querySelector('.project-cartegory > div');

window.addEventListener('scroll', () => {
   const titleDivBottom = titleDiv.getBoundingClientRect().bottom;

   if (titleDivBottom <= 0) {
       menu.classList.remove('hide');
       menu.classList.add('show');
   } else {
       menu.classList.remove('show');
       menu.classList.add('hide');
   }
});
});
</script>