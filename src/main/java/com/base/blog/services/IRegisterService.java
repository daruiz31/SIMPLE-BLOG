package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IRegisterService {
	
	ResponseBlog<UserDTO> createUser(UserDTO user) throws SimpleBlogException;

}
