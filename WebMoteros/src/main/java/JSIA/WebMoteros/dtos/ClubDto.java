package JSIA.WebMoteros.dtos;
import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
/**

 * Clase para el Dto Club.

 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class ClubDto {
    private String nombreClub;

    private String coloresClub;

    private String mailClub;

    private String contrasenyaClub;

    // Constructor sin parámetros para la deserialización

    public ClubDto() {
        super();
    }

    // Constructor con parámetros, anotado para soportar Jackson

    @JsonCreator
    public ClubDto(

            @JsonProperty("nombreClub") String nombreClub,

            @JsonProperty("coloresClub") String coloresClub,

            @JsonProperty("mailClub") String mailClub,

            @JsonProperty("contrasenyaClub") String contrasenyaClub) {

        this.nombreClub = nombreClub;

        this.coloresClub = coloresClub;

        this.mailClub = mailClub;

        this.contrasenyaClub = contrasenyaClub;
    }

    // Getters y Setters

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {

        this.nombreClub = nombreClub;
    }

    public String getColoresClub() {
        return coloresClub;
    }

    public void setColoresClub(String coloresClub) {

        this.coloresClub = coloresClub;
    }

    public String getMailClub() {
        return mailClub;
    }
    public void setMailClub(String mailClub) {
        this.mailClub = mailClub;
    }
    
    public String getContrasenyaClub() {

        return contrasenyaClub;
    }

    public void setContrasenyaClub(String contrasenyaClub) {

        this.contrasenyaClub = contrasenyaClub;
    }

}