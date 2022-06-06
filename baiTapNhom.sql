CREATE TABLE KhachHang(
  tenTaiKhoan nvarchar(100) PRIMARY KEY,
  hoTen nvarchar(50) NOT NULL,
  soDienThoai nvarchar(10) NOT NULL,
  email nvarchar(100) NOT NULL,
  phai BIT NOT NULL,
  matKhau nvarchar(100) NOT NULL
)

INSERT INTO KhachHang VALUES 
(
  'LeeTrongjNghiax', 
  N'Lê Trọng Nghĩa', 
  N'0938225745', 
  N'leetrongjnghiax0938225745@gmail.com', 
  1, 
  '1234567890'
)
INSERT INTO KhachHang VALUES 
(
  'LeeTrongjNghiax2', 
  N'Lê Trọng Nghĩa', 
  N'0938225745', 
  N'leetrongjnghiax0938225745@gmail.com', 
  0, 
  '1234567890'
)

Insert into KhachHang values ('bonefries','Maria Anders','0391387320','ngocthien.dinh26@gmail.com',1,'diem10LTHSK')
Insert into KhachHang values ('hearteggplant','Alfreds Futterkiste','0352608969 ','liam_windler45@yahoo.com',0,'khongbiet')
Insert into KhachHang values ('eyebrowtriumph','Maria Larsson','0973052011','ella_james@gmail.com',1,'maimaiyeuem')
Insert into KhachHang values ('cordshark','Sales Representative','0999951781','tahlia.watson71@yahoo.com',0,'toilatoi')
Insert into KhachHang values ('irissunflower','Janete Limeira','0959839683','molly.turcotte19@yahoo.com',1,'ductlifter')
Insert into KhachHang values ('medullavulcan','Michael Holz','0859999321','taylor.thomas@gmail.com',1,'maimaiyeungan')
Insert into KhachHang values ('molarsmiley','Jose Pavarotti','0962838936','liam_windler45@yahoo.com',0,'quanvippro')
Insert into KhachHang values ('tissuefrowning','Jytte Petersen','0933340137','aaron_mccullough@gmail.com',1,'quanvippro123')
Insert into KhachHang values ('ulnaanger','Horst Kloss','0985985380','toby_lowe@hotmail.com',0,'quanvipno1')
Insert into KhachHang values ('metatarsalcop','Rene Phillips','0956044560','violet_hamilton@yahoo.com',1,'quanhayquan')

SELECT TOP (1000) [tenTaiKhoan]
      ,[hoTen]
      ,[soDienThoai]
      ,[email]
      ,[phai]
      ,[matKhau]
  FROM [QuanLyThongTinDuLich].[dbo].[KhachHang]

DROP TABLE KhachHang

-- DELETE FROM KhachHang

---------------------------------------------------------------------------------

CREATE TABLE NhanVien(
  ma nvarchar(10) PRIMARY KEY,
  hoTen nvarchar(50) NOT NULL,
  soDienThoai nvarchar(10) NOT NULL,
  email nvarchar(100) NOT NULL,
  phai BIT NOT NULL,
  matKhau nvarchar(100) NOT NULL
)

INSERT INTO NhanVien 
VALUES (
  'NV001', 
  N'Nguyễn Nhật Ánh', 
  N'0946245725', 
  N'nguyennhatanh@gmail.com', 
  1, 
  '1234567890'
)

Insert into NhanVien values ('NV121',N'Mai Khắc Triệu','0956044560','ciara2@gmail.com',1,'zxcvbnm')
Insert into NhanVien values ('NV123',N'Vĩnh Bình Quân','0985985426','ernestina96@gmail.com',1,'hanoiyeudau')
Insert into NhanVien values ('NV124',N'Nguyễn Huy Tường','0962838019','maximillia_rippin40@hotmail.com',1,'quanhayquan')
Insert into NhanVien values ('NV125',N'Thái Thanh Quang','0933340162','julia_roob@yahoo.com',1,'quanvippro')
Insert into NhanVien values ('NV126',N'Giang Chiêu Phong','0899951781','blgb00b123@gmail.com',1,'diem10LTHSK')
Insert into NhanVien values ('NV127',N'Nguyễn Nhật Ánh','0956044592','francisca_collins@gmail.com',0,'quanvipno1')
Insert into NhanVien values ('NV128',N'Lưu Hồng Khuê','0762838936','batmatlosefather@gmail.com',0,'mothaiba')
Insert into NhanVien values ('NV129',N'Ngô Thanh Hồng','0956044576','iamdogtor@yahoo.com',0,'motbahai')
Insert into NhanVien values ('NV130',N'Quyền Thiên Hương','0933340125','nghiadeptrai@gmail.com',0,'haimotba')
Insert into NhanVien values ('NV122',N'Ngô Thanh Hồng','0933401389','quannghiaquanvippro123@gmail.com',0,'motmotba')

