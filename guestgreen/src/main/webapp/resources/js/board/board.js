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
