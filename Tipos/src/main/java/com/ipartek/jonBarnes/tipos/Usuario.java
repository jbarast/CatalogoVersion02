package com.ipartek.jonBarnes.tipos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * POJO usuario, para guardar datos de lo usuario.
 * 
 * @author jonBarnes
 * @version 23/06/2017
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	// Al ser serializable parametro que necesita.
	private static final long serialVersionUID = 1L;

	// atributos.
	@Id
	// @Column(name = "id")
	@GeneratedValue
	private long id;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_rol")
	private ROL idRoles;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "nombre_completo")
	private String nombreCompleto;

	// Constructores.
	public Usuario(long id, ROL idRoles, String username, String password, String nombreCompleto) {
		super();
		this.id = id;
		this.idRoles = idRoles;
		this.username = username;
		this.password = password;
		this.nombreCompleto = nombreCompleto;
	}

	// Un constructor muy interesante.
	// public usuario(String username, String password,String nombreCompleto){
	// super();

	// this.username = username;
	// this.password = password;
	// this.nombreCompleto = nombreCompleto;
	// }

	public Usuario(ROL idRoles, String username, String password, String nombreCompleto) {
		super();
		this.idRoles = idRoles;
		this.username = username;
		this.password = password;
		this.nombreCompleto = nombreCompleto;
	}

	public Usuario(String username, String password, String nombreCompleto) {
		super();
		this.username = username;
		this.password = password;
		this.nombreCompleto = nombreCompleto;
	}

	public Usuario() {
		super();
	}

	// Getters y setters.

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ROL getId_roles() {
		return idRoles;
	}

	public void setId_roles(ROL id_roles) {
		this.idRoles = id_roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	// Otros metodos.

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", id_roles=" + idRoles + ", username=" + username + ", password=" + password
				+ ", nombreCompleto=" + nombreCompleto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((idRoles == null) ? 0 : idRoles.hashCode());
		result = prime * result + ((nombreCompleto == null) ? 0 : nombreCompleto.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (idRoles == null) {
			if (other.idRoles != null)
				return false;
		} else if (!idRoles.equals(other.idRoles))
			return false;
		if (nombreCompleto == null) {
			if (other.nombreCompleto != null)
				return false;
		} else if (!nombreCompleto.equals(other.nombreCompleto))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
