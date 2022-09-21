package com.base.blog.entities;

import java.io.Serializable;
import java.util.Date;

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

import com.base.blog.dtos.ReviewDTO;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreviews", unique = true, nullable = false)
	private Long idReviews;

	@NotNull
	@Column(name = "date_created")
	private Date dateCreated;

	@NotBlank
	private String title;
	@NotBlank
	private String description;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
	private User user;

	public Review() {
		super();
	}

	public Review(@NotNull Date dateCreated, @NotBlank String title, @NotBlank String description, @NotNull User user) {
		super();
		this.dateCreated = dateCreated;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public Review(Long idReviews, @NotNull Date dateCreated, @NotBlank String title, @NotBlank String description,
			@NotNull User user) {
		super();
		this.idReviews = idReviews;
		this.dateCreated = dateCreated;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public Review(ReviewDTO review) {
		super();
		this.idReviews = review.getIdReviews() != null ? review.getIdReviews() : this.idReviews;
		this.dateCreated = review.getDateCreated() != null ? review.getDateCreated() : this.dateCreated;
		this.title = review.getTitle().isBlank() ? this.title : review.getTitle();
		this.description = review.getDescription().isBlank() ? this.description : review.getDescription();
		this.user = review.getUser() != null ? new User(review.getUser()) : this.user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [idReviews=" + idReviews + ", dateCreated=" + dateCreated + ", title=" + title + ", description="
				+ description + ", user=" + user + "]";
	}

}
