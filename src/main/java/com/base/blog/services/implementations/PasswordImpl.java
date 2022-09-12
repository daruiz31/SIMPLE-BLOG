package com.base.blog.services.implementations;

import org.springframework.stereotype.Service;

import com.base.blog.services.IPasswordService;

@Service
public class PasswordImpl implements IPasswordService {

	@Override
	public String encodeSHA1(String text) {
		return org.apache.commons.codec.digest.DigestUtils.sha1Hex(text);
	}

}
