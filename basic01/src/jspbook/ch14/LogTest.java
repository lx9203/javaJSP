package jspbook.ch14;

import org.slf4j.*;

public class LogTest {
	private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		String msg = "Hello Log";
		LOG.info("Test log");
		LOG.warn("Test log : {}", msg);
		LOG.debug("degug level test");
		LOG.trace("degug level test");
		
/*	public static void main(String[] args) {
		String msg = "Hello Log";
		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.info("Test log");
		logger.warn("Test log : {}", msg);
		*/
	}
	
}
