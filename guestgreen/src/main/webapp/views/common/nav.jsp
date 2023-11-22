<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav>
	<div class="nav-menu">
		<div>
			<ul class="nav-menu-list">
				<li class="lnb-category-expansion">
				 <a onclick="lnbCategoryClose()">메뉴</a> 
					<div class="lnb-category">
						<a href="#">카테고리1</a> 
						<a href="#">카테고리2</a> 
						<a href="#">카테고리3</a>
						<a href="#">카테고리4</a> 
						<a href="#">카테고리4</a>
					</div>
				</li>
				<li><a href="/form/homeform.do">홈</a></li>
				<li><a href="#">진행중인 프로젝트</a></li>
				<li><a href="#">공개예정 프로젝트</a></li>
				<li><a href="/boardList.do?cpage=1">공지사항</a></li>
			</ul>
		</div>
	</div>
</nav>

 <script src="/resources/js/common/nav.js"></script>