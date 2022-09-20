package com.base.blog.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IRegisterService;

@RestController
@RequestMapping(path = "/simpleBlog/v1/register")
public class RegisterController {

	@Autowired
	private IRegisterService iRegisterService;

	/**
	 * Register user with information of the UserDTO object
	 * @param user Object
	 * UserDTO - Required registration information for user
	 * @return ResponseBlog<UserDTO>
	 * Generic ResponseBlog response with UserDTO saved register
	 * @throws SimpleBlogException
	 */
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<ResponseBlog<UserDTO>> createUser(@RequestBody @NotNull @Valid UserDTO user)
			throws SimpleBlogException {
		try {
			ResponseBlog<UserDTO> response = iRegisterService.createUser(user);
			return Boolean.FALSE.equals(response.getStateProcess()) ? ResponseEntity.badRequest().body(response)
					: ResponseEntity.accepted().body(response);
		} catch (SimpleBlogException e) {
			return ResponseEntity.internalServerError().body(new ResponseBlog<>(false, e.toString()));
		}
	}

}
