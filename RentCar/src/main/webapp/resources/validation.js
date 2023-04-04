function checkValues(htmlForm) {
	let url = "regist.jsp?&";

	const custno = document.getElementById("custno").value;
	const custname = document.getElementById("custname").value;
	const phone = document.getElementById("phone").value;
	const address = document.getElementById("address").value;
	const joindate = document.getElementById("joindate").value;
	const grade = document.getElementById("grade").value;
	const city = document.getElementById("city").value;
	
	let check = true;

	if (custname !== "") {
		url += "custname=" + custname + "&"; //엔터
	}

	if (phone !== "") {
		url += "phone=" + phone + "&";
	}

	if (address !== "") {
		url += "address=" + address + "&";
	}

	if (joindate !== "") {
		url += "joindate=" + joindate + "&";
	}

	if (grade !== "") {
		url += "grade=" + grade + "&";
	}

	if (custname !== "") {
		url += "city=" + city;
	}

	// 항목에 값이 없으면 -> 페이지 유지
	// ㄴ 입력되지 않은 항목에 대해 alert() & regist.jsp 이동하면서 focus 넘기기
	// 모든 항목이 입력되어 있으면 -> submit


	if (custname == "") {
		alert('회원성명이 입력되지 않았습니다');
		check = false;
	}

	else if (phone == "") {
		alert('전화번호가 입력되지 않았습니다');
		check = false;
	}

	else if (address == "") {
		alert('주소가 입력되지 않았습니다');
		check = false;
	}

	else if (joindate == "") {
		alert('가입일자가 입력되지 않았습니다');
		check = false;
	}

	else if (grade == "") {
		alert('등급이 입력되지 않았습니다');
		check = false;
	}

	else if (city == "") {
		alert('지역코드가 입력되지 않았습니다');
		check = false;
	}

	if(check === false) {
		location.href=url;
	}
	
	else {
		htmlForm.submit();
	}
}