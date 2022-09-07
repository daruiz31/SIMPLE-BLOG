package com.base.blog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.base.blog.dtos.RolDTO;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idroles")
	private Long idRol;

	@NotBlank
	private String role;
	@NotBlank
	private String description;
	@NotNull
	private Integer enabled;

	public Rol() {
		super();
	}

	public Rol(@NotNull Long idRol, @NotBlank String role, @NotBlank String description, @NotNull Integer enabled) {
		super();
		this.idRol = idRol;
		this.role = role;
		this.description = description;
		this.enabled = enabled;
	}

	public Rol(RolDTO rol) {
		super();
		this.idRol = rol.getIdRol() != null ? rol.getIdRol() : this.idRol;
		this.role = rol.getRole().isBlank() ? this.role : rol.getRole();
		this.description = rol.getDescription().isBlank() ? this.description : rol.getDescription();
		this.enabled = rol.getEnabled() != null ? rol.getEnabled() : this.enabled;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, enabled, idRol, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(description, other.description) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(idRol, other.idRol) && Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", role=" + role + ", description=" + description + ", enabled=" + enabled + "]";
	}

}
