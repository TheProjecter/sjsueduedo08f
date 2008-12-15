# Host     : localhost
# Port     : 3306
# Database : universitySystem


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `universitySystem`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `universitysystem`;

#
# Structure for the `course` table : 
#

CREATE TABLE `course` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `section` INTEGER(2) NOT NULL,
  `location_id` INTEGER(11) DEFAULT NULL,
  `instructor_id` INTEGER(10) NOT NULL,
  `units` INTEGER(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `unique-name-section` (`name`, `section`)

)ENGINE=InnoDB
AUTO_INCREMENT=2 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `course_meeting_hours` table : 
#

CREATE TABLE `course_meeting_hours` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `course_id` INTEGER(10) NOT NULL,
  `event_information_id` INTEGER(10) NOT NULL,
  PRIMARY KEY (`id`)

)ENGINE=InnoDB
AUTO_INCREMENT=3 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `event_information` table : 
#

CREATE TABLE `event_information` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `day_of_week` ENUM('M','T','W','R','F','S','U') NOT NULL,
  `start_time` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `end_time` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)

)ENGINE=InnoDB
AUTO_INCREMENT=246 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `instructor` table : 
#

CREATE TABLE `instructor` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `employee_id` VARCHAR(11) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `department` VARCHAR(40) COLLATE latin1_swedish_ci DEFAULT NULL,
  `office` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_id` (`employee_id`)

)ENGINE=InnoDB
AUTO_INCREMENT=4 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `instructor_office_hours` table : 
#

CREATE TABLE `instructor_office_hours` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `instructor_id` INTEGER(10) NOT NULL,
  `event_information_id` INTEGER(10) NOT NULL,
  PRIMARY KEY (`id`)

)ENGINE=InnoDB
AUTO_INCREMENT=9 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `location` table : 
#

CREATE TABLE `location` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)

)ENGINE=InnoDB
AUTO_INCREMENT=154 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `person` table : 
#

CREATE TABLE `person` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `last_name` VARCHAR(50) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `address` VARCHAR(200) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `city` VARCHAR(50) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `state` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `zip_code` VARCHAR(10) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `type` ENUM('STUDENT','INSTRUCTOR') NOT NULL DEFAULT 'STUDENT',
  `type_id` INTEGER(10) NOT NULL,
  PRIMARY KEY (`id`)

)ENGINE=InnoDB
AUTO_INCREMENT=7 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `student` table : 
#

CREATE TABLE `student` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `student_id` VARCHAR(11) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id` (`student_id`)

)ENGINE=InnoDB
AUTO_INCREMENT=4 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';

#
# Structure for the `student_to_course` table : 
#

CREATE TABLE `student_to_course` (
  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,
  `student_id` INTEGER(10) NOT NULL,
  `course_id` INTEGER(10) NOT NULL,
  PRIMARY KEY (`id`)

)ENGINE=InnoDB
AUTO_INCREMENT=2 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT='InnoDB free: 146432 kB';



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;