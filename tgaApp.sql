-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: tga_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Snack gourmet'),(2,'Sandwich'),(3,'Hot dogs'),(4,'Bebidas'),(5,'Alcohol'),(6,'Ensaladas'),(7,'Café'),(8,'Snacks'),(9,'Burguers'),(10,'Bocadillos'),(11,'Montaditos'),(12,'Pizzas'),(13,'Carnes'),(14,'Pastas'),(15,'Postres');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofertas`
--

DROP TABLE IF EXISTS `ofertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ofertas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `urlimagen` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofertas`
--

LOCK TABLES `ofertas` WRITE;
/*!40000 ALTER TABLE `ofertas` DISABLE KEYS */;
INSERT INTO `ofertas` VALUES (1,'Oferta de Almuerzo','Descuento especial en almuerzos entre semana','2024-04-01','2024-04-30',NULL),(2,'Oferta de Cumpleaños','Obtén un postre gratis en tu cumpleaños','2024-01-01','2024-12-31',NULL);
/*!40000 ALTER TABLE `ofertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `ingredientes` text,
  `urlimagen` varchar(255) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Patatas clásicas viudas',NULL,NULL,3.00,1),(2,'Patatas clásicas rancheras','BACON, QUESO Y SALSA RANCHERA',NULL,5.45,1),(3,'Patatas clásicas TGA','BACON, QUESO Y SALSA CASERA TGA',NULL,5.45,1),(4,'Patatas deluxe viudas',NULL,NULL,3.80,1),(5,'Patatas deluxe rancheras',NULL,NULL,5.95,1),(6,'Patatas deluxe TGA','BACON, QUESO Y SALSA CASERA TGA',NULL,5.95,1),(7,'Patatas Bravas con salsa',NULL,NULL,3.50,1),(8,'Patatas Bravas sin salsa',NULL,NULL,2.90,1),(9,'Tabla de Nachos','NACHOS, SALSA RANCHERA, CARNE DESILACHADA, QUESO, PICO DE GALLO Y JALAPEÑOS',NULL,9.65,1),(10,'Aros de Cebolla (6 uds)',NULL,NULL,2.30,1),(11,'Alitas (6 uds)',NULL,NULL,4.90,1),(12,'Nuggets (6 uds)',NULL,NULL,2.90,1),(13,'Enchilada','CARNE MOLIDA , SOFRITA CON VERDURAS, ESPECIAS, SALSA PICANTE Y ENVUELTA EN FAJITA CON QUESO.',NULL,5.25,1),(14,'Enchilada de Salmon','SALMON, GUACAMOLE, PICO DE GALLO, LECHUGA Y ENVULTA EN FAJITA CON QUESO.',NULL,5.25,1),(15,'Tequeños (6 uds)',NULL,NULL,6.95,1),(16,'Redondos de Cheddar (8 uds)',NULL,NULL,7.50,1),(17,'M-Box','JAMON YORK Y QUESO CON MANTEQUILLA','https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/m-box.png?alt=media',2.50,2),(18,'Vegetal','ATÚN, LECHUGA, PIMIENTO PIQUILLO, ALCACHOFA, ESPARRAGOS, TOMATE Y MAYONESA APARTE','https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/vegetariano.png?alt=media',5.40,2),(19,'Viudo',NULL,'https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/viudo.png?alt=media',3.50,3),(20,'Chimi-churri','QUESO CHEDDAR, CEBOLLA DESIDRATADA Y SALSA CHIMI-CHURRI',NULL,3.99,3),(21,'Carvi','QUESO CHEDDAR, BACON, PATATAS CLASICAS Y SALSA BRAVA',NULL,3.99,3),(22,'Original','QUESO CHEDDAR, BACON Y CEBOLLA CRUJIENTE',NULL,3.80,3),(23,'Heineken 1/4',NULL,NULL,1.80,4),(24,'Heineken sin alcohol',NULL,NULL,2.00,4),(25,'Amstel 1/3',NULL,NULL,1.80,4),(26,'Caña',NULL,NULL,1.30,4),(27,'Tanque de Amstel',NULL,NULL,2.50,4),(28,'Amstel Radler',NULL,NULL,1.50,4),(29,'Pepsi',NULL,NULL,1.80,4),(30,'Tinto de verano',NULL,NULL,2.50,4),(31,'Agua Vichi',NULL,NULL,1.50,4),(32,'Águila 1/3',NULL,NULL,1.80,4),(33,'Agua Grande',NULL,NULL,1.50,4),(34,'Agua Pequeña',NULL,NULL,1.00,4),(35,'Ginebra',NULL,NULL,5.50,5),(36,'Vodka',NULL,NULL,5.50,5),(37,'Whisky',NULL,NULL,5.50,5),(38,'Ron',NULL,NULL,5.50,5),(39,'Ensalada del Soto','TOMATE PARTIDO, CEBOLLA MORADA, TRALLOS, OLIVAS Y PEPINILLOS.',NULL,6.00,6),(40,'Ensalda Cesar','LECHUGA ICEBERG, SALSA CESAR, TIRAS DE POLLOS, PICATOSTES Y QUESO PARMESANO.',NULL,7.00,6),(41,'Ensalda TGA','LECHUGA VARIADA, PICATOSTES, PASAS, BACON CRISPY, NUECES Y SALSA TGA.',NULL,7.50,6),(42,'Solo',NULL,NULL,1.00,7),(43,'Cortado',NULL,NULL,1.20,7),(44,'Cafe con leche',NULL,NULL,1.50,7),(45,'Bombon',NULL,NULL,1.20,7),(46,'Americano',NULL,NULL,1.50,7),(47,'Carajillo',NULL,NULL,1.50,7),(48,'Belmonte',NULL,NULL,1.50,7),(49,'Mixto',NULL,NULL,1.30,7),(50,'ColaCao',NULL,NULL,2.00,7),(51,'Té verde',NULL,NULL,1.00,7),(52,'Té rojo',NULL,NULL,1.00,7),(53,'Té negro',NULL,NULL,1.00,7),(54,'Manzanilla',NULL,NULL,1.00,7),(55,'Tíla',NULL,NULL,1.00,7),(56,'Cappuchino',NULL,NULL,1.50,7),(57,'Revuelto',NULL,NULL,1.00,8),(58,'Olivas',NULL,NULL,1.00,8),(59,'Almendras',NULL,NULL,2.00,8),(60,'Bocas de Mar',NULL,NULL,1.00,8),(61,'Viudo',NULL,'https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/viuda.png?alt=media',4.20,9),(62,'Smash Original','TERNERA 120GR, QUESO CHEDDAR, TOMATE, BACON, AROS DE CEBOLLA Y SALSA TGA','https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/burguer.png?alt=media',6.40,9),(63,'Burguer Original','TERNERA 170GR, QUESO CHEDDAR, TOMATE, BACON, AROS DE CEBOLLA Y SALSA TGA','https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/original.png?alt=media',7.40,9),(64,'Burger Original 2.0','TERNERA 170GR, QUESO CHEDDAR, TOMATE, PEPINILLO, CEBOLLA NATURAL Y SALSA TGA','https://firebasestorage.googleapis.com/v0/b/tga-images.appspot.com/o/original2.png?alt=media',8.40,9),(65,'Doble cheese burger','DOBLE TERNERA 170GR, QUESO CHEDDAR, TOMATE, PEPINILLO, CEBOLLA NATURAL Y SALSA TGA',NULL,9.95,9),(66,'Crispy Chicken','LECHUGA, BACON Y SALSA TGA',NULL,6.90,9),(67,'Doble crispy chicken','DOBLE POLLO, QUESO CHEDDAR, LECHUGA, BACON Y SALSA TGA',NULL,10.50,9),(68,'Angus Gourmet','QUESO CHEDDAR, BACON, CANONIGOS, AROS DE CEBOLLA Y SALSA BBQ',NULL,10.30,9),(69,'Wagyu','QUESO CHEDDAR, CEBOLLA A LA PLANCHA Y CANONIGOS',NULL,10.50,9),(70,'Cheese Burger','QUESO CHEDDAR Y PEPINILLOS',NULL,2.10,9),(71,'Vegan Burger','TOMATE, LECHUGA, CEBOLLA, PEPINILLOS Y QUESO',NULL,9.95,9),(72,'Angie Deluxe','QUESO CHEDDAR, QUESO DE CABRA, MERMELADA DE PIMIENTO, CEBOLLA CRUJIENTE Y CANONIGOS',NULL,9.50,9),(73,'Black Smash Burguer','BACON, SALSA DE TRUFA, QUESO',NULL,6.90,9),(74,'Black Angus Gourmet','QUESO DE CABRA, CEBOLLA PLANCHA, QUESO DE CHEDAR Y TOMATE CARAMELIZADO',NULL,11.50,9),(75,'Smash Bávara','QUESO CHEDDAR, BACON Y SALSA TGA',NULL,5.99,9),(76,'Teresona','PECHUGA DE POLLO, PIMIENTO PIQUILLO, QUESO CHEDDAR EN LONCHAS',NULL,4.20,10),(77,'TGA','LOMO, QUESO Y SALSA TGA',NULL,5.95,10),(78,'Lomo y tomate',NULL,NULL,2.50,11),(79,'Pechuga y tomate',NULL,NULL,2.50,11),(80,'Salmón y queso fresco',NULL,NULL,3.50,11),(81,'Átun',NULL,NULL,2.00,11),(82,'Al Gusto',NULL,NULL,8.50,12),(83,'Kebab','BASE DE TOMATE, PIMIENTO VERDE, CEBOLLA MORADA, CARNE KABAB Y SALSA KEBAB',NULL,11.00,12),(84,'Alcaparra','BASE DE TOMATE, ATÚN Y ALCAPARRAS',NULL,10.00,12),(85,'Barbacoa','BASE BBQ, TENERA Y BACON',NULL,10.50,12),(86,'Cabrera','BASE DE TOMATE, QUESO DE CABRA, BACON Y CHAMPIÑON',NULL,11.00,12),(87,'Carbonara','BASE TGA, BACON, CHAMPIÑON Y CEBOLLA',NULL,10.50,12),(88,'Cuatro quesos',NULL,NULL,10.00,12),(89,'Diabla','BASE DE BRAVA, BACON Y TERNERA',NULL,9.50,12),(90,'Frita','BASE DE TOMATE, JAMON YORK Y PATATAS CLASICAS',NULL,9.50,12),(91,'Granjera','BASE DE TOMATE, SALCHICHA FRANKFURT, TIRAS DE POLLO Y CEBOLLA FRITA',NULL,9.50,12),(92,'Hay-Gamberry','BASE DE TOMATE, ATÚN, GAMBAS, ANCHOAS, TOMATE CHERRY Y RUCULA',NULL,10.50,12),(93,'Huevona','BASE DE TOMATE, CEBOLLA FRITA, HUEVO Y BACON',NULL,9.50,12),(94,'Margarita','BASE DE TOMATE Y QUESO',NULL,8.00,12),(95,'MariDeluxe','BASE DE TOMATE, BACON, TERNERA Y PATATAS DELUXE',NULL,11.00,12),(96,'Mexicana','BASE DE BRAVA, BACON, TERNERA, MAIZ, OLIVAS NEGRAS Y CEBOLLA FRITA',NULL,10.50,12),(97,'MultiDeluxe','BASE DE TOMATE, BACON, TERNERA, PIMIENTO VERDE, PIMIENTO ROJO Y CHAMPIÑON',NULL,10.50,12),(98,'Napolitana','BASE DE TOMATE, ALBAHACA, ACEITUNAS NEGRAS',NULL,9.50,12),(99,'Peperoni','BASE DE TOMATE Y PEPERONI',NULL,9.50,12),(100,'Piamontesa','BASE DE TOMATE, BACON, SALAMI Y CHAMPIÑÓN',NULL,9.50,12),(101,'Popeye','BASE DE TOMATE, ESPINACAS Y NUECES',NULL,9.50,12),(102,'PizzaNet','BASE DE TOMATE, PEPERONI, TERNERA, PIMIENTO VERDE Y BACON CRISPY',NULL,10.50,12),(103,'Tropical','BASE DE TOMATE, JAMON YORK Y PIÑA',NULL,9.50,12),(104,'Vegetal','BASE DE TOMATE, PIMIENTO VERDE, PIMIENTO ROJO, CEBOLLA FRITA, TOMATE CHERRY Y ACEITUNAS NEGRAS',NULL,9.50,12),(105,'Virginia','BASE DE TOMATE, JAMON YORK, ATUN Y BACON',NULL,9.50,12),(106,'Entrecot',NULL,NULL,18.00,13),(107,'Costillar',NULL,NULL,14.00,13),(108,'Carbonara',NULL,NULL,5.50,14),(109,'Atún y tomate',NULL,NULL,5.50,14),(110,'Gofree',NULL,NULL,3.50,15),(111,'Pancake',NULL,NULL,3.00,15),(112,'Cheesecake de lotus',NULL,NULL,3.50,15),(113,'Cheesecake de oreo',NULL,NULL,3.50,15),(114,'Cheesecake de frutos rojos',NULL,NULL,3.50,15);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_oferta`
--

DROP TABLE IF EXISTS `usuario_oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_oferta` (
  `correo` varchar(255) NOT NULL,
  `oferta_id` int NOT NULL,
  `codigo` varchar(100) NOT NULL,
  `activo` tinyint(1) DEFAULT '0',
  `tiempo_para_gastar` datetime DEFAULT NULL,
  PRIMARY KEY (`correo`,`oferta_id`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `oferta_id` (`oferta_id`),
  CONSTRAINT `usuario_oferta_ibfk_1` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`correo`),
  CONSTRAINT `usuario_oferta_ibfk_2` FOREIGN KEY (`oferta_id`) REFERENCES `ofertas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_oferta`
--

LOCK TABLES `usuario_oferta` WRITE;
/*!40000 ALTER TABLE `usuario_oferta` DISABLE KEYS */;
INSERT INTO `usuario_oferta` VALUES ('arroba@gmail.com',1,'BRf5ki',0,'2024-06-10 17:12:49'),('arroba@gmail.com',2,'AKcSPW',0,'2024-06-10 17:11:47'),('german23@gmail.com',1,'CCqrrD',0,'2024-06-11 20:44:53'),('german23@gmail.com',2,'bQES7P',0,'2024-06-12 12:49:48');
/*!40000 ALTER TABLE `usuario_oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `correo` varchar(255) NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `rol` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('arroba@gmail.com','$2a$10$YpI.CIuC2xWzbjg1KWUmO.Bw7Qxh2n9G7l6Z7w.6G53ZO6N68mdRy','Pepe','mendoza Méndez dial','USER'),('berto@gmail.com','$2a$10$3jRKbQK.7rIxUsZoSwlHb.EMeZDJXw2cv0qkbbO4tF08AhI4wEXNG','Alberto Cayetano Rivera','Tercero Prieto Garcia','USER'),('german@gmail.com','$2a$10$fJrjhsb6lmAN1DnlWSqGWuawqSlFxCUsSeUp2ShuGhLagAL/50hfi','German','Gomez Carrillo','USER'),('german23@gmail.com','$2a$10$v0RLRLtFj5UtyDrsFxtMSOyqcLhr7/PY6GpQ5x4T9aWuOwopD492W','German','Gomez Carrillo','USER'),('nsddksdj@gmail.com','$2a$10$Rn3SxMO/upaq8khRLtcBFu9JsbCMAgpxWCd2AwT/g9/RPqxs8XrSC','paxo','ekekd','USER'),('nsksdj@gmail.com','$2a$10$h2biMIpJP7t1ymKoj3TeGechLXlrQ8iwjBm/DFOq7KUcQAGA5wGHG','paxo','ekekd','USER'),('paco@gmail.com','$2a$10$vuLjDlThMbIURoyRpFPmYOl/4ATiUlGzmNJGKKGWw.39ramSYxITC','Paco','Sanchez Castejon','USER'),('papakdo@gmail.com','$2a$10$OfYdIpu2FZ2BN4sWmjN5JOTmS31tcDXQ/.AZjGpMUThYjKK.oO4D.','dududu','dudududdj','USER'),('pepepm@gmail.com','$2a$10$ZIJr4D3iu3C1lu91uv2YR.Hic5QVe1SIYWAplqklrOeRHgk4ji3b2','Pepe','potro martinez','USER'),('pepepm23@gmail.com','$2a$10$uiDVUv4tmE8Ea3ai3oxROO1Dy5/DunFGHt81FgTA/GNTKKb7.5yUG','Pepe','potro martinez','USER');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-13 20:40:49
