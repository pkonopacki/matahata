CREATE DATABASE matahata
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_polish_ci;
CREATE USER 'matahata'@'localhost' IDENTIFIED BY 'matahata';
GRANT ALL PRIVILEGES ON *.* TO 'matahata'@'localhost' WITH GRANT OPTION;