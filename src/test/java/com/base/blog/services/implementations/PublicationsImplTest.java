package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.dtos.ReviewDTO;
import com.base.blog.exceptions.SimpleBlogException;

@SpringBootTest
class PublicationsImplTest {

	@Autowired
	private PublicationsImpl publicationsImpl;

	@Value("${test.impl.publications.user.id}")
	private Long idUser;

	@Test
	@Tag("PublicationsImpl.createReview")
	void createReview() {
		try {
			assertTrue(publicationsImpl
					.createReview(new ReviewDTO(new Date(), "JUnit Tets", "Prueba unitaria automática"), idUser)
					.getStateProcess(), "Function save publication review for PublicationsImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}

	}

}
