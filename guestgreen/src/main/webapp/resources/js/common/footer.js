const items = document.querySelectorAll('.question');

function openCloseAnswer() {
	const answerId = this.id.replace('que', 'ans');
	const answerElement = document.getElementById(answerId);

	if (answerElement.style.display === 'block') {
		answerElement.style.display = 'none';
		document.getElementById(this.id + '-toggle').textContent = '+';
	} else {
		answerElement.style.display = 'block';
		document.getElementById(this.id + '-toggle').textContent = '-';
		answerElement.scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'nearest' });
	}
}

items.forEach(item => item.addEventListener('click', openCloseAnswer));




var target = document.querySelectorAll('.btn_open');
var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
var targetID;

// 팝업 열기
for (var i = 0; i < target.length; i++) {
	target[i].addEventListener('click', function() {
		targetID = this.getAttribute('href');
		document.querySelector(targetID).style.display = 'block';
	});
}

// 팝업 닫기
for (var j = 0; j < target.length; j++) {
	btnPopClose[j].addEventListener('click', function() {
		this.parentNode.parentNode.style.display = 'none';
	});
}
