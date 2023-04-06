function checkBookingValues(htmlForm) {
	let url = "booking?";

	const vehicleId = document.getElementById("vehicleId").value;
	const type = document.getElementById("type").value;
	const bookingDate = document.getElementById("bookingDate").value;
	const bookingTime = document.getElementById("bookingTime").value;
	const rentDay = document.getElementById("rentDay").value;
	const rentHour = document.getElementById("rentHour").value;

	let check = true;
	let today = new Date();
	let year = today.getFullYear();
	let month = today.getMonth() + 1;
	let day = today.getDate();

	const bookingYMD = bookingDate.split("-");
	const bYear = parseInt(bookingYMD[0]);
	const bMonth = parseInt(bookingYMD[1]);
	const bDay = parseInt(bookingYMD[2]);

	if (vehicleId !== "") {
		url += "&vehicleId=" + vehicleId;
	}

	if (bookingTime !== "") {
		url += "&bookingTime=" + bookingTime;
	}

	if (type !== "") {
		url += "&type=" + type;
	}

	if (type === "S" && rentHour !== "") {
		url += "&rentHour=" + rentHour;
	}

	if (type === "L" && rentDay !== "") {
		url += "&rentDay=" + rentDay;
	}

	if (bYear === year && bMonth === month && bDay > day || bYear === year && bMonth > month || bYear > year) {
		url += "&bookingDate=" + bookingDate;
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

	else if (!(bYear === year && bMonth === month && bDay > day || bYear === year && bMonth > month || bYear > year)) {
		alert('오늘 날짜 이후부터만 예약이 가능합니다');
		check = false;
	}

	if (check === false) {
		location.href = url;
	}

	else {
		htmlForm.submit();
	}
}