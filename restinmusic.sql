-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : mer. 24 nov. 2021 à 15:11
-- Version du serveur :  5.7.34
-- Version de PHP : 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `restinmusic`
--

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `release_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `album`
--

INSERT INTO `album` (`id`, `name`, `release_date`) VALUES
(1, 'La coding', '2021-11-24'),
(2, 'Foire St Martin', '2021-11-24'),
(3, 'L\'Olympique de Marseille', '2021-11-24');

-- --------------------------------------------------------

--
-- Structure de la table `song`
--

CREATE TABLE `song` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `category` varchar(100) NOT NULL,
  `duration` varchar(100) NOT NULL,
  `release_date` date NOT NULL,
  `album_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `song`
--

INSERT INTO `song` (`id`, `name`, `artist`, `category`, `duration`, `release_date`, `album_id`) VALUES
(8, 'Modified', 'test', 'cat', '3:33', '2021-11-10', 2),
(13, 'Song1', 'Artist1', 'Rap', '3:33', '2021-11-24', 1),
(14, 'Song2', 'Artist2', 'Jazz', '3:33', '2021-11-24', 2),
(15, 'Song3', 'Artist3', 'Pop', '3:33', '2021-11-24', 3),
(16, 'Song4', 'Artist4', 'Rap', '3:33', '2021-11-24', 1),
(17, 'Song5', 'Artist5', 'Jazz', '3:33', '2021-11-24', 2),
(18, 'Song6', 'Artist6', 'Pop', '3:33', '2021-11-24', 3),
(19, 'Song7', 'Artist7', 'Rap', '3:33', '2021-11-24', 1),
(20, 'Song8', 'Artist8', 'Jazz', '3:33', '2021-11-24', 2),
(21, 'Song9', 'Artist9', 'Pop', '3:33', '2021-11-24', 3),
(22, 'Song10', 'Artist10', 'Rap', '3:33', '2021-11-24', 1),
(23, 'Song11', 'Artist11', 'Jazz', '3:33', '2021-11-24', 2),
(24, 'Song12', 'Artist12', 'Pop', '3:33', '2021-11-24', 3),
(25, 'Song13', 'Artist13', 'Rap', '3:33', '2021-11-24', 1),
(26, 'Song14', 'Artist14', 'Jazz', '3:33', '2021-11-24', 2),
(27, 'Song15', 'Artist15', 'Pop', '3:33', '2021-11-24', 3),
(28, 'Song16', 'Artist16', 'Rap', '3:33', '2021-11-24', 1),
(29, 'Song17', 'Artist17', 'Jazz', '3:33', '2021-11-24', 2),
(30, 'Song18', 'Artist18', 'Pop', '3:33', '2021-11-24', 3),
(31, 'Song19', 'Artist19', 'Rap', '3:33', '2021-11-24', 1),
(32, 'Song20', 'Artist20', 'Jazz', '3:33', '2021-11-24', 2),
(33, 'Song21', 'Artist21', 'Pop', '3:33', '2021-11-24', 3),
(34, 'Song22', 'Artist22', 'Rap', '3:33', '2021-11-24', 1),
(35, 'Song23', 'Artist23', 'Jazz', '3:33', '2021-11-24', 2),
(36, 'Song24', 'Artist24', 'Pop', '3:33', '2021-11-24', 3),
(37, 'Song25', 'Artist25', 'Rap', '3:33', '2021-11-24', 1),
(38, 'Song26', 'Artist26', 'Jazz', '3:33', '2021-11-24', 2),
(39, 'Song27', 'Artist27', 'Pop', '3:33', '2021-11-24', 3),
(40, 'Song28', 'Artist28', 'Rap', '3:33', '2021-11-24', 1),
(41, 'Song29', 'Artist29', 'Jazz', '3:33', '2021-11-24', 2),
(42, 'Song30', 'Artist30', 'Pop', '3:33', '2021-11-24', 3),
(43, 'Song31', 'Artist31', 'Rap', '3:33', '2021-11-24', 1),
(44, 'Song32', 'Artist32', 'Jazz', '3:33', '2021-11-24', 2),
(45, 'Song33', 'Artist33', 'Pop', '3:33', '2021-11-24', 3),
(46, 'Song34', 'Artist34', 'Rap', '3:33', '2021-11-24', 1),
(47, 'Song35', 'Artist35', 'Jazz', '3:33', '2021-11-24', 2),
(48, 'Song36', 'Artist36', 'Pop', '3:33', '2021-11-24', 3),
(49, 'Song37', 'Artist37', 'Rap', '3:33', '2021-11-24', 1),
(50, 'Song38', 'Artist38', 'Jazz', '3:33', '2021-11-24', 2),
(51, 'Song39', 'Artist39', 'Pop', '3:33', '2021-11-24', 3),
(52, 'Song40', 'Artist40', 'Rap', '3:33', '2021-11-24', 1),
(53, 'Song41', 'Artist41', 'Jazz', '3:33', '2021-11-24', 2),
(54, 'Song42', 'Artist42', 'Pop', '3:33', '2021-11-24', 3),
(55, 'Song43', 'Artist43', 'Rap', '3:33', '2021-11-24', 1),
(56, 'Song44', 'Artist44', 'Jazz', '3:33', '2021-11-24', 2),
(57, 'Song45', 'Artist45', 'Pop', '3:33', '2021-11-24', 3),
(58, 'Song46', 'Artist46', 'Rap', '3:33', '2021-11-24', 1),
(59, 'Song47', 'Artist47', 'Jazz', '3:33', '2021-11-24', 2),
(60, 'Song48', 'Artist48', 'Pop', '3:33', '2021-11-24', 3),
(61, 'Song49', 'Artist49', 'Rap', '3:33', '2021-11-24', 1),
(62, 'Song50', 'Artist50', 'Jazz', '3:33', '2021-11-24', 2),
(63, 'Song51', 'Artist51', 'Pop', '3:33', '2021-11-24', 3),
(64, 'Song52', 'Artist52', 'Rap', '3:33', '2021-11-24', 1),
(65, 'Song53', 'Artist53', 'Jazz', '3:33', '2021-11-24', 2),
(66, 'Song54', 'Artist54', 'Pop', '3:33', '2021-11-24', 3),
(67, 'Song55', 'Artist55', 'Rap', '3:33', '2021-11-24', 1),
(68, 'Song56', 'Artist56', 'Jazz', '3:33', '2021-11-24', 2),
(69, 'Song57', 'Artist57', 'Pop', '3:33', '2021-11-24', 3),
(70, 'Song58', 'Artist58', 'Rap', '3:33', '2021-11-24', 1),
(71, 'Song59', 'Artist59', 'Jazz', '3:33', '2021-11-24', 2),
(72, 'Song60', 'Artist60', 'Pop', '3:33', '2021-11-24', 3),
(73, 'Song61', 'Artist61', 'Rap', '3:33', '2021-11-24', 1),
(74, 'Song62', 'Artist62', 'Jazz', '3:33', '2021-11-24', 2),
(75, 'Song63', 'Artist63', 'Pop', '3:33', '2021-11-24', 3),
(76, 'Song64', 'Artist64', 'Rap', '3:33', '2021-11-24', 1),
(77, 'Song65', 'Artist65', 'Jazz', '3:33', '2021-11-24', 2),
(78, 'Song66', 'Artist66', 'Pop', '3:33', '2021-11-24', 3),
(79, 'Song67', 'Artist67', 'Rap', '3:33', '2021-11-24', 1),
(80, 'Song68', 'Artist68', 'Jazz', '3:33', '2021-11-24', 2),
(81, 'Song69', 'Artist69', 'Pop', '3:33', '2021-11-24', 3),
(82, 'Song70', 'Artist70', 'Rap', '3:33', '2021-11-24', 1),
(83, 'Song71', 'Artist71', 'Jazz', '3:33', '2021-11-24', 2),
(84, 'Song72', 'Artist72', 'Pop', '3:33', '2021-11-24', 3),
(85, 'Song73', 'Artist73', 'Rap', '3:33', '2021-11-24', 1),
(86, 'Song74', 'Artist74', 'Jazz', '3:33', '2021-11-24', 2),
(87, 'Song75', 'Artist75', 'Pop', '3:33', '2021-11-24', 3),
(88, 'Song76', 'Artist76', 'Rap', '3:33', '2021-11-24', 1),
(89, 'Song77', 'Artist77', 'Jazz', '3:33', '2021-11-24', 2),
(90, 'Song78', 'Artist78', 'Pop', '3:33', '2021-11-24', 3),
(91, 'Song79', 'Artist79', 'Rap', '3:33', '2021-11-24', 1),
(92, 'Song80', 'Artist80', 'Jazz', '3:33', '2021-11-24', 2),
(93, 'Song81', 'Artist81', 'Pop', '3:33', '2021-11-24', 3),
(94, 'Song82', 'Artist82', 'Rap', '3:33', '2021-11-24', 1),
(95, 'Song83', 'Artist83', 'Jazz', '3:33', '2021-11-24', 2),
(96, 'Song84', 'Artist84', 'Pop', '3:33', '2021-11-24', 3),
(97, 'Song85', 'Artist85', 'Rap', '3:33', '2021-11-24', 1),
(98, 'Song86', 'Artist86', 'Jazz', '3:33', '2021-11-24', 2),
(99, 'Song87', 'Artist87', 'Pop', '3:33', '2021-11-24', 3),
(100, 'Song88', 'Artist88', 'Rap', '3:33', '2021-11-24', 1),
(101, 'Song89', 'Artist89', 'Jazz', '3:33', '2021-11-24', 2),
(102, 'Song90', 'Artist90', 'Pop', '3:33', '2021-11-24', 3),
(103, 'Song91', 'Artist91', 'Rap', '3:33', '2021-11-24', 1),
(104, 'Song92', 'Artist92', 'Jazz', '3:33', '2021-11-24', 2),
(105, 'Song93', 'Artist93', 'Pop', '3:33', '2021-11-24', 3),
(106, 'Song94', 'Artist94', 'Rap', '3:33', '2021-11-24', 1),
(107, 'Song95', 'Artist95', 'Jazz', '3:33', '2021-11-24', 2),
(108, 'Song96', 'Artist96', 'Pop', '3:33', '2021-11-24', 3),
(109, 'Song97', 'Artist97', 'Rap', '3:33', '2021-11-24', 1),
(110, 'Song98', 'Artist98', 'Jazz', '3:33', '2021-11-24', 2),
(111, 'Song99', 'Artist99', 'Pop', '3:33', '2021-11-24', 3),
(112, 'Song100', 'Artist100', 'Rap', '3:33', '2021-11-24', 1),
(113, 'Song101', 'Artist101', 'Jazz', '3:33', '2021-11-24', 2),
(114, 'Song102', 'Artist102', 'Pop', '3:33', '2021-11-24', 3),
(115, 'Song', 'Artist', 'Rock', '3:33', '2021-11-24', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`id`),
  ADD KEY `album_id` (`album_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `album`
--
ALTER TABLE `album`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `song`
--
ALTER TABLE `song`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `song`
--
ALTER TABLE `song`
  ADD CONSTRAINT `song_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
