# -*- coding: utf-8 -*-
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
# Integrantes:
# 
#       Ana Maria Chipres Castellanos - #14210475
#       Miguel Angel Pasillas Luis    - #14210423
#       Andrea Carolina Romero Vega   - #142104
#       Anthon Brian Rodiguez Rojas   - #142104
# 
# ###############################################################
# ###############################################################
# ###############################################################

import os # Limpiar pantalla
import MySQLdb  #Permite la conexion de base de datos

DB_HOST = 'localhost' 
DB_USER = 'root' 
DB_PASS = '' 
DB_NAME = 'EstacionamientoTec13' # <<<------- Modificar Base de datos
 
def run_query(query=''): 
	datos = [DB_HOST, DB_USER, DB_PASS, DB_NAME] 
 
	conn = MySQLdb.connect(*datos) # Conectar a la base de datos 
	cursor = conn.cursor()         # Crear un cursor 
	cursor.execute(query)          # Ejecutar una consulta 
 
	if query.upper().startswith('SELECT'): 
		data = cursor.fetchall()   # Traer los resultados de un select 
	else: 
		conn.commit()              # Hacer efectiva la escritura de datos 
		data = None 
 
	cursor.close()                 # Cerrar el cursor 
	conn.close()                   # Cerrar la conexión 
 
	return data

# Metodo Limpiar
def Limpiar():
	# Limpiado pantalla
	os.system ("cls")

# Validacion de Numeros Enteros
def ValidarInt(ent):
	try:
		int(ent)
		return False
	except ValueError:
		return True

# Metodo que mostraran mensajes al incio de pantalla
def pantallaPrincipal():
	print "\t\t\t\t***********************"
	print "\t\t\t\t* Estacionamiento Tec *"
	print "\t\t\t\t***********************"

def pantallaSecundaria():
	print "\n\t########################################################################################\n"
	print "\t\t _____    _             _                             _            _         "
	print "\t\t|  ___|  | |           (_)                           (_)          | |        "
	print "\t\t| |__ ___| |_ __ _  ___ _  ___  _ __   __ _ _ __ ___  _  ___ _ __ | |_ ___   "
	print "\t\t|  __/ __| __/ _` |/ __| |/ _ \| '_ \ / _` | '_ ` _ \| |/ _ \ '_ \| __/ _ \  "
	print "\t\t| |__\__ \ || (_| | (__| | (_) | | | | (_| | | | | | | |  __/ | | | || (_) | "
	print "\t\t\____/___/\__\__,_|\___|_|\___/|_| |_|\__,_|_| |_| |_|_|\___|_| |_|\__\___/  "                                                                          
	print "\t\t\t\t\t _____          "
	print "\t\t\t\t\t|_   _|         "
	print "\t\t\t\t\t  | | ___  ___  "
	print "\t\t\t\t\t  | |/ _ \/ __| "
	print "\t\t\t\t\t  | |  __/ (__  "
	print "\t\t\t\t\t  \_/\___|\___| "
	print "\n\t########################################################################################"
	print "\t\t*******************************************************************"
	print "\t\t*  1.- Ingresar un profesor al estacionamiento.                   *"
	print "\t\t*******************************************************************"
	print "\t\t*  2.- Elimnar profesor del estacionamiento.                      *"
	print "\t\t*******************************************************************"
	print "\t\t*  3.- Ver los profesores que estan usando un estacionamiento.    *"
	print "\t\t*******************************************************************"
	print "\t\t*  4.- Ver los registros del estacionamiento.                     *"
	print "\t\t*******************************************************************"
	print "\t\t*  5.- Salir                                                      *"
	print "\t\t*******************************************************************"
def pantallaMenu1():
	print "\n\t\t*******************************************************************"
	print "\t\t*           1.- Ingresar un profesor al estacionamiento           *"
	print "\t\t*******************************************************************"
	print "\t\t*  Cuando el profesor ingresa al estacionamiento debera de ser    *"
	print "\t\t*  registrado en este formulario.                                 *"
	print "\t\t*******************************************************************"
