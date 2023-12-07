<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav>
	<div class="nav-menu">
		<div>
			<ul class="nav-menu-list">
				<li class="lnb-category-expansion"><a
					onclick="lnbCategoryClose()" class="menu_img"><img
						src="/resources/image/menu.png" alt="메뉴" style="width: 20px;"></a>
					<div class="lnb-category">
						<a href="/views/category/category.jsp">카테고리1</a> <a href="#">카테고리2</a>
						<a href="#">카테고리3</a> <a href="#">카테고리4</a> <a href="#">카테고리4</a>
					</div></li>
				<li><a href="/form/home.do" class="menu_text">홈</a></li>
				<li><a href="#" class="menu_text">진행중인 프로젝트</a></li>
				<li><a href="#" class="menu_text">공개예정 프로젝트</a></li>
				<li><a href="/boardList.do?cpage=1">공지사항</a></li>
			</ul>
		</div>

		<div onclick="projectSearch()">
			<input type="text" name="searchText" placeholder="검색어를 입력해주세요.">
			<button type="button">검색</button>
		</div>
	</div>
</nav>

<script src="/resources/js/common/nav.js"></script>


