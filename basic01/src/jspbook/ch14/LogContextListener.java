package jspbook.ch14;

import java.util.logging.*;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public abstract class LogContextListener implements ServletContextListener {
	Logger log;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("LogContextListener stop");
	}
	
	
}

