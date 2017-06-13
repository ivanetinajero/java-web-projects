-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cinemadb
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `cast` text NOT NULL,
  `director` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `synopsis` text NOT NULL,
  `status` varchar(20) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES (1,'Vacation','Ed Helms, Christina Applegate, Leslie Mann, Chris Hemsworth, Skyler Gisondo.','John Francis Daley, Jonathan M. Gol.',2016,100,'Comedy, Action,Adventure.','Hoping to bring his family closer together and to recreate his childhood vacation for his own kids, a grown up Rusty Griswold takes his wife and their two sons on a cross-country road trip to the coolest theme park in America, Walley World. Needless to say, things don´t go quite as planned','active','1_vacation.jpg'),(2,'Pixels','Peter Dinklage, Josh Gad, Michelle Monaghan, Adam Sandler, Kevin James.','Chris Columbus',2016,105,'Animation','As kids in the 1980s, Sam Brenner, Will Cooper, Ludlow Lamonsoff, and Eddie \"The Fire Blaster\" Plant saved the world thousands of times - at 25 cents a game in the video arcades. Now, they´re going to have to do it for real. When intergalactic aliens discover video feeds of classic arcade games and misinterpret them as a declaration of war, they attack the Earth, using the video games as the models for their assaults - and now-U.S. President Cooper must call on his old-school arcade friends to save the world from being destroyed by PAC-MAN, Donkey Kong, Galaga, Centipede, and Space Invaders. ','active','2_pixels.jpeg'),(3,'Ant-Man','Paul Rudd, Evangeline Lilly, Hayley Atwell, Corey Stoll, Michael Douglas','Peyton Reed',2016,117,'Action/Adventure','Armed with the astonishing ability to shrink in scale but increase in strength, con-man Scott Lang must embrace his inner-hero and help his mentor, Dr. Hank Pym, protect the secret behind his spectacular Ant-Man suit from a new generation of towering threats. Against seemingly insurmountable obstacles, Pym and Lang must plan and pull off a heist that will save the world.','active','3_ant-man.jpg'),(4,'Paper Towns','Nat Wolff, Cara Delevingne, Halston Sage, Austin Abrams','Jake Schreier',2016,109,'Suspense/Thriller, Romance','Paper Towns is a coming-of-age story centering on Quentin and his enigmatic neighbor Margo, who loved mysteries so much she became one. After taking him on an all-night adventure through their hometown, Margo suddenly disappears--leaving behind cryptic clues for Quentin to decipher. The search leads Quentin and his quick-witted friends on an exhilarating adventure that is equal parts hilarious and moving. Ultimately, to track down Margo, Quentin must find a deeper understanding of true friendship--and true love. ','active','4_paper-towns.jpg'),(5,'Minions','Sandra Bullock, Jon Hamm','Kyle Balda, Pierre Coffin',2016,88,'Animation, Comedy, Family','The story of Minions begins at the dawn of time. Starting as single-celled yellow organisms, Minions evolve through the ages, perpetually serving the most despicable of masters. Continuously unsuccessful at keeping these masters-from T. rex to Napoleon-the Minions find themselves without someone to serve and fall into a deep depression. But one Minion named Kevin has a plan, and he-alongside teenage rebel Stuart and lovable little Bob-ventures out into the world to find a new evil boss for his brethren to follow. The trio embarks upon a thrilling journey that ultimately leads them to their next potential master, Scarlet Overkill, the world´s first-ever female super-villain. They travel from frigid Antarctica to 1960s New York City, ending in mod London, where they must face their biggest challenge to date: saving all of Minionkind...from annihilation.','coming','5_minions.jpg'),(6,'Mission: Impossible Rogue Nation','Tom Cruise, Jeremy Renner, Simon Pegg, Rebecca Ferguson, Alec Baldwin','Christopher McQuarrie',2016,131,'Action/Adventure','Ethan and team take on their most impossible mission yet, eradicating the Syndicate - an International rogue organization as highly skilled as they are, committed to destroying the IMF','coming','6_mission-impossible.jpg'),(7,'Trainwreck','Amy Schumer, Bill Hader, Brie Larson, Colin Quinn, John Cena','Judd Apatow',2016,124,'Comedy','Since she was a little girl, it´s been drilled into Amy´s head by her rascal of a dad that monogamy isn´t realistic. Now a magazine writer, Amy lives by that credo - enjoying what she feels is an uninhibited life free from stifling, boring romantic commitment - but in actuality, she´s kind of in a rut. When she finds herself starting to fall for the subject of the new article she´s writing, a charming and successful sports doctor named Aaron Conners, Amy starts to wonder if other grown-ups, including this guy who really seems to like her, might be on to something.','coming','7_trainwreck.jpg'),(8,'Southpaw','Nat Wolff, Cara Delevingne, Halston Sage, Austin Abrams.','Jake Schreier',2016,109,'Suspense/Thriller, Romance','Paper Towns is a coming-of-age story centering on Quentin and his enigmatic neighbor Margo, who loved mysteries so much she became one. After taking him on an all-night adventure through their hometown, Margo suddenly disappears--leaving behind cryptic clues for Quentin to decipher. The search leads Quentin and his quick-witted friends on an exhilarating adventure that is equal parts hilarious and moving. Ultimately, to track down Margo, Quentin must find a deeper understanding of true friendship--and true love','coming','8_paper-towns.jpg'),(9,'The Revenant ','Domhnall Gleeson, Tom Hardy, Leonardo DiCaprio',' Alejandro GonzÃ¡lez IÃ±Ã¡rritu',2016,140,'Action','In an expedition of the uncharted American wilderness, legendary explorer Hugh Glass is brutally attacked by a bear and left for dead by members of his own hunting team. In a quest to survive, Glass endures unimaginable grief as well as the betrayal of his confidant John Fitzgerald. Guided by sheer will and the love of his family, Glass must navigate a vicious winter in a relentless pursuit to live and find redemption.','coming','the-revenant.jpg'),(10,'The Forest','Natalie Dormer, Taylor Kinney, Eoin Macken','Jason Zada',2016,120,'Thriller','A supernatural thriller set in the legendary Aokigahara Forest at the base of Mt. Fuji in Japan. A young American woman, Sara, goes in search of her twin sister, who has mysteriously disappeared. Despite everyone\'s warnings to \"stay on the path,\" Sara enters the forest determined to discover the truth about her sister\'s fate - only to be confronted by the angry and tormented souls of the dead that prey on anyone who wanders into the forest.','coming','the-forest.jpg'),(11,'Joy',' Jennifer Lawrence, Bradley Cooper, Robert De Niro',' David O. Russell',2016,137,'Comedy','This is the wild story of a family across four generations centered on the girl who becomes the woman who founds a business dynasty and becomes a matriarch in her own right. Betrayal, treachery, the loss of innocence and the scars of love, pave the road in this intense emotional and human comedy about becoming a true boss of family and enterprise facing a world of unforgiving commerce. Allies become adversaries and adversaries become allies, both inside and outside the family, as Joy\'s inner life and fierce imagination carry her through the storm she face','coming','joy.jpg'),(12,'Daddy\'s Home','Will Ferrell, Mark Wahlberg, Linda Cardellini',' Sean Anders',2016,147,'Comedy','A mild-mannered radio executive strives to become the best stepdad to his wife\'s two children, but complications ensue when their freewheeling and freeloading real father arrives, forcing him to compete for the affection of the kids.','coming','daddys-home.jpg'),(13,'Sisters',' Amy Poehler, Tina Fey, Maya Rudolph, James Brolin','Jason Moore',2016,124,'Comedy','Two disconnected sisters are summoned home to clean out their childhood bedroom before their parents sell the family house. Looking to recapture their glory days, they throw one final high-school-style party for their classmates, which turns into the cathartic rager that a bunch of ground-down adults really need','coming','sisters.jpg'),(14,'The Danish Girl ','Alicia Vikander, Eddie Redmayne','Tom Hooper',2016,120,'Drama','The story of real-life Danish painter Einar Wegener who, in 1931, became the first man to undergo a sex-change operation. His wife Greta, also a painter, first discovers her husband\'s affinity for feminine attire when he sits in for one of her models. Ultimately, she encourages him on his transexual journey.','coming','the-danish-girl.jpg'),(15,'Carol',' Rooney Mara, Cate Blanchett','Todd Haynes',2016,118,'Drama','A young woman in her 20s, Therese Belivet is a clerk working in a Manhattan department store and dreaming of a more fulfilling life when she meets Carol, an alluring woman trapped in a loveless, convenient marriage. As an immediate connection sparks between them, the innocence of their first encounter dims and their connection deepens. While Carol breaks free from the confines of marriage, her husband threatens her competence as a mother when Carol\'s involvement with Therese and close relationship with her best friend Abby comes to light. As Carol leaves the comfort of home to travel with Therese, an internal journey of self-discovery coincides with her new sense of space','coming','carol.jpg'),(16,'Creed','Michael B. Jordan, Sylvester Stallone','Ryan Coogler',2016,133,'Drama','Adonis Johnson never knew his famous father,world heavy weight champion Apollo Creed, who died before he was born. Still, there\'s no denying that boxing is in his blood, so Adonis heads to Philadelphia, the site of Apollo Creed\'s legendary match with a tough upstart named Rocky Balboa. Rocky sees in Adonis the strength and determination he had known in Apollo - the fierce rival who became his closest friend.','coming','creed.jpg'),(17,'The BOSS','Melissa McCarthy, Kristen Bell, Peter Dinklage','Ben Falcone',2016,125,' Comedy','A titan of industry is sent to prison after she\'s caught for insider trading. When she emerges ready to rebrand herself as America\'s latest sweetheart, not everyone she screwed over is so quick to forgive and forget. ','active','the-boss.jpg');
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'itinajero','administrator'),(2,'enrique','administrator');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Schedule`
--

DROP TABLE IF EXISTS `Schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idMovie` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `screen` varchar(25) NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Schedule` (`idMovie`),
  CONSTRAINT `fk_Schedule` FOREIGN KEY (`idMovie`) REFERENCES `Movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Schedule`
