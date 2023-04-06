function checkValues(htmlForm) {

	const boardNum = document.getElementById("boardNum").value;
	const boardType = document.getElementById("boardType").value;
	const title = document.getElementById("title").value;
	const content = document.getElementById("content").value;

	let url = "write?&boardNum="+boardNum;
	let check = true;

	if (boardType !== "") {
		url += "&boardType=" + boardType;
	}

	if (title !== "") {
		url += "&title=" + title;
	}
	
	if (content !== "") {
		url += "&content=" + content;
	}

	if (title == "") {
		alert('제목을 입력하세요');
		check = false;
	}

	else if (content == "") {
		alert('내용을 입력하세요');
		check = false;
	}

	if (check === false) {
		location.href = url;
	}

	else {
		htmlForm.submit();
	}
}