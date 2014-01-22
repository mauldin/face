/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import com.sam.model.Loginuser;
import java.util.List;
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
    
    public Loginuser find(String name, String password) {
        log.info("samster! " + name + " " + password);
        Loginuser user = null;
        try{
            user = (Loginuser) em.createNamedQuery("Loginuser.findUserOnInfo")
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
    
    public List<Loginuser> findAll() {
        return em.createNamedQuery("Loginuser.findAll")
                .getResultList();
    }
}
