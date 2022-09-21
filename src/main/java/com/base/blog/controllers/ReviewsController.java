package com.base.blog.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IPublicationService;
import com.base.blog.services.IReviewsService;

@RestController
@RequestMapping(path = "/simpleBlog/v1/review")
public class ReviewsController {

	@Autowired
	private IReviewsService iReviewsService;

	@Autowired
	private IPublicationService iPublicationService;

	@GetMapping("/findById")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ResponseBlog<ReviewDTO>> findById(@RequestParam @NotNull @Valid Long idReview) {
		try {
			ResponseBlog<ReviewDTO> responseFindById = iReviewsService.findById(idReview);
			return Boolean.FALSE.equals(responseFindById.getStateProcess())
					? ResponseEntity.badRequest().body(responseFindById)
					: ResponseEntity.accepted().body(responseFindById);
		} catch (SimpleBlogException e) {
			return ResponseEntity.internalServerError().body(new ResponseBlog<>(false, e.toString()));
		}
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ResponseBlog<ReviewDTO>> saveReview(@RequestParam @NotNull @Valid Long idUser,
			@RequestBody @Valid ReviewDTO review) {
		try {
			ResponseBlog<ReviewDTO> responseSaveReview = iPublicationService.createReview(review, idUser);
			return Boolean.FALSE.equals(responseSaveReview.getStateProcess())
					? ResponseEntity.badRequest().body(responseSaveReview)
					: ResponseEntity.accepted().body(responseSaveReview);
		} catch (SimpleBlogException e) {
			return ResponseEntity.internalServerError().body(new ResponseBlog<>(false, e.toString()));
		}
	}

}
