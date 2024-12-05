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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" href="<c:url value='/css/styles.css' />"> -->
<title>Bienvenido a mi Formulario</title>

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
								<li><a class="dropdown-item" href="registroCuenta">Dar de alta</a></li>
								<li><a class="dropdown-item" href="editarCuenta">Editar cuenta</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="eliminarCuenta">Eliminar cuenta</a></li>
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

	<c:if test="${not empty rol}">
		<div style="color: green;">
			${rol}
			<!-- Muestra el mensaje de éxito -->
		</div>
	</c:if>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<!-- <script src="<c:url value='/js/script.js' />"></script> -->
</body>
</html>