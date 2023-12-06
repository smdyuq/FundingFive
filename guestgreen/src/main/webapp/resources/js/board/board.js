//페이지 상세보기
function detailPage(idx){
	const pageUrl = '/boardDetail.do?idx=' + idx;
	window.location.href = pageUrl;
}
/*//게시글 등록
function boardEnroll(){
	const form = document.getElementById("post-form");
	
	form.action = "/boardEnroll.do";
	form.method = "post";
	form.submit();
}*/
//게시글 삭제
function boardDelete(){
	const form = document.getElementById("detail-form");
	
	form.action = "/boardDelete.do";
	form.method = "post";
	form.submit();
}
//수정 페이지 이동
function boardUpdateCheck(idx){
	const pageUrl = '/boardUpdateCheck.do?idx=' + idx;
	window.location.href = pageUrl;
}
//수정 페이지 - 취소 버튼
function back(idx){
	const pageUrl = '/boardDetail.do?idx=' + idx;
	window.location.href = pageUrl;
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
        document.querySelector('.menu[onclick="showContent(\'' + id + '\')"]').classList.add('active');
    }

    window.onload = function () {
        // 페이지 로드 시 '공지사항' 메뉴의 내용을 보여줌
        showContent('notice');

        var faqItems = document.querySelectorAll('.faq-item');

        faqItems.forEach(function (item) {
            var title = item.querySelector('.faq-title');
            var content = item.querySelector('.faq-content');

            title.addEventListener('click', function () {
                var display = content.style.display;
                content.style.display = (display === 'block') ? 'none' : 'block';

            });

            

        });
    };