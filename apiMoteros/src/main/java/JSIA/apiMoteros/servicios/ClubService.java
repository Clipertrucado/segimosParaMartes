package JSIA.apiMoteros.servicios;

import JSIA.apiMoteros.daos.Clubs;
import JSIA.apiMoteros.daos.MailDto;
import JSIA.apiMoteros.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Clubs> getAllClubs() {
        return clubRepository.findAll();
    }

    public Clubs loginClub(String mail, String contrasenya) {
        Optional<Clubs> club = clubRepository.findByMailClubAndContrasenyaClub(mail, contrasenya);
        return club.orElse(null);
    }

    public Clubs createClub(Clubs club) {
    	
    	Optional<Clubs> clubEncontrar = clubRepository.findByMailClub(club.getMailClub());
    	
    	if (clubEncontrar.isPresent()) {
              
            return null;
        }
    	
        return clubRepository.save(club);
    	
    	
       
    }

    public Clubs updateClub(Long id, Clubs clubDetails) {
        Clubs club = clubRepository.findById(id).orElseThrow(() -> new RuntimeException("Club no encontrado"));
        club.setNombreClub(clubDetails.getNombreClub());
        club.setMailClub(clubDetails.getMailClub());
        club.setContrasenyaClub(clubDetails.getContrasenyaClub());
        club.setColoresClub(clubDetails.getColoresClub());
        club.setDescripcionClub(clubDetails.getDescripcionClub());
        club.setLocalizadorClub(clubDetails.getLocalizadorClub());
        club.setFechaAltaClub(clubDetails.getFechaAltaClub());
        club.setNickClub(clubDetails.getNickClub());
        club.setImgClub(clubDetails.getImgClub());
        club.setSedeClub(clubDetails.getSedeClub());
        return clubRepository.save(club);
    }
    
    public Clubs buscarMail(MailDto mail) {
        Optional<Clubs> club = clubRepository.findByMailClub(mail.getMail());
        
        if (club.isPresent()) {
        	System.out.print("si se encontro");
              // Elimina el club encontrado
    
            return club.get();
        }
        System.out.print("pues no");
        return null;
    }

    @Transactional
    public Clubs deleteClub(String mail, String contrasenya) {
        Optional<Clubs> club = clubRepository.findByMailClubAndContrasenyaClub(mail, contrasenya);
        if (club.isPresent()) {
            clubRepository.delete(club.get());  // Elimina el club encontrado
            return club.get();
        }
        return null;
    }
}
