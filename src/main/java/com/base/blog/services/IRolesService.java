package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.RolDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IRolesService {

	ResponseBlog<RolDTO> findByRole(String role) throws SimpleBlogException;

}
