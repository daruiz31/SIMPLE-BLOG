package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface ILoginService {

	ResponseBlog<UserDTO> login(String email, String password) throws SimpleBlogException;
}
