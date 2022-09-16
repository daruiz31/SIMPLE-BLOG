package com.base.blog.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.ResponseBlog;
import com.base.blog.services.ITestService;

@Service
public class TestImpl implements ITestService {

	private static final Logger LOG = LoggerFactory.getLogger(TestImpl.class);

	@Override
	public ResponseBlog<String> test() {
		LOG.info("SIMPLE TEST OK");
		return new ResponseBlog<>(true, "TEST", "OK");
	}

}
