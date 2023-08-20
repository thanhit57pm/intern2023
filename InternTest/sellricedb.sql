-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2023 at 08:33 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sellricedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `price` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `price`) VALUES
(1, 'good rice', 'High quality rice', 25000),
(2, 'bad rice', 'poor quality rice', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `product_price`
--

CREATE TABLE `product_price` (
  `id` int(4) NOT NULL,
  `product_id` int(4) NOT NULL,
  `price` int(4) NOT NULL,
  `created_at` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_price`
--

INSERT INTO `product_price` (`id`, `product_id`, `price`, `created_at`) VALUES
(1, 1, 20000, '2023-08-20'),
(2, 1, 25000, '2023-08-21');

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

CREATE TABLE `statistics` (
  `id` int(4) NOT NULL,
  `product_price_id` int(4) NOT NULL DEFAULT 1,
  `sale_date` date NOT NULL DEFAULT current_timestamp(),
  `qty` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `statistics`
--

INSERT INTO `statistics` (`id`, `product_price_id`, `sale_date`, `qty`) VALUES
(1, 1, '2023-08-20', 81),
(2, 1, '2023-08-20', 93),
(3, 1, '2023-08-20', 111),
(4, 1, '2023-08-20', 111),
(5, 1, '2023-08-20', 93),
(6, 1, '2023-08-20', 57),
(7, 1, '2023-08-20', 105),
(8, 1, '2023-08-20', 96),
(9, 1, '2023-08-20', 36),
(10, 1, '2023-08-20', 72),
(11, 1, '2023-08-20', 117),
(12, 1, '2023-08-20', 18),
(13, 1, '2023-08-20', 66),
(14, 1, '2023-08-20', 36),
(15, 1, '2023-08-20', 15),
(16, 1, '2023-08-20', 27),
(17, 1, '2023-08-20', 27),
(18, 1, '2023-08-20', 69),
(19, 1, '2023-08-20', 57),
(20, 1, '2023-08-20', 93),
(21, 1, '2023-08-20', 69),
(22, 1, '2023-08-20', 33),
(23, 1, '2023-08-20', 114),
(24, 1, '2023-08-20', 48),
(25, 1, '2023-08-20', 39),
(26, 1, '2023-08-20', 78),
(27, 1, '2023-08-20', 90),
(28, 1, '2023-08-20', 18),
(29, 1, '2023-08-20', 36),
(30, 1, '2023-08-20', 36),
(31, 1, '2023-08-20', 36),
(32, 2, '2023-08-21', 36),
(33, 2, '2023-08-21', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_price`
--
ALTER TABLE `product_price`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_price_id` (`product_price_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product_price`
--
ALTER TABLE `product_price`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `statistics`
--
ALTER TABLE `statistics`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product_price`
--
ALTER TABLE `product_price`
  ADD CONSTRAINT `product_price_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `statistics`
--
ALTER TABLE `statistics`
  ADD CONSTRAINT `statistics_ibfk_1` FOREIGN KEY (`product_price_id`) REFERENCES `product_price` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
