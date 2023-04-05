function checkBookingValues(htmlForm) {
	let url = "booking?";

	const type = document.getElementById("type").value;
	const bookingDate = document.getElementById("bookingDate").value;
	const bookingTime = document.getElementById("bookingTime").value;
	const rentDay = document.getElementById("rentDay").value;
	const rentHour = document.getElementById("rentHour").value;

	let check = true;

	if (bookingDate !== "") {
		url += "&bookingDate=" + bookingDate;
	}

	if (bookingTime !== "") {
		url += "&bookingTime=" + bookingTime;
	}

	if (type !== "") {
		url += "&type=" + type;
	}

	if (bookingDate == "") {
		alert('이용 시작일이 입력되지 않았습니다');
		check = false;
	}

	else if (bookingTime == "") {
		alert('이용 시간이 입력되지 않았습니다');
		check = false;
	}

	else if (rentDay == "" && rentHour == "") {
		alert('이용 시간이 입력되지 않았습니다');
		check = false;
	}

	else if (type == "S" && rentDay != "") {
		alert('단기 렌트는 이용 시간만 기재 가능합니다');
		check = false;
	}

	else if (type == "L" && rentHour != "") {
		alert('장기 렌트는 이용 일수만 기재 가능합니다');
		check = false;
	}

	if (check === false) {
		location.href = url;
	}

	else {
		htmlForm.submit();
	}
}