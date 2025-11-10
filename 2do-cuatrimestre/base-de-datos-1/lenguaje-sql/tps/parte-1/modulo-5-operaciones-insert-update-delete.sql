CREATE DATABASE IF NOT EXISTS gestionacademica;
USE gestionacademica;

CREATE TABLE IF NOT EXISTS carreras (
  id INT PRIMARY KEY,
  nombre_carrera VARCHAR(100),
  duracion TINYINT,
  departamento VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS alumnos (
  id INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  edad TINYINT,
  id_carrera INT,
  FOREIGN KEY (id_carrera) REFERENCES carreras(id)
);

CREATE TABLE IF NOT EXISTS asignaturas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  creditos INT,
  id_carrera INT,
  FOREIGN KEY (id_carrera) REFERENCES carreras(id)
);

INSERT INTO carreras VALUES (1,'CIENCIA DE DATOS',5,'SISTEMAS');
INSERT INTO carreras VALUES (2,'ANALISIS DE DATOS',3,'SISTEMAS');
INSERT INTO carreras VALUES (3,'DISEÑO WEB',3,'ARTES Y DISEÑO');

INSERT INTO alumnos SET id = 101, nombre='Juan', apellido='Soto', edad=25, id_carrera=1;
INSERT INTO alumnos SET id = 102, nombre='Gabriela', apellido='Ruiz', edad=35, id_carrera=2;
INSERT INTO alumnos SET id = 103, nombre='Diego', apellido='Lopez', edad=29, id_carrera=3;
INSERT INTO alumnos SET id = 104, nombre='Mariela', apellido='Puertas', edad=19, id_carrera=1;

INSERT INTO asignaturas (nombre, creditos, id_carrera) VALUES
('Programación I', 8, 1),
('Matemática', 12, 2),
('Base de Datos I', 8, 3);

UPDATE alumnos SET nombre = 'Juan Domingo' WHERE id = 101;
UPDATE asignaturas SET nombre = 'BASE DE DATOS I', creditos = 15 WHERE id = 3;

DELETE FROM alumnos WHERE id = 103;
DELETE FROM asignaturas WHERE id_carrera = 1 AND creditos = 8;
