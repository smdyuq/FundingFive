	function deleteBtn() {
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			let form = document.getElementById("update-form");
			form.action = "/memberDelete.do";
			form.submit();
		}
	}

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
		showTabContent('information');
	};