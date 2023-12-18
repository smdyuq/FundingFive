function projectDetail(projectNo) {
	
	console.log("sadasd");
   const pageUrl = '/projectAdministrator.do?projectNo=' + projectNo;
   window.location.href = pageUrl;
}

function yesButton() {
   const form = document.getElementById("project-administratorok-form");

   form.action = "/projectUpdate.do";
   form.method = "post";
   form.submit();
}

function noButton() {
    var form = document.getElementById("project-administratorok-form");
    var message = prompt("거절 사유를 입력해주세요.");

    if (message != null) {
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'reason';
        input.value = message;
        form.appendChild(input);

        form.action = "/projectDelete.do";
        form.method = "post";
        form.submit();
    }

}

 
// 좌측 메뉴
/*function showContent(id) {
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
}*/

function showProject(menu){
	const pageUrl = "/administratorOk.do?menu="+menu+"&cpage=1";
	window.location.href = pageUrl;
}

/*document.addEventListener('DOMContentLoaded', function () {
    // 페이지 로드 시 '프로젝트 승인 목록' 메뉴의 내용을 보여줌
    showContent('project_approval');
});*/


	//출고 성사된 프로젝트
	function successfulProject(){
		let formId = document.getElementById("project-success");
		formId.action = "/expiredProject.do";
		formId.method="post";
		formId.submit();
	}
	//출고 실패한 프로젝트
	function failedProject(){
		let formId = document.getElementById("project-fail");
		formId.action = "/expiredProject.do";
		formId.method="post";
		formId.submit();
	}
