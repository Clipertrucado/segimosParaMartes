package JSIA.WebMoteros.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import JSIA.WebMoteros.dtos.ClubRequestDto;
import JSIA.WebMoteros.dtos.UsuarioRequestDto;
import JSIA.WebMoteros.services.ApiService;
import jakarta.servlet.http.HttpSession;


@Controller
public class VentanaPrincipalController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/ventanaPrincipal")
    public ModelAndView showLoginPage(HttpSession session) {
    	ModelAndView modelAndViewPaginaPrincipal = new ModelAndView("ventanaPrincipal");
    	try {
    	UsuarioRequestDto usuarioDto = (UsuarioRequestDto) session.getAttribute("datos");
    	
        modelAndViewPaginaPrincipal.addObject("rol", usuarioDto.getRolUsuario());
        
        System.out.println("Ehhhhhhhhhhhhhhhhhhh"+usuarioDto.toString());
        
        return modelAndViewPaginaPrincipal;
    	}catch(ClassCastException | NullPointerException e) {
    		ClubRequestDto clubDto = (ClubRequestDto) session.getAttribute("datos");
 
            System.out.println(clubDto.toString());
    	}
    		
    	return modelAndViewPaginaPrincipal;
        
    	
    }
    
    
    

}
