//top 버튼 
document.addEventListener("DOMContentLoaded", function() {
	document.querySelector('.top-button').addEventListener('click', function() {
		window.scrollTo({ top: 0, behavior: 'smooth' }); // 화면 상단으로 부드럽게 스크롤되도록 설정
	});
	window.addEventListener('scroll', function() {
		var topButton = document.querySelector('.top-button');
		if (window.pageYOffset > 400) {
			topButton.style.display = "block";
		} else {
			topButton.style.display = "none";
		}
	});
	document.querySelector('#kakao-talk-channel-chat-button').addEventListener('click', function() {
		Kakao.Channel.chat({ channelPublicId: '_HMxjGG' });
	});
});