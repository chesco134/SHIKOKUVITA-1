/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categorias;

import java.util.ArrayList;

/**
 *
 * @author tetra
 */
public class ManejoArchivoCategorias {
	
	java.util.List<Categoria> listaCategoria;
	
    public ManejoArchivoCategorias(){
		listaCategoria = new java.util.ArrayList<>();
                
    }
    
    public Categoria[] recuperaCategorias(String nombreArchivo){
        if(listaCategoria.isEmpty())
            try(java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(new java.io.File(nombreArchivo)))){
                String line;
                Categoria categorias;
                while((line = br.readLine()) != null)
                    if((categorias = SerializarCategoria.deserializarCategoria(line)) != null)
                        listaCategoria.add(categorias);
            }catch(java.io.IOException e){
                e.printStackTrace();
            }
        return listaCategoria.toArray(new Categoria[]{});
    }
    
    public void guardaCategorias(String nombreArchivo){
        try(java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(new java.io.File(nombreArchivo)))){
            for(Categoria usuario : listaCategoria)
                pw.println(SerializarCategoria.serializaCategorias(usuario));
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }
    
    public void agregarCategoria(Categoria categoria){
        listaCategoria.add(categoria);
    }
    
    public void quitaCategorias(int index){
        listaCategoria.remove(index);
    }
    
    public void quitaCategorias(String nombreCategoria){
		ArrayList <Categoria> cate = new ArrayList<>();
        for(Categoria categoria : listaCategoria){
           if(categoria.getNombreCategoria().equals(nombreCategoria))
				cate.add(categoria);
		}
		listaCategoria.removeAll(cate);
                //listaCategoria.remove(categoria);
			
    }
	public boolean checkCategoria(String categoria,boolean jajatl){
        for(Categoria categoriia : listaCategoria){
            if(categoria.equalsIgnoreCase(categoriia.getNombreCategoria())){
                jajatl = false;
                break;
            }
        }return jajatl;
    }
    
    public Categoria[] getUsuarios(){
        return listaCategoria.toArray(new Categoria[]{});
    }
    
    public Categoria containsUser(Categoria user){
        for(Categoria usuario : listaCategoria)
            if(usuario.getNombreCategoria().equals(user.getNombreCategoria()))
                return usuario;
        return null;
    }
}