def pantallaMenu2():
	print "\t\t*******************************************************************"
	print "\t\t*           2.- Elimnar profesor del estacionamiento.             *"
	print "\t\t*******************************************************************"
	print "\t\t*  Cuando el profesor desocupa un estacionamiento tiene que ser   *"
	print "\t\t*  eliminado de la base de datos para dar espacio a otros         *"
	print "\t\t*  profesores.                                                    *"
	print "\t\t*******************************************************************"
def pantallaMenu3():
	print "\t\t*******************************************************************"
	print "\t\t*   3.- Ver los profesores que estan usando un estacionamiento.   *"
	print "\t\t*******************************************************************"
	print "\t\t*  Muestra los profesores actuales que estan ocupando un lugar.   *"
	print "\t\t*******************************************************************"
def pantallaMenu4():
	print "\t\t*******************************************************************"
	print "\t\t*           4.- Ver los registros de los profesores.              *"
	print "\t\t*******************************************************************"
	print "\t\t*           Ver los registros de todos los profesores              *"
	print "\t\t*******************************************************************"

# Metodo que inicia una vez que sea iniciado sesion
def iniciadoSesion():
	# Entrando al ciclo del menu
	while True:
		# Limpiado pantalla
		Limpiar()
		# Mostrar el menu de pantalla
		pantallaSecundaria()
		# Mostrar mensaje de opcion y obteber su valor
		opcionMenuSesion = raw_input("\nOpcion: ")
		# Dependiendo de la eleccion del usuario se ejecutara  
		if opcionMenuSesion == "1": # 1.- Ingresar un profesor al estacionamiento
			# Verificar si todavia hay espacio antes de poder ingresar a un profesor
			queryEspacio = "SELECT Lugares FROM LugaresDisponibles";
			# Ejecutamos la instruccion
			runqueryEspacio = run_query(queryEspacio)
			# Obtenemos el espacio disponible
			for row in runqueryEspacio:
				disponibilida = row[0]
			# Si es igual a cero
			if disponibilida == 0:
				# Mandar aviso
				print "\t\tYa no hay lugares disponibles. Espere a que se desocupen."
				variable =  raw_input("\n\t\tPresione una <ENTER> para salir de la sesion...")
			else:
				# Llamada de metodo: ingresar profesor
				ingresarProfesor()
		elif opcionMenuSesion == "2": # 2.- Elimnar profesor del estacionamiento. 
			# Llamada de metodo: elimnar profesor
			eliminarProfesor()
		elif opcionMenuSesion == "3": # 3.- Ver los profesores que estan usando un estacionamiento.
			# Llamada de metodo: ver los profesores que estan en el estacionamiento
			mostrarProfesores()
		elif opcionMenuSesion == "4": # 4.- Ver los registros de los profesores.
			# Llamada de metodo: ver los registros
			mostrarRegistro()
		elif opcionMenuSesion == "5":
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\t\tPresione una <ENTER> para salir de la sesion...")
			# Salir del programa
			break
		else: # Opcion incorrecta
			print "Opcion incorrecta"
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\t\tPresione una <ENTER> para salir de la sesion...")

