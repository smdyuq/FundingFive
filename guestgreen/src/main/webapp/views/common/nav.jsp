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
						<a href="/category.do?category=entire">전체</a> <a
							href="/category.do?category=Appliances">가전</a> <a
							href="/category.do?category=Clothes">의류</a> <a
							href="/category.do?category=Beauty">향수·뷰티</a> <a
							href="/category.do?category=Food">푸드</a> <a
							href="/category.do?category=Jewelry">주얼리</a>
						<a	href="/category.do?category=Christmas">크리스마스</a>
					</div></li>
				<li><a href="/form/home.do" class="menu_text">홈</a></li>
				<li><a href="/menu.do?menu=proceeding" class="menu_text">진행중인
						프로젝트</a></li>
				<li><a href="/menu.do?menu=complete" class="menu_text">달성완료
						프로젝트</a></li>
				<li><a href="/menu.do?menu=popularity" class="menu_text">인기
						프로젝트</a></li>
				<li><a href="/boardList.do?cpage=1">공지사항</a></li>
			</ul>

		<div onclick="getSearchForm()">
			<input type="text" name="searchText" placeholder="검색어를 입력해주세요.">
			<button type="button">검색</button>
		</div>
	</div>
	</div>
</nav>

<script src="/resources/js/common/nav.js"></script>
<script src="/resources/js/search/projectSearch.js"></script>
    <script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
    <script type="text/javascript">
        function googleTranslateElementInit() {
            new google.translate.TranslateElement({pageLanguage: 'ko', autoDisplay: true}, 'google_translate_element');
        }

        document.querySelector('.translation-links').addEventListener('change', function (event) {
            const tolang = event.target.value;
            const gtcombo = document.querySelector('.goog-te-combo');
            if (gtcombo == null) {
                alert("Error: Could not find Google translate Combolist.");
                return false;
            }
            gtcombo.value = tolang;
            gtcombo.dispatchEvent(new Event('change'));
        });
    </script>
