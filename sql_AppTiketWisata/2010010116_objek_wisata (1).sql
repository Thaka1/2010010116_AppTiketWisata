-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2023 at 10:43 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2010010116_objek_wisata`
--

-- --------------------------------------------------------

--
-- Table structure for table `agen`
--

CREATE TABLE `agen` (
  `kd_agen` varchar(50) NOT NULL,
  `nama_agen_travel` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `agen`
--

INSERT INTO `agen` (`kd_agen`, `nama_agen_travel`, `jenis_kelamin`, `alamat`, `no_telp`) VALUES
('KA01', 'Hafizh', 'Laki-laki', 'Jl.Permata', '085821238127'),
('KA02', 'Budi', 'Laki-laki', 'Jl.Pramuka', '080000000011'),
('KA03', 'Ratna', 'Perempuan', 'Jl.Melati', '080000000022'),
('KA04', 'Ahmad', 'Laki-Laki', 'Jl.Garuda', '080000000033'),
('KA05', 'Rara', 'Perempuan', 'Jl.Angsana', '080000000044');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `kd_penjualan` varchar(50) NOT NULL,
  `tanggal` varchar(50) NOT NULL,
  `kd_objek_wisata` varchar(50) NOT NULL,
  `jumlah_tiket_terjual` varchar(50) NOT NULL,
  `harga_tiket` varchar(50) NOT NULL,
  `total_penjualan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`kd_penjualan`, `tanggal`, `kd_objek_wisata`, `jumlah_tiket_terjual`, `harga_tiket`, `total_penjualan`) VALUES
('KD00-P1', '1-14-2023', 'KO01', '6', '45000', '270000'),
('KD00-P2', '1-15-2023', 'KO02', '10', '5000', '50000'),
('KD00-P3', '1-20-2023', 'KO03', '8', '50000', '400000'),
('KD00-P4', '2-03-2023', 'KO04', '23', '20000', '460000');

-- --------------------------------------------------------

--
-- Table structure for table `tempat_wisata`
--

CREATE TABLE `tempat_wisata` (
  `kd_objek_wisata` varchar(50) NOT NULL,
  `nama_objek_wisata` varchar(50) NOT NULL,
  `harga_tiket_masuk` varchar(50) NOT NULL,
  `kd_agen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tempat_wisata`
--

INSERT INTO `tempat_wisata` (`kd_objek_wisata`, `nama_objek_wisata`, `harga_tiket_masuk`, `kd_agen`) VALUES
('KO01', 'Bukit Batu', 'Rp.45.000', 'KD01'),
('KO02', 'Pantai Takisung', 'Rp.5.000', 'KD02'),
('KO03', 'Alaska Park', 'Rp.50.000', 'KD03'),
('KO04', 'Museum', 'Rp.20.000', 'KD04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agen`
--
ALTER TABLE `agen`
  ADD PRIMARY KEY (`kd_agen`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`kd_penjualan`),
  ADD UNIQUE KEY `kd_objek_wisata` (`kd_objek_wisata`);

--
-- Indexes for table `tempat_wisata`
--
ALTER TABLE `tempat_wisata`
  ADD PRIMARY KEY (`kd_objek_wisata`),
  ADD UNIQUE KEY `kd_agen` (`kd_agen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
