package com.base.blog.services;

import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;

@Service
public class LoginImpl implements ILoginService {

	@Override
	public ResponseBlog<String> login(String email, String password) {
		// Validar que los datos no esten vacios
		if (email.isBlank() || password.isBlank()) {
			return new ResponseBlog<>(false, "La petición debe llevar email y password");
		}

		// Consultar en la base de datos por email y password
		String emailDataBase = "hola@g.com";
		String passDataBase = "123";

		// Validar las credenciales
		if (!email.equals(emailDataBase) || !password.equals(passDataBase)) {
			return new ResponseBlog<>(false, "La credenciales no coinciden");
		}

		// Respuesta correcta
		return new ResponseBlog<>(true, "Usuario correcto", "OK");
	}

}
