
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


function checkShipping() {
	let data = {
		t_code: document.getElementById("t_code").value,
		t_invoice: document.getElementById("t_invoice").value,
		t_key: document.getElementById("t_key").value
	}
	axios.post("https://info.sweettracker.co.kr/api/v1/trackingInfo", data, {
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
		},
	})
		.then(function(response) {
			console.log(response);
			response.data.status,
				response.data.msg,
				response.data.firstDetail,
				response.data.invoiceNo,
				response.data.itemName
		})
		.catch(function(error) {
			console.log("api로 데이터 전송 실패");
		});
}
