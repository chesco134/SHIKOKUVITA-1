package Categorias;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author tetra
 */
public class SerializarCategoria {
    public static String serializaCategorias(Categoria cat){
        System.out.println("Serializing categoria.");
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
                        try{ cat.setDescCategoria(json.getString("descripcion_categoria")); } catch(Exception ignore){}
			return cat;
		}catch(JSONException e){
//			e.printStackTrace();
			return null;
		}
	
	}
}
