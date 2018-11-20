package Usuarios;


import java.util.*;

/**
 * 
 */
public class ListaUsuarios{


   private ArrayList<Usuario> lista;

   public ArrayList getLista() {
   	return lista;
   }

   public void setLista(ArrayList lista) {
   	this.lista = lista;
   }

   public void add(Usuario u) {
   	lista.add(u);
   }

   public void remove(int i) {
   	lista.remove(i);
   }

}