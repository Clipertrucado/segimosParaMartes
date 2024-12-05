package JSIA.WebMoteros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import JSIA.WebMoteros.dtos.ClubRequestDto;
import JSIA.WebMoteros.dtos.MailContrasenyaRequestDto;
import JSIA.WebMoteros.dtos.UsuarioRequestDto;
import JSIA.WebMoteros.services.ApiService;
import JSIA.WebMoteros.services.EncriptarService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EliminarController {

	@Autowired
	private ApiService apiService;

	@GetMapping("/eliminarCuenta")
	public ModelAndView showdeletePage(HttpSession session) {
		ModelAndView modelAndViewEliminar = new ModelAndView("eliminar");

		try {
			UsuarioRequestDto usuarioDto = (UsuarioRequestDto) session.getAttribute("datos");

			modelAndViewEliminar.addObject("rol", usuarioDto.getRolUsuario());

			return modelAndViewEliminar;
		} catch (ClassCastException | NullPointerException e) {
			ClubRequestDto clubDto = (ClubRequestDto) session.getAttribute("datos");

			System.out.println(clubDto.toString());
		}

		return modelAndViewEliminar;

	}

	@PostMapping("/eliminarCuenta/club")
	public ModelAndView deleteClub(@RequestParam String mail, @RequestParam String contrasenya) {
		ModelAndView modelAndViewEliminar = new ModelAndView("eliminar");

		MailContrasenyaRequestDto loginRequest = new MailContrasenyaRequestDto(mail,
				EncriptarService.encriptarContraseña(contrasenya));

		String response = apiService.eliminarClubUsuario(loginRequest, "club");

		if ("success".equalsIgnoreCase(response)) {
			modelAndViewEliminar.addObject("estado", "Credenciales correctas, Club eliminsado correctamente");
			return modelAndViewEliminar; // Redirige a ventanaPrincipal
		} else {

			modelAndViewEliminar.addObject("error", "Credenciales incorrectas"); // Error al login

		}
		return modelAndViewEliminar;

	}

	@PostMapping("/eliminarCuenta/usuario")
	public ModelAndView deleteUser(@RequestParam String mail, @RequestParam String contrasenya) {
		ModelAndView modelAndViewEliminar = new ModelAndView("eliminar");

		MailContrasenyaRequestDto loginRequest = new MailContrasenyaRequestDto(mail,
				EncriptarService.encriptarContraseña(contrasenya));

		String response = apiService.eliminarClubUsuario(loginRequest, "usuarios");

		if ("success".equalsIgnoreCase(response)) {
			modelAndViewEliminar.addObject("estado", "Credenciales correctas, Club eliminsado correctamente");
			return modelAndViewEliminar; // Redirige a ventanaPrincipal
		} else {

			modelAndViewEliminar.addObject("error", "Credenciales incorrectas"); // Error al login

		}
		return modelAndViewEliminar;

	}

}
