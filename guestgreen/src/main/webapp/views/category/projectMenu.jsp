<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		
		<div class="project-cartegory">
			<c:forEach var="item" items="${list }">
				
					<div>${title }</div>

					<div class="product_container">
						<div class="product">
							<div class="img_div">
								<a class="img_div_a" href=""><img
									src="/resources/uploads/outerimage/130x105/${item.projectOuterImageName }" alt="상품 이미지"></a>
							</div>
							<a href="#" class="category_name">${item.projectKind }</a><a
								class="divide_area">|</a><a href="#" class="manager_name">${item.projectManagerName }</a>
							<a href="#" class="project_title">제목 2줄 넘어가면 잘림 테스트
								테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트</a>
							<p class="project_explanation">설명 2줄 넘어가면 잘림 테스트
								테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트</p>
							<div class="detail_text">
								<p class="achievement_rate">{달성률}%</p>
								<p class="sponsorship_amount">{현재 후원된 금액}원</p>
								<p class="remaining_days">{남은 날짜}일 남음</p>
							</div>
						</div>

					</div>
				
			</c:forEach>
		
		
	</main>
	<%@ include file="../../views/common/footer.jsp"%>
</body>
</html>