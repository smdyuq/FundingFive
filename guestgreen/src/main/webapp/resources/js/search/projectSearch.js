

function projectSearch(){
	let searchWord = document.getElementById("search_box").value;
	window.location.href = '/projectSearch.do?searchWord=' + searchWord;
}
