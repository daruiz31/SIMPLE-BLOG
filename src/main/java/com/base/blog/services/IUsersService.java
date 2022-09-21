package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IUsersService {

	ResponseBlog<UserDTO> create(UserDTO user) throws SimpleBlogException;

	ResponseBlog<UserDTO> findByEmail(String email) throws SimpleBlogException;

	ResponseBlog<UserDTO> findByEmailAndPassword(String email, String password) throws SimpleBlogException;
	
	ResponseBlog<UserDTO> findById(Long id) throws SimpleBlogException;

}
