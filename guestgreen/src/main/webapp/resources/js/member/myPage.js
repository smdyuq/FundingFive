	function deleteBtn() {
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			let form = document.getElementById("update-form");
			form.action = "/memberDelete.do";
			form.submit();
		}
	}

	function showTabContent(tabId) {
		// 모든 탭 컨텐츠 숨김
		var tabContents = document.querySelectorAll('.tab_content');
		tabContents.forEach(function(content) {
			content.style.display = 'none';
		});

		// 선택한 탭 컨텐츠 표시
		var selectedTabContent = document.getElementById(tabId + '_content');
		if (selectedTabContent) {
			selectedTabContent.style.display = 'block';
		}
	}

	
// 좌측 메뉴
function showContent(id) {
	var sections = document.getElementsByClassName('content-section');
	for (var i = 0; i < sections.length; i++) {
		sections[i].style.display = 'none';
	}
	document.getElementById(id).style.display = 'block';

	var menus = document.getElementsByClassName('menu');
	for (var i = 0; i < menus.length; i++) {
		menus[i].classList.remove('active');
	}
	document.querySelector('.menu[onclick="showContent(\'' + id + '\')"]').classList
		.add('active');
}

window.onload = function() {
	
	const shippingApiKey = document.getElementById("t_key");
	shippingApiKey.value = config.shipping_api_key;
	showTabContent('information');
	
	// 페이지 로드 시 '공지사항' 메뉴의 내용을 보여줌
	showContent('information');

	var faqItems = document.querySelectorAll('.faq-item');

	faqItems.forEach(function(item) {
		var title = item.querySelector('.faq-title');
		var content = item.querySelector('.faq-content');

		title.addEventListener('click', function() {
			var display = content.style.display;
			content.style.display = (display === 'block') ? 'none'
				: 'block';

		});

	});
};
