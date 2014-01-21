/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author sam
 */
@Stateless
public class UserService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    public LoginUser find(String name, String password) {
        log.info("samster! " + name + " " + password);
        LoginUser user = null;
        try{
            user = (LoginUser) em.createNamedQuery("findUserOnInfo")
                    .setParameter("name", name)
                    .setParameter("password", password)
                    .getSingleResult();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        log.info("word em up nigga");
        return user;
    }
}
