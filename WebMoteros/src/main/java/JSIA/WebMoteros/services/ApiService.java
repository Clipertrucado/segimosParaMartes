package JSIA.WebMoteros.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import JSIA.WebMoteros.dtos.ClubDto;
import JSIA.WebMoteros.dtos.ClubEditarDto;
import JSIA.WebMoteros.dtos.ClubRequestDto;
import JSIA.WebMoteros.dtos.MailContrasenyaRequestDto;
import JSIA.WebMoteros.dtos.UsuarioEditarDto;
import JSIA.WebMoteros.dtos.UsuarioRequestDto;
import JSIA.WebMoteros.dtos.Usuariosdtos;
import jakarta.servlet.http.HttpSession;

@Service
public class ApiService {

	@Value("${api.endpoint}")
	private String apiEndpoint;

	public String sendLoginData(MailContrasenyaRequestDto loginRequest, String campo, HttpSession session) {
		// Crear una instancia de RestTemplate
		try {
			URI uri = new URI("http://localhost:8081/apiMoteros/api/" + campo + "/login");
			URL url = uri.toURL();

			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("POST");
			conexion.setRequestProperty("Content-Type", "application/json");
			conexion.setDoOutput(true);

			// Crear el cuerpo de la solicitud con Jackson
			ObjectMapper mapper = new ObjectMapper();
			String jsonInput = mapper.writeValueAsString(loginRequest);

			try (OutputStream os = conexion.getOutputStream()) {
				os.write(jsonInput.getBytes());
				os.flush();
			}

			int codigoRespuesta = conexion.getResponseCode();
			System.out.print(codigoRespuesta);
			if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
				// Leer la respuesta del servidor
				BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				StringBuilder response = new StringBuilder();
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				if (campo == "usuarios") {
					UsuarioRequestDto usuario = mapper.readValue(response.toString(), UsuarioRequestDto.class);
					System.out.print(usuario.toString());
					session.setAttribute("datos", usuario);

					return "success";
				} else {
					System.out.println("Entramos en club");
					ClubRequestDto club = mapper.readValue(response.toString(), ClubRequestDto.class);
					System.out.print(club.toString());
					session.setAttribute("datos", club);
					

					return "success";
				}
			} else {
				System.out.println("Error en la conexión: " + codigoRespuesta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public String enviarRegistroClub(ClubDto nuevoClub, HttpSession session) {

		try {
			URI uri = new URI("http://localhost:8081/apiMoteros/api/clubs");
			URL url = uri.toURL();

			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

			conexion.setRequestProperty("content-Type", "application/json");
			conexion.setDoOutput(true);

			// Pasar el dto a json para enviarlo a la api

			ObjectMapper mapper = new ObjectMapper();

			String dtoAJson = mapper.writeValueAsString(nuevoClub);
			System.out.println(dtoAJson);

			// Se envian los datos al servidor
			try (OutputStream os = conexion.getOutputStream()) {
				os.write(dtoAJson.getBytes());
				os.flush();

				// Leer la respuesta del servidor
				int codigoRespuesta = conexion.getResponseCode();

				if (codigoRespuesta == HttpURLConnection.HTTP_CREATED) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
					StringBuilder response = new StringBuilder();
					String inputLine;

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					ClubDto club = mapper.readValue(response.toString(), ClubDto.class);

					if (club != null) {
						// Guardar el objeto UsuarioDto en la sesión

						session.setAttribute("usuario", club);

						return "success";
					} else {
						System.out.println("Error: La respuesta de la API no contiene un usuario válido.");
						return "error";
					}
				} else {
					System.out.println("Error en la conexión: " + codigoRespuesta);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public String sendAddUsu(Usuariosdtos usuDto, HttpSession session) {
		// Crear una instancia de RestTemplate
		try {
			System.out.println("entramos en addUsu");
			URI uri = new URI("http://localhost:8081/apiMoteros/api/usuarios");
			URL url = uri.toURL();

			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("POST");
			conexion.setRequestProperty("Content-Type", "application/json");
			conexion.setDoOutput(true);

			// Crear cuerpo de la solicitud con Jackson
			ObjectMapper mapper = new ObjectMapper();
			String jsonInput = mapper.writeValueAsString(usuDto);

			System.out.println(jsonInput);

			try (OutputStream os = conexion.getOutputStream()) {
				os.write(jsonInput.getBytes());
				os.flush();
			}

			int codigoRespuesta = conexion.getResponseCode();
			if (codigoRespuesta == HttpURLConnection.HTTP_CREATED) {
				System.out.print("credenciales validas");
				BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				UsuarioRequestDto usuario = mapper.readValue(response.toString(), UsuarioRequestDto.class);
				System.out.print(usuario.toString());
				session.setAttribute("datos", usuario);
				
				return "success";
			} else {
				System.out.println("Error en la conexión: " + codigoRespuesta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "asdf";
	}
	
	public String eliminarClubUsuario(MailContrasenyaRequestDto DtoPassEmail, String campo) {
		// Crear una instancia de RestTemplate
		try {
			System.out.println("entramos en eliminar");
			URI uri = new URI("http://localhost:8081/apiMoteros/api/" + campo + "/delete");
            URL url = uri.toURL();
            
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestMethod("DELETE");
	        conexion.setRequestProperty("Content-Type", "application/json");
	        conexion.setDoOutput(true);

	        // Crear cuerpo de la solicitud con Jackson
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonInput = mapper.writeValueAsString(DtoPassEmail);
	        
	        System.out.println(jsonInput);
	        
	        try (OutputStream os = conexion.getOutputStream()) {
	            os.write(jsonInput.getBytes());
	            os.flush();
	        }
	        System.out.println("Estamos en el final de eliminarUsu");

	        int codigoRespuesta = conexion.getResponseCode();
	        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
	        	System.out.print("credenciales validas");
	            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            return "success";
	        } else {
	            System.out.println("Error en la conexión: " + codigoRespuesta);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "asdf";
	}
	
	public ClubRequestDto buscarClubUsuario(String mail, String campo) {
		// Crear una instancia de RestTemplate
		try {
			System.out.println("entramos en eliminar");
			URI uri = new URI("http://localhost:8081/apiMoteros/api/"+campo+"/buscarMail");
            URL url = uri.toURL();
            
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestMethod("POST");
	        conexion.setRequestProperty("Content-Type", "application/json");
	        conexion.setDoOutput(true);

	        // Crear cuerpo de la solicitud con Jackson
	        Map<String, String> jsonMap = new HashMap<>();
            jsonMap.put("mail", mail);

            // Crear el ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Convertir el mapa a JSON
            String jsonInput = mapper.writeValueAsString(jsonMap);
	        
	        System.out.println(jsonInput);
	        
	        try (OutputStream os = conexion.getOutputStream()) {
	            os.write(jsonInput.getBytes());
	            os.flush();
	        }
	        System.out.println("Estamos en el final de buscarclub");

	        int codigoRespuesta = conexion.getResponseCode();
	        
	        System.out.println(codigoRespuesta);
	        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
	        	System.out.print("credenciales validas");
	            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            
	            ClubRequestDto club = mapper.readValue(response.toString(), ClubRequestDto.class);
				System.out.print(club.toString());
	            
	            return club;
	        } else {
	            System.out.println("Error en la conexión: " + codigoRespuesta);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public UsuarioRequestDto buscarUsuario(String mail, String campo) {
		// Crear una instancia de RestTemplate
		try {
			System.out.println("entramos en eliminar");
			URI uri = new URI("http://localhost:8081/apiMoteros/api/"+campo+"/buscarMail");
            URL url = uri.toURL();
            
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestMethod("POST");
	        conexion.setRequestProperty("Content-Type", "application/json");
	        conexion.setDoOutput(true);

	        // Crear cuerpo de la solicitud con Jackson
	        Map<String, String> jsonMap = new HashMap<>();
            jsonMap.put("mail", mail);

            // Crear el ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Convertir el mapa a JSON
            String jsonInput = mapper.writeValueAsString(jsonMap);
	        
	        System.out.println(jsonInput);
	        
	        try (OutputStream os = conexion.getOutputStream()) {
	            os.write(jsonInput.getBytes());
	            os.flush();
	        }
	        System.out.println("Estamos en el final de buscarUsuario");

	        int codigoRespuesta = conexion.getResponseCode();
	        
	        System.out.println(codigoRespuesta);
	        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
	        	System.out.print("credenciales validas");
	            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            
	            UsuarioRequestDto usuario = mapper.readValue(response.toString(), UsuarioRequestDto.class);
				System.out.print(usuario.toString());
	            
	            return usuario;
	        } else {
	            System.out.println("Error en la conexión: " + codigoRespuesta);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public String editarClubUsuario(ClubEditarDto club, String campo) {
		// Crear una instancia de RestTemplate
		try {
			URI uri = new URI("http://localhost:8081/apiMoteros/api/"+campo+"/"+club.getId());
            URL url = uri.toURL();
            
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestMethod("PUT");
	        conexion.setRequestProperty("Content-Type", "application/json");
	        conexion.setDoOutput(true);

			// Pasar el dto a json para enviarlo a la api

			ObjectMapper mapper = new ObjectMapper();

			String dtoAJson = mapper.writeValueAsString(club);
			System.out.println(dtoAJson);

			// Se envian los datos al servidor
			try (OutputStream os = conexion.getOutputStream()) {
				os.write(dtoAJson.getBytes());
				os.flush();

				// Leer la respuesta del servidor
				int codigoRespuesta = conexion.getResponseCode();

				if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
					StringBuilder response = new StringBuilder();
					String inputLine;

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					System.out.println("respuerta");

					System.out.println(response.toString());

					return "success";
					
				} else {
					System.out.println("Error en la conexión: " + codigoRespuesta);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	public String editarUsuario(String campo, UsuarioEditarDto usuario) {
		// Crear una instancia de RestTemplate
		try {
			URI uri = new URI("http://localhost:8081/apiMoteros/api/"+campo+"/"+usuario.getId());
            URL url = uri.toURL();
            
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestMethod("PUT");
	        conexion.setRequestProperty("Content-Type", "application/json");
	        conexion.setDoOutput(true);

			// Pasar el dto a json para enviarlo a la api

			ObjectMapper mapper = new ObjectMapper();

			String dtoAJson = mapper.writeValueAsString(usuario);
			System.out.println(dtoAJson);

			// Se envian los datos al servidor
			try (OutputStream os = conexion.getOutputStream()) {
				os.write(dtoAJson.getBytes());
				os.flush();

				// Leer la respuesta del servidor
				int codigoRespuesta = conexion.getResponseCode();

				if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
					StringBuilder response = new StringBuilder();
					String inputLine;

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					System.out.println("respuerta");

					System.out.println(response.toString());

					return "success";
					
				} else {
					System.out.println("Error en la conexión: " + codigoRespuesta);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	

}
