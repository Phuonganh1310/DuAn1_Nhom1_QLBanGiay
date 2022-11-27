﻿CREATE DATABASE DU_AN1
GO
USE DU_AN1
GO
-- ChucVu
CREATE TABLE ChucVu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) NOT NULL,
Ten NVARCHAR(50) NOT NULL
)
GO
--NhanVien
CREATE TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdCV UNIQUEIDENTIFIER,
MaNV VARCHAR(20) NOT NULL,
TenNV NVARCHAR(50) NOT NULL,
GioiTinh NVARCHAR(5) NOT NULL,
NgaySinh VARCHAR(20) NOT NULL,
DiaChi NVARCHAR(100) NOT NULL,
SDT VARCHAR(30) NOT NULL,
Email VARCHAR(50) NOT NULL,
Anh VARCHAR(100),
MatKhau VARCHAR(30) NOT NULL,
TrangThai INT DEFAULT 0
)
GO
-- KhachHang
CREATE TABLE KhachHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKH VARCHAR(20) NOT NULL,
TenKH NVARCHAR(50) NOT NULL,
NgaySinh VARCHAR(20) NOT NULL,
SDT VARCHAR(30) NOT NULL,
Email VARCHAR(50),
DiaChi NVARCHAR(50)
)
GO
--HoaDon
CREATE TABLE HoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
IdKM UNIQUEIDENTIFIER,
MaHD VARCHAR(20) NOT NULL,
NgayTao DATE NOT NULL,
NgayThanhToan DATE NOT NULL,
TrangThai INT DEFAULT 0
)
GO
--KhuyenMai
CREATE TABLE KhuyenMai(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKM VARCHAR(20) NOT NULL,
TenKM NVARCHAR(50) NOT NULL,
GiamGia VARCHAR(20) NOT NULL,
NgayBD VARCHAR(20) NOT NULL,
NgayKT VARCHAR(20) NOT NULL,
MoTa NVARCHAR(100)
)
GO
--SanPham
CREATE TABLE SanPham(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaSP VARCHAR(20) NOT NULL,
TenSP NVARCHAR(50) NOT NULL
)
GO
--Hang
CREATE TABLE Hang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaHang VARCHAR(20) NOT NULL,
TenHang NVARCHAR(50) NOT NULL
)
GO
--TheLoai
CREATE TABLE TheLoai(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaTL VARCHAR(20) NOT NULL,
TenTL NVARCHAR(50) NOT NULL
)
GO
--De
CREATE TABLE De(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaDe VARCHAR(20) NOT NULL,
TenDe NVARCHAR(50) NOT NULL,
ChatLieu NVARCHAR(50) NOT NULL,
DoCao VARCHAR(20) NOT NULL,
)
GO
--ChatLieu
CREATE TABLE ChatLieu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaCL VARCHAR(20) NOT NULL,
TenCL NVARCHAR(50) NOT NULL
)
GO
--MauSac
CREATE TABLE MauSac(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaMS VARCHAR(20) NOT NULL,
TenMS NVARCHAR(50) NOT NULL
)
GO
--KichCo
CREATE TABLE KichCo(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKC VARCHAR(20) NOT NULL,
TenKC NVARCHAR(50) NOT NULL
)
GO
--ChiTietSP
CREATE TABLE ChiTietSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdSanPham UNIQUEIDENTIFIER,
IdKichCo UNIQUEIDENTIFIER,
IdMauSac UNIQUEIDENTIFIER,
IdLoaiSP UNIQUEIDENTIFIER,
IdChatLieu UNIQUEIDENTIFIER,
IdHang UNIQUEIDENTIFIER,
IdDe UNIQUEIDENTIFIER,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
SoLuong INT NOT NULL,
BarCode VARCHAR(20),
MoTa NVARCHAR(50),
Anh VARCHAR(100),
TrangThai INT DEFAULT 0
)
GO
--HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
IdKM UNIQUEIDENTIFIER,
SoLuong INT NOT NULL,
DonGia DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_HoaDonCT PRIMARY KEY (IdHoaDon,IdChiTietSP),
CONSTRAINT PK1 FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id),
CONSTRAINT FK2 FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
CONSTRAINT FK3 FOREIGN KEY(IdKM) REFERENCES KhuyenMai(Id)
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - ChucVu
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)
--HoaDon - KhachHang
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
--HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id)
--HoaDon - KhuyenMai
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKM) REFERENCES KhuyenMai(Id)
--HoaDon - SanPham
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdSanPham) REFERENCES SanPham(Id)
--ChiTietSP - KichCo
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdKichCo) REFERENCES KichCo(Id)
--ChiTietSP - MauSac
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id)
--ChiTietSP - TheLoai
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdLoaiSP) REFERENCES TheLoai(Id)
--ChiTietSP - ChatLieu
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdChatLieu) REFERENCES ChatLieu(Id)
--ChiTietSP - Hang
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdHang) REFERENCES Hang(Id)
--ChiTietSP - De
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdDe) REFERENCES De(Id)


-- Tạo View cho login
Create view [login]
as 
 Select NhanVien.MaNV,NhanVien.TenNV, NhanVien.GioiTinh,NhanVien.Email,NhanVien.MatKhau, ChucVu.Ma,ChucVu.Ten from NhanVien left join ChucVu on NhanVien.IdCV = ChucVu.Id

 select*from [login]





