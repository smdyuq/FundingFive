<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>프로젝트 검색</title>
	<link href="/resources/css/project/projectSearch.css" rel="stylesheet" />
	<script src="/resources/js/search/projectSearch.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>

    <div class="search_box_div">
        <img src="./search.png" alt="돋보기 이미지" style="width: 40px; height: 40px;">
        <div>
	        <input type="text" class="search_box" id="search_box" placeholder="검색어를 입력해주세요." required>
	        <button class="search_btn" onclick="projectSearch()">검색</button>
	        <button class="close_btn">X</button>
        </div>
    </div>
    <div class="recent_searches">
        <p>최근 검색어</p>
        <div class="recent_searches_text">
        <c:choose>
	        <c:when test="${empty memberSearchArr}">
	            <div class="recent_searches_result">
	                <a href="#">최근검색어가 없습니다.</a>
	            </div>
	        </c:when>
	        <c:otherwise>
	            <div class="recent_searches_result">
	            	<c:forEach var="searching" items="${memberSearchArr}">
	                	<div id="search-words${searching.searchNo}"><a id="search-word">${searching.searchWord}</a><a onclick="deleteSearchHistory(${searching.searchNo})">x</a></div>
	                </c:forEach>
	            </div>
	        </c:otherwise>   
        </c:choose> 
        </div>
    </div>    
    <div class="popular_searches">
        <p>인기 검색어</p>
        <div class="popular_searches_text">
        <c:choose>
	        <c:when test="${empty popularSearchArr}">
	            <div class="searche_row">
	                <div><a href="#">인기검색어가 없습니다.</a></div>
	            </div>
	        </c:when>    
	        <c:otherwise>
	        	<c:forEach var="searching" items="${popularSearchArr}">
	                	<div onclick="searchPopularWord(${searching.searchWord})"><a href="#">${searching.rowNum}</a><a id="popular-search">${searching.searchWord}</a></div>
	            </c:forEach>
	        </c:otherwise>
        </c:choose>
        </div>
    </div>


</body>

</html>


