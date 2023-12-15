// 좋아요 버튼
window.onload = function(){
	for (var i = 0; i <= 9999; i++) {
		var btn = document.getElementsByClassName("like")[i];

		btn.addEventListener('click', function() {
			this.classList.toggle('active');
		});
	}
}