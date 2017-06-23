package com.ipartek.jonBarnes.tipos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Para indicar el rol del usuario en la aplicacion.
 * 
 * @author jonBarnes
 * @version 23/06/2017
 *
 */
@Entity
@Table(name = "roles")
public class ROL implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos.

	@Id
	// @Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "rol")
	private String rol;

	@Column(name = "descripcion")
	private String descripcion;

	// Constructores.
	public ROL(Long id, String rol, String descripcion) {
		super();
		this.id = id;
		this.rol = rol;
		this.descripcion = descripcion;
	}

	public ROL(String rol, String descripcion) {
		super();

		this.rol = rol;
		this.descripcion = descripcion;
	}

	public ROL() {
		super();
	}

	// Getters y setters.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Otros metodos.

	@Override
	public String toString() {
		return "ROL [id=" + id + ", rol=" + rol + ", descripcion=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ROL other = (ROL) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

}
