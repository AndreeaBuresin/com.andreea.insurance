-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema msg_cv
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema msg_cv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `msg_cv` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema insuranceDB
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema insurance_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema insurance_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `insurance_project` DEFAULT CHARACTER SET utf8 ;
USE `msg_cv` ;

-- -----------------------------------------------------
-- Table `msg_cv`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `msg_cv`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `dateOfBirth` VARCHAR(45) NOT NULL,
  `cnp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnp_UNIQUE` (`cnp` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `msg_cv`.`cvuser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `msg_cv`.`cvuser` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `cvTitle` VARCHAR(45) NOT NULL,
  `cvContent` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_userid_idx` (`userId` ASC),
  CONSTRAINT `fk_userid`
  FOREIGN KEY (`userId`)
  REFERENCES `msg_cv`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

USE `insurance_project` ;

-- -----------------------------------------------------
-- Table `insurance_project`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurance_project`.`address` (
  `id` INT(11) NOT NULL,
  `town` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `number` INT(11) NOT NULL,
  `apartment` INT(11) NULL DEFAULT NULL)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `insurance_project`.`claim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurance_project`.`claim` (
  `id` INT(11) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `registrationDate` DATE NOT NULL,
  `damages` DECIMAL(2,0) NULL DEFAULT NULL,
  `moralDamages` DECIMAL(2,0) NULL DEFAULT NULL,
  `losses` DECIMAL(2,0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `insurance_project`.`financialorders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurance_project`.`financialorders` (
  `id` INT(11) NOT NULL,
  `amount` DECIMAL(2,0) NOT NULL,
  `account` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `insurance_project`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurance_project`.`person` (
  `cnp` BIGINT(13) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `phoneNo` BIGINT(10) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `loginUser` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `contractDate` DATE NOT NULL,
  PRIMARY KEY (`cnp`),
  UNIQUE INDEX `loginUser_UNIQUE` (`loginUser` ASC),
  UNIQUE INDEX `cnp_UNIQUE` (`cnp` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `insurance_project`.`policy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurance_project`.`policy` (
  `id` INT(11) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `amount` DECIMAL(2,0) NOT NULL,
  `discount` DECIMAL(2,0) NULL DEFAULT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `insurance_project`.`vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurance_project`.`vehicle` (
  `identificationNo` BIGINT(17) NOT NULL,
  `registrationNo` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `cylinders` INT(11) NOT NULL,
  `kw` INT(11) NOT NULL,
  PRIMARY KEY (`identificationNo`),
  UNIQUE INDEX `identificationNo_UNIQUE` (`identificationNo` ASC),
  UNIQUE INDEX `registrationNo_UNIQUE` (`registrationNo` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
