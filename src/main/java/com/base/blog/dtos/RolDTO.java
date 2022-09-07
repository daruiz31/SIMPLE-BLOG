package com.base.blog.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.base.blog.entities.Rol;

public class RolDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long idRol;
	@NotBlank
	private String role;
	@NotBlank
	private String description;
	@NotNull
	private Integer enabled;

	public RolDTO() {
		super();
	}

	public RolDTO(@NotNull Long idRol, @NotBlank String role, @NotBlank String description, @NotNull Integer enabled) {
		super();
		this.idRol = idRol;
		this.role = role;
		this.description = description;
		this.enabled = enabled;
	}

	public RolDTO(Rol rol) {
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
		RolDTO other = (RolDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(idRol, other.idRol) && Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "RolDTO [idRol=" + idRol + ", role=" + role + ", description=" + description + ", enabled=" + enabled
				+ "]";
	}

}
