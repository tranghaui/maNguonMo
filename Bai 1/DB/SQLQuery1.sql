USE MASTER
GO
IF(EXISTS(SELECT * FROM SYSDATABASES WHERE NAME='PMMNM_Bai1'))
	DROP DATABASE PMMNM_Bai1
GO
USE MASTER
GO

CREATE DATABASE PMMNM_Bai1
GO
USE PMMNM_Bai1
GO

go
create table LoaiSanPham (
	MaLoaiSP nchar(20) not null primary key,
	TenLoaiSP nvarchar(50) null
)
go

go
create table SanPham (
	MaSP nchar(20) not null primary key,
	TenSP nvarchar(50) null,
	NhaSanXuat nvarchar(50) null,
	MaLoaiSP nchar(20) not null,
	foreign key (MaLoaiSP) references LoaiSanPham(MaLoaiSP) 
)
go

insert into LoaiSanPham values ('L01', N'Sản phẩm loại 1'),
('L02', N'Sản phẩm loại 2'),
('L03', N'Sản phẩm loại 3')

insert into SanPham values('SP01', N'Sản phẩm 01', N'Nhà sản xuất 01', 'L01'),
('SP02', N'Sản phẩm 02', N'Nhà sản xuất 01', 'L01'),
('SP03', N'Sản phẩm 03', N'Nhà sản xuất 01', 'L02'),
('SP04', N'Sản phẩm 04', N'Nhà sản xuất 02', 'L02'),
('SP05', N'Sản phẩm 05', N'Nhà sản xuất 02', 'L03'),
('SP06', N'Sản phẩm 06', N'Nhà sản xuất 03', 'L03'),
('SP07', N'Sản phẩm 07', N'Nhà sản xuất 04', 'L02')

select * from LoaiSanPham

select * from SanPham

select * from LoaiSanPham inner join SanPham on LoaiSanPham.MaLoaiSP = SanPham.MaLoaiSP
