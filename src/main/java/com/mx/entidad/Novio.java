package com.mx.entidad;


import javax.persistence.*;
@Entity
@Table(name="NOVIO")
public class Novio {
	@Id
	@Column(name="ID_NOVIO", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(100)")
	String nombre;
	
	@Column(name="APP", columnDefinition="NVARCHAR2(100)")
	String app;
	
	@Column(name="TELEFONO", columnDefinition="NVARCHAR2(100)")
	String telefono;
	
	@Column(name="TRABAJO", columnDefinition="NVARCHAR2(100)")
	String trabajo;
	
	@Column(name="EDAD", columnDefinition="NUMBER")
	int edad;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_NOVIA")
	Novia novia;

	public Novio() {
	}

	public Novio(int id) {
		this.id = id;
	}

	public Novio(int id, String nombre, String app, String telefono, String trabajo, int edad, Novia novia) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.telefono = telefono;
		this.trabajo = trabajo;
		this.edad = edad;
		this.novia = novia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Novia getNovia() {
		return novia;
	}

	public void setNovia(Novia novia) {
		this.novia = novia;
	}

	@Override
	public String toString() {
		return "Novio [id=" + id + ", nombre=" + nombre + ", app=" + app + ", telefono=" + telefono + ", trabajo="
				+ trabajo + ", edad=" + edad + " ]";
	}
	
	
}
