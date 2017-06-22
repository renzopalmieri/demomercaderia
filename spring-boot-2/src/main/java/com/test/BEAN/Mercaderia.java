package com.test.BEAN;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Mercaderias")
public class Mercaderia  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mercaderia_id")
    private int mercaderiaId;  
	
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="tipoMercaderia")
    private String tipoMercaderia;
	
	@Column(name="cantidad")
    private int cantidad;
	
	@Column(name="precio")
    private int precio;
	
	@Column(name="tipoNegocio")
    private String tipoNegocio;
	
	

	public int getmercaderiaId() {
		return mercaderiaId;
	}

	public void setmercaderiaId(int merc) {
		mercaderiaId = merc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoMercaderia() {
		return tipoMercaderia;
	}

	public void setTipoMercaderia(String tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	
	
	

}
