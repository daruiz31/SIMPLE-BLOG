package com.base.blog.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.base.blog.dtos.RespuestaGenerica;

@Service
public class TestImpl implements ITestService {

	private static final Logger LOG = LoggerFactory.getLogger(TestImpl.class);

	@Override
	public RespuestaGenerica<String> test() {
		LOG.info("TEST OK");
		return new RespuestaGenerica<>(true, "TEST", "OK");
	}

}
