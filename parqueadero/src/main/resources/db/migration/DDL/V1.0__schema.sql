CREATE TABLE vehiculo (
  placa VARCHAR(6) NOT NULL,
  tipo VARCHAR(5) NOT NULL,
  cilindraje INT NOT NULL,
  marca VARCHAR(45) NOT NULL,
  modelo VARCHAR(45) NOT NULL,
  fechaIngreso datetime null,
  PRIMARY KEY (placa)
);

--CREATE TABLE historial (
-- id INT NOT NULL AUTO_INCREMENT,
--  fechaIngreso DATETIME NOT NULL,
--  fechaSalida DATETIME NULL,
--  pago FLOAT ZEROFILL NULL,
--  placaVehiculo VARCHAR(6) NOT NULL,
--  PRIMARY KEY (id),
--  INDEX (vehiculo_placa),
--  FOREIGN KEY (vehiculo_placa) REFERENCES vehiculo(placa)
--  ON DELETE NO ACTION
--  ON UPDATE CASCADE
--);