package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;

public interface ILoginService {

	ResponseBlog<String> login(String email, String password);
}