# Dara de alta a un profesor
def ingresarProfesor():
	# Limpiar pantalla
	Limpiar()
	# Mostrar menu principal
	pantallaMenu1()
	# Mensaje de ingresar datos
	print "\nIngrese los siguientes datos: "
	# Ingresar la matricula
	Matricula = raw_input("\n\t\tIngrese la matricula del profesor: ")
	# Validar que el dato sea numero
	if ValidarInt(Matricula):
		print "\n\t\tSolo se pueden ingresar numeros. Intente de nuevo."
		# Mensaje de salida y detener pantalla
		variable = raw_input("\n\n\tPresione en <ENTER> para continuar...")
	else:
		# Ingresar la posicion
		Lugar = raw_input("\n\t\tIngrese el numero de estacionamiento: ")
		# Validar que el dato sea numero
		if ValidarInt(Lugar):
			print "\n\t\tSolo se pueden ingresar numeros. Intente de nuevo."
			# Mensaje de salida y detener pantalla
			variable = raw_input("\n\n\tPresione en <ENTER> para continuar...")
		else:
			# Verificar si existe esa matricual (Profesor)
			querybuscarMaestro = "SELECT Nombre, ApellidoPaterno FROM PROFESOR WHERE Matricula = %s" % Matricula
			# Ejecutamos la instruccion
			runQueryIngresarMaestro = run_query(querybuscarMaestro)
			# Si no la encuentra...
			if not runQueryIngresarMaestro:
				# Mostrar mensaje
				print "\n\n\tLa matricula \"",Matricula,"\" no existe. Intentelo de nuevo."
				# Mensaje de salida y detener pantalla
				variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
			else:
				# Buscamos el num de lugar
				queryBuscarDuplicado = "SELECT IdMatriculaOcupado FROM LUGAROCUPADO WHERE IdMatriculaOcupado = %s" % Matricula
				# Correr la instruccion de arriba
				runMatriculaRepetida = run_query(queryBuscarDuplicado)
				# Si la encuentro...
				if runMatriculaRepetida:
					# Mostrar mensaje
					print "\n\n\tLa matricula \"",Matricula,"\" ya esta ingresada. Intentelo de nuevo con otra matricula."
					# Mensaje de salida y detener pantalla
					variable = raw_input("\n\n\tPresione en <ENTER> para continuar...")
				else:
					# Transformar de string a int
					L = int(Lugar)
					# Si es un menor a 1 y mayor a 40...
					if not ( L >=1 and L <=40 ):
						# Mostrar mensaje
						print "\n\n\tEliga un lugar del 1 al 40. Intentelo de nuevo con otro lugar."
						# Mensaje de salida y detener pantalla
						variable = raw_input("\n\n\tPresione en <ENTER> para continuar...")
					else:
						# Buscamos el lugar si esta disponibles
						queryBuscarLugar = "SELECT * FROM LUGAROCUPADO WHERE Lugar = %s" % Lugar
						# Correr la instruccion de arriba
						runLugarRepetido = run_query(queryBuscarLugar)
						# Si encuentra el lugar
						if runLugarRepetido:
							# Mostrar mensaje
							print "\n\n\tEl lugar que eligio ya esta en uso. Intentelo de nuevo con otro lugar."
							# Mensaje de salida y detener pantalla
							variable = raw_input("\n\n\tPresione en <ENTER> para continuar...")
						else:
							# Ingresar el profesor en tabla de Ocupados
							queryIngresarMaestro = "INSERT INTO LUGAROCUPADO (IdMatriculaOcupado,Lugar) VALUES (%s, %s)" % (Matricula,Lugar)
							# Correr la instruccion de arriba
							run_query(queryIngresarMaestro)
							# Restar uno al tabla LugaresDisponibles
							queryRestarEspacio = "UPDATE LugaresDisponibles SET Lugares = Lugares - 1 WHERE Espacio = 1"
							 # Correr la instruccion de arriba
							run_query(queryRestarEspacio)
							# Mostrar el mensaje cuando sea correcto
							print "\n\n\t\t*********************************************************************"
							print "\t\t*    Se ha agregado correctamente la matricula \"",Matricula,"\"            *"
							print "\t\t*    al estacionamiento.                                            *"
							print "\t\t*********************************************************************"
							# Mensaje de salida y detener pantalla
							variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")

# Eliminar profesor
def eliminarProfesor():
	# Limpiar pantalla
	Limpiar()
	# Mostrar menu principal
	pantallaMenu2()
	print "\n\t\t\tIngrese de que forma en que desea desocupar el Lugar: "
	print "\n\t1.- Matricula"
	print "\t2.- Lugar Ocupado"
	opcion = raw_input("\n\tOpcion: ")

	if opcion == '1':
		eliminarPorMatricula()
	elif opcion == '2':
		eliminarPorLugar()
	else:
		print "\nOpcion incorrecta."
		# Mensaje de salida y detener pantalla
		variable =  raw_input("\n\t\tPresione una <ENTER> para salir de la sesion...")
	

