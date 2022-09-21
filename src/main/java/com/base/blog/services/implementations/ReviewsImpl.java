package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.NotFoundException;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.repositories.IReviewsRepository;
import com.base.blog.services.IReviewsService;

@Service
public class ReviewsImpl implements IReviewsService {

	private static final Logger LOG = LoggerFactory.getLogger(ReviewsImpl.class);

	@Autowired
	private IReviewsRepository iReviewsRepository;

	@Override
	public ResponseBlog<ReviewDTO> findById(Long idReview) throws SimpleBlogException {
		try {
			return new ResponseBlog<>(true, "Found review", new ReviewDTO(iReviewsRepository.findById(idReview)
					.orElseThrow(() -> new NotFoundException("ERROR-REVIEW-FIND-BY-ID"))));
		} catch (Exception e) {
			String message = "Error find idReview {" + idReview + "} : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

}