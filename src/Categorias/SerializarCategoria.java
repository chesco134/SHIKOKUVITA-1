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
                        json.put("descripcion_categoria", cat.getDescCategoria());
			return json.toString();
		}catch(JSONException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Categoria deserializarCategoria(String jsonString){
		try{
			Categoria cat = new Categoria();
			JSONObject json = new JSONObject(jsonString);
			cat.setNombreCategoria(json.getString("nombre_Categoria"));
                        cat.setDescCategoria(json.getString("descripcion_categoria"));
			return cat;
		}catch(JSONException e){
//			e.printStackTrace();
			return null;
		}
	
	}
}
