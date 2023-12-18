<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>

<link rel="stylesheet"
	href="/resources/css/project/projectSearchResult.css">
<script src="/resources/js/project/projectDetail.js"></script>
</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>

	<main>
		<div class="project-search">
			<div class="back_btn">
				<img src="/resources/image/back.png" onclick="history.back();">
			</div>
			<div class="search_word">
				<p>
					'<span>${searchWord}</span>'에 대한 검색결과 입니다.
				</p>
			</div>
			<div class="Search_results_number">
				<p>
					<span>${searchCount}</span>건의 검색결과
				</p>
			</div>
		</div>
		<hr class="thick-line">
		<div class="product_container">
			<c:forEach var="item" items="${searchedProjectList}">
				<div class="product">
					<div class="img_div" onclick="projectDetail('${item.projectNo}')">
						<a class="img_div_a" onclick="projectDetail(${item.projectNo})"><img
							src="/resources/uploads/outerimage/300x300/${item.projectOuterImageName}"
							alt="상품 이미지"></a>
					</div>

					<div class="LikeButton_Wrapper">
						<input type="hidden" id="project-no${count}"
							value="${item.projectNo}">
						<button class="LikeBtn2">
							<svg
								class="like count${count} ${not empty userLikeMap[no] ? 'active' : ''}"
								xmlns="http://www.w3.org/2000/svg" height="16" width="16"
								viewBox="0 0 512 512">
                                 <path
									d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z" /></svg>

						</button>
					</div>



					<a href="#" class="category_name">${item.projectKind }</a><a
						class="divide_area">|</a><a href="#" class="manager_name">${item.projectManagerName }</a>
					<a class="project_title"
						onclick="projectDetail('${item.projectNo}')">${item.projectName }</a>
					<p class="project_explanation"
						onclick="projectDetail('${item.projectNo}')">${item.projectIntroduce }</p>
					<div class="detail_text">
						<p class="achievement_rate">${item.projectCurrentPercentage}%</p>
						<p class="sponsorship_amount">${item.projectCurrentAmount}원</p>
						<p class="remaining_days">${item.projectRemainDate}일남음</p>
					</div>
				</div>
			</c:forEach>

		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>