<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="{ % static "css/base.css" % }">
<link rel="stylesheet" type="text/css" href="{ % block extrastyle % }{ % endblock % }">

<nav>
	<div class="nav_parent_div">
		<div class="nav_menu_left">
			<ul class="nav-menu-list">
				<li class="lnb-category-expansion"><a
					onclick="lnbCategoryClose()" class="menu_img"><img
						src="/resources/image/menu.png" alt="메뉴" style="width: 20px;"></a>
					<div class="lnb-category">
						<div class="lnb-category-a-div">
							<a href="/category.do?category=entire">전체</a> <a
								href="/category.do?category=Appliances">가전</a> <a
								href="/category.do?category=Clothes">의류</a> <a
								href="/category.do?category=Beauty">향수·뷰티</a> <a
								href="/category.do?category=Food">푸드</a> <a
								href="/category.do?category=Jewelry">주얼리</a> <a
								href="/category.do?category=Christmas"
								class="Christmas_menu_text">크리스마스</a>
						</div>
					</div></li>
				<li><a href="/form/home.do" class="menu_text">홈</a></li>
				<li><a href="/menu.do?menu=proceeding" class="menu_text">진행중인
						프로젝트</a></li>
				<li><a href="/menu.do?menu=complete" class="menu_text">달성완료
						프로젝트</a></li>
				<li><a href="/menu.do?menu=popularity" class="menu_text">인기
						프로젝트</a></li>
				<li><a href="/menu.do?menu=noteworthy" class="menu_text">주목할 만한
						프로젝트</a></li>
			</ul>

		</div>

		<div class="nav_menu_right">


			<c:if test="${empty sessionScope.memberNo}">
				<div class="nav_menu_right_hover">
					<a href="/form/loginform.do"><img src="/resources/image/id.png"
						alt=""> <span class="subtext">마이페이지</span> </a>
				</div>
				<div class="nav_menu_right_hover">
					<a href="/form/loginform.do"><img
						src="/resources/image/project.png" alt=""> <span
						class="subtext">프로젝트 등록</span> </a>
				</div>
				<div class="nav_menu_right_hover">
					<a onclick="getSearchForm()"><img
						src="/resources/image/search.png" alt=""> <span
						class="subtext">검색</span> </a>
				</div>
			</c:if>

			<c:if test="${not empty sessionScope.memberNo}">
				<c:if test="${sessionScope.memberType == 1}">

					<div class="nav_menu_right_hover">

						<a href="/myPage.do?cpage=1"><img src="/resources/image/id.png"
							alt=""> <span class="subtext">마이페이지</span> </a>
					</div>
					<div class="nav_menu_right_hover">
						<a href="/form/projectEnrollForm.do"><img
							src="/resources/image/project.png" alt=""> <span
							class="subtext">프로젝트 등록</span> </a>
					</div>
					<div class="nav_menu_right_hover">
						<a onclick="getSearchForm()"><img
							src="/resources/image/search.png" alt=""> <span
							class="subtext">검색</span> </a>
					</div>
				</c:if>

				<c:if test="${sessionScope.memberType == 0}">

					<div class="nav_menu_right_hover">
						<a href="/administratorOk.do?cpage=1""><img

							src="/resources/image/project.png" alt=""> <span
							class="subtext">프로젝트 관리</span> </a>
					</div>
					<div class="nav_menu_right_hover">
						<a onclick="getSearchForm()"><img
							src="/resources/image/search.png" alt=""> <span
							class="subtext">검색</span> </a>
					</div>
				</c:if>
			</c:if>



		</div>

	</div>
</nav>

<script src="/resources/js/common/nav.js"></script>
<script
	src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function getSearchForm() {
		window.location.href = "/searchForm.do?status=select";
	}
	function googleTranslateElementInit() {
		new google.translate.TranslateElement({
			pageLanguage : 'ko',
			autoDisplay : true
		}, 'google_translate_element');
	}

	document.querySelector('.translation-links').addEventListener('change',
			function(event) {
				const tolang = event.target.value;
				const gtcombo = document.querySelector('.goog-te-combo');
				if (gtcombo == null) {
					alert("Error: Could not find Google translate Combolist.");
					return false;
				}
				gtcombo.value = tolang;
				gtcombo.dispatchEvent(new Event('change'));
			});
	document.querySelector('.menu_img').addEventListener('mouseover', function() {
	    document.querySelector('.Christmas_menu_text').style.color = 'red';
	});
</script>

