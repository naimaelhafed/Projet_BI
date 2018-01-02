package com.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener()
public class WebApplicationtListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebConfig.initialize(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
