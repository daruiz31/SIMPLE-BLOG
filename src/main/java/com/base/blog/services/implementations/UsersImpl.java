package com.base.blog.services.implementations;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.UserDTO;
import com.base.blog.entities.User;
import com.base.blog.exceptions.InternalServerErrorException;
import com.base.blog.exceptions.NotFoundException;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.repositories.IUsersRepository;
import com.base.blog.services.IUsersService;

@Service
public class UsersImpl implements IUsersService {

	private static final Logger LOG = LoggerFactory.getLogger(UsersImpl.class);

	@Autowired
	private IUsersRepository iUsersRepository;

	@Override
	public ResponseBlog<UserDTO> create(UserDTO user) throws SimpleBlogException {
		try {
			User newUser = Optional.of(iUsersRepository.save(new User(user)))
					.orElseThrow(() -> new InternalServerErrorException("ERROR-USER-CREATE"));
			return new ResponseBlog<>(true, "User created", new UserDTO(newUser));
		} catch (Exception e) {
			String message = "Error creating user {" + user + "} : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

	@Override
	public ResponseBlog<UserDTO> findByEmail(String email) throws SimpleBlogException {
		try {
			return new ResponseBlog<>(true, "Found user", new UserDTO(iUsersRepository.findByEmail(email)
					.orElseThrow(() -> new NotFoundException("ERROR-USER-FIND-BY-EMAIL"))));
		} catch (Exception e) {
			String message = "Error searching user by mail {" + email + "} : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

	@Override
	public ResponseBlog<UserDTO> findByEmailAndPassword(String email, String password) throws SimpleBlogException {
		try {
			return new ResponseBlog<>(true, "Found user",
					new UserDTO(iUsersRepository.findByEmailAndPassword(email, password)
							.orElseThrow(() -> new NotFoundException("ERROR-USER-FIND-BY-EMAIL-PASSWORD"))));
		} catch (Exception e) {
			String message = "Error searching user by mail {" + email + "} and password : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

	@Override
	public ResponseBlog<UserDTO> findById(Long id) throws SimpleBlogException {
		try {
			return new ResponseBlog<>(true, "Found user", new UserDTO(
					iUsersRepository.findById(id).orElseThrow(() -> new NotFoundException("ERROR-USER-FIND-BY-ID"))));
		} catch (Exception e) {
			String message = "Error searching user by id {" + id + "} : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

}
