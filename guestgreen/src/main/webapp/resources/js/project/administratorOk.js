function projectDetail(projectNo) {
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
    
    
    // 탭이동 스크립트
    
	function showTabContent(tabId) {
		// 모든 탭 컨텐츠 숨김
		var tabContents = document.querySelectorAll('.tab_content');
		tabContents.forEach(function(content) {
			content.style.display = 'none';
		});

		// 선택한 탭 컨텐츠 표시
		var selectedTabContent = document.getElementById(tabId + '_content');
		if (selectedTabContent) {
			selectedTabContent.style.display = 'block';
		}
	}

	window.onload = function() {
		showTabContent('project_approval');
	};
