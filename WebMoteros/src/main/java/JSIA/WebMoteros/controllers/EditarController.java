package JSIA.WebMoteros.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import JSIA.WebMoteros.dtos.ClubEditarDto;
import JSIA.WebMoteros.dtos.ClubRequestDto;
import JSIA.WebMoteros.dtos.MailContrasenyaRequestDto;
import JSIA.WebMoteros.dtos.UsuarioEditarDto;
import JSIA.WebMoteros.dtos.UsuarioRequestDto;
import JSIA.WebMoteros.services.ApiService;
import JSIA.WebMoteros.services.EncriptarService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EditarController {

	@Autowired
	private ApiService apiService;

	@GetMapping("/editarCuenta")
	public ModelAndView showdeletePage(HttpSession session) {
		ModelAndView modelAndViewEditar = new ModelAndView("editar");

		try {
			UsuarioRequestDto usuarioDto = (UsuarioRequestDto) session.getAttribute("datos");

			modelAndViewEditar.addObject("rol", usuarioDto.getRolUsuario());

			return modelAndViewEditar;
		} catch (ClassCastException | NullPointerException e) {
			ClubRequestDto clubDto = (ClubRequestDto) session.getAttribute("datos");

			System.out.println(clubDto.toString());
		}

		return modelAndViewEditar;

	}

	@PostMapping("/editarCuenta/buscarClub")
	public ModelAndView buscarClub(@RequestParam String mail) {
		ModelAndView modelAndViewEditar = new ModelAndView("editar");

		ClubRequestDto club = apiService.buscarClubUsuario(mail, "clubs");

		if (club != null) {
			modelAndViewEditar.addObject("club", club);
			return modelAndViewEditar; // Redirige a ventanaPrincipal
		} else {

			modelAndViewEditar.addObject("error", "Credenciales incorrectas"); // Error al login

		}
		return modelAndViewEditar;

	}

	@PostMapping("/editarCuenta/editarClub")
	public ModelAndView eliminarClub(@RequestParam(required = false) Integer id, @RequestParam String nombreClub,
			@RequestParam String mail, @RequestParam String contrasenyaClub, @RequestParam String coloresClub,
			@RequestParam String descripcionClub, @RequestParam String localizadorClub, @RequestParam String sedeClub,
			@RequestParam(required = false) String imgClub, @RequestParam String nickClub, HttpSession session) {
		ModelAndView modelAndViewEditar = new ModelAndView("editar");

		ClubEditarDto club = new ClubEditarDto(id, nombreClub, mail, contrasenyaClub, coloresClub, descripcionClub,
				localizadorClub, nickClub, imgClub, sedeClub);
		System.out.println(" ");
		System.out.println("entramos");

		String response = apiService.editarClubUsuario(club, "clubs");

		if ("success".equalsIgnoreCase(response)) {
			modelAndViewEditar.addObject("estado", "Credenciales correctas, Club actualizado correctamente");
			return modelAndViewEditar; // Redirige a ventanaPrincipal
		} else {

			modelAndViewEditar.addObject("error", "Credenciales incorrectas"); // Error al login

		}
		return modelAndViewEditar;

	}

	@PostMapping("/editarCuenta/buscarUsuario")
	public ModelAndView buscarUsuario(@RequestParam String mail) {
		ModelAndView modelAndViewEditar = new ModelAndView("editar");

		UsuarioRequestDto usuarios = apiService.buscarUsuario(mail, "usuarios");

		if (usuarios != null) {
			modelAndViewEditar.addObject("usuarios", usuarios);
			return modelAndViewEditar; // Redirige a ventanaPrincipal
		} else {

			modelAndViewEditar.addObject("error", "Credenciales incorrectas"); // Error al login

		}
		return modelAndViewEditar;

	}

	@PostMapping("/editarCuenta/editarUsuario")
	public ModelAndView editarUsuario(@RequestParam(required = false) Long id, @RequestParam String nombreUsuario,
			@RequestParam String apellidosUsuario, @RequestParam String mailUsuario,
			@RequestParam String fechaNacimientoUsuario, @RequestParam String nicknameUsuario,
			@RequestParam String contrasenyaUsuario, @RequestParam(required = false) String descripcionUsuario,
			@RequestParam String dniUsuario, @RequestParam String telefonoUsuario,
			@RequestParam(required = false) String imgUsuario, @RequestParam String rolUsuario, HttpSession session) {
		
		ModelAndView modelAndViewEditar = new ModelAndView("editar");

		Date fechaNacimiento = null;
	    try {
	        fechaNacimiento = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoUsuario);
	    } catch (ParseException e) {
	        modelAndViewEditar.addObject("error", "Formato de fecha inválido");
	        return modelAndViewEditar;
	    }
	    
		UsuarioEditarDto usuario = new UsuarioEditarDto(id, nombreUsuario, apellidosUsuario, mailUsuario,
				fechaNacimiento, nicknameUsuario, contrasenyaUsuario, descripcionUsuario, dniUsuario, telefonoUsuario,
				imgUsuario, rolUsuario);

		System.out.println(" ");
		System.out.println("entramos");

		String response = apiService.editarUsuario("usuarios", usuario);

		if ("success".equalsIgnoreCase(response)) {
			modelAndViewEditar.addObject("estado", "Credenciales correctas, Club actualizado correctamente");
			return modelAndViewEditar; // Redirige a ventanaPrincipal
		} else {

			modelAndViewEditar.addObject("error", "Credenciales incorrectas"); // Error al login

		}
		return modelAndViewEditar;

	}

}
