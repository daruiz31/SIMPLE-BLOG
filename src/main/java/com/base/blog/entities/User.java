package com.base.blog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
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
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusers")
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

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol")
	private Rol idRol;

	public User() {
		super();
	}

	public User(@NotBlank String name, @NotBlank String surname, @NotBlank String email, @NotBlank String password,
			@NotNull Integer enabled, Rol idRol) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.idRol = idRol;
	}
	
	
	public User(@Nullable Long idUser, @NotBlank String name, @NotBlank String surname, @NotBlank String email,
			@NotBlank String password, @NotNull Integer enabled, @NotNull Rol idRol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.idRol = idRol;
	}

	public User(UserDTO user) {
		super();
		this.idUser = user.getIdUser() != null ? user.getIdUser() : this.idUser;
		this.name = user.getName().isBlank() ? this.name : user.getName();
		this.surname = user.getSurname().isBlank() ? this.surname : user.getSurname();
		this.email = user.getEmail().isBlank() ? this.email : user.getEmail();
		this.password = user.getPassword().isBlank() ? this.password : user.getPassword();
		this.enabled = user.getEnabled() != null ? user.getEnabled() : this.enabled;
		this.idRol = user.getIdRol() != null ? new Rol(user.getIdRol()) : this.idRol;
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

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
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
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(idRol, other.idRol) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", enabled=" + enabled + ", idRol=" + idRol + "]";
	}

}
