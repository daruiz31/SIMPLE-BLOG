package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.exceptions.SimpleBlogException;

@SpringBootTest
class ReviewsImplTest {

	@Autowired
	private ReviewsImpl reviewsImpl;

	@Test
	@Tag("ReviewsImpl.findById")
	void findById() {
		try {
			assertTrue(reviewsImpl.findById(1L).getStateProcess(),
					"Function find review by id for ReviewsImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}
	}

}
