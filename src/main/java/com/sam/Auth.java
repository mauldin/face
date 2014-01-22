/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sam;

import com.sam.model.Loginuser;
import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sam
 */
@ManagedBean
@ViewScoped
public class Auth {

    private String username;
    private String password;
    private String originalURL;

    @ManagedProperty(value="#{sessionData}")
    private SessionData sessionData;
    
    @Inject
    private Logger log;
    
    @PostConstruct
    public void init() {
        //No idea tbh
    }

    @EJB
    private UserService userService;

    public String login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        log.info("hey sammy!");
        try {
            request.login(username, password);
            Loginuser user = userService.find(username, org.apache.commons.codec.digest.DigestUtils.sha256Hex(password));
            sessionData.setUser(username);
            return "success";
        } catch (ServletException e) {
            // Handle unknown username/password in request.login().
           // context.addMessage(null, new FacesMessage("Unknown login"));
        }
        return "failure";
    }

    public void logout() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public SessionData getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }

    
}
