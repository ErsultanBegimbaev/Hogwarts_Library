-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 07 2020 г., 10:08
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `hogwarts`
--

-- --------------------------------------------------------

--
-- Структура таблицы `books`
--

CREATE TABLE `books` (
  `Id` int(11) NOT NULL,
  `bookID` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `data` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `books`
--

INSERT INTO `books` (`Id`, `bookID`, `title`, `author`, `data`) VALUES
(1, '69', 'Dark.Magic', 'Shrek', '29.05.1959'),
(3, '45', 'Botanika', 'Khvorost', '15.02.1456');

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `Id` int(200) NOT NULL,
  `bookID` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`Id`, `bookID`, `name`, `surname`) VALUES
(1, '79', 'Goro', 'Mortal'),
(2, '79', 'Goro', 'Mortal'),
(3, '69', 'Goro', 'Mortal'),
(4, '45', 'Goro', 'Mortal');

-- --------------------------------------------------------

--
-- Структура таблицы `studentdata`
--

CREATE TABLE `studentdata` (
  `Id` int(11) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `course` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `studentdata`
--

INSERT INTO `studentdata` (`Id`, `Login`, `password`, `Name`, `Surname`, `faculty`, `course`) VALUES
(1, 'Goro01', 'password', 'Goro', 'Mortal', ' Ravenclaw', '2'),
(7, 'Goro01', 'asddsa', 'Goro', 'Alex', 'Gryffindor', '1'),
(8, 'Loj', 'asd', 'Goro', 'GoroBek', 'Gryffindor', '1'),
(9, 'Loj', 'asd', 'Goro', 'GoroBek', 'Gryffindor', '1'),
(10, 'Goro01', 'asddas', 'asd', 'asd', 'Gryffindor', '1');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `studentdata`
--
ALTER TABLE `studentdata`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `books`
--
ALTER TABLE `books`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `Id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `studentdata`
--
ALTER TABLE `studentdata`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
