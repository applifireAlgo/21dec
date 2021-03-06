DROP TABLE IF EXISTS `art_app_alarm`;

CREATE TABLE `art_app_alarm` ( `id` varchar(64) NOT NULL , `alarm_id` INT(11) DEFAULT NULL, `severity` INT(11) DEFAULT NULL, `connector_order_id` VARCHAR(45) DEFAULT NULL, `message` TEXT, `diagnose` TEXT, `solution` TEXT, `log_module_id` varchar(64) NOT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` DATETIME DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` INT(1) DEFAULT NULL, PRIMARY KEY (`id`), KEY `fk_art_app_alarm_co_idx` (`connector_order_id`), KEY `fk_art_app_alarm_lm_idx` (`log_module_id`), CONSTRAINT `fk_art_app_alarm_log_module` FOREIGN KEY (`log_module_id`) REFERENCES `art_log_module` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION ) ;

