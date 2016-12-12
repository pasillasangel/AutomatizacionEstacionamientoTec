/*	
    # ###############################################################
	# ###############################################################
	# ###############################################################
	# 
	#       Automatizacion de control de acceso de estacionamiento 
	#       para Profesores del Instituto Tecnologico de Tijuana
	# 
	# ###############################################################
	# ###############################################################
	# ###############################################################
	# 
	# Profesora:
	#       Maria Concepcion Ibarra Gamiz
	# 
	# Clase:
	#       Lenguajes de Programacion
	# 
	# Integrantes
	# 
	#       Ana Maria Chipres Castellanos - #14210475
	#       Miguel Angel Pasillas Luis    - #14210423
	#       Andrea Carolina Romero Vega   - #142104
	#       Anthon Brian Rodiguez Rojas   - #142104
	# 
	# ###############################################################
	# ###############################################################
	# ###############################################################
    
*/


-- CORRER ESTA INSTRUCCION: Solucionando el problema de Actualizacion
SET SQL_SAFE_UPDATES = 0;

create database EstacionamientoTec11

use EstacionamientoTec11

CREATE TABLE USUARIO
(
	iduser int primary key,
	usuario varchar(30),
    pass varchar(30)
)

Create table PROFESOR
(
	Matricula int primary key,
	ApellidoPaterno varchar(30),
	ApellidoMaterno varchar(30),
	Nombre varchar (20),
	Departamento varchar (15),
	Telefono varchar(15)
)

CREATE TABLE LUGAROCUPADO
(
	IdMatriculaOcupado int UNIQUE,
	Entr TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY fk_m (IdMatriculaOcupado) REFERENCES PROFESOR(Matricula)
)

CREATE TABLE REGISTRO
(
	IdRegistro int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	IdMatricula int,
    Entrada DATETIME,
    Salida TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE LugaresDisponibles
(
	Espacio int,
	Lugares int default 40 
)

/*
			##################################################################
			##################################################################
			##################################################################
			INSERCION DE DATOS
			##################################################################
            ##################################################################
            ##################################################################
*/
-- Usuarios por defecto
INSERT INTO USUARIO VALUES (1,"pasillas", "12345");
INSERT INTO USUARIO VALUES (2,"chipres", "12345");
INSERT INTO USUARIO VALUES (3,"rodriguez", "12345");
INSERT INTO USUARIO VALUES (4,"romero", "12345");

-- Profesores
INSERT INTO PROFESOR VALUES (10000, "Fierro", "Garcia", "Resffa", "Sistemas", "664-603-18-52");
INSERT INTO PROFESOR VALUES (10132, "Solis", "Reyes", "Rene", "Sistemas", "664-234-54-43");
INSERT INTO PROFESOR VALUES (10144, "Bermudez", "Jimenez", "Maria", "Sistemas", "661-522-32-12");
INSERT INTO PROFESOR VALUES (10123, "Herrera", "Herrara", "Rivera", "Sistemas", "664-23-13-23");
INSERT INTO PROFESOR VALUES (10133, "Magdalena", "Serrano", "Maria", "Sistemas", "664-513-14-23");
INSERT INTO PROFESOR VALUES (10153, "Perez", "Amador", "Martin", "Sistemas", "661-512-33-23");
INSERT INTO PROFESOR VALUES (10121, "Gonzalez", "Flores", "Felma", "Sistemas", "664-774-76-22");
INSERT INTO PROFESOR VALUES (10161, "Zazueta", "Gomez", "Marco", "Sistemas", "664-134-24-10");
INSERT INTO PROFESOR VALUES (10162, "Ramos", "Renteria", "Miguel", "Sistemas", "661-123-11-23");
INSERT INTO PROFESOR VALUES (10122, "Solis", "Reyes", "Rene", "Sistemas", "661-724-34-75");
INSERT INTO PROFESOR VALUES (10177, "Medina", "Cervantes", "Jose", "Sistemas", "661-345-43-34");

-- Disponibles
insert into LugaresDisponibles VALUES (1,default);

/*
			##################################################################
            ##################################################################
            ##################################################################
			Mostrar tablas
			##################################################################
            ##################################################################
            ##################################################################
*/
SELECT * FROM LugaresDisponibles

SELECT * FROM LUGAROCUPADO

SELECT * FROM REGISTRO

SELECT * FROM PROFESOR

SELECT * FROM USUARIO


/*
			##################################################################
            ##################################################################
            ##################################################################
			Algunas consultas
			##################################################################
            ##################################################################
            ##################################################################
*/

-- Mostrar la tabla con de los lugares ocupados con sus repectivos nombres
SELECT LUGAROCUPADO.IdMatriculaOcupado, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(LUGAROCUPADO.Entr, '%e %M') AS Fecha, DATE_FORMAT(LUGAROCUPADO.Entr, '%H:%i') AS Hora FROM LUGAROCUPADO,PROFESOR WHERE LUGAROCUPADO.IdMatriculaOcupado = PROFESOR.Matricula

-- Mostrar el registro de los profesores (entradas y salidas)
SELECT REGISTRO.IdMatricula, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(REGISTRO.Entrada, '%e %M') AS FechaLlegada, DATE_FORMAT(REGISTRO.Entrada, '%H:%i') AS HoraLlegada, DATE_FORMAT(REGISTRO.Salida, '%e %M') AS FechaSalida, DATE_FORMAT(REGISTRO.Salida, '%H:%i') AS HoraSalida FROM REGISTRO,PROFESOR WHERE REGISTRO.IdMatricula = PROFESOR.Matricula

-- Verificar que no esten disponibles lugares
SELECT Lugares FROM LugaresDisponibles

-- 