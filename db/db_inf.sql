-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 06, 2023 at 01:31 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_inf`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_inf`
--

CREATE TABLE `tb_inf` (
  `id` int NOT NULL,
  `kode_pasien` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jen_kel` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `penyakit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_inf`
--

INSERT INTO `tb_inf` (`id`, `kode_pasien`, `nama`, `jen_kel`, `alamat`, `penyakit`) VALUES
(6, '12005', 'Andi', 'Laki - laki', 'Malang', 'Tipes'),
(8, '12008', 'Siti', 'Perempuan', 'Bekasi', 'Demam Berdarah'),
(9, '12309', 'Desi', 'Perempuan', 'Jakarta', 'Sakit Hati'),
(10, '12007', 'Peter', 'Laki - laki', 'Malang', 'Sakit gigi'),
(11, '12004', 'Parker', 'Perempuan', 'Palembang', 'Demam'),
(13, '12003', 'Harry', 'Laki - laki', 'Bogor', 'Sakit Hati');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_inf`
--
ALTER TABLE `tb_inf`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_inf`
--
ALTER TABLE `tb_inf`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
