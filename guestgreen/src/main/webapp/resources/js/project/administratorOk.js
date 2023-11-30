function projectDetail(projectNo) {
	const pageUrl = '/projectDetail.do?projectNo=' + projectNo;
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