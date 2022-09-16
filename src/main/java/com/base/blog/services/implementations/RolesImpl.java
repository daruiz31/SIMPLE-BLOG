package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.RolDTO;
import com.base.blog.exceptions.NotFoundException;
import com.base.blog.exceptions.SimpleBlogException;
import com.base.blog.repositories.IRolesRepository;
import com.base.blog.services.IRolesService;

@Service
public class RolesImpl implements IRolesService {

	private static final Logger LOG = LoggerFactory.getLogger(RolesImpl.class);

	@Autowired
	private IRolesRepository iRolesRepository;

	@Override
	public ResponseBlog<RolDTO> findByRole(String role) throws SimpleBlogException {
		try {
			return new ResponseBlog<>(true, "Found rol", new RolDTO(iRolesRepository.findByRole(role)
					.orElseThrow(() -> new NotFoundException("ERROR-ROLE-FIND-BY-ROLE"))));
		} catch (Exception e) {
			String message = "Error find role {" + role + "} : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

}