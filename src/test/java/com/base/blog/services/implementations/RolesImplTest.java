package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.exceptions.SimpleBlogException;

@SpringBootTest
class RolesImplTest {

	@Autowired
	private RolesImpl rolesImpl;

	@Value("${simple.blog.properties.default.role}")
	private String defaultRol;

	@Test
	@Tag("IRolesService.findByRole")
	void findByRole() {
		try {
			assertTrue(rolesImpl.findByRole(defaultRol).getStateProcess(),
					"Function findByRole for RolesImpl - FAILED");
		} catch (SimpleBlogException e) {
			fail(e.toString());
		}
	}

}
