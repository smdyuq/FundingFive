function getSearchForm(){
	window.location.href = "/searchForm.do?status=select";
}

function projectSearch(){
	let searchWord = document.getElementById("search_box").value;
	window.location.href = '/projectSearch.do?searchWord=' + searchWord;
}

function deleteSearchHistory(searchNo){
	
	$.ajax({
		type: "GET",
		url: "/searchForm.do",
		data: {
			searchNo : searchNo,
			status : 'delete'
		},
		success: function(){
			let searchWords = document.getElementById("search-words"+searchNo);
			searchWords.style.display = "none";
		},
		error: function(){
			alert('실패');
		}
	})
	
}

function searchPopularWord(searchWord){
	window.location.href = '/searchPopularWord.do?searchWord=' + searchWord;
}

function seachRecentProject(searchWord){
	window.location.href = '/projectSearch.do?searchWord=' + searchWord;
}








