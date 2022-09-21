package com.base.blog.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IReviewsService;

@RestController
@RequestMapping(path = "/simpleBlog/v1/review")
public class ReviewsController {

	@Autowired
	private IReviewsService iReviewsService;

	@GetMapping("/findById")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ResponseBlog<ReviewDTO>> findById(@RequestParam @NotNull @Valid Long idReview) {
		try {
			ResponseBlog<ReviewDTO> response = iReviewsService.findById(idReview);
			return Boolean.FALSE.equals(response.getStateProcess()) ? ResponseEntity.badRequest().body(response)
					: ResponseEntity.accepted().body(response);
		} catch (SimpleBlogException e) {
			return ResponseEntity.internalServerError().body(new ResponseBlog<>(false, e.toString()));
		}
	}

}