# Eliminar por matricula
def eliminarPorMatricula():
	# Limpiar pantalla
	Limpiar()
	# Mostrar menu principal
	pantallaMenu2()
	# Mensaje de ingresar datos
	print "\nIngrese los siguientes datos: "
	# Ingresar la matricula
	Matricula = raw_input("\n\t\tIngrese la matricula del profesor: ")
	 # Validar que el dato sea numero
	if ValidarInt(Matricula):
		print "\n\t\tSolo se pueden ingresar numeros. Intente de nuevo."
		# Mensaje de salida y detener pantalla
		variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
	else:
		# Verificar si existe esa matricual (Profesor)
		querybuscarMaestro = "SELECT Nombre, ApellidoPaterno FROM PROFESOR WHERE Matricula = %s" % Matricula
		# Ejecutamos la instruccion
		runQueryIngresarMaestro = run_query(querybuscarMaestro)
		# Si no la encuentra...
		if not runQueryIngresarMaestro:
			# Mostrar mensaje
			print "\n\n\tLa matricula \"",Matricula,"\" no existe. Intentelo de nuevo."
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
		else:
			# Buscar la misma Matricula
			queryBuscarDuplicado = "SELECT IdMatriculaOcupado, Entr, Lugar FROM LUGAROCUPADO WHERE IdMatriculaOcupado = %s" % Matricula
			# Correr la instruccion de arriba
			runMatriculaRepetida = run_query(queryBuscarDuplicado)
			# Si no la encuentra...
			if not runMatriculaRepetida:
				# Mostrar mensaje
				print "\n\n\tLa matricula \"",Matricula,"\" no ha sido ingresada. Intentelo de nuevo con otra matricula."
				# Mensaje de salida y detener pantalla
				variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
			else:
				# Ingresar el profesor en tabla de Ocupados
				queryIngresarMaestro = "DELETE FROM LUGAROCUPADO WHERE IdMatriculaOcupado = (%s)" % Matricula
				# Correr la instruccion de arriba
				run_query(queryIngresarMaestro)
				# Suma uno al tabla LugaresDisponibles
				queryRestarEspacio = "UPDATE LugaresDisponibles SET Lugares = Lugares + 1 WHERE Espacio = 1"
				# Correr la instruccion de arriba
				run_query(queryRestarEspacio)
				# Actualizar datos
				for row in runMatriculaRepetida:
					matri = row[0]
					entr = row[1]
					pos = row[2]
				# Query para actulizar
				queryActulizar = "INSERT INTO REGISTRO (IdMatricula, Entrada, Lugar) VALUES ('%s', '%s', '%s')" % (matri, entr, pos)
				# Correr la instruccion de arriba
				run_query(queryActulizar)
				# Mostrar el mensaje cuando sea correcto
				print "\n\n\t\t*********************************************************************"
				print "\t\t*    Se ha quitado correctamente el profeosr del estacionamiento.     *"
				print "\t\t*********************************************************************"
				# Mensaje de salida y detener pantalla
				variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")

