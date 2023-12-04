//top 버튼 

window.addEventListener('scroll', function() {
	var topButton = document.querySelector('.top-button');
	if (window.pageYOffset > 400) {
		topButton.style.display = "block";
	} else {
		topButton.style.display = "none";
	}
});



document.querySelector('.top-button').addEventListener('click', function() {
	window.scrollTo({ top: 0, behavior: 'smooth' }); // 화면 상단으로 부드럽게 스크롤되도록 설정
});



//구글 번역 

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