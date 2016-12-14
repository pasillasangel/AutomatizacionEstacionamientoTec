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

/*
			##################################################################
			##################################################################
			##################################################################
						   ___                    _             
						  / __\ __ ___  __ _  ___(_) ___  _ __  
						 / / | '__/ _ \/ _` |/ __| |/ _ \| '_ \ 
						/ /__| | |  __/ (_| | (__| | (_) | | | |
						\____/_|  \___|\__,_|\___|_|\___/|_| |_|
																
			##################################################################
            ##################################################################
            ##################################################################
*/


CREATE DATABASE EstacionamientoTec13
USE EstacionamientoTec13
/*
	##################################################################
	Usuario: Los usuarios que tiene permiso de poder acceder a la 
    base de datos.
    ##################################################################
*/
CREATE TABLE USUARIO
(
	iduser int primary key,
	usuario varchar(30),
    pass varchar(30)
)
/*
	##################################################################
	Profesores: Almacena todos los datos de los docentes que tiene
    derecho a usar el estacionamiento de Profesores.
    ##################################################################
*/
Create table PROFESOR
(
	Matricula int primary key,
	ApellidoPaterno varchar(30),
	ApellidoMaterno varchar(30),
	Nombre varchar (20),
	Departamento varchar (15),
	Telefono varchar(15)
)
/*
	##################################################################
	Lugar Ocupado: Tabla que guarda las matriculares, la hora y fecha
    y la posicion en que se aguarda un auto.
    ##################################################################
*/
CREATE TABLE LUGAROCUPADO
(
	IdMatriculaOcupado int UNIQUE,
	Entr TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Lugar int,
    
    FOREIGN KEY fk_m (IdMatriculaOcupado) REFERENCES PROFESOR(Matricula)
)
/*
	##################################################################
	Registro: Tabla que guarda toda la informacion de todos las
    matriculas de las que han ocupado un estacionamiento..
    ##################################################################
*/
CREATE TABLE REGISTRO
(
	IdRegistro int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	IdMatricula int,
	Lugar int,
    Entrada DATETIME,
    Salida TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)
/*
	##################################################################
	Lugares Disponibles: Tabla que guarda los lugares disponibles,
    se restara y se sumara cada vez que se ingrese o se elimine un
    registro de la tabla 'LugarOcupado'.
    ##################################################################
*/
CREATE TABLE LugaresDisponibles
(
	Espacio int,
	Lugares int default 40 
)

