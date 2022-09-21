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
public class RegisterUserImpl implements IRegisterService {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterUserImpl.class);

	@Autowired
	private IUsersService iUsersService;

	@Autowired
	private IPasswordService iPasswordService;

	@Autowired
	private IRolesService iRolesService;

	@Value("${simple.blog.properties.default.role}")
	private String defaultRol;

	/**
	 * Create and enabled basic user with SHA1 password
	 * @Param user
	 * {@link UserDTO} - User to create
	 * @return {@link ResponseBlog<UserDTO>} User created
	 */
	@Override
	public ResponseBlog<UserDTO> createUser(UserDTO user) throws SimpleBlogException {
		LOG.info("STARTING USER CREATION PROCESS ...");

		// Hash password
		iPasswordService = new SHA1Impl();
		user.setPassword(iPasswordService.createHash(user.getPassword()));

		// Enable user
		user.setEnabled(1);

		// Assign role by user or defaultRol
		ResponseBlog<RolDTO> assignRol = iRolesService.setUserRol(user, defaultRol);
		if (Boolean.FALSE.equals(assignRol.getStateProcess())) {
			return new ResponseBlog<>(false, assignRol.getResponseMessage());
		}
		user.setRol(assignRol.getData());

		// Create user and response
		return iUsersService.create(user);
	}

}
