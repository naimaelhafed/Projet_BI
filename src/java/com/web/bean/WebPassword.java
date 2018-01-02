package com.web.bean;


import com.web.entity.WebUser;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

public class WebPassword  {
    @NotNull
    private String password,newPassword,passwordConfirmation;

    private WebUser user;

    public WebPassword(HttpServletRequest request) {
        if (request.getParameter("password") != null) {
            this.password = request.getParameter("password");
        }
        if (request.getParameter("newPassword") != null) {
            this.newPassword = request.getParameter("newPassword");
        }
        if (request.getParameter("passwordConfirmation") != null) {
            this.passwordConfirmation = request.getParameter("passwordConfirmation");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public WebUser getUser() {
        return user;
    }

    public void setUser(WebUser user) {
        this.user = user;
    }
    
    
    
  
}
