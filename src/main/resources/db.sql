-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema asigurariauto_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema asigurariauto_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `asigurariauto_db` DEFAULT CHARACTER SET utf8 ;
USE `asigurariauto_db` ;

-- -----------------------------------------------------
-- Table `asigurariauto_db`.`persoana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`persoana` (
  `id` INT(11) NOT NULL,
  `cnp` BIGINT(13) NOT NULL,
  `tipPersoana` VARCHAR(45) NOT NULL,
  `nume` VARCHAR(45) NOT NULL,
  `prenume` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefon` BIGINT(10) NOT NULL,
  `idPolita` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnp_UNIQUE` (`cnp` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `idPolita_idx` (`idPolita` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`adresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`adresa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `oras` VARCHAR(45) NOT NULL,
  `strada` VARCHAR(45) NOT NULL,
  `numar` INT(11) NOT NULL,
  `idPersoana` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `idPersoana_idx` (`idPersoana` ASC),
  CONSTRAINT `idPersoana`
  FOREIGN KEY (`idPersoana`)
  REFERENCES `asigurariauto_db`.`persoana` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`vehicol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`vehicol` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idSerieSasiu` BIGINT(17) NOT NULL,
  `nrIdentificare` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `combustibil` VARCHAR(45) NULL DEFAULT NULL,
  `cilindrii` INT(11) NOT NULL,
  `kw` INT(3) NOT NULL,
  `masaMaxAutorizata` INT(5) NOT NULL,
  `dataFabricatiei` DATE NOT NULL,
  `accident` INT(11) NOT NULL,
  `sumaAsigurata` DECIMAL(10,0) NOT NULL,
  `proprietar/asigurat` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idAsigurat_idx` (`proprietar/asigurat` ASC),
  CONSTRAINT `idAsigurat`
  FOREIGN KEY (`proprietar/asigurat`)
  REFERENCES `asigurariauto_db`.`persoana` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`polita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`polita` (
  `id` INT(11) NOT NULL,
  `dataInceput` DATE NOT NULL,
  `dataSfarsit` DATE NOT NULL,
  `chitanta` INT(11) NOT NULL,
  `vehicol` INT(11) NOT NULL,
  `asigurat` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `idChitanta_idx` (`chitanta` ASC),
  INDEX `idVehicol_idx` (`vehicol` ASC),
  INDEX `idAsigurat_idx` (`asigurat` ASC),
  CONSTRAINT `asigurat`
  FOREIGN KEY (`asigurat`)
  REFERENCES `asigurariauto_db`.`persoana` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `chitanta`
  FOREIGN KEY (`chitanta`)
  REFERENCES `asigurariauto_db`.`chitanta` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `vehicol`
  FOREIGN KEY (`vehicol`)
  REFERENCES `asigurariauto_db`.`vehicol` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`chitanta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`chitanta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `suma` DECIMAL(10,0) NOT NULL,
  `descriere` VARCHAR(45) NOT NULL,
  `discount` DECIMAL(10,0) NOT NULL,
  `persoanaId` BIGINT(13) NOT NULL,
  `politaId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `persoanaId_idx` (`persoanaId` ASC),
  INDEX `politaId_idx` (`politaId` ASC),
  CONSTRAINT `persoanaId`
  FOREIGN KEY (`persoanaId`)
  REFERENCES `asigurariauto_db`.`persoana` (`cnp`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `politaId`
  FOREIGN KEY (`politaId`)
  REFERENCES `asigurariauto_db`.`polita` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`despagubire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`despagubire` (
  `id` INT(11) NOT NULL,
  `dataDespagubire` DATE NOT NULL,
  `sumaDespagubire` DECIMAL(10,0) NOT NULL,
  `descriereAvarii` DECIMAL(10,0) NOT NULL,
  `idPolitaValabila` INT(11) NOT NULL,
  `idPersoanaImplicata` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPolitaValabila_idx` (`idPolitaValabila` ASC),
  INDEX `idPersoanaImplicata_idx` (`idPersoanaImplicata` ASC),
  CONSTRAINT `idPersoanaImplicata`
  FOREIGN KEY (`idPersoanaImplicata`)
  REFERENCES `asigurariauto_db`.`persoana` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPolitaValabila`
  FOREIGN KEY (`idPolitaValabila`)
  REFERENCES `asigurariauto_db`.`polita` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `asigurariauto_db`.`plata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asigurariauto_db`.`plata` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cont` VARCHAR(45) NOT NULL,
  `salar` DECIMAL(10,0) NULL DEFAULT NULL,
  `comisionSalar` DECIMAL(10,0) NULL DEFAULT NULL,
  `comision` DECIMAL(10,0) NULL DEFAULT NULL,
  `despagubireId` INT(11) NULL DEFAULT NULL,
  `persoanaPlatitaId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `despagubireId_idx` (`despagubireId` ASC),
  INDEX `persoanaPlatitaId_idx` (`persoanaPlatitaId` ASC),
  CONSTRAINT `despagubireId`
  FOREIGN KEY (`despagubireId`)
  REFERENCES `asigurariauto_db`.`despagubire` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `persoanaPlatitaId`
  FOREIGN KEY (`persoanaPlatitaId`)
  REFERENCES `asigurariauto_db`.`persoana` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
