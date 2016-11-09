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
-- Schema insurance_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema insurance_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `insurance_project` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema asigurariauto_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema asigurariauto_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `asigurariauto_db` DEFAULT CHARACTER SET utf8 ;
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
  PRIMARY KEY (`cnp`),
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

USE `asigurariauto_db` ;

-- -----------------------------------------------------
-- Table `asigurariauto_db`.`persoana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`persoana` (
  `idpersoana(CNP)` BIGINT(13) NOT NULL,
  `tipPersoana` VARCHAR(45) NOT NULL,
  `nume` VARCHAR(20) NOT NULL,
  `prenume` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefon` BIGINT(10) NOT NULL,
  PRIMARY KEY (`idpersoana(CNP)`),
  UNIQUE INDEX `idperson_UNIQUE` (`idpersoana(CNP)` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`vehicol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`vehicol` (
  `idSerieSasiu` VARCHAR(17) NOT NULL,
  `nrIdentificare` VARCHAR(7) NOT NULL,
  `marca` VARCHAR(15) NOT NULL,
  `model` VARCHAR(15) NOT NULL,
  `combustibil` VARCHAR(15) NOT NULL,
  `cilindri` INT(11) NOT NULL,
  `kw` INT(11) NOT NULL,
  `masaMaxAsigurata` INT(11) NOT NULL,
  `dataFabricatie` DATE NOT NULL,
  `accident` INT(11) NOT NULL,
  `sumaAsigurata` DECIMAL(4,0) NOT NULL,
  PRIMARY KEY (`idSerieSasiu`),
  UNIQUE INDEX `idIdentificareNr_UNIQUE` (`nrIdentificare` ASC),
  UNIQUE INDEX `serieSasiu_UNIQUE` (`idSerieSasiu` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`chitanta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`chitanta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `suma` DECIMAL(4,0) NOT NULL,
  `descriere` VARCHAR(45) NOT NULL,
  `discount` DECIMAL(4,0) NULL DEFAULT NULL,
  `persoanaId` BIGINT(13) NOT NULL,
  `politaId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `persoanaId_idx` (`persoanaId` ASC),
  INDEX `politaId_idx` (`politaId` ASC),
  CONSTRAINT `persoanaId`
  FOREIGN KEY (`persoanaId`)
  REFERENCES `asigurariauto_db`.`persoana` (`idpersoana(CNP)`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `politaId`
  FOREIGN KEY (`politaId`)
  REFERENCES `asigurariauto_db`.`polita` (`idpolita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`polita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`polita` (
  `idpolita` INT(11) NOT NULL AUTO_INCREMENT,
  `dataInceput` DATE NOT NULL,
  `dataSfarsit` DATE NOT NULL,
  `nrChitanta` INT(11) NOT NULL,
  `vehicolId` VARCHAR(17) NOT NULL,
  `idAsigurat` BIGINT(13) NOT NULL,
  PRIMARY KEY (`idpolita`),
  UNIQUE INDEX `idpolita_UNIQUE` (`idpolita` ASC),
  INDEX `nrChitanta_idx` (`nrChitanta` ASC),
  INDEX `idVehicol_idx` (`vehicolId` ASC),
  INDEX `idAsigurat_idx` (`idAsigurat` ASC),
  CONSTRAINT `idAsigurat`
  FOREIGN KEY (`idAsigurat`)
  REFERENCES `asigurariauto_db`.`persoana` (`idpersoana(CNP)`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idVehicol`
  FOREIGN KEY (`vehicolId`)
  REFERENCES `asigurariauto_db`.`vehicol` (`idSerieSasiu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nrChitanta`
  FOREIGN KEY (`nrChitanta`)
  REFERENCES `asigurariauto_db`.`chitanta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`adresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`adresa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `oras` VARCHAR(20) NOT NULL,
  `strada` VARCHAR(45) NOT NULL,
  `numar` INT(11) NOT NULL,
  `idPersoana` BIGINT(13) NOT NULL,
  `idPolitaAdress` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `idPersoana_idx` (`idPersoana` ASC),
  INDEX `idPolitaAdress_idx` (`idPolitaAdress` ASC),
  CONSTRAINT `idPersoana`
  FOREIGN KEY (`idPersoana`)
  REFERENCES `asigurariauto_db`.`persoana` (`idpersoana(CNP)`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPolitaAdress`
  FOREIGN KEY (`idPolitaAdress`)
  REFERENCES `asigurariauto_db`.`polita` (`idpolita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`despagubire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`despagubire` (
  `iddespagubire` INT(11) NOT NULL AUTO_INCREMENT,
  `dataDespagubire` DATE NOT NULL,
  `sumaDespagubire` DECIMAL(4,0) NOT NULL,
  `descriereAvarii` VARCHAR(45) NOT NULL,
  `idPolitaValabila` INT(11) NOT NULL,
  `idPersoanaImplicata` BIGINT(13) NULL DEFAULT NULL,
  PRIMARY KEY (`iddespagubire`),
  UNIQUE INDEX `iddespagubire_UNIQUE` (`iddespagubire` ASC),
  INDEX `idPolitaValabila_idx` (`idPolitaValabila` ASC),
  INDEX `idPersoanaImplicata_idx` (`idPersoanaImplicata` ASC),
  CONSTRAINT `idPersoanaImplicata`
  FOREIGN KEY (`idPersoanaImplicata`)
  REFERENCES `asigurariauto_db`.`persoana` (`idpersoana(CNP)`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPolitaValabila`
  FOREIGN KEY (`idPolitaValabila`)
  REFERENCES `asigurariauto_db`.`polita` (`idpolita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`plata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`plata` (
  `idplati` INT(11) NOT NULL AUTO_INCREMENT,
  `salar` DECIMAL(4,0) NULL DEFAULT NULL,
  `comisionS` DECIMAL(4,0) NULL DEFAULT NULL,
  `comision` DECIMAL(4,0) NULL DEFAULT NULL,
  `despagubireId` INT(11) NULL DEFAULT NULL,
  `persoanaPlatitaId` BIGINT(13) NOT NULL,
  PRIMARY KEY (`idplati`),
  UNIQUE INDEX `idplati_UNIQUE` (`idplati` ASC),
  INDEX `persoanaPlatitaId_idx` (`persoanaPlatitaId` ASC),
  INDEX `despagubireId_idx` (`despagubireId` ASC),
  CONSTRAINT `despagubireId`
  FOREIGN KEY (`despagubireId`)
  REFERENCES `asigurariauto_db`.`despagubire` (`iddespagubire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `persoanaPlatitaId`
  FOREIGN KEY (`persoanaPlatitaId`)
  REFERENCES `asigurariauto_db`.`persoana` (`idpersoana(CNP)`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
