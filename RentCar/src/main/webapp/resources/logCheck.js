function loginCheck(htmlForm) {
	let url = "login.jsp?&";

	const id = document.getElementById("id").value;
	const pw = document.getElementById("pw").value;

	let check = true;

	if (id !== "") {
		url += "&id=" + id;
	}

	if (pw !== "") {
		url += "&pw=" + pw;
	}

	if (id == "") {
		alert('아이디를 입력해주세요');
		check = false;
	}

	else if (pw == "") {
		alert('비밀번호를 입력해주세요');
		check = false;
	}

	if (check === false) {
		location.href = url;
	}

	else {
		htmlForm.submit();
	}
}