package com.vuln.webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.vuln.webapp.db.DatabaseConnectionManager;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	
    	String url = ctx.getInitParameter("DBURL");
    	String u = ctx.getInitParameter("DBUSER");
    	String p = ctx.getInitParameter("DBPWD");
    	
    	//create database connection from init parameters and set it to context
    	DatabaseConnectionManager dbManager = new DatabaseConnectionManager(url, u, p);
    	ctx.setAttribute("DBManager", dbManager);
    	System.out.println("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	DatabaseConnectionManager dbManager = (DatabaseConnectionManager) ctx.getAttribute("DBManager");
    	dbManager.closeConnection();
    	System.out.println("Database connection closed for Application.");
    	
    }
	
}
