package JSIA.WebMoteros.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import JSIA.WebMoteros.dtos.ClubDto;
import JSIA.WebMoteros.dtos.Usuariosdtos;
import JSIA.WebMoteros.services.ApiService;
import JSIA.WebMoteros.services.EncriptarService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CrearController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/registroCuenta")
    public ModelAndView showRegisterPage() {
        ModelAndView modelAndViewRegistro = new ModelAndView("crearUsuario");
        return modelAndViewRegistro; // Retorna la vista del formulario de registro
    }
    
    @PostMapping("/registroCuenta/addUsu")
	public String addUsu(@RequestParam String nombre, @RequestParam String apellidos,
			@RequestParam Date fechaNacimiento, @RequestParam String email, @RequestParam String telefono,
			@RequestParam String nick, @RequestParam String dni, @RequestParam String contrasenya, HttpSession session) {
		System.out.println("Estamos ready");

		Usuariosdtos usuDto = new Usuariosdtos(nombre, apellidos, fechaNacimiento, email, telefono, nick, dni,
				EncriptarService.encriptarContraseña(contrasenya));
		System.out.print(usuDto.toString());
		String response = apiService.sendAddUsu(usuDto, session);

		if ("success".equalsIgnoreCase(response)) {
			System.out.println(nombre + " " + apellidos);
			return "redirect:/ventanaPrincipal";
		}
		return "redirect:/login?error";
	}
    
    @PostMapping("/registroCuenta/darAltaClub")

	public String darAltaClub(@RequestParam String nombreClub, @RequestParam String coloresClub, @RequestParam String mailClub, @RequestParam String contraseniaClub, HttpSession session) {

	ClubDto nuevoClub = new ClubDto(  nombreClub,  coloresClub,   mailClub,   EncriptarService.encriptarContraseña(contraseniaClub));

	String respuesta = apiService.enviarRegistroClub(nuevoClub, session);

	if("success".equalsIgnoreCase(respuesta)) {

		return "redirect:/ventanaPrincipal";

	}else {

		return "redirect:/login?error";

	}

}
    
    

    
}