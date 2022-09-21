package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IReviewsService {
	
	ResponseBlog<ReviewDTO> findById(Long idReview) throws SimpleBlogException;
	
	ResponseBlog<ReviewDTO> saveReview(ReviewDTO review) throws SimpleBlogException;

}