# Eliminar por Lugar
def eliminarPorLugar():
	# Limpiar pantalla
	Limpiar()
	# Mostrar menu principal
	pantallaMenu2()
	# Mensaje de ingresar datos
	print "\nIngrese los siguientes datos: "
	# Ingresar la matricula
	Lugar = raw_input("\n\t\tIngrese el Lugar del profesor: ")
	# Validar que el dato sea numero
	if ValidarInt(Lugar):
		print "\n\t\tSolo se pueden ingresar numeros. Intente de nuevo."
		# Mensaje de salida y detener pantalla
		variable = raw_input("\n\n\tPresione en <ENTER> para continuar...")
	else:
		# Verificar si existe ese lugar
		querybuscarLugar = "SELECT IdMatriculaOcupado, Entr, Lugar FROM LUGAROCUPADO WHERE Lugar = %s" % Lugar
		# Ejecutamos la instruccion
		runQueryIngresarLugar = run_query(querybuscarLugar)
		# Si no la encuentra...
		if not runQueryIngresarLugar:
			# Mostrar mensaje
			print "\n\n\tEl lugar \"" + Lugar + "\" esta disponible. Intente con otro lugar."
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
		else:
			# Ingresar el profesor en tabla de Ocupados
			queryIngresarMaestro = "DELETE FROM LUGAROCUPADO WHERE Lugar = (%s)" % Lugar
			# Correr la instruccion de arriba
			run_query(queryIngresarMaestro)
			# Suma uno al tabla LugaresDisponibles
			queryRestarEspacio = "UPDATE LugaresDisponibles SET Lugares = Lugares + 1 WHERE Espacio = 1"
			# Correr la instruccion de arriba
			run_query(queryRestarEspacio)
			# Actualizar datos
			for row in runQueryIngresarLugar:
				matri = row[0]
				entr = row[1]
				pos = row[2]
			# Query para actulizar
			queryActulizar = "INSERT INTO REGISTRO (IdMatricula, Entrada, Lugar) VALUES ('%s', '%s', '%s')" % (matri, entr, pos)
			# Correr la instruccion de arriba
			run_query(queryActulizar)
			# Mostrar el mensaje cuando sea correcto
			print "\n\n\t\t*********************************************************************"
			print "\t\t*    Se ha desocupado correctamente el lugar "+Lugar+".               *"
			print "\t\t*********************************************************************"
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")

# Mostrar los profesores que estan ingresados
def mostrarProfesores():
	# Limpiar pantalla
	Limpiar()
	# Mostrar menu principal
	pantallaMenu3()
	# Seleccionar en los profesores
	queryMostrarProfesores = "SELECT LUGAROCUPADO.IdMatriculaOcupado, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(LUGAROCUPADO.Entr, '%e %M') AS Fecha, DATE_FORMAT(LUGAROCUPADO.Entr, '%H:%i') AS Hora, LUGAROCUPADO.Lugar FROM LUGAROCUPADO,PROFESOR WHERE LUGAROCUPADO.IdMatriculaOcupado = PROFESOR.Matricula"
	# Correr la instruccion anterior
	runQueryMostrarOcupados = run_query(queryMostrarProfesores)
	# Mostrar tabla
	print "\n\n/+++++++++++++|+++++++++++++++|+++++++++++++++++++++|+++++++++++++++++|++++++++++++++++|++++++++++++++++\\"
	print "|Matricula\tNombre\t\tApellido\t\tHora\t\tFecha\t\tLugar"
	print "|+++++++++++++|+++++++++++++++|+++++++++++++++++++++|+++++++++++++++++|++++++++++++++++|++++++++++++++++\\"
	# Mostrar los datos
	for row in runQueryMostrarOcupados:
		matri = row[0]
		# matri2 = row[1]
		nom = row[2]
		ape = row[3]
		fecha = row[4]
		hora = row[5]
		l = row[6]
		print "| %s \t%s \t\t%s \t\t\t%s \t\t%s \t%s" % (matri,nom,ape,hora,fecha,l)
	# Imprimir marco
	print "\\+++++++++++++|+++++++++++++++|+++++++++++++++++++++|+++++++++++++++++|+++++++++++++++++++++++++++++++++/"
	# Mensaje de salida y detener pantalla
	variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")

