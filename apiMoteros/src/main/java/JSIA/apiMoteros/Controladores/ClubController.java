package JSIA.apiMoteros.Controladores;

import JSIA.apiMoteros.daos.Clubs;
import JSIA.apiMoteros.daos.LoginRequest;
import JSIA.apiMoteros.daos.MailDto;
import JSIA.apiMoteros.servicios.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public List<Clubs> getAllClubs() {
        return clubService.getAllClubs();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
    public ResponseEntity<?> loginClub(@RequestBody LoginRequest loginRequest) {
        Clubs club = clubService.loginClub(loginRequest.getMail(), loginRequest.getContrasenya());
        if (club != null) {
        	System.out.println("si");
            return ResponseEntity.ok(club); 
            
        } else {
        	System.out.println("no");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<Clubs> createClub(@RequestBody Clubs club) {
        Clubs nuevoClub = clubService.createClub(club);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoClub);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping("/{id}")
    public ResponseEntity<Clubs> updateClub(@PathVariable Long id, @RequestBody Clubs clubDetails) {
        try {
            return ResponseEntity.ok(clubService.updateClub(id, clubDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/buscarMail")
    public ResponseEntity<Clubs> BuscarClub(@RequestBody MailDto mail) {
        Clubs nuevoClub = clubService.buscarMail(mail);
        System.out.println(nuevoClub.toString());
        return ResponseEntity.status(HttpStatus.OK).body(nuevoClub);
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClub(@RequestBody LoginRequest loginRequest) {
    	System.out.print(loginRequest.toString());
        Clubs club = clubService.deleteClub(loginRequest.getMail(), loginRequest.getContrasenya());
        if (club != null) {
        	
            return ResponseEntity.ok(club);
            
        } else {
        	System.out.println("no");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }
}
