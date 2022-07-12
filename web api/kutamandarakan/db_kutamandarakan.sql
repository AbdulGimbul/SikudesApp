-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2021 at 06:47 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kutamandarakan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_note`
--

CREATE TABLE `tabel_note` (
  `id` int(11) NOT NULL,
  `judul` varchar(30) NOT NULL,
  `deskripsi` text NOT NULL,
  `tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_note`
--

INSERT INTO `tabel_note` (`id`, `judul`, `deskripsi`, `tanggal`) VALUES
(2, 'Rapat PHBI', 'Persiapan tinggal logistik saja', '0000-00-00 00:00:00'),
(3, 'Musyawarah Dengan RT', 'Bahwa akan ada pengadaan kerja bakti', '0000-00-00 00:00:00'),
(4, 'Rapat Kecamatan', 'Penyegahan COVID di tiap desa', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_penduduk`
--

CREATE TABLE `tabel_penduduk` (
  `nik` bigint(16) NOT NULL,
  `no_kk` bigint(16) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jk` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `agama` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `pekerjaan` varchar(30) NOT NULL,
  `goldar` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_penduduk`
--

INSERT INTO `tabel_penduduk` (`nik`, `no_kk`, `nama`, `tempat_lahir`, `tgl_lahir`, `jk`, `alamat`, `agama`, `status`, `pekerjaan`, `goldar`) VALUES
(3208302909980000, 3208302909980000, 'Muhammad Alfan Alfarizi', 'Kuningan', '1998-09-29', 'Laki-laki', 'DUSUN I RT 01 RW 01', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'O'),
(3208301102970000, 3208301102970000, 'Mahmud Fauzi', 'Kuningan', '1997-11-02', 'Laki-laki', 'DUSUN I RT 01 RW 01', 'Islam', 'Menikah', 'Karyawan', 'A'),
(3208300903980000, 3208300903980000, 'Zamzam Bil Fadhli', 'Kuningan', '1998-09-03', 'Laki-laki', 'DUSUN I RT 01 RW 01', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'O'),
(3208301202950000, 3208201202950000, 'Deni Trianto', 'Kuningan', '1995-12-02', 'Laki-laki', 'DUSUN I RT 01 RW 01', 'Islam', 'Belum Nikah', 'Wiraswasta', 'AB'),
(3208302304990000, 3208302304990000, 'Ravi', 'Kuningan', '1999-04-23', 'Laki-laki', 'DUSUN I RT 01 RW 01', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'B'),
(3208302202010000, 3208302202010000, 'Tiara', 'Kuningan', '2001-02-22', 'Perempuan', 'DUSUN I RT 02 RW 01', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'A'),
(3208302911980000, 3208302911980000, 'Winda Sya\'banniah', 'Kuningan', '1998-11-29', 'Perempuan', 'DUSUN I RT 02 RW 01', 'Islam', 'Belum Nikah', 'Karyawan', 'AB'),
(3208300305970000, 3208300305970000, 'Sinta', 'Jakarta', '1997-03-05', 'Perempuan', 'DUSUN I RT 02 RW 01', 'Islam', 'Menikah', 'Ibu Rumah Tangga', 'A'),
(3208302606900000, 3208302606900000, 'Iin', 'Kuningan', '1990-06-26', 'Perempuan', 'DUSUN I RT 02 RW 01', 'Islam', 'Menikah', 'Ibu Rumah Tangga', 'AB'),
(3208301212980000, 3208301212980000, 'momoh', 'Kuningan', '1998-12-12', 'Perempuan', 'DUSUN I RT 02 RW 01', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'A'),
(3208302212990000, 3208302212990000, 'Yogi Iskandar', 'Kuningan', '1999-12-22', 'Laki-laki', 'DUSUN I RT 03 RW 01', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'O'),
(3208302312950000, 3208302312950000, 'Ikin Sodikin', 'Kuningan', '1995-12-23', 'Laki-laki', 'DUSUN I RT 03 RW 01', 'Islam', 'Menikah', 'Wiraswasta', 'O'),
(3208302811950000, 3208302811950000, 'Ika', 'Kuningan', '1995-11-28', 'Perempuan', 'DUSUN I RT 03 RW 01', 'Islam', 'Menikah', 'Ibu Rumah Tangga', 'O'),
(3208301010900000, 3208301010900000, 'Titin', 'Jakarta', '1990-10-10', 'Perempuan', 'DUSUN I RT 03 RW 01', 'Islam', 'Menikah', 'Ibu Rumah Tangga', 'A'),
(3208302404940000, 3208302404940000, 'Bambang Pamungkas', 'Jakarta', '1994-04-24', 'Laki-laki', 'DUSUN I RT 03 RW 01', 'Islam', 'Menikah', 'Wiraswasta', 'A'),
(3208301908980000, 3208301908980000, 'Silpia Agustina', 'Kuningan', '1998-08-19', 'Perempuan', 'DUSUN II RT 04 RW 02', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'O'),
(3208300808960000, 3208300808960000, 'Tuti', 'Kuningan', '1996-08-08', 'Perempuan', 'DUSUN II RT 05 RW 02', 'Islam', 'Menikah', 'Karyawan', 'O'),
(3208300205980000, 3208300205980000, 'Samsul', 'Kuningan', '1998-02-05', 'Laki-laki', 'DUSUN II RT 06 RW 02', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'O'),
(3208300803990000, 3208300803990000, 'Anida', 'Kuningan', '1999-08-03', 'Perempuan', 'DUSUN II RT 06 RW 02', 'Islam', 'Belum Nikah', 'Belum Bekerja', 'O'),
(111111111111111, 11111111111111, 'Abdul', 'Kuningan', '1998-07-20', 'Laki-laki', 'Desa Cikahuripan', 'Islam', 'androidx.appcompat.widget.AppC', 'Operator', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_struktural`
--

CREATE TABLE `tabel_struktural` (
  `nipd` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(35) NOT NULL,
  `pendidikan` varchar(35) NOT NULL,
  `tmt` date NOT NULL,
  `jk` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_struktural`
--

INSERT INTO `tabel_struktural` (`nipd`, `nama`, `jabatan`, `pendidikan`, `tmt`, `jk`) VALUES
(4, 'Sanen', 'Kepala Desa', 'SMA', '2017-10-05', 'Laki-laki'),
(5, 'Tatang', 'Sekertaris', 'SMA', '2016-02-16', 'Laki-laki'),
(6, 'Tedi Rustandi, SE', 'Kasi Pemerintahan', 'Sarjana', '2015-02-18', 'Laki-laki'),
(7, 'Nurhidayat', 'Kasi Ekbang', 'SMA', '2019-02-16', 'Laki-laki'),
(8, 'Mohammad Faisal', 'Kaur Umum', 'Diploma III', '2016-02-16', 'Laki-laki'),
(9, 'Iwan Setiawan, S.Pd', 'Kaur Keuangan', 'Sarjana', '2015-02-18', 'Laki-laki'),
(10, 'Diki Muhammad Rizki', 'Staf Keuangan', 'SMA', '2018-02-16', 'Laki-laki'),
(11, 'Ahim', 'KADUS I', 'SMA', '2018-02-16', 'Laki-laki'),
(12, 'Ujang Didi Cahyadi, SE', 'KADUS II', 'Sarjana', '2019-10-01', 'Laki-laki');

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `user_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`user_id`, `username`, `email`, `password`) VALUES
(1, 'Muhamad Abdul Aziz', 'azizgimboell@gmail.com', '0907'),
(2, 'aziz', 'aziz@gmail.com', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_note`
--
ALTER TABLE `tabel_note`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_struktural`
--
ALTER TABLE `tabel_struktural`
  ADD PRIMARY KEY (`nipd`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_note`
--
ALTER TABLE `tabel_note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tabel_struktural`
--
ALTER TABLE `tabel_struktural`
  MODIFY `nipd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
