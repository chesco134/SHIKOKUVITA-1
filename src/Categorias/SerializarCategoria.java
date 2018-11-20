package Categorias;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author tetra
 */
public class SerializarCategoria {
    public static String serializaCategorias(Categoria cat){
		try{
			JSONObject json = new JSONObject();
			json.put("nombre_Categoria", cat.getNombreCategoria());
			return json.toString();
		}catch(JSONException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Categoria deserializarCategoria(String jsonString){
		try{
			String nombreCategoria;
			JSONObject json = new JSONObject(jsonString);
			nombreCategoria = json.getString("nombre_Categoria");
			Categoria cat = new Categoria(nombreCategoria);
			return cat;
		}catch(JSONException e){
//			e.printStackTrace();
			return null;
		}
	
	}
}
