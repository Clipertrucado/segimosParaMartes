<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="<c:url value='/css/styles.css' />">
<title>Bienvenido a mi Formulario</title>

</head>
<body>
	<!-- Formulario de registro para Clubes -->
	<div class="container-form sign-up club-sign-up">
		<div class="welcome-back">
			<div class="message">
				<h2>Bienvenido a Bikers</h2>
				<p>Si ya tienes una cuenta por favor inicia sesión aquí</p>
				<button class="sign-up-btn active">Iniciar Sesión</button>
			</div>
		</div>
		<form class="formulario" id="form_registro_club" action="/darAltaClub"
			method="POST">
			<u style="display: inline;">Club</u>
			<p class="sign-up-btn sign-up-user" style="display: inline;">&nbsp;Usuario</p>
			<h2 class="create-account">Crear una cuenta de Club</h2>
			<div class="iconos">
				<div class="border-icon">
					<i class='bx bxl-instagram'></i>
				</div>
				<div class="border-icon">
					<i class='bx bxl-apple'></i>
				</div>
				<div class="border-icon">
					<i class='bx bxl-facebook-circle'></i>
				</div>
			</div>
			<input type="text" placeholder="Nombre del club" id="nombre_club"
				name="nombreClub" required> <input type="text"
				placeholder="Colores del club" id="colores_club" name="coloresClub"
				required> <input type="email" placeholder="Mail del club"
				id="mail_club" name="mailClub" required> <input
				type="password" placeholder="Contraseña" id="contraseña_club"
				name="contraseniaClub" required> <input type="password"
				placeholder="Confirmar Contraseña" id="confirmar_contraseña"
				required>
			<button class="botoncito" type="submit" value="Registrarse Clubs">Crear
				Club</button>
		</form>
	</div>

	<!-- Formulario de registro para Usuarios -->
	<div class="container-form sign-up user-sign-up">
		<div class="welcome-back">
			<div class="message">
				<h2>Bienvenido a Bikers</h2>
				<p>Si ya tienes una cuenta por favor inicia sesión aquí</p>
				<button class="sign-up-btn active">Iniciar Sesión</button>
			</div>
		</div>
		<form class="formulario" id="form_registro_usuario" action="/addUsu"
			method="POST">
			<p class="sign-up-btn sign-up-club" style="display: inline;">Club&nbsp;</p>
			<u style="display: inline">Usuario</u>
			<h2 class="create-account">Crear una cuenta de Usuario</h2>
			<div class="iconos">
				<div class="border-icon">
					<i class='bx bxl-instagram'></i>
				</div>
				<div class="border-icon">
					<i class='bx bxl-apple'></i>
				</div>
				<div class="border-icon">
					<i class='bx bxl-facebook-circle'></i>
				</div>
			</div>
			<!-- IMPORTANTE: Agregar el atributo name -->
			<input type="text" name="nombre" id="nombre" placeholder="Nombre"
				required> <input type="text" name="apellidos" id="apellidos"
				placeholder="Apellidos" required> <input type="date"
				name="fechaNacimiento" id="fechaNacimiento"
				placeholder="Fecha de Nacimiento" required> <input
				type="email" name="email" id="email" placeholder="Email" required>
			<input type="tel" name="telefono" id="telefono"
				placeholder="Teléfono" required> <input type="text"
				name="nick" id="nick" placeholder="Nick" required> <input
				type="text" name="dni" id="dni" placeholder="DNI" required>
			<input type="password" name="contrasenya" id="contrasenya"
				placeholder="Contraseña" required> <input type="password"
				name="confirmarContrasenya" id="confirmarContrasenya"
				placeholder="Confirmar Contraseña" required
				oninput="this.setCustomValidity(this.value !== document.getElementById('contrasenya').value ? 'Las contraseñas no coinciden.' : '')">
			<button class="botoncito" type="submit" value="Registrarse Usuario">Crear
				Usuario</button>
		</form>

	</div>

	<!-- Formulario de Inicio de Sesión -->
	<div class="container-form sign-in active">
		<form class="formulario" id="form_login" action="/login" method="post">
			<h2 class="create-account">Iniciar Sesión</h2>
			<div class="iconos">
				<div class="border-icon">
					<i class='bx bxl-instagram'></i>
				</div>
				<div class="border-icon">
					<i class='bx bxl-apple'></i>
				</div>
				<div class="border-icon">
					<i class='bx bxl-facebook-circle'></i>
				</div>
			</div>
			<p class="cuenta-gratis">¿Aún no tienes una cuenta?</p>
			<input type="email" id="mail" name="mail" placeholder="Email"
				required> <input type="password" id="contrasenya"
				name="contrasenya" placeholder="Contraseña" required>
			<button class="botoncito" type="submit" value="Iniciar Sesión">Iniciar
				Sesion</button>

		</form>
		<div class="welcome-back">
			<div class="message">
				<h2>Bienvenido de nuevo</h2>
				<p>Si aún no tienes una cuenta, regístrate aquí:</p>
				<button class="sign-in-btn sign-up-club">Registrarse Club</button>
				<button class="sign-in-btn sign-up-user">Registrarse
					Usuario</button>
			</div>
		</div>
	</div>
	<div>
		<span th:text="${good}"></span>
	</div>
	<script src="<c:url value='/js/script.js' />"></script>
</body>
</html>