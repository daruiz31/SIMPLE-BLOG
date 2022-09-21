package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;

@SpringBootTest
class RegisterUserImplTest {

	@Autowired
	private RegisterUserImpl registerUserImpl;

	@Test
	@Tag("IRegisterService.createUser")
	void createUser() {
		SecureRandom secureRandom = new SecureRandom();
		try {
			assertTrue(
					registerUserImpl.createUser(new UserDTO("JUnitTest", "Auto",
							"_" + String.valueOf(secureRandom.nextInt()) + "@JUnit.test",
							String.valueOf(secureRandom.nextInt()))).getStateProcess(),
					"Function createUser for RegisterImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}
	}

}
