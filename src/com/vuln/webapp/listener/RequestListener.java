package com.vuln.webapp.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    	ServletRequest servletRequest = servletRequestEvent.getServletRequest();
    	System.out.println("ServletRequest destroyed. Remote IP="+servletRequest.getRemoteAddr());
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    	ServletRequest servletRequest = servletRequestEvent.getServletRequest();
    	System.out.println("ServletRequest initialized. Remote IP="+servletRequest.getRemoteAddr());
    }
	
}
