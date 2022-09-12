package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.services.ILoginService;
import com.base.blog.services.IPasswordService;
import com.base.blog.services.IUsersService;

@Service
public class LoginImpl implements ILoginService {

	private static final Logger LOG = LoggerFactory.getLogger(LoginImpl.class);

	@Autowired
	private IUsersService iUsersService;

	@Autowired
	private IPasswordService iPasswordService;

	@Override
	public ResponseBlog<UserDTO> login(String email, String password) throws SimpleBlogException {
		LOG.info("LOGGGING IN FOR USER ...");
		
		// Hash password
		password = iPasswordService.encodeSHA1(password);

		// Consult the database by email and password
		ResponseBlog<UserDTO> user = iUsersService.findByEmailAndPassword(email, password);
		
		// Bad answer
		if (Boolean.FALSE.equals(user.getStatus())) {
			return new ResponseBlog<>(false, user.getMessage());
		}

		// Correct answer
		return new ResponseBlog<>(true, "Correct user", user.getData());
	}

}
