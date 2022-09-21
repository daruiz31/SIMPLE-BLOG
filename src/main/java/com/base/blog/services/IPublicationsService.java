package com.base.blog.services;

import java.util.List;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IPublicationsService {

	ResponseBlog<ReviewDTO> createReview(ReviewDTO review, Long idUser) throws SimpleBlogException;
	
	ResponseBlog<List<ReviewDTO>> listReviewsByDefaultRole() throws SimpleBlogException;

}
