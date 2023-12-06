<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<nav>
		<div class="nav-menu">
			<div>
				<ul class="nav-menu-list">
					<li class="lnb-category-expansion"><a onclick="lnbCategoryClose()" class="menu_img"><img
								src="/resources/image/menu.png" alt="메뉴" style="width: 20px;"></a>
						<div class="lnb-category">
							<a href="/views/category/category.jsp">카테고리1</a> <a href="#">카테고리2</a> <a href="#">카테고리3</a>
							<a href="#">카테고리4</a> <a href="#">카테고리4</a>
						</div>
					</li>
					<li><a href="/form/home.do" class="menu_text">홈</a></li>
					<li><a href="#" class="menu_text">진행중인 프로젝트</a></li>
					<li><a href="#" class="menu_text">공개예정 프로젝트</a></li>
					<li><a href="/boardList.do?cpage=1">공지사항</a></li>
				</ul>
					<!-- 번역기 -->
					    <style type="text/css">
        body { position: static !important; top:0px !important; }	
        iframe.goog-te-banner-frame { display: none !important; }
        .skiptranslate > iframe { display: none !important; }
        .goog-logo-link { display:none !important; } 
        .goog-te-gadget { color: transparent !important; overflow: hidden;} 
        .goog-te-balloon-frame{display: none !important;} 
        .goog-tooltip {display: none !important;}
        .goog-tooltip:hover {display: none !important;}
        .goog-text-highlight {background-color: transparent !important; border: none !important; box-shadow: none !important;}
      .VIpgJd-ZVi9od-l4eHX-hSRGPd{ display: none;}
    </style>

 <div id="google_translate_element" style="display:none;"></div>
    <select class="translation-links">
        <option value="ko" data-lang="ko">한국어</option>
        <option value="en" data-lang="en">영어</option>
        <option value="ja" data-lang="ja">일본어</option>
    </select>
					<!-- /번역기 -->
			</div>

		<div onclick="projectSearch()">
			<input type="text" name="searchText" placeholder="검색어를 입력해주세요.">
			<button type="button"> 검색</button>
		</div>	
	</div>
</nav>

<script src="/resources/js/common/nav.js"></script>
<!-- 번역기 -->
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
<!-- /번역기 -->