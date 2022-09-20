package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${simple.blog.properties.default.role}")
	private String defaultRol;

	@Override
	public ResponseBlog<UserDTO> createUser(UserDTO user) throws SimpleBlogException {
		LOG.info("STARTING USER CREATION PROCESS ...");
		
		// Hash password
		user.setPassword(iPasswordService.encodeSHA1(user.getPassword()));

		// Enable user
		user.setEnabled(1);

		// Assign role to user
		if (Boolean.TRUE.equals(user.getIdRol() == null)) {
			ResponseBlog<RolDTO> role = iRolesService.findByRole(defaultRol);
			if (Boolean.FALSE.equals(role.getStateProcess())) {
				return new ResponseBlog<>(false, role.getResponseMessage());
			}
			user.setIdRol(role.getData());
		}
		
		return iUsersService.create(user);
	}

}
