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
import com.base.blog.services.IRolesService;
import com.base.blog.services.IUsersService;

@Service
public class RegisterImpl implements IRegisterService {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterImpl.class);

	@Autowired
	private IUsersService iUsersService;

	@Autowired
	private IPasswordService iPasswordService;

	@Autowired
	private IRolesService iRolesService;
	

	@Override
	public ResponseBlog<UserDTO> createUser(UserDTO user) throws SimpleBlogException {
		LOG.info("STARTING USER CREATION PROCESS ...");
		
		// Hash password
		user.setPassword(iPasswordService.encodeSHA1(user.getPassword()));

		// Enable user
		user.setEnabled(1);
		
		// Assign role to user
		ResponseBlog<RolDTO> assignRol = iRolesService.searchUserRol(user);
		if(Boolean.FALSE.equals(assignRol.getStateProcess())) {
			return new ResponseBlog<>(false, assignRol.getResponseMessage());
		}
		user.setRol(assignRol.getData());		
		
		// Create user and response 
		return iUsersService.create(user);
	}

}
