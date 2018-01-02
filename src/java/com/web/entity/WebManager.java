package com.web.entity;

import com.web.service.WebEntityManager;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;


@Entity
@Table
@NamedQueries(value = {
    @NamedQuery(name = "WebManager.findByEmail",query = "SELECT c FROM WebManager c WHERE c.email LIKE CONCAT('%', ?1,'%')" ),
    @NamedQuery(name = "WebManager.findByTelephone",query = "SELECT c FROM WebManager c WHERE c.telephoneMobile LIKE CONCAT('%', ?1,'%')" )
})
public class WebManager extends WebEntity {
    
    
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull
    @Column(nullable = false, unique = true)
    private String telephoneMobile;
    @Column
    private boolean admin;
    
    public WebManager(){}
    
    public WebManager(HttpServletRequest request) { 
        super(request);
        if (request.getParameter("email") != null) {
            this.email = request.getParameter("email");
        }
        if (request.getParameter("telephoneMobile") != null) {
            this.telephoneMobile = request.getParameter("telephoneMobile");
        }
        
    }
    public String getEmail() {
        return email;
    }

    public WebManager setEmail(String email) {
        this.email = email;
        return this;
    }

   
    public String getTelephoneMobile() {
        return telephoneMobile;
    }
    public WebManager setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
        return this;
    }

    public boolean isAdmin() {
        return admin;
    }

    public WebManager setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }
    
    
   @PostPersist
    public void trrigerAfterInsert(){
       WebEntityManager<WebUser> userManager=new WebEntityManager<>(WebUser.class);
       WebUser user=new WebUser();
       user
               .setPassword(telephoneMobile)
               .setUsername(email)
               .setEmail(email);
       if(admin){
           user.setRole(WebRole.ADMIN);
       }
       userManager.create(user);
    }
    
    @Override
    public String toString() {
        return "Projet BI";
    }
}