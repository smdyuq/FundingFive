
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
	console.log("asdsds");
	const shippingApiKey = document.getElementById("t_key");
	console.log(shippingApiKey);
	
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
function openPopup(url, trackingNumber) {
  var tKey = document.getElementById('t_key').value;
  var tCode = document.getElementById('t_code').value;
  document.getElementById('popup-iframe').src = `${url}?t_key=${tKey}&t_code=${tCode}&t_invoice=${trackingNumber}`;
  document.getElementById('popup-modal').style.display = 'block';
}

function closePopup() {
  document.getElementById('popup-modal').style.display = 'none';
  document.getElementById('popup-iframe').src = '';
}