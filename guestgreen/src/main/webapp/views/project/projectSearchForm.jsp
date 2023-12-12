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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
	<div class="search_box_page">
		<div class="search_box_div">
			<div class="back_btn">
				<img src="resources/image/back.png" onclick="history.back();">
			</div>
			<div class="input_imgbutton_div">
				<input type="text" class="search_box" id="search_box"
					placeholder="검색어를 입력해주세요." required>
				<!-- 검색결과 페이지 이동 -->
				<button class="search_btn">
					<img src="resources/image/search.png" alt="돋보기 이미지"
						style="width: 40px; height: 40px;">
				</button>
			</div>
		</div>
		<div class="recent_searches">
			<p class="recent_searches_title">최근 검색어</p>
			<div class="recent_searches_text">
				<c:choose>
					<c:when test="${empty memberSearchArr}">
						<div class="recent_searches_result_n">
							<p>최근검색어가 없습니다.</p>
						</div>
					</c:when>
					<c:otherwise>
						<div class="recent_searches_result">
							<c:forEach var="searching" items="${memberSearchArr}">
								<div class="searches_result_div">
									<div id="search-words${searching.searchNo}">
										<a id="search-word">${searching.searchWord}</a> <a
											onclick="deleteSearchHistory(${searching.searchNo})">x</a>
									</div>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="popular_searches">
			<p class="recent_searches_title">인기 검색어</p>
			<div class="popular_searches_text">
				<c:choose>
					<c:when test="${empty popularSearchArr}">
						<div class="recent_searches_result_n">
							<p>인기검색어가 없습니다.</p>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="searching" items="${popularSearchArr}">
							<div class="search_row_div" style="background-color: aqua;">
								<div class="searche_row">
									<div onclick="searchPopularWord(${searching.searchWord})">
										<a href="#">${searching.rowNum}</a><a id="popular-search">${searching.searchWord}</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>

</html>
<script>
    window.onload = function() {
        document.querySelector('.search_btn').addEventListener('click', function() {
            location.href = '#';
        });
    
        document.getElementById('search_box').addEventListener('keydown', function(e) {
            if (e.key === 'Enter') {
                location.href = '#';
            }
        });
    };
</script>



