package com.web;

import com.web.entity.WebApplication;
import com.web.entity.WebManager;
import com.web.service.WebEntityManager;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;

public class WebConfig {
    
    private static String driver,url,username,password;

    private static String jspDirectiry="";
    
    private static String dataDirectory="";
    
    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        WebConfig.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        WebConfig.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        WebConfig.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        WebConfig.password = password;
    }

    public static String getJspDirectiry() {
        return jspDirectiry;
    }

    public static void setJspDirectiry(String jspDirectiry) {
        WebConfig.jspDirectiry = jspDirectiry;
    }

    public static String getDataDirectory() {
        return dataDirectory;
    }

    public static void setDataDirectory(String dataDirectory) {
        WebConfig.dataDirectory = dataDirectory;
    }
    
    public static void initialize(ServletContext servletContext){
         WebConfig.setDriver("org.hsqldb.jdbcDriver");
        WebConfig.setPassword("ADMIN");
        WebConfig.setUsername("ADMIN");
        WebConfig.setUrl("jdbc:hsqldb:file:" + servletContext.getRealPath("/WEB-INF/data") + java.io.File.separator + "data.db;hsqldb.lock_file=false;;shutdown=true;");
        WebEntityManager<WebApplication> wm = new WebEntityManager(WebApplication.class);
        List<WebApplication> app = wm.findEntities();
        if (!app.isEmpty()) {
            WebApplication application = app.get(0);
            if(application.getServer()!=null 
                    && application.getDatabase()!=null 
                    && application.getUsername()!=null){
                 WebConfig.setDriver("oracle.jdbc.driver.OracleDriver");
                 WebConfig.setPassword("oracle");
                 WebConfig.setUsername("system");
                 WebConfig.setUrl("jdbc:oracle:thin:@localhost:1521:orcl12c");
            }
        }
        
      /*  
 */
       
        try {
            WebManager manager = new WebManager()
                    .setEmail("ADMIN")
                    .setTelephoneMobile("ADMIN")
                    .setAdmin(true);
            new WebEntityManager(WebManager.class).create(manager);
        } catch (Exception e) {
         }
    }
}