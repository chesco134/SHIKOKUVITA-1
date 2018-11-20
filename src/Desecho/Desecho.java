/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desecho;
import org.apache.commons.lang3.builder.*;
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

	public boolean isTipoMasa() {
		return tipoMasa;
	}

	public void setTipoMasa(boolean tipoMasa) {
		this.tipoMasa = tipoMasa;
	}

 @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Desecho)) {
            return false;
        }

        Desecho dese = (Desecho) o;

        return new EqualsBuilder()
                .append(categoria, dese.categoria)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(categoria)
                .toHashCode();
    }

	
	
}
