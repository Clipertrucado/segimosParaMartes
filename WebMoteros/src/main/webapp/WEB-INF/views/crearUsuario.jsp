<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<title>Registro de Usuarios y Clubes</title>
<style>
.hidden {
	display: none;
}

.form-container {
	width: 50%;
	margin: 0 auto; /* Centra el contenedor horizontalmente */
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Sistema de Registro</a>
		</div>
	</nav>
	<div class="container mt-5">
		<h1 class="text-center">Registro de Usuarios y Clubes</h1>
		<div class="text-center mb-4">
			<!-- Botones para alternar entre formularios -->
			<button id="btnFormUsuario" class="btn btn-primary mx-2">Registrar
				Usuario</button>
			<button id="btnFormClub" class="btn btn-secondary mx-2">Registrar
				Club</button>
		</div>

		<!-- Formulario de registro de usuario -->
		<form id="formUsuario" class="form-container" action="/addUsu"
			method="POST">
			<h3>Crear una Cuenta de Usuario</h3>
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="nombre" name="nombre"
					placeholder="Nombre" required>
			</div>
			<div class="mb-3">
				<label for="apellidos" class="form-label">Apellidos</label> <input
					type="text" class="form-control" id="apellidos" name="apellidos"
					placeholder="Apellidos" required>
			</div>
			<div class="mb-3">
				<label for="fechaNacimiento" class="form-label">Fecha de
					Nacimiento</label> <input type="date" class="form-control"
					id="fechaNacimiento" name="fechaNacimiento" required>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Correo Electrónico</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Email" required>
			</div>
			<div class="mb-3">
				<label for="telefono" class="form-label">Teléfono</label> <input
					type="tel" class="form-control" id="telefono" name="telefono"
					placeholder="Teléfono" required>
			</div>
			<div class="mb-3">
				<label for="nick" class="form-label">Nick</label> <input type="text"
					class="form-control" id="nick" name="nick" placeholder="Nick"
					required>
			</div>
			<div class="mb-3">
				<label for="dni" class="form-label">DNI</label> <input type="text"
					class="form-control" id="dni" name="dni" placeholder="DNI" required>
			</div>
			<div class="mb-3">
				<label for="contrasenya" class="form-label">Contraseña</label> <input
					type="password" class="form-control" id="contrasenya"
					name="contrasenya" placeholder="Contraseña" required>
			</div>
			<div class="mb-3">
				<label for="confirmarContrasenya" class="form-label">Confirmar
					Contraseña</label> <input type="password" class="form-control"
					id="confirmarContrasenya" name="confirmarContrasenya"
					placeholder="Confirmar Contraseña" required
					oninput="this.setCustomValidity(this.value !== document.getElementById('contrasenya').value ? 'Las contraseñas no coinciden.' : '')">
			</div>
			<button type="submit" class="btn btn-primary">Crear Usuario</button>
		</form>

		<!-- Formulario de registro de club -->
		<form id="formClub" class="hidden form-container" action="/addClub"
			method="POST">
			<h3>Crear una Cuenta de Club</h3>
			<div class="mb-3">
				<label for="nombreClub" class="form-label">Nombre del Club</label> <input
					type="text" class="form-control" id="nombreClub" name="nombreClub"
					placeholder="Nombre del Club" required>
			</div>
			<div class="mb-3">
				<label for="emailClub" class="form-label">Correo Electrónico</label>
				<input type="email" class="form-control" id="emailClub"
					name="emailClub" placeholder="Email del Club" required>
			</div>
			<div class="mb-3">
				<label for="contrasenyaClub" class="form-label">Contraseña</label> <input
					type="password" class="form-control" id="contrasenyaClub"
					name="contrasenyaClub" placeholder="Contraseña" required>
			</div>
			<button type="submit" class="btn btn-secondary">Crear Club</button>
		</form>
	</div>

	<script>
        // Alternar visibilidad de formularios
        const btnFormUsuario = document.getElementById('btnFormUsuario');
        const btnFormClub = document.getElementById('btnFormClub');
        const formUsuario = document.getElementById('formUsuario');
        const formClub = document.getElementById('formClub');

        btnFormUsuario.addEventListener('click', () => {
            formUsuario.classList.remove('hidden');
            formClub.classList.add('hidden');
        });

        btnFormClub.addEventListener('click', () => {
            formClub.classList.remove('hidden');
            formUsuario.classList.add('hidden');
        });
    </script>
</body>
</html>