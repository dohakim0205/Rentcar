function checkValues(htmlForm) {
	let url = "regist.jsp?&";

	const id = document.getElementById("id").value;
	const pw = document.getElementById("pw").value;
	const name = document.getElementById("name").value;

	let check = true;

	if (id !== "") {
		url += "&id=" + id;
	}

	if (pw !== "") {
		url += "&pw=" + pw;
	}

	if (name !== "") {
		url += "&name=" + name;
	}

	if (id == "") {
		alert('회원성명이 입력되지 않았습니다');
		check = false;
	}

	else if (pw == "") {
		alert('비밀번호가 입력되지 않았습니다');
		check = false;
	}

	else if (name == "") {
		alert('이름이 입력되지 않았습니다');
		check = false;
	}

	if (check === false) {
		location.href = url;
	}

	else {
		htmlForm.submit();
	}
}