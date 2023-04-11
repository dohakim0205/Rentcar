INSERT INTO Vehicle VALUES('CAR001', '2023 마세라티 MC 첼로', '서울시 송파구 231-2', 100, 10);
INSERT INTO Vehicle VALUES('CAR002', '2024 쉐보레 트랙스 크로스오버', '서울시 강동구 223-3', 2000, 1);
INSERT INTO Vehicle VALUES('CAR003', '2023 폭스바겐 투아렉', '서울특별시 종로구 계동 102-1', 120, 50);
INSERT INTO Vehicle VALUES('CAR004', '2024 QM6', '서울특별시 성동구 성수동1가 668-79', 10000, 1000);
INSERT INTO Vehicle VALUES('CAR005', '2023 포드 레인저 랩터', '서울특별시 송파구 송파동 42', 22000, 4);
INSERT INTO Vehicle VALUES('CAR006', '2023 포드 레인저', '서울특별시 성동구 성수동1가 668-30', 37, 12);
INSERT INTO Vehicle VALUES('CAR007', '2023 볼보 EX90', '서울 종로구 북촌로4길 20', 17, 2);
INSERT INTO Vehicle VALUES('CAR008', '2023 볼보 XC60', '서울 서대문구 연희로15길 21', 254, 22);
INSERT INTO Vehicle VALUES('CAR009', '2024 쉐보레 트랙스 크로스오버', '서울 영등포구 국제금융로6길 33', 163, 33);
INSERT INTO Vehicle VALUES('CAR010', '2024 메르세데스-AMG GLA클래스', '서울 영등포구 선유로47길 16', 1243, 5);
INSERT INTO Vehicle VALUES('CAR011', '롯데월드 붕붕카', '서울 송파구 올림픽로 240', 33, 5);
INSERT INTO Vehicle VALUES('CAR012', '에버랜드 범퍼카', '경기 용인시 처인구 포곡읍 에버랜드로 199', 50, 7);

INSERT INTO Client (client_id, client_pw, client_name) VALUES('qwer1234', '1111', '김우동');
INSERT INTO Client (client_id, client_pw, client_name) VALUES('asdf1234', '2222', '강김밥');
INSERT INTO Client (client_id, client_pw, client_name) VALUES('zxcv1234', '3333', '박베이컨');
INSERT INTO Client (client_id, client_pw, client_name) VALUES('asdf5678', '4444', '진갈비');

INSERT INTO Board (board_num, board_type, client_id, title, content) VALUES(1, '문의', 'asdf1234', '붕붕카 가격 문의', '붕붕카가 왜 범퍼카보다 비싼가요?');

INSERT INTO Booking (booking_num, booking_type, vehicle_id, client_id, booking_time, rent_day, payment) VALUES(1, 'L', 'CAR001', 'asdf1234', date_format('2024-01-01 12:00', '%y-%m-%d %H:%i'), 10, 1000);
