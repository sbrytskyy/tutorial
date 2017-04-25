package com.gl.vz.logging.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOG.debug("debug");
		LOG.info("info");
		LOG.error("error");
	}
}
