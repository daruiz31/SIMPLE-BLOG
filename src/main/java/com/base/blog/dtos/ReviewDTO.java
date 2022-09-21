package com.base.blog.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.base.blog.entities.Review;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Nullable
	private Long idReviews;

	@Nullable
	private Date dateCreated;

	@NotBlank
	private String title;
	@NotBlank
	private String description;
	@Nullable
	private UserDTO user;

	public ReviewDTO() {
		super();
	}

	public ReviewDTO(@NotBlank String title, @NotBlank String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public ReviewDTO(Date dateCreated, @NotBlank String title, @NotBlank String description) {
		super();
		this.dateCreated = dateCreated;
		this.title = title;
		this.description = description;
	}

	public ReviewDTO(@NotNull Date dateCreated, @NotBlank String title, @NotBlank String description,
			@NotNull UserDTO user) {
		super();
		this.dateCreated = dateCreated;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public ReviewDTO(Long idReviews, @NotNull Date dateCreated, @NotBlank String title, @NotBlank String description,
			@NotNull UserDTO user) {
		super();
		this.idReviews = idReviews;
		this.dateCreated = dateCreated;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public ReviewDTO(Review review) {
		super();
		this.idReviews = review.getIdReviews() != null ? review.getIdReviews() : this.idReviews;
		this.dateCreated = review.getDateCreated() != null ? review.getDateCreated() : this.dateCreated;
		this.title = review.getTitle().isBlank() ? this.title : review.getTitle();
		this.description = review.getDescription().isBlank() ? this.description : review.getDescription();
		this.user = review.getUser() != null ? new UserDTO(review.getUser()) : this.user;
	}

	public Long getIdReviews() {
		return idReviews;
	}

	public void setIdReviews(Long idReviews) {
		this.idReviews = idReviews;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ReviewDTO [idReviews=" + idReviews + ", dateCreated=" + dateCreated + ", title=" + title
				+ ", description=" + description + ", user=" + user + "]";
	}

}
