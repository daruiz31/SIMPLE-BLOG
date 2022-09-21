package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.ILoginService;

@SpringBootTest
class LoginImplTest {

	@Autowired
	private ILoginService iLoginService;

	@Value("${test.impl.login.email}")
	private String email;

	@Value("${test.impl.login.password}")
	private String password;

	@Test
	void login() {
		try {
			assertTrue(iLoginService.login(email, password).getStateProcess(), "Function login for LoginImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}
	}

}