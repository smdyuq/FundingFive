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
</head>

<body>

    <div class="search_box_div">
        <img src="./search.png" alt="돋보기 이미지" style="width: 40px; height: 40px;">
        <input type="text" class="search_box" id="search_box" placeholder="검색어를 입력해주세요." required>
        <button class="search_btn">검색</button>
        <button class="close_btn">X</button>
    </div>
    <div class="recent_searches">
        <p>최근 검색어</p>
        <div class="recent_searches_text">
        <c:when test="${empty projectApprovedList}">
            <div class="recent_searches_result">
                <a href="#">최근검색어가 없습니다.</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="recent_searches_result">
            	<c:forEach var="search-word" items="${memberSearchArr}">
                	<a href="#">${search-word}</a><a href="#">x</a>
                </c:forEach>
            </div>
        </c:otherwise>    
        </div>
    </div>    
    <div class="popular_searches">
        <p>인기 검색어</p>
        <div class="popular_searches_text">
            <div class="searche_row">
                <div><p>1</p><a href="#">임시값</a></div>
                <div><p>2</p><a href="#">임시값</a></div>
                <div><p>3</p><a href="#">임시값</a></div>
                <div><p>4</p><a href="#">임시값</a></div>
                <div><p>5</p><a href="#">임시값</a></div>
            </div>
            <div class="searche_row">
                <div><p>6</p><a href="#">임시값</a></div>
                <div><p>7</p><a href="#">임시값</a></div>
                <div><p>8</p><a href="#">임시값</a></div>
                <div><p>9</p><a href="#">임시값</a></div>
                <div><p>10</p><a href="#">임시값</a></div>
            </div>
        </div>
    </div>


</body>

</html>


