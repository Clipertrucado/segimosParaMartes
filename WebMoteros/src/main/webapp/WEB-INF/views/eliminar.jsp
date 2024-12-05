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
								<li><a class="dropdown-item" href="editarCuenta">Editar cuenta</a></li>
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
		<h1 class="text-center">Control de Formularios</h1>
		<div class="text-center mb-4">
			<!-- Botones para controlar la visibilidad -->
			<button id="btnForm1" class="btn btn-primary mx-2">Club</button>
			<button id="btnForm2" class="btn btn-secondary mx-2">Usuario</button>
		</div>

		<!-- Formulario 1 -->
		<form id="form1" class="hidden form-container" action="/eliminarCuenta/club" method="post">
			<h3>Eliminar Club</h3>
			<div class="mb-3">
				<label for="email1" class="form-label">Correo Electrónico
					del Club</label> <input type="email" class="form-control" id="email1"
					placeholder="Ingresa tu correo" name="mail">
			</div>
			<div class="mb-3">
				<label for="password1" class="form-label">Contraseña del
					Club</label> <input type="password" class="form-control" id="password1"
					placeholder="Ingresa tu contraseña" name="contrasenya">
			</div>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>

		<!-- Formulario 2 -->
		<form id="form2" class="hidden form-container" action="/eliminarCuenta/usuario" method="post">
			<h3>Eliminar Usuario</h3>
			<div class="mb-3">
				<label for="email2" class="form-label">Correo Electrónico
					del Usuario</label> <input type="email" class="form-control" id="email2"
					placeholder="Ingresa tu correo" name="mail">
			</div>
			<div class="mb-3">
				<label for="password2" class="form-label">Contraseña del
					Usuario</label> <input type="password" class="form-control" id="password2"
					placeholder="Ingresa tu contraseña" name="contrasenya">
			</div>
			<button type="submit" class="btn btn-secondary">Enviar</button>
		</form>
	</div>
	
	<c:if test="${not empty estado}">
		<div style="color: green;">
			${estado}
			<!-- Muestra el mensaje de éxito -->
		</div>
	</c:if>
	
	<c:if test="${not empty error}">
		<div style="color: red;">
			${error}
			<!-- Muestra el mensaje de éxito -->
		</div>
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