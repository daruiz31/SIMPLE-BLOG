package com.base.blog.services.implementations;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.services.ITestService;

@SpringBootTest
class TestImplTest {

	@Autowired
	private ITestService iTestService;	

	@Test
	@Tag("ITestService.test")
	void contextLoads() {
		ResponseBlog<String> testService = iTestService.test();
		assertTrue(testService.getStateProcess(), "Function test for TestImpl - FAILED");
	}

}
