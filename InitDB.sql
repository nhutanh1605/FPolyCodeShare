--- Demo

use CodeShare

--- Insert Role

INSERT INTO dbo.role ([id], [name]) VALUES (N'487c52bf-a845-47a0-a4cf-4efb6b9501da', N'CENSOR')
INSERT INTO dbo.role ([id], [name]) VALUES (N'710ad7ca-34ce-44cc-b758-f45779eedc33', N'STUDENT')
INSERT INTO dbo.role ([id], [name]) VALUES (N'710ad7ca-34ce-44cc-b758-f45779eedc35', N'ADMIN')

--- Insert Major

INSERT INTO dbo.majors ([id], [name]) VALUES (N'27884680-685e-4355-b946-1545c8b57ecf', N'Lập trình Mobile')
INSERT INTO dbo.majors ([id], [name]) VALUES (N'ec52285f-c94a-4ef2-b916-ea412b692a25', N'Lập trình Web')
INSERT INTO dbo.majors ([id], [name]) VALUES (N'ec52285f-c94a-4ef2-b916-ea471b692a25', N'Lập trình máy tính')
INSERT INTO dbo.majors ([id], [name]) VALUES (N'a122ec02-78c4-4c98-8ba5-f55bae091b7e', N'Ứng dụng phần mềm')

--- Insert Tech

INSERT INTO dbo.techs ([id], [name]) VALUES (N'56228ca2-b849-490e-96aa-6aee9ed221b1', N'Spring Boot')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'f4ffad71-737b-4d1a-9fee-301ed9d797fa', N'Java')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'2840db9d-e2e1-4dbd-a9b7-37913c66a330', N'HTML/CSS')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'96c6044d-dc69-47f0-b735-0ad2f433420e', N'JavaScript')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'3c5175b3-0923-4e4e-bd8e-95d4ecef7800', N'Thymeleaf')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'a12e7c3c-aeb3-4524-a644-f3d2bc4c840a', N'AngularJS')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'158a108f-f22a-4825-8789-386c28fc0bbb', N'MySQL')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'9a13c137-6acf-4684-a81f-f81cf693173d', N'MS SQL Server')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'7ba9adad-435e-4f2a-8bdf-5acdba69b458', N'Bootstrap')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'3a059500-ad54-4ce9-8529-45a3fdc1368b', N'C/C++')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'd4538d6a-a121-4ed4-84e3-5a727d0cc778', N'C#')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'2c0f64ea-0f10-4dbf-b302-591bd6faa48d', N'JSP/Servlet')
INSERT INTO dbo.techs ([id], [name]) VALUES (N'3e2e6a32-e3a2-4ff8-b5b9-ea965844b518', N'Java Swing')

--- Insert User

---
INSERT INTO dbo.users ([id], [major_id], [avatar], [email], [fullname], [password], [username], [phone], [person_id]) 
VALUES (
	N'0CD0D881-CA41-473F-A4A8-1DEFA7874AE0', 
	N'a122ec02-78c4-4c98-8ba5-f55bae091b7e', 
	N'https://firebasestorage.googleapis.com/v0/b/shopping-11ad2.appspot.com/o/avatar%2Ff099d77d-6edd-44ee-90fe-edafee260433?alt=media&token=284dee93-a6d9-4de1-af3b-6ceea6a637c0', 
	N'thinhttps24687@fpt.edu.vn', 
	N'Trần Trung Thịnh',
	N'123456', 
	N'thinhttps24687',
	'0359668361',
	'ps24687'
)

INSERT INTO dbo.user_roles ([user_id], [role_id]) VALUES ('0CD0D881-CA41-473F-A4A8-1DEFA7874AE0', '710AD7CA-34CE-44CC-B758-F45779EEDC33')
---

