package com.base.blog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.base.blog.dtos.UserDTO;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusers", unique = true, nullable = false)
	private Long idUser;

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotBlank
	@Column(unique = true)
	private String email;
	@NotBlank
	private String password;
	@NotNull
	private Integer enabled;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRol")
	private Rol rol;

	public User() {
		super();
	}

	public User(@NotBlank String name, @NotBlank String surname, @NotBlank String email, @NotBlank String password,
			@NotNull Integer enabled, Rol rol) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.rol = rol;
	}
	
	
	public User(@Nullable Long idUser, @NotBlank String name, @NotBlank String surname, @NotBlank String email,
			@NotBlank String password, @NotNull Integer enabled, @NotNull Rol rol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.rol = rol;
	}

	public User(UserDTO user) {
		super();
		this.idUser = user.getIdUser() != null ? user.getIdUser() : this.idUser;
		this.name = user.getName().isBlank() ? this.name : user.getName();
		this.surname = user.getSurname().isBlank() ? this.surname : user.getSurname();
		this.email = user.getEmail().isBlank() ? this.email : user.getEmail();
		this.password = user.getPassword().isBlank() ? this.password : user.getPassword();
		this.enabled = user.getEnabled() != null ? user.getEnabled() : this.enabled;
		this.rol = user.getRol() != null ? new Rol(user.getRol()) : this.rol;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enabled, rol, idUser, name, password, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(rol, other.rol) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", enabled=" + enabled + ", rol=" + rol + "]";
	}

}
