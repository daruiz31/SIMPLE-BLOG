package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.dtos.RolDTO;
import com.base.blog.dtos.UserDTO;
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

	@Override
	public ResponseBlog<RolDTO> findById(Long idRole) throws SimpleBlogException {
		try {
			return new ResponseBlog<>(true, "Found rol", new RolDTO(iRolesRepository.findById(idRole)
					.orElseThrow(() -> new NotFoundException("ERROR-ROLE-FIND-BY-ID"))));
		} catch (Exception e) {
			String message = "Error find idRole {" + idRole + "} : " + e.getMessage();
			LOG.error(message);
			return new ResponseBlog<>(false, message);
		}
	}

	/**
	 * Role of corresponding to user.rol.idRol or defaultRol respectively
	 * @Param user
	 * {@link UserDTO} - use of idRol from RolDTO
	 * @Param defaultRol
	 * String - Default role is used if idRol is not found
	 * @Return {@link ResponseBlog<RolDTO>} Role corresponding to the expected parameters
	 */
	@Override
	public ResponseBlog<RolDTO> setUserRol(UserDTO user, String defaultRol) throws SimpleBlogException {
		ResponseBlog<RolDTO> role;
		if (Boolean.TRUE.equals(user.getRol() != null)) {
			role = findById(user.getRol().getIdRol());
		} else {
			role = findByRole(defaultRol);

		}
		
		// Validate process findByRole
		if (Boolean.FALSE.equals(role.getStateProcess())) {
			return new ResponseBlog<>(false, role.getResponseMessage());
		}
		
		return role;
	}

}