/*
			##################################################################
			##################################################################
			##################################################################
					  _____                         _             
					  \_   \_ __  ___  ___ _ __ ___(_) ___  _ __  
					   / /\/ '_ \/ __|/ _ \ '__/ __| |/ _ \| '_ \ 
					/\/ /_ | | | \__ \  __/ | | (__| | (_) | | | |
					\____/ |_| |_|___/\___|_|  \___|_|\___/|_| |_|
                    
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
INSERT INTO PROFESOR VALUES (10000, "Fierro", "Garcia", "Raul", "Sistemas", "664-613-32-52");
INSERT INTO PROFESOR VALUES (10101, "Munos", "Torres", "Ivan", "Sistemas", "661-621-81-22");
INSERT INTO PROFESOR VALUES (10102, "Bravo", "Vidal", "Hugo", "Sistemas", "664-634-53-23");
INSERT INTO PROFESOR VALUES (10103, "Blanco", "Escobar", "Luca", "Sistemas", "664-633-18-52");
INSERT INTO PROFESOR VALUES (10104, "Diaz", "Ferrer", "Eric", "Sistemas", "661-103-48-34");
INSERT INTO PROFESOR VALUES (10105, "Flores", "Infante", "Zoe", "Sistemas", "664-614-12-52");
INSERT INTO PROFESOR VALUES (10106, "Lopez", "Vera", "Nora", "Sistemas", "664-643-28-44");
INSERT INTO PROFESOR VALUES (10107, "Ortiz", "Morales", "Sara", "Sistemas", "664-632-14-32");
INSERT INTO PROFESOR VALUES (10108, "Ortega", "Luna", "Ana", "Sistemas", "661-303-45-22");
INSERT INTO PROFESOR VALUES (10109, "Ruiz", "Hidalgo", "Angel", "Sistemas", "664-603-18-52");
INSERT INTO PROFESOR VALUES (10010, "Vega", "Tapia", "Luis", "Sistemas", "664-603-18-52");
INSERT INTO PROFESOR VALUES (10132, "Solis", "Reyes", "Rene", "Sistemas", "664-234-54-43");
INSERT INTO PROFESOR VALUES (10144, "Kamal", "Jimenez", "Maria", "Sistemas", "661-522-32-12");
INSERT INTO PROFESOR VALUES (10123, "Castro", "Herrara", "Rivera", "Sistemas", "664-23-13-23");
INSERT INTO PROFESOR VALUES (10133, "Campos", "Serrano", "Maria", "Sistemas", "664-513-14-23");
INSERT INTO PROFESOR VALUES (10153, "Perez", "Amador", "Martin", "Sistemas", "661-512-33-23");
INSERT INTO PROFESOR VALUES (10121, "Ibarra", "Flores", "Felma", "Sistemas", "664-774-76-22");
INSERT INTO PROFESOR VALUES (10161, "Pena", "Gomez", "Marco", "Sistemas", "664-134-24-10");
INSERT INTO PROFESOR VALUES (10162, "Ramos", "Renteria", "Miguel", "Sistemas", "661-123-11-23");
INSERT INTO PROFESOR VALUES (10122, "Solis", "Reyes", "Rene", "Sistemas", "661-724-34-75");
INSERT INTO PROFESOR VALUES (10177, "Medina", "Cervantes", "Jose", "Sistemas", "661-345-43-34");

-- Disponibles
insert into LugaresDisponibles VALUES (1,default);

/*
			##################################################################
            ##################################################################
            ##################################################################
										  _                  
						  /\/\   ___  ___| |_ _ __ __ _ _ __ 
						 /    \ / _ \/ __| __| '__/ _` | '__|
						/ /\/\ \ (_) \__ \ |_| | | (_| | |   
						\/    \/\___/|___/\__|_|  \__,_|_|   
															 
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
						   ___                      _ _            
						  / __\___  _ __  ___ _   _| | |_ __ _ ___ 
						 / /  / _ \| '_ \/ __| | | | | __/ _` / __|
						/ /__| (_) | | | \__ \ |_| | | || (_| \__ \
						\____/\___/|_| |_|___/\__,_|_|\__\__,_|___/
                                           
			##################################################################
            ##################################################################
            ##################################################################
*/

-- Mostrar la tabla con de los lugares ocupados con sus repectivos nombres
SELECT LUGAROCUPADO.IdMatriculaOcupado, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(LUGAROCUPADO.Entr, '%e %M') AS Fecha, DATE_FORMAT(LUGAROCUPADO.Entr, '%H:%i') AS Hora, LUGAROCUPADO.Lugar FROM LUGAROCUPADO,PROFESOR WHERE LUGAROCUPADO.IdMatriculaOcupado = PROFESOR.Matricula

-- Mostrar el registro de los profesores (entradas y salidas)
SELECT REGISTRO.IdMatricula, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(REGISTRO.Entrada, '%e %M') AS FechaLlegada, DATE_FORMAT(REGISTRO.Entrada, '%H:%i') AS HoraLlegada, DATE_FORMAT(REGISTRO.Salida, '%e %M') AS FechaSalida, DATE_FORMAT(REGISTRO.Salida, '%H:%i') AS HoraSalida FROM REGISTRO,PROFESOR WHERE REGISTRO.IdMatricula = PROFESOR.Matricula

-- Verificar que no esten disponibles lugares
SELECT Lugares FROM LugaresDisponibles

-- 