--

LOCK TABLES `Schedule` WRITE;
/*!40000 ALTER TABLE `Schedule` DISABLE KEYS */;
INSERT INTO `Schedule` VALUES (1,2,'2016-02-11','22:00:00','Premium ',10),(2,2,'2016-02-11','17:00:00','Screen 3',10),(3,2,'2016-02-11','20:00:00','Screen 1',10),(4,1,'2016-02-11','17:00:00','Premium',15),(5,1,'2016-02-11','18:00:00','Screen 1',15),(6,1,'2016-02-11','20:00:00','Screen 4',15),(7,1,'2016-02-11','21:00:00','Screen 3',15),(8,3,'2016-02-11','20:00:00','Premium',10),(9,3,'2016-02-11','21:00:00','Screen 1',10),(10,3,'2016-02-11','17:00:00','Screen 4',10),(11,4,'2016-02-11','16:00:00','Premium ',15),(12,4,'2016-02-11','17:00:00','Screen 1',10),(13,4,'2016-02-11','18:00:00','Screen 2',10),(14,4,'2016-02-11','20:00:00','Screen 3',10),(15,4,'2016-02-11','21:00:00','Screen 4',10),(16,4,'2016-02-11','22:00:00','Screen 5',12),(17,2,'2016-02-12','22:00:00','Premium ',10),(18,2,'2016-02-12','17:00:00','Screen 3',10),(19,2,'2016-02-12','20:00:00','Screen 1',10),(20,1,'2016-02-12','17:00:00','Premium',15),(21,1,'2016-02-12','18:00:00','Screen 1',15),(22,1,'2016-02-12','20:00:00','Screen 4',15),(23,1,'2016-02-12','21:00:00','Screen 3',15),(24,3,'2016-02-12','20:00:00','Premium',10),(25,3,'2016-02-12','21:00:00','Screen 1',10),(26,3,'2016-02-12','17:00:00','Screen 4',10),(27,4,'2016-02-12','16:00:00','Premium ',15),(28,4,'2016-02-12','17:00:00','Screen 1',10),(29,4,'2016-02-12','18:00:00','Screen 2',10),(30,4,'2016-02-12','20:00:00','Screen 3',10),(31,4,'2016-02-12','21:00:00','Screen 4',10),(32,4,'2016-02-12','22:00:00','Screen 5',12),(33,2,'2016-02-13','22:00:00','Premium ',10),(34,2,'2016-02-13','17:00:00','Screen 3',10),(35,2,'2016-02-13','20:00:00','Screen 1',10),(36,1,'2016-02-13','17:00:00','Premium',15),(37,1,'2016-02-13','18:00:00','Screen 1',15),(38,1,'2016-02-13','20:00:00','Screen 4',15),(39,1,'2016-02-13','21:00:00','Screen 3',15),(40,3,'2016-02-13','20:00:00','Premium',10),(41,3,'2016-02-13','21:00:00','Screen 1',10),(42,3,'2016-02-13','17:00:00','Screen 4',10),(43,4,'2016-02-13','16:00:00','Premium ',15),(44,4,'2016-02-13','17:00:00','Screen 1',10),(45,4,'2016-02-13','18:00:00','Screen 2',10),(46,4,'2016-02-13','20:00:00','Screen 3',10),(47,4,'2016-02-13','21:00:00','Screen 4',10),(48,4,'2016-02-13','22:00:00','Screen 5',12),(49,2,'2016-02-14','22:00:00','Premium ',10),(50,2,'2016-02-14','17:00:00','Screen 3',10),(51,1,'2016-02-14','17:00:00','Premium',15),(52,1,'2016-02-14','18:00:00','Screen 1',15),(53,1,'2016-02-14','20:00:00','Screen 4',15),(54,3,'2016-02-14','20:00:00','Premium',10),(55,3,'2016-02-14','21:00:00','Screen 1',10),(56,3,'2016-02-14','17:00:00','Screen 4',10),(57,4,'2016-02-14','16:00:00','Premium ',15),(58,4,'2016-02-14','17:00:00','Screen 1',10),(59,4,'2016-02-14','18:00:00','Screen 2',10),(60,4,'2016-02-14','20:00:00','Screen 3',10),(61,6,'2016-02-15','16:00:00','Screen 1',15),(62,6,'2016-02-15','15:00:00','Screen 2',10),(63,6,'2016-02-15','20:30:00','Premium',20),(65,17,'2016-02-12','15:30:00','Premium',20),(66,17,'2016-02-12','18:00:00','Screen 4',15),(67,17,'2016-02-13','20:00:00','Screen 2',14);
/*!40000 ALTER TABLE `Schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Ivan E. Tinajero Diaz','itinajero','c4ca4238a0b923820dcc509a6f75849b');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-11 18:49:57