---
INSERT INTO dbo.users ([id], [major_id], [avatar], [email], [fullname], [password], [username], [phone], [person_id]) 
VALUES (
	N'67f4c989-a197-498c-9eb2-802aead71531', 
	N'a122ec02-78c4-4c98-8ba5-f55bae091b7e', 
	N'https://firebasestorage.googleapis.com/v0/b/shopping-11ad2.appspot.com/o/avatar%2Ff099d77d-6edd-44ee-90fe-edafee260433?alt=media&token=284dee93-a6d9-4de1-af3b-6ceea6a637c0', 
	N'nhuhpps26083@fpt.edu.vn', 
	N'Hà Phương Như',
	N'123456', 
	N'nhuhpps26083',
	'0359228471',
	'ps26083'
)

INSERT INTO dbo.user_roles ([user_id], [role_id]) VALUES ('67f4c989-a197-498c-9eb2-802aead71531', '710AD7CA-34CE-44CC-B758-F45779EEDC33')
---

---
INSERT INTO dbo.users ([id], [major_id], [avatar], [email], [fullname], [password], [username], [phone], [person_id]) 
VALUES (
	N'9ec492e4-c1bb-4cdb-af43-99a2067905a1', 
	N'a122ec02-78c4-4c98-8ba5-f55bae091b7e', 
	N'https://firebasestorage.googleapis.com/v0/b/shopping-11ad2.appspot.com/o/avatar%2Ff099d77d-6edd-44ee-90fe-edafee260433?alt=media&token=284dee93-a6d9-4de1-af3b-6ceea6a637c0', 
	N'phuocntps10893@fe.edu.vn', 
	N'Nguyễn Thanh Phước',
	N'123456', 
	N'phuocntps10893',
	'0283740583',
	'ps10893'
)

INSERT INTO dbo.user_roles ([user_id], [role_id]) VALUES ('9ec492e4-c1bb-4cdb-af43-99a2067905a1', '487C52BF-A845-47A0-A4CF-4EFB6B9501DA')
---

---
INSERT INTO dbo.users ([id], [major_id], [avatar], [email], [fullname], [password], [username], [phone], [person_id]) 
VALUES (
	N'c0d94093-d168-44e7-9fe4-9f5d2ac7758d', 
	N'a122ec02-78c4-4c98-8ba5-f55bae091b7e', 
	N'https://firebasestorage.googleapis.com/v0/b/shopping-11ad2.appspot.com/o/avatar%2Ff099d77d-6edd-44ee-90fe-edafee260433?alt=media&token=284dee93-a6d9-4de1-af3b-6ceea6a637c0', 
	N'locthps10827@fe.edu.vn',
	N'Thân Hoàng Lộc',
	N'123456', 
	N'locthps10827',
	'0585283871',
	'ps10827'
)

INSERT INTO dbo.user_roles ([user_id], [role_id]) VALUES ('c0d94093-d168-44e7-9fe4-9f5d2ac7758d', '487C52BF-A845-47A0-A4CF-4EFB6B9501DA')
---

---
INSERT INTO dbo.users ([id], [major_id], [avatar], [email], [fullname], [password], [username], [phone], [person_id]) 
VALUES (
	N'0152ef9b-9fbc-4281-8481-b5ef3e61326d', 
	N'a122ec02-78c4-4c98-8ba5-f55bae091b7e', 
	N'https://firebasestorage.googleapis.com/v0/b/shopping-11ad2.appspot.com/o/avatar%2Ff099d77d-6edd-44ee-90fe-edafee260433?alt=media&token=284dee93-a6d9-4de1-af3b-6ceea6a637c0', 
	N'anhtnps24610@fpt.edu.vn',
	N'Trần Nhựt Anh',
	N'24610', 
	N'anhtnps24610',
	'0286472846',
	'ps24610'
)

INSERT INTO dbo.user_roles ([user_id], [role_id]) VALUES ('0152ef9b-9fbc-4281-8481-b5ef3e61326d', '710AD7CA-34CE-44CC-B758-F45779EEDC35')
---