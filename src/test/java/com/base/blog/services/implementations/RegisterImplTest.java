package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IRegisterService;

@SpringBootTest
class RegisterImplTest {

	@Autowired
	private IRegisterService iRegisterService;

	@Test
	void createUser() {
		SecureRandom secureRandom = new SecureRandom();

		try {
			assertTrue(
					iRegisterService.createUser(new UserDTO("JUnitTest", "Auto",
							"_" + String.valueOf(secureRandom.nextInt()) + "@JUnit.test",
							String.valueOf(secureRandom.nextInt()))).getStateProcess(),
					"Function createUser for RegisterImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}
	}

}
