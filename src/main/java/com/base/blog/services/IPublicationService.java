package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IPublicationService {

	ResponseBlog<ReviewDTO> createReview(ReviewDTO review, Long idUser) throws SimpleBlogException;

}
