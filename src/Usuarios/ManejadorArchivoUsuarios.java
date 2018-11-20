/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Usuarios.Usuario;
import Usuarios.SerializarUsuario;

/**
 *
 * @author Juan Capiz
 */
public class ManejadorArchivoUsuarios {
    
    java.util.List<Usuario> usuarios;
    Usuario usuarioActual;
    
    public ManejadorArchivoUsuarios(){
        usuarios = new java.util.ArrayList<>();
    }
    
    public Usuario[] recuperaUsuarios(String nombreArchivo){
        if(usuarios.isEmpty())
            try(java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(new java.io.File(nombreArchivo)))){
                String line;
                Usuario usuario;
                while((line = br.readLine()) != null)
                    if( (usuario = SerializarUsuario.deserializaUsuario(line)) != null)
                        usuarios.add(usuario);
            }catch(java.io.IOException e){
                e.printStackTrace();
            }
        return usuarios.toArray(new Usuario[]{});
    }
    
    public void guardaUsuarios(String nombreArchivo){
        try(java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(new java.io.File(nombreArchivo)))){
            for(Usuario usuario : usuarios)
                pw.println(SerializarUsuario.serializaUsuario(usuario));
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }
    
    public void agregarusuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void quitaUsuario(int index){
        usuarios.remove(index);
    }
    
    public Usuario[] getUsuarios(){
        return usuarios.toArray(new Usuario[]{});
    }
    
    public Usuario containsUser(Usuario user){
        for(Usuario usuario : usuarios)
            if(usuario.getNombreUsuario().equals(user.getNombreUsuario()) && usuario.getPass().equals(user.getPass()))
                return usuario;
        return null;
    }
    
    public void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }
    
    public Usuario getUsuarioActual(){ return usuarioActual; }
    
    public Usuario recuperarUsuarioActual(String fileName){
        try(java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(new java.io.File(fileName)))){
            return (usuarioActual = SerializarUsuario.deserializaUsuario(br.readLine()));
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void guardaUsuarioActual(String fileName){
        try(java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(new java.io.File(fileName)))){
            pw.println(SerializarUsuario.serializaUsuario(usuarioActual));
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }
}
