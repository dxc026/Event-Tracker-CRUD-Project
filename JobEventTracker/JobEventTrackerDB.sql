-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema JobEventTrackerDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `JobEventTrackerDB` ;

-- -----------------------------------------------------
-- Schema JobEventTrackerDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JobEventTrackerDB` DEFAULT CHARACTER SET utf8 ;
USE `JobEventTrackerDB` ;

-- -----------------------------------------------------
-- Table `job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job` ;

CREATE TABLE IF NOT EXISTS `job` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(250) NULL,
  `company` VARCHAR(250) NULL,
  `date` DATE NULL,
  `status` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `job`
-- -----------------------------------------------------
START TRANSACTION;
USE `JobEventTrackerDB`;
INSERT INTO `job` (`id`, `title`, `company`, `date`, `status`, `city`, `state`) VALUES (1, 'Software Developer', 'Frost', '2017-04-17', 'denied', 'San Antonio', 'TX');
INSERT INTO `job` (`id`, `title`, `company`, `date`, `status`, `city`, `state`) VALUES (2, 'Front-end Developer', 'Snowman Labs', '2017-04-17', 'pending', 'Orlando ', 'FL');
INSERT INTO `job` (`id`, `title`, `company`, `date`, `status`, `city`, `state`) VALUES (3, 'Intern Software Developer', 'SourceToad', '2017-04-19', 'pending', 'Tampa', 'FL');
INSERT INTO `job` (`id`, `title`, `company`, `date`, `status`, `city`, `state`) VALUES (4, 'Geospatial Software Developer', 'DigitalGlobal', '2017-04-21', 'pending', 'Tampa', 'FL');
INSERT INTO `job` (`id`, `title`, `company`, `date`, `status`, `city`, `state`) VALUES (5, 'Java Developer', 'USAA', '2018-04-21', 'pending', 'San Antonio', 'TX');

COMMIT;