DELETE FROM NhanVien WHERE ma='NV001'

SELECT TOP (1000) [ma]
      ,[hoTen]
      ,[soDienThoai]
      ,[email]
      ,[phai]
      ,[matKhau]
  FROM [QuanLyThongTinDuLich].[dbo].[NhanVien]

DROP TABLE NhanVien

---------------------------------------------------------------------------------

CREATE TABLE Tuyen(
  maTuyen NVARCHAR(10) PRIMARY KEY,
  tenTuyen NVARCHAR(100) NOT NULL,
  moTa NVARCHAR(1000) NOT NULL,
  ngayKhoiHanh DATE NOT NULL,
  ngayKetThuc DATE NOT NULL,
  gia MONEY NOT NULL,
  soNguoiThamGiaToiDa INT NOT NULL, 
  maNhanVien NVARCHAR(10) REFERENCES NhanVien(ma)
)

Insert into Tuyen values('T001',N'Sài Gòn-Đà Nẵng',N'Hướng về Đà Nẵng', CONVERT(date, '01-05-2022', 105), CONVERT(date, '08-05-2022', 105) ,10000000,40, 'NV121')
Insert into Tuyen values('T002',N'Sài Gòn-Đà Lạt',N'Hướng về Đà Lạt',CONVERT(date, '22-05-2022', 105),CONVERT(date, '25-05-2022', 105),12000000,40, 'NV122')
Insert into Tuyen values('T003',N'Sài Gòn-Nha Trang',N'Hướng về Nha Trang',CONVERT(date, '30-05-2022', 105),CONVERT(date, '03-06-2022', 105),8000000,40, 'NV123')
Insert into Tuyen values('T004',N'Sài Gòn-Hà Nội',N'Hướng về Hà Nội',CONVERT(date, '01-06-2022', 105),CONVERT(date, '07-06-2022', 105),11000000,20, 'NV124')
Insert into Tuyen values('T005',N'Sài Gòn-Rạch Giá',N'Hướng về Rạch Giá',CONVERT(date, '09-06-2022', 105),CONVERT(date, '14-06-2022', 105),14000000,40, 'NV125')
Insert into Tuyen values('T006',N'Sài Gòn-Châu Đốc',N'Hướng về Châu Đốc',CONVERT(date, '07-05-2022', 105),CONVERT(date, '09-05-2022', 105),1200000,20, 'NV126')
Insert into Tuyen values('T007',N'Sài Gòn-Cà Mau',N'Hướng về Cà Mau',CONVERT(date, '09-05-2022', 105),CONVERT(date, '09-05-2022', 105),2000000,40, 'NV127')
Insert into Tuyen values('T008',N'Sài Gòn-Phan Thiết',N'Hướng về Phan Thiết',CONVERT(date, '01-06-2022', 105),CONVERT(date, '03-06-2022', 105),5000000,40, 'NV128')
Insert into Tuyen values('T009',N'Sài Gòn-Vũng Tàu',N'Hướng về Vũng Tàu',CONVERT(date, '01-06-2022', 105),CONVERT(date, '09-06-2022', 105),900000,40, 'NV129')
Insert into Tuyen values('T010',N'Sài Gòn-Bến Tre',N'Hướng về Bến Tre',CONVERT(date, '07-05-2022', 105),CONVERT(date, '08-05-2022', 105),4000000,40, 'NV121')

