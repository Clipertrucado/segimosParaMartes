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
<!-- <link rel="stylesheet" href="<c:url value='/css/styles.css' />"> -->
<title>Bienvenido a mi Formulario</title>
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
			<a class="navbar-brand" href="#">Ventana 1</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Ventana 2</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Ventana 3</a></li>
					<c:if test="${rol == 'admin'}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								ADMIN </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Dar de alta</a></li>
								<li><a class="dropdown-item" href="#">Editar cuenta</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Eliminar cuenta</a></li>
							</ul></li>
					</c:if>
				</ul>

				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="buscar"
						aria-label="buscar">
					<button class="btn btn-outline-success" type="submit">buscar</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<h1 class="text-center">Editar datos de una cuenta</h1>
		<div class="text-center mb-4">
			<!-- Botones para controlar la visibilidad -->
			<button id="btnForm1" class="btn btn-primary mx-2">Club</button>
			<button id="btnForm2" class="btn btn-secondary mx-2">Usuario</button>
		</div>

		<!-- Formulario 1 -->
		<form id="form1" class="hidden form-container"
			action="/editarCuenta/buscarClub" method="post">
			<h3>Buscar Club</h3>
			<div class="mb-3">
				<label for="email1" class="form-label">Correo Electrónico
					del Club</label> <input type="email" class="form-control" id="email1"
					placeholder="Ingresa tu correo" name="mail">
			</div>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>

		<!-- Formulario 2 -->
		<form id="form2" class="hidden form-container"
			action="/editarCuenta/buscarUsuario" method="post">
			<h3>Buscar Club</h3>
			<div class="mb-3">
				<label for="email1" class="form-label">Correo Electrónico
					del Club</label> <input type="email" class="form-control" id="email1"
					placeholder="Ingresa tu correo" name="mail">
			</div>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>

	<c:if test="${not empty club}">
		<!-- Formulario para editar los datos del club -->
		<form id="form1" class="form-container"
			action="/editarCuenta/editarClub" method="post">
			<h3>Editar datos del Club</h3>

			<!-- Campo ID del Club (Solo lectura) -->
			<div class="mb-3">
				<label for="id" class="form-label">ID del Club:</label> <input
					type="text" class="form-control" id="id" value="${club.id}"
					name="id" readonly>
			</div>

			<!-- Campo Nombre del Club (Editable) -->
			<div class="mb-3">
				<label for="nombreClub" class="form-label">Nombre del Club:</label>
				<input type="text" class="form-control" id="nombreClub"
					value="${club.nombreClub}" name="nombreClub">
			</div>

			<!-- Campo Email del Club (Solo lectura) -->
			<div class="mb-3">
				<label for="email1" class="form-label">Mail del Club:</label> <input
					type="email" class="form-control" id="email1"
					value="${club.mailClub}" name="mail" readonly>
			</div>

			<!-- Campo Contraseña del Club (Solo lectura) -->
			<div class="mb-3">
				<label for="contrasenyaClub" class="form-label">Contraseña
					del Club:</label> <input type="password" class="form-control"
					id="contrasenyaClub" value="${club.contrasenyaClub}"
					name="contrasenyaClub" readonly>
			</div>

			<!-- Campo Colores del Club (Editable) -->
			<div class="mb-3">
				<label for="coloresClub" class="form-label">Colores del
					Club:</label> <input type="text" class="form-control" id="coloresClub"
					value="${club.coloresClub}" name="coloresClub">
			</div>

			<!-- Campo Descripción del Club (Editable) -->
			<div class="mb-3">
				<label for="descripcionClub" class="form-label">Descripción
					del Club:</label> <input type="text" class="form-control"
					id="descripcionClub" value="${club.descripcionClub}"
					name="descripcionClub">
			</div>

			<!-- Campo Localizador del Club (Editable) -->
			<div class="mb-3">
				<label for="localizadorClub" class="form-label">Localizador
					del Club:</label> <input type="text" class="form-control"
					id="localizadorClub" value="${club.localizadorClub}"
					name="localizadorClub">
			</div>

			<!-- Campo Fecha de Alta del Club (Solo lectura) -->
			<div class="mb-3">
				<label for="fechaAltaClub" class="form-label">Fecha de Alta
					del Club:</label> <input type="text" class="form-control"
					id="fechaAltaClub" value="${club.fechaAltaClub}"
					name="fechaAltaClub" readonly>
			</div>

			<!-- Campo Nickname del Club (Solo lectura) -->
			<div class="mb-3">
				<label for="nickClub" class="form-label">Nick del Club:</label> <input
					type="text" class="form-control" id="nickClub"
					value="${club.nickClub}" name="nickClub" readonly>
			</div>

			<!-- Campo Imagen del Club (Editable) -->
			<div class="mb-3">
				<label for="imgClub" class="form-label">Imagen del Club:</label> <input
					type="text" class="form-control" id="imgClub"
					value="${club.imgClub}" name="imgClub">
			</div>

			<!-- Campo Sede del Club (Editable) -->
			<div class="mb-3">
				<label for="sedeClub" class="form-label">Sede del Club:</label> <input
					type="text" class="form-control" id="sedeClub"
					value="${club.sedeClub}" name="sedeClub">
			</div>

			<button type="submit" class="btn btn-primary">Actualizar
				Datos</button>
		</form>
	</c:if>

	<c:if test="${not empty usuarios}">
		<!-- Formulario para editar los datos del usuario -->
		<form id="formEditarUsuario" class="form-container"
			action="/editarCuenta/editarUsuario" method="post">
			<h3>Editar datos del Usuario</h3>

			<!-- Campo ID del Usuario (Solo lectura) -->
			<div class="mb-3">
				<label for="idUsuario" class="form-label">ID del Usuario:</label> <input
					type="text" class="form-control" id="idUsuario"
					value="${usuarios.id}" name="id" readonly>
			</div>

			<!-- Campo Nombre del Usuario (Editable) -->
			<div class="mb-3">
				<label for="nombreUsuario" class="form-label">Nombre del
					Usuario:</label> <input type="text" class="form-control" id="nombreUsuario"
					value="${usuarios.nombreUsuario}" name="nombreUsuario">
			</div>

			<!-- Campo Apellidos del Usuario (Editable) -->
			<div class="mb-3">
				<label for="apellidosUsuario" class="form-label">Apellidos
					del Usuario:</label> <input type="text" class="form-control"
					id="apellidosUsuario" value="${usuarios.apellidosUsuario}"
					name="apellidosUsuario">
			</div>

			<!-- Campo Email del Usuario (Solo lectura) -->
			<div class="mb-3">
				<label for="mailUsuario" class="form-label">Mail del
					Usuario:</label> <input type="email" class="form-control" id="mailUsuario"
					value="${usuarios.mailUsuario}" name="mailUsuario" readonly>
			</div>

			<!-- Campo Fecha de Nacimiento del Usuario (Editable) -->
			<div class="mb-3">
				<label for="fechaNacimientoUsuario" class="form-label">Fecha
					de Nacimiento:</label> <input type="date" class="form-control"
					id="fechaNacimientoUsuario"
					value="${usuarios.fechaNacimientoUsuario}"
					name="fechaNacimientoUsuario">
			</div>

			<!-- Campo Nickname del Usuario (Editable) -->
			<div class="mb-3">
				<label for="nicknameUsuario" class="form-label">Nickname del
					Usuario:</label> <input type="text" class="form-control"
					id="nicknameUsuario" value="${usuarios.nicknameUsuario}"
					name="nicknameUsuario">
			</div>

			<!-- Campo Contraseña del Usuario (Editable) -->
			<div class="mb-3">
				<label for="contrasenyaUsuario" class="form-label">Contraseña
					del Usuario:</label> <input type="password" class="form-control"
					id="contrasenyaUsuario" value="${usuarios.contrasenyaUsuario}"
					name="contrasenyaUsuario">
			</div>

			<!-- Campo Descripción del Usuario (Editable) -->
			<div class="mb-3">
				<label for="descripcionUsuario" class="form-label">Descripción
					del Usuario:</label> <input type="text" class="form-control"
					id="descripcionUsuario" value="${usuarios.descripcionUsuario}"
					name="descripcionUsuario">
			</div>

			<!-- Campo DNI del Usuario (Editable) -->
			<div class="mb-3">
				<label for="dniUsuario" class="form-label">DNI del Usuario:</label>
				<input type="text" class="form-control" id="dniUsuario"
					value="${usuarios.dniUsuario}" name="dniUsuario">
			</div>

			<!-- Campo Teléfono del Usuario (Editable) -->
			<div class="mb-3">
				<label for="telefonoUsuario" class="form-label">Teléfono del
					Usuario:</label> <input type="text" class="form-control"
					id="telefonoUsuario" value="${usuarios.telefonoUsuario}"
					name="telefonoUsuario">
			</div>

			<!-- Campo Imagen del Usuario (Editable) -->
			<div class="mb-3">
				<label for="imgUsuario" class="form-label">Imagen del
					Usuario:</label> <input type="text" class="form-control" id="imgUsuario"
					value="${usuarios.imgUsuario}" name="imgUsuario">
			</div>

			<!-- Campo Rol del Usuario (Editable) -->
			<div class="mb-3">
				<label for="rolUsuario" class="form-label">Rol del Usuario:</label>
				<input type="text" class="form-control" id="rolUsuario"
					value="${usuarios.rolUsuario}" name="rolUsuario">
			</div>

			<button type="submit" class="btn btn-primary">Actualizar
				Datos</button>
		</form>
	</c:if>


	<c:if test="${not empty estado}">
		<div style="color: green;">${estado}</div>
	</c:if>

	<script>
        // Seleccionamos los elementos
        const btnForm1 = document.getElementById('btnForm1');
        const btnForm2 = document.getElementById('btnForm2');
        const form1 = document.getElementById('form1');
        const form2 = document.getElementById('form2');

        // Eventos para alternar la visibilidad
        btnForm1.addEventListener('click', () => {
            form1.classList.remove('hidden');
            form2.classList.add('hidden');
        });

        btnForm2.addEventListener('click', () => {
            form2.classList.remove('hidden');
            form1.classList.add('hidden');
        });
    </script>
</body>
</html>