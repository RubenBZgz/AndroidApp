-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-03-2023 a las 11:39:52
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `android`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `idCine` int(11) NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `capacidad` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`idCine`, `nombre`, `capacidad`) VALUES
(1, 'Cinesa', 2000),
(2, 'Aragonia', 2300),
(3, 'Palafox', 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cpeli`
--

CREATE TABLE `cpeli` (
  `idCine` int(4) DEFAULT NULL,
  `idPelicula` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `cpeli`
--

INSERT INTO `cpeli` (`idCine`, `idPelicula`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 4),
(3, 4),
(2, 4),
(3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `idEntrada` int(11) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  `idUsuario` int(4) DEFAULT NULL,
  `idPelicula` int(4) DEFAULT NULL,
  `idCine` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`idEntrada`, `precio`, `idUsuario`, `idPelicula`, `idCine`) VALUES
(1, '5.00', 2, 1, NULL),
(2, '5.00', 3, 3, NULL),
(3, '5.00', 4, 3, NULL),
(4, '5.00', 4, 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL,
  `titulo` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `tematica` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `trailer` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `anio` int(4) NOT NULL,
  `edadRecomendada` int(2) NOT NULL,
  `butacasLibres` int(4) NOT NULL,
  `butacasOcupadas` int(4) NOT NULL,
  `calificacion` decimal(3,2) NOT NULL,
  `vecesPuntuado` int(4) NOT NULL,
  `imagen` varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idPelicula`, `titulo`, `tematica`, `trailer`, `anio`, `edadRecomendada`, `butacasLibres`, `butacasOcupadas`, `calificacion`, `vecesPuntuado`, `imagen`) VALUES
(1, 'La forja de un campeon', 'Deportes', 'https://www.youtube.com/watch?v=QL8NpsQiBgA', 2022, 16, 100, 200, '4.20', 100, ''),
(2, 'Avatar: El sentido del agua', 'Aventura', 'https://www.youtube.com/watch?v=FSyWAxUg3Go', 2022, 12, 46, 564, '4.70', 1330, ''),
(3, 'Scream', 'Terror', 'https://www.youtube.com/watch?v=LItQuV1bFf4', 2022, 16, 80, 300, '3.90', 221, ''),
(4, 'Avatar', 'Aventura', 'https://www.youtube.com/watch?v=AZS_d_hS2dM', 2009, 7, 100, 200, '5.00', 300, 'https://images.pexels.com/photos/5774804/pexels-photo-5774804.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
(5, 'El Gato con Botas: El último deseo', 'Animación', 'https://www.youtube.com/watch?v=7afDrYLajRk', 2022, 7, 20, 130, '4.10', 450, ''),
(6, 'Muere, Hart', 'Acción', 'https://www.youtube.com/watch?v=kAYOmh5Kh2U', 2023, 18, 100, 60, '2.30', 90, ''),
(7, 'Shark Side of the Moon', 'Acción', 'https://www.youtube.com/watch?v=6DKVDjLKy8g', 2022, 18, 65, 35, '2.70', 87, ''),
(8, 'Creed III', 'Acción', 'https://www.youtube.com/watch?v=jdEEZeRiyeQ', 2023, 16, 20, 130, '4.20', 260, ''),
(9, 'Winnie the Pooh: Blood and Honey', 'Horror', 'Winnie the Pooh: Blood and Honey', 2023, 18, 50, 60, '3.60', 143, ''),
(10, 'La ballena', 'Drama', 'https://www.youtube.com/watch?v=IUezfSnXzEY', 2022, 16, 20, 130, '4.10', 412, ''),
(11, 'Todo a la vez en todas partes', 'Acción', 'https://www.youtube.com/watch?v=U3cKYWgl2dU', 2022, 16, 20, 130, '4.10', 187, ''),
(12, 'Shazam', 'Acción', 'https://www.youtube.com/watch?v=B_DpkUSH2Mk', 2019, 0, 20, 130, '4.00', 302, ''),
(13, 'Spider-Man: No Way Home', 'Acción', 'https://www.youtube.com/watch?v=ldMn-1iQzKE', 2021, 12, 20, 130, '4.30', 580, ''),
(14, 'El niño delfín', 'Animación', 'https://www.youtube.com/watch?v=iYVCk_uJycM', 2022, 6, 20, 130, '4.10', 221, ''),
(15, 'Jujutsu Kaisen 0', 'Animación', 'https://www.youtube.com/watch?v=Jvaej6rvlIc', 2021, 12, 20, 130, '4.70', 432, ''),
(16, 'Medieval', 'Historia', 'https://www.youtube.com/watch?v=AmQILSvYajI', 2022, 16, 20, 130, '4.10', 300, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `correo` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `correo`, `password`) VALUES
(1, 'admin', 'admin@gmail.com', '123'),
(2, 'Ruben', 'rb@gmail.com', '111'),
(3, 'Lolo', 'lolo@gmail.com', '222'),
(4, 'Paco', 'paco@gmail.com', '333');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`idCine`);

--
-- Indices de la tabla `cpeli`
--
ALTER TABLE `cpeli`
  ADD KEY `FK_cPeli_cine` (`idCine`),
  ADD KEY `FK_cPeli_pelicula` (`idPelicula`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`idEntrada`),
  ADD KEY `FK_entrada_usuario` (`idUsuario`),
  ADD KEY `FK_entrada_peli` (`idPelicula`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `UN_usuario_correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cine`
--
ALTER TABLE `cine`
  MODIFY `idCine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `idEntrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cpeli`
--
ALTER TABLE `cpeli`
  ADD CONSTRAINT `FK_cPeli_cine` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`),
  ADD CONSTRAINT `FK_cPeli_pelicula` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `FK_entrada_peli` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `FK_entrada_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
