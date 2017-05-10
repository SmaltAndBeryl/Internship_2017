CREATE SCHEMA IF NOT EXISTS scgj;
GRANT ALL PRIVILEGES ON *.* TO 'scgj_db_user'@'localhost' IDENTIFIED BY 'scgj1234$$' with GRANT option;
GRANT SELECT  ON `scgj`.* TO 'scgj_user'@'localhost' IDENTIFIED BY 'myteam';
GRANT SELECT,UPDATE,INSERT,DELETE  ON `scgj`.* TO 'scgj_app_user'@'localhost' IDENTIFIED BY 'ScGjApp123$$';
