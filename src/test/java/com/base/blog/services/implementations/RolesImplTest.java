package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IRolesService;

@SpringBootTest
class RolesImplTest {

	@Autowired
	private IRolesService iRolesService;

	@Value("${simple.blog.properties.default.role}")
	private String defaultRol;

	@Test
	void findByRole() {
		try {
			assertTrue(iRolesService.findByRole(defaultRol).getStatus(), "Function findByRole for RolesImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}
	}

}
