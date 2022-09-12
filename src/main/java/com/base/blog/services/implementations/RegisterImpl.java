package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.RolDTO;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.IPasswordService;
import com.base.blog.services.IRegisterService;
import com.base.blog.services.IUsersService;

@Service
public class RegisterImpl implements IRegisterService {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterImpl.class);

	@Autowired
	private IUsersService iUsersService;

	@Autowired
	private IPasswordService iPasswordService;

	@Override
	public ResponseBlog<UserDTO> createUser(UserDTO user) throws SimpleBlogException {
		// Hash password
		user.setPassword(iPasswordService.encodeSHA1(user.getPassword()));

		// Enable user
		user.setEnabled(1);

		// Assign role to user
		user.setIdRol(new RolDTO(1L, "USER", "registered users", 1));

		LOG.info("STARTING USER CREATION PROCESS {}", user);
		return iUsersService.create(user);
	}

}
