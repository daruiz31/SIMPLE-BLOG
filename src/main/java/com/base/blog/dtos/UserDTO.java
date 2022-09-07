package com.base.blog.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.base.blog.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long idUser;
	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotNull
	private Integer enabled;
	@Nullable
	private RolDTO idRol;

	public UserDTO() {
		super();
	}

	public UserDTO(@NotNull Long idUser, @NotBlank String name, @NotBlank String surname, @NotBlank String email,
			@NotBlank String password, @NotNull Integer enabled) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public UserDTO(@NotNull Long idUser, @NotBlank String name, @NotBlank String surname, @NotBlank String email,
			@NotBlank String password, @NotNull Integer enabled, RolDTO idRol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.idRol = idRol;
	}

	public UserDTO(User user) {
		super();
		this.idUser = user.getIdUser() != null ? user.getIdUser() : this.idUser;
		this.name = user.getName().isBlank() ? this.name : user.getName();
		this.surname = user.getSurname().isBlank() ? this.surname : user.getSurname();
		this.email = user.getEmail().isBlank() ? this.email : user.getEmail();
		this.password = user.getPassword().isBlank() ? this.password : user.getPassword();
		this.enabled = user.getEnabled() != null ? user.getEnabled() : this.enabled;
		this.idRol = user.getIdRol() != null ? new RolDTO(user.getIdRol()) : this.idRol;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public RolDTO getIdRol() {
		return idRol;
	}

	public void setIdRol(RolDTO idRol) {
		this.idRol = idRol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enabled, idRol, idUser, name, password, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(idRol, other.idRol) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "UserDTO [idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + ", enabled=" + enabled + ", idRol=" + idRol + "]";
	}

}
