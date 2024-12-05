package JSIA.WebMoteros.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClubEditarDto {

	private Integer id;
	private String nombreClub;
	private String mailClub;
	private String contrasenyaClub;
	private String coloresClub;
	private String descripcionClub;
	private String localizadorClub;
	private String nickClub;
	private String imgClub; // Se permite null
	private String sedeClub;

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
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

	public String getColoresClub() {
		return coloresClub;
	}

	public void setColoresClub(String coloresClub) {
		this.coloresClub = coloresClub;
	}

	public String getDescripcionClub() {
		return descripcionClub;
	}

	public void setDescripcionClub(String descripcionClub) {
		this.descripcionClub = descripcionClub;
	}

	public String getLocalizadorClub() {
		return localizadorClub;
	}

	public void setLocalizadorClub(String localizadorClub) {
		this.localizadorClub = localizadorClub;
	}

	public String getNickClub() {
		return nickClub;
	}

	public void setNickClub(String nickClub) {
		this.nickClub = nickClub;
	}

	public String getImgClub() {
		return imgClub;
	}

	public void setImgClub(String imgClub) {
		this.imgClub = imgClub;
	}

	public String getSedeClub() {
		return sedeClub;
	}

	public void setSedeClub(String sedeClub) {
		this.sedeClub = sedeClub;
	}

	// Constructor vacío
	public ClubEditarDto() {
	}

	// Constructor con parámetros
	public ClubEditarDto(@JsonProperty Integer id, @JsonProperty String nombreClub, @JsonProperty String mailClub,
			@JsonProperty String contrasenyaClub, @JsonProperty String coloresClub,
			@JsonProperty String descripcionClub, @JsonProperty String localizadorClub, @JsonProperty String nickClub,
			@JsonProperty String imgClub, @JsonProperty String sedeClub) {
		this.id = id;
		this.nombreClub = nombreClub;
		this.mailClub = mailClub;
		this.contrasenyaClub = contrasenyaClub;
		this.coloresClub = coloresClub;
		this.descripcionClub = descripcionClub;
		this.localizadorClub = localizadorClub;
		this.nickClub = nickClub;
		this.imgClub = imgClub;
		this.sedeClub = sedeClub;
	}

	@Override
	public String toString() {
		return "ClubRequestDto{" + "id=" + id + ", nombreClub='" + nombreClub + '\'' + ", mailClub='" + mailClub + '\''
				+ ", contrasenyaClub='" + contrasenyaClub + '\'' + ", coloresClub='" + coloresClub + '\''
				+ ", descripcionClub='" + descripcionClub + '\'' + ", localizadorClub='" + localizadorClub + '\''
				+ ", nickClub='" + nickClub + '\'' + ", imgClub='" + imgClub + '\'' + ", sedeClub='" + sedeClub + '\''
				+ '}';
	}
}
