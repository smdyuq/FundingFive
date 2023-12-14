<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="/resources/js/project/projectDetail.js"></script>
</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>
	<link rel="stylesheet" href="/resources/css/category/category.css">
	<main>

		<div class="project-cartegory">

			<div>${title }</div>
			<hr>




			<div class="product_container">
				<c:forEach var="item" items="${list }">
					<div class="product" onclick="projectDetail(${item.projectNo})">
						<div class="img_div">
							<a href="#" class="img_div_a"><img
								src="/resources/uploads/outerimage/300x300/${item.projectOuterImageName }"

								alt="상품 이미지"></a>
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
</body>
</html>