package com.base.blog.services.implementations;

import org.springframework.stereotype.Service;

import com.base.blog.services.IPasswordService;

@Service
public class SHA1Impl implements IPasswordService {

	/**
	 * Generate a new text with SHA1 algorithm
	 * @Param text
	 * String - text to convert to SHA1
	 * @Return String Text converted to SHA1
	 */
	@Override
	public String createHash(String text) {
		return org.apache.commons.codec.digest.DigestUtils.sha1Hex(text);
	}

}
