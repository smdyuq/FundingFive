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

function searchSelectedrWord(searchWord){
	window.location.href = '/projectSearch.do?searchWord=' + searchWord;
}

   window.onload = function() {
        document.querySelector('.search_btn').addEventListener('click', function() {
            location.href = 'projectSearch()';
        });
    
        document.getElementById('search_box').addEventListener('keydown', function(e) {
            if (e.key === 'Enter') {
                location.href = 'projectSearch()';
            }
        });
    };








