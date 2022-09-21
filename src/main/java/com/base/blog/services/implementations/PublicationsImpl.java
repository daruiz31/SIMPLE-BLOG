package com.base.blog.services.implementations;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.ReviewDTO;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IPublicationsService;
import com.base.blog.services.IReviewsService;
import com.base.blog.services.IUsersService;

@Service
public class PublicationsImpl implements IPublicationsService {

	private static final Logger LOG = LoggerFactory.getLogger(PublicationsImpl.class);

	@Value("${simple.blog.properties.default.role}")
	private String defaultRole;

	@Autowired
	private IUsersService iUsersService;

	@Autowired
	private IReviewsService iReviewsService;

	@Override
	public ResponseBlog<ReviewDTO> createReview(ReviewDTO review, Long idUser) throws SimpleBlogException {
		LOG.info("PUBLISHING NEW REVIEW ...");

		// Find user by id
		ResponseBlog<UserDTO> responseUserFound = iUsersService.findById(idUser);

		// Validate search
		if (Boolean.FALSE.equals(responseUserFound.getStateProcess())) {
			return new ResponseBlog<>(false, responseUserFound.getResponseMessage());
		}

		// Set object user
		review.setUser(responseUserFound.getData());

		// Set date created
		review.setDateCreated(new Date());

		return iReviewsService.saveReview(review);
	}

	@Override
	public ResponseBlog<List<ReviewDTO>> listReviewsByDefaultRole() throws SimpleBlogException {
		LOG.info("LISTING REVIEWS BY ROLE {} ...", defaultRole);		
		return iReviewsService.listAllByRole(defaultRole);
	}

}
