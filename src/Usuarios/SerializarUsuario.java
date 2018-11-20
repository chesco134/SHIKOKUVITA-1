package Usuarios;


import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Alumno
 */
public class SerializarUsuario {
    public static String serializaUsuario(Usuario usuario){
		try{
			JSONObject json = new JSONObject();
			json.put("nombre_Usuario", usuario.getNombreUsuario());
			json.put("contraseña_usuario", usuario.getPass());
			json.put("privilegio_usuario", usuario.getPrivilegio());
			return json.toString();
		}catch(JSONException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Usuario deserializaUsuario(String jsonString){
		try{
			String nombreUsuario;
			String contraseña;
			boolean privilegio;
			JSONObject json = new JSONObject(jsonString);
			nombreUsuario = json.getString("nombre_Usuario");
			contraseña = json.getString("contraseña_usuario");
			privilegio = json.getBoolean("privilegio_usuario");
			Usuario usuario = new Usuario(nombreUsuario, contraseña, privilegio);
			return usuario;
		}catch(JSONException e){
//			e.printStackTrace();
			return null;
		}
	}
}
