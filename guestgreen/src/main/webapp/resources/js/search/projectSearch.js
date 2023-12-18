

//function projectSearch(){

//	let searchWord = document.getElementById("search_box").value;
//	window.location.href = '/projectSearch.do?searchWord=' + searchWord;
//}

function deleteSearchHistory(searchNo) {
	$.ajax({
		type: "GET",
		url: "/searchForm.do",
		data: {
			searchNo: searchNo,
			status: 'delete'
		},
		success: function() {
			let searchWords = document.getElementById("search-words" + searchNo);
			searchWords.parentNode.removeChild(searchWords);
		},
		error: function() {
			alert('실패');
		}
	})
}

function searchSelectedWord(searchWord) {
	console.log('asdasdadsasdasd');
	window.location.href = '/projectSearch.do?searchWord=' + searchWord;
}

window.onload = function() {
	document.querySelector('.search_btn').addEventListener('click', function() {
		console.log("asd");
		let searchWord = document.getElementById("search_box").value;
		window.location.href = '/projectSearch.do?searchWord=' + searchWord;        
	});
	    
	document.getElementById('search_box').addEventListener('keydown', function(e) {
	    if (e.key === 'Enter') {
		console.log("bbb");
			let searchWord = document.getElementById("search_box").value;
			window.location.href = '/projectSearch.do?searchWord=' + searchWord;            
		}
	});

}