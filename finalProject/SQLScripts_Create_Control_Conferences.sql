-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema control_conferences
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `control_conferences` DEFAULT CHARACTER SET utf8 ;
USE `control_conferences` ;

DROP TABLE IF EXISTS `control_conferences`.`role`;
DROP TABLE IF EXISTS `control_conferences`.`conference`;
DROP TABLE IF EXISTS `control_conferences`.`user`;
DROP TABLE IF EXISTS `control_conferences`.`report`;
DROP TABLE IF EXISTS `control_conferences`.`user_conference`;


-- -----------------------------------------------------
-- Table `control_conferences`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_conferences`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `control_conferences`.`conference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_conferences`.`conference` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date` DATE NULL,
  `place` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `control_conferences`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_conferences`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `rating` VARCHAR(45) NULL,
  `salary` DECIMAL NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_role_idx` (`role_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `control_conferences`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `control_conferences`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_conferences`.`report` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `text` VARCHAR(45) NULL,
  `speaker_id` INT NOT NULL,
  `conference_id` int ,
  PRIMARY KEY (`id`),
  INDEX `fk_report_user1_idx` (`speaker_id` ASC),
  INDEX `fk_report_conference1_idx` (`conference_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_report_user1`
    FOREIGN KEY (`speaker_id`)
    REFERENCES `control_conferences`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_conference1`
    FOREIGN KEY (`conference_id`)
    REFERENCES `control_conferences`.`conference` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `control_conferences`.`user_conference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_conferences`.`user_conference` (
  `conference_id` INT NULL,
  `user_id` INT NULL,
  `visited` TINYINT(1) NULL,
  `id` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`id`),
  INDEX `fk_user_conference_conference_idx` (`conference_id` ASC),
  INDEX `fk_user_conference_user_idx` (`user_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_user_conference_conference`
    FOREIGN KEY (`conference_id`)
    REFERENCES `control_conferences`.`conference` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_conference_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `control_conferences`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
