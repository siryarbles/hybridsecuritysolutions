package com.vuln.webapp.listener;


import com.vuln.webapp.db.DatabaseConnectionManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;


@WebListener
public class AppContextListener implements ServletContextListener {
	
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	final ConfigurationFactory source; 
        
    	//initialize DB Connection
    	String dbURL = ctx.getInitParameter("dbURL");
    	String user = ctx.getInitParameter("dbUser");
    	String pwd = ctx.getInitParameter("dbPassword");
    	
    	try {
			DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(dbURL, user, pwd);
			ctx.setAttribute("DBConnection", connectionManager.getConnection());
			System.out.println("DB Connection initialized successfully.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	//initialize log4j
    	String log4jConfig = ctx.getInitParameter("log4j-config");
    	if(log4jConfig == null){
    		System.err.println("No log4j-config init param, initializing log4j with BasicConfigurator");
			
    		Configurator.initialize(new DefaultConfiguration());
    	}else {
			String webAppPath = ctx.getRealPath("/");
			String log4jProp = webAppPath + log4jConfig;
			File log4jConfigFile = new File(log4jProp);
			 
			if (log4jConfigFile.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
                 Logger l = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME); 
         

			} else {
				System.err.println(log4jProp + " file not found, initializing log4j with BasicConfigurator");
				Configurator.initialize(new DefaultConfiguration());
			}
		}
    	System.out.println("log4j configured properly");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
    	try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
