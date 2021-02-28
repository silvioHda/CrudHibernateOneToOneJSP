package com.mx.entidad;
import javax.persistence.*;
@Entity
@Table(name="NOVIA")
public class Novia {
	@Id
	@Column(name="ID_NOVIA", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(100)")
	String nombre;
	
	@Column(name="APP", columnDefinition="NVARCHAR2(100)")
	String app;
	
	@Column(name="ESTATURA", columnDefinition="NUMBER")
	double estatura;
	
	@Column(name="PASATIEMPO", columnDefinition="NVARCHAR2(100)")
	String pasatiempo;
	
	@Column(name="EDAD", columnDefinition="NUMBER")
	int edad;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_NOVIO")
	Novio novio;
	
	public Novia(int id, String nombre, String app, double estatura, String pasatiempo, int edad, Novio novio) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.estatura = estatura;
		this.pasatiempo = pasatiempo;
		this.edad = edad;
		this.novio = novio;
	}

	public Novio getNovio() {
		return novio;
	}

	public void setNovio(Novio novio) {
		this.novio = novio;
	}

	public Novia() {
	}

	public Novia(int id) {
		this.id = id;
	}

	public Novia(int id, String nombre, String app, double estatura, String pasatiempo, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.estatura = estatura;
		this.pasatiempo = pasatiempo;
		this.edad = edad;
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

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public String getPasatiempo() {
		return pasatiempo;
	}

	public void setPasatiempo(String pasatiempo) {
		this.pasatiempo = pasatiempo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Novia [id=" + id + ", nombre=" + nombre + ", app=" + app + ", estatura=" + estatura + ", pasatiempo="
				+ pasatiempo + ", edad=" + edad + ", novio="+novio+"]";
	}
	
	
}
