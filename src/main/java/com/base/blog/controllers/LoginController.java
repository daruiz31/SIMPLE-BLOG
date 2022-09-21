package com.base.blog.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.ILoginService;

@RestController
@RequestMapping(path = "/simpleBlog/v1/login")
public class LoginController {

	@Autowired
	private ILoginService iLoginService;

	/**
	 * Login user with email and password
	 * @param email
	 * String - user mail 
	 * @param password
	 * String - user password
	 * @return {@link ResponseBlog<UserDTO>}
	 * Generic ResponseBlog response with UserDTO login data
	 */
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ResponseBlog<UserDTO>> login(@RequestParam @NotBlank @Valid String email,
			@RequestParam @NotBlank @Valid String password) {
		try {
			ResponseBlog<UserDTO> responseLogin = iLoginService.login(email, password);
			return Boolean.FALSE.equals(responseLogin.getStateProcess()) ? ResponseEntity.badRequest().body(responseLogin)
					: ResponseEntity.ok().body(responseLogin);
		} catch (SimpleBlogException e) {
			return ResponseEntity.internalServerError().body(new ResponseBlog<>(false, e.toString()));
		}
	}

}
