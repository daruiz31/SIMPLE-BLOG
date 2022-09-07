package com.base.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.services.ILoginService;

@RestController
@RequestMapping(path = "/simpleBlog/v1/login")
public class LoginController {

	@Autowired
	private ILoginService iLoginService;

	@GetMapping("/sesion")
	@ResponseStatus(HttpStatus.OK)
	public ResponseBlog<String> login(@RequestParam String email, @RequestParam String password) {
		return iLoginService.login(email, password);
	}

}
