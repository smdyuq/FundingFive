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
				<img src="/resources/image/back.png" onclick="history.back();" >
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
					<a href="#" class="category_name" >${item.projectKind }</a><a
						class="divide_area">|</a><a href="#" class="manager_name">${item.projectManagerName }</a>
					<a class="project_title"  onclick="projectDetail('${item.projectNo}')">${item.projectName }</a>
					<p class="project_explanation"  onclick="projectDetail('${item.projectNo}')">${item.projectIntroduce }</p>
					<div class="detail_text">
						<p class="achievement_rate">${item.projectCurrentPercentage}%</p>
						<p class="sponsorship_amount">${item.projectCurrentAmount}원</p>
						<p class="remaining_days">${item.projectRemainDate}일 남음</p>
					</div>
				</div>
			</c:forEach>

		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>