DELETE FROM Tuyen

SELECT TOP (1000) [maTuyen]
      ,[tenTuyen]
      ,[moTa]
      ,[ngayKhoiHanh]
      ,[ngayKetThuc]
      ,[gia]
      ,[soNguoiThamGiaToiDa]
  FROM [QuanLyThongTinDuLich].[dbo].[Tuyen]

SELECT * FROM Tuyen AS T JOIN DiaDiemDuLich AS D ON T.maTuyen = D.maTuyen
SELECT D.maDiaDiem, D.tenDiaDiem, D.diaChi, D.dacTrung FROM Tuyen AS T JOIN DiaDiemDuLich AS D ON T.maTuyen=D.maTuyen  WHERE T.maTuyen='T001'

DROP TABLE Tuyen

---------------------------------------------------------------------------------

CREATE TABLE DiaDiemDuLich(
  maDiaDiem NVARCHAR(10) PRIMARY KEY,
  tenDiaDiem NVARCHAR(100) NOT NULL,
  diaChi NVARCHAR(100) NOT NULL,
  dacTrung NVARCHAR(100) NULL,
  maTuyen NVARCHAR(10) FOREIGN KEY REFERENCES Tuyen(maTuyen)
)

Insert into DiaDiemDuLich values ('DDDL001',N'Đà Nẵng',N'Thành phố Đà Nẵng',N'Biển','T001')
Insert into DiaDiemDuLich values ('DDDL002',N'Đà Lạt',N'Thành phố Đà Lạt',N'Thời tiết và Núi','T002')
Insert into DiaDiemDuLich values ('DDDL003',N'Nha Trang',N'Thành phố Nha Trang',N'Biển','T003')
Insert into DiaDiemDuLich values ('DDDL004',N'Hà Nội',N'Thủ đô Hà Nội',N'Kiến trúc','T004')
Insert into DiaDiemDuLich values ('DDDL005',N'Rạch Giá',N'Thành phố Rạch Giá',N'Núi','T005')
Insert into DiaDiemDuLich values ('DDDL006',N'Châu Đốc',N'Núi Sam',N'Chùa chiền,núi','T006')
Insert into DiaDiemDuLich values ('DDDL007',N'Cà Mau',N'Chợ nổi Cà Mau',N'Vùng sông nước','T007')
Insert into DiaDiemDuLich values ('DDDL008',N'Phan Thiết',N'Thành phố Phan Thiết',N'Biển','T008')
Insert into DiaDiemDuLich values ('DDDL009',N'Vũng Tàu',N'Thành phố Bà Rịa Vũng Tàu',N'Biển','T009')
Insert into DiaDiemDuLich values ('DDDL010',N'Bến Tre',N'Thành phố Bến Tre',N'Dừa','T010')
Insert into DiaDiemDuLich values ('DDDL011',N'Bến Tre2',N'Thành phố Bến Tre',N'Dừa','T010')

SELECT TOP (1000) [maDiaDiem]
      ,[tenDiaDiem]
      ,[diaChi]
      ,[dacTrung]
      ,[maTuyen]
  FROM [QuanLyThongTinDuLich].[dbo].[DiaDiemDuLich]

DROP TABLE DiaDiemDuLich

---------------------------------------------------------------------------------

CREATE TABLE ThongTinDatVe (
  soNguoiThamGia INT NOT NULL,
  hinhThucThanhToan NVARCHAR(100) NOT NULL,
  tenTaiKhoan NVARCHAR(100) REFERENCES KhachHang(tenTaiKhoan),
  maTuyen NVARCHAR(10) REFERENCES Tuyen(maTuyen)
)

SELECT TOP (1000) [soNguoiThamGia]
      ,[hinhThucThanhToan]
      ,[maKhachHang]
      ,[maTuyen]
  FROM [QuanLyThongTinDuLich].[dbo].[ThongTinDatVe]

DROP TABLE ThongTinDatVe

SELECT TTDV.soNguoiThamGia, T.soNguoiThamGiaToiDa FROM ThongTinDatVe AS TTDV
JOIN Tuyen AS T ON TTDV.maTuyen = T.maTuyen
