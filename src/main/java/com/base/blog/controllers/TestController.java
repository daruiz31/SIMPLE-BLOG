package com.base.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.services.ITestService;

@RestController
@RequestMapping(path = "/simpleBlog/v1/test")
public class TestController {

	@Autowired
	private ITestService iTestService;

	@GetMapping("/")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseBlog<String> test() {
		return iTestService.test();
	}

}
