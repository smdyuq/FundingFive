<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
	<link rel="stylesheet" href="/resources/css/project/projectSearchResult.css">
	<script src="/resources/js/project/projectDetail.js"></script>
</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>
	<link rel="stylesheet" href="/resources/css/project/projectSearchResult.css">
	    <main>
        <div class="project-search">
            <div class="search_word">
                <p>'<span>${searchWord}</span>'에 대한 검색결과 입니다.</p>

            </div>
            <div class="Search_results_number">
                <p><span>n</span>건의 검색결과</p>
            </div>
        </div>
        <hr class="thick-line">
        <div class="product_container">

        <c:forEach var="item" items="${searchedProjectList}">
            <div class="product" onclick="projectDetail('${item.projectNo}')">
                <div class="img_div">
                    <a class="img_div_a" href=""><img src="#" alt="상품 이미지"></a>
                </div>
                <a href="#" class="category_name">카테고리</a><a class="divide_area">|</a><a href="#"
                    class="manager_name">창작자</a>
                <a href="#" class="project_title">제목 2줄 넘어가면 잘림 테스트 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트</a>
                <p class="project_explanation">설명 2줄 넘어가면 잘림 테스트 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트</p>
                <div class="detail_text">
                    <p class="achievement_rate">{달성률}%</p>
                    <p class="sponsorship_amount">{현재 후원된 금액}원 </p>
                    <p class="remaining_days">{남은 날짜}일 남음</p>
                </div>
            </div>
            </c:forEach>

        </div>
    </main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
