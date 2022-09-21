package com.base.blog.services;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.RolDTO;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;

public interface IRolesService {

	ResponseBlog<RolDTO> findByRole(String role) throws SimpleBlogException;
	
	ResponseBlog<RolDTO> findById(Long idRole) throws SimpleBlogException;
	
	ResponseBlog<RolDTO> searchUserRol(UserDTO user) throws SimpleBlogException;

}
