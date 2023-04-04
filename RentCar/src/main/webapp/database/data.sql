CREATE TABLE Vehicle (
vehicle_id CHAR(10) PRIMARY KEY,
vehicle_name VARCHAR(40) NOT NULL,
vehicle_location VARCHAR(40) NOT NULL,
price_per_day INT NOT NULL,
price_per_hour INT NOT NULL
);

CREATE TABLE Client (
client_id VARCHAR(20) PRIMARY KEY,
client_pw VARCHAR(20) NOT NULL,
client_name VARCHAR(20) NOTC NULL,
regist_date TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE Board (
board_num INT PRIMARY KEY,
board_type VARCHAR(10) NOT NULL,
client_id VARCHAR(20) NOT NULL,
publish_date TIMESTAMP DEFAULT current_timestamp,
modify_date DATE,
title VARCHAR(100) NOT NULL,
content VARCHAR(400) NOT NULL,
FOREIGN KEY(client_id) references Client(client_id)
);

CREATE TABLE Booking (
booking_num INT PRIMARY KEY,
booking_type CHAR(1) NOT NULL,
vehicle_id CHAR(10) NOT NULL,
client_id VARCHAR(20) NOT NULL,
booking_approval_time TIMESTAMP DEFAULT current_timestamp,
booking_time DATE NOT NULL,
rent_day INT,
rent_hour INT,
payment INT NOT NULL
FOREIGN KEY(client_id) references Client(client_id),
FOREIGN KEY(vehicle_id) references Vehicle(vehicle_id)
);