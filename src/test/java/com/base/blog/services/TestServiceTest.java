package com.base.blog.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.dtos.ResponseBlog;

@SpringBootTest
public class TestServiceTest {

	@Autowired
	private ITestService iTestService;

	@Test
	@Tag("ITestService.test")
	void contextLoads() {
		ResponseBlog<String> testService = iTestService.test();
		assertTrue(testService.getStatus(), "Function test for ITestService - OK");
	}

}
