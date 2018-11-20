/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desecho;

/**
 *
 * @author tetra
 */
public class Desecho {
	private String categoria;
	private int Cantidad;
	private boolean tipoMasa;

	public Desecho(String categoria, int Cantidad,boolean tipoMasa) {
		this.categoria = categoria;
		this.Cantidad = Cantidad;
		this.tipoMasa = tipoMasa;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int Cantidad) {
		this.Cantidad = Cantidad;
	}

	
	
}
