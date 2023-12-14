document.addEventListener('DOMContentLoaded', function() {
	var lnbMenu = document.querySelector('.lnb-category-expansion');
	var lnbCategory = document.querySelector('.lnb-category');

	lnbMenu.addEventListener('click', function(event) {
		event.stopPropagation();
		lnbCategoryToggle();
	});

	lnbMenu.addEventListener('mouseover', function() {
		lnbCategoryOpen();
	});

	lnbMenu.addEventListener('mouseout', function() {
		lnbCategoryClose();
	});

	document.addEventListener('click', function() {
		lnbCategoryClose();
	});

	function lnbCategoryToggle() {
		if (lnbCategory.style.display === 'block'
			|| lnbCategory.style.display === '') {
			lnbCategory.style.display = 'none';
		} else {
			lnbCategory.style.display = 'block';
		}
	}

	function lnbCategoryOpen() {
		lnbCategory.style.display = 'block';
	}

	function lnbCategoryClose() {
		lnbCategory.style.display = 'none';
	}
});

function projectDetail(projectNo) {
	const pageUrl = 'projectDetail.do?projectNo=' + projectNo;
	window.location.href = pageUrl;
}



function projectDonate(projectNo) {
	const pageUrl = '/getData.do?projectNo=' + projectNo;
	window.location.href = pageUrl;
}

function noteworthyProject() {
	const pageUrl = '/menu.do?menu=noteworthy';
	window.location.href = pageUrl;
}











