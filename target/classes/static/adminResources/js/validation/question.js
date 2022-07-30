function getQuestion(){
	
	const id = $("#streamTypeId").val();
	
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText);

			$("#examQuestion").val(jsn.examQuestion);
			console.log(jsn);
		}
	}

	htp.open("get", "getexambyStream?id=" + id, true);
	htp.send();
	
}