# Mostrar registro de los profesores
def mostrarRegistro():
	# Limpiar pantalla
	Limpiar()
	# Mostrar menu principal
	pantallaMenu4()
	# Seleccionar en los profesores
	queryMostrarProfesores = "SELECT REGISTRO.IdMatricula, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(REGISTRO.Entrada, '%e %M') AS FechaLlegada, DATE_FORMAT(REGISTRO.Entrada, '%H:%i') AS HoraLlegada, DATE_FORMAT(REGISTRO.Salida, '%e %M') AS FechaSalida, DATE_FORMAT(REGISTRO.Salida, '%H:%i') AS HoraSalida, REGISTRO.Lugar FROM REGISTRO,PROFESOR WHERE REGISTRO.IdMatricula = PROFESOR.Matricula"
	# Correr la instruccion anterior
	runQueryMostrarOcupados = run_query(queryMostrarProfesores)
	# Mostrar tabla
	print "\n\n/+++++++++++++|+++++++|++++++++++++|++++++++++++++++++|+++++++++++++++|+++++++++++++++|++++++++++++|++++++\\"
	print "|Matricula\tNombre\tApellido\tFechaLlegada\tHoraLlegada\tFechaSalida\tHoraSalida     L"
	print "|+++++++++++++|+++++++|++++++++++++|++++++++++++++++++|+++++++++++++++|+++++++++++++++|++++++++++++|++++++\\"
	# Mostrar los datos
	for row in runQueryMostrarOcupados:
		matri = row[0]
		# matri2 = row[1]
		nom = row[2]
		ape = row[3]
		fechaLlegada = row[4]
		horaLlegada = row[5]
		fechaSalida = row[6]
		horaSalida = row[7]
		pos = row[8]
		print "|  %s \t%s \t%s \t\t%s \t%s \t\t%s \t%s         %s" % (matri,nom,ape,fechaLlegada,horaLlegada,fechaSalida,horaSalida, pos)
	# Imprimir marco
	print "\+++++++++++++|+++++++|++++++++++++|++++++++++++++++++|+++++++++++++++|+++++++++++++++|++++++++++++|++++++/"
	# Mensaje de salida y detener pantalla
	variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")

##
####
######
########
##########
############
##############
################
##################
####################
######################
#######################
# INICIO DEL PROGRAMA ##
#######################
######################
####################
##################
################
##############
############
##########
########
######
####
##


# Ciclo que se repetira hasta que se rompa (break)
while True:
	# Limpiado pantalla
	Limpiar()
	# Mostrar mensaje principal
	pantallaPrincipal()
	# Mostrar opciones disponibles
	print "\n\t1.- Iniciar Sesion"
	print "\n\t2.- Salir"
	# Mostrar mensaje de opcion y obteber su valor
	opcionPrincipal = raw_input("\nOpcion: ")
	# Dependiendo de la eleccion del usuario se ejecutara
	if opcionPrincipal == "1": # Opcion: Iniciar sesion
		# Limpiado pantalla
		Limpiar()
		# Mostrar mensaje principal
		pantallaPrincipal()
		# Obtener los valores del usuario
		usuarioPrincipal = raw_input("\n\t\tIngrese su usuario: ")
		passPrincipal = raw_input("\n\t\tIngrese su password: ")
		# Seleccioar la base de datos en la tabla Profesores
		# si hay un usuario con estos valores, iniciara secion
		# si son erroneos no lo dejara entrar
		querySesion = "SELECT usuario,pass FROM USUARIO WHERE usuario = '%s' AND pass = '%s'" % (usuarioPrincipal,passPrincipal)
		# Ejecutamos la instruccion
		runQuerySesion = run_query(querySesion)
		# Si regresa valor nulo es que no existe el usuairo
		# Si regresa algo es que existe el usuario.
		if not runQuerySesion: # Si no son correctos el usuario y la contraseña
			# Mostrar el mensaje cuando no son los datos correctos
			print "\n\n\t-> Error: Ingrese su usuario y password correcto. Intentelo de nuevo."
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
		else: # Cuando los datos introducidos son correctoss
			# Mostrar el mensaje cuando los datos sena correctos
			print "\n\n\t\t\t**************************************"
			print "\t\t\t* Haz iniciado sesion correctamente. *"
			print "\t\t\t**************************************"
			# Mensaje de salida y detener pantalla
			variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")
			# Llamar al metodo
			iniciadoSesion()
	elif opcionPrincipal == "2": # Opcion: Salir del programa
		# Mensaje de salida
		print "\n\n\tPresione una <ENTER> para salir del sistema..."
		# Detener pantalla
		variable = raw_input()
		# Saliendo del ciclo
		break
	else: # Opcion: Equivocada
		# Mensaje de opcion incorrecta
		print "\n\n\t\t\t*******************************************"
		print "\t\t\t* Eliga una opcion correcta para continuar. *"
		print "\t\t\t*******************************************"
		# Mensaje de salida y detener pantalla
		variable =  raw_input("\n\n\tPresione en <ENTER> para continuar...")

# Limpiado pantalla
Limpiar()