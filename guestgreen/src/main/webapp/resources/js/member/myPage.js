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

//운송장 팝업
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



//더보기 버튼 
window.onload = function() {
	var itemContainers = ['.item-container', '.item-container1', '.item-container2', '.item-container3'];
	var moreBtns = ['.moreBtn', '.moreBtn1', '.moreBtn2', '.moreBtn3'];

	itemContainers.forEach(function(container, index) {
		var items = document.querySelectorAll(container);
		for (var i = 0; i < items.length; i++) {
			if (i < 3) {
				items[i].style.display = 'block';
			} else {
				items[i].style.display = 'none';
			}
		}

		// 항목의 갯수가 3개 미만인 경우 '더보기' 버튼을 숨김 
		if (items.length <= 3) {
			var moreBtn = document.querySelector(moreBtns[index]);
			moreBtn.style.display = 'none';
		}
	});

	moreBtns.forEach(function(btnClass, index) {
		var btn = document.querySelector(btnClass);
		btn.addEventListener('click', function(event) {
			var btn = event.target;
			var container = btn.closest('.sponsorship_result_div');
			var items = container.querySelectorAll(itemContainers[index]);
			var hiddenItems = Array.from(items).filter(function(item) {
				return item.style.display === 'none';
			});

			if (btn.innerText === '더보기') {
				for (var j = 0; j < hiddenItems.length && j < 3; j++) {
					hiddenItems[j].style.display = 'block';
				}

				if (hiddenItems.length <= 3) {
					btn.innerText = '닫기';
				}
			} else {
				for (var j = 0; j < items.length; j++) {
					items[j].style.display = 'none';
				}

				for (var j = 0; j < items.length && j < 3; j++) {
					items[j].style.display = 'block';
				}

				btn.innerText = '더보기';
			}
		});
	});

	showContent('information'); //페이지 최초 진입 시, 내정보 메뉴 활성화 
};
