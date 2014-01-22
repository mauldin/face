/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sam.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "loginuser", schema = "jboss")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loginuser.findAll", query = "SELECT l FROM Loginuser l"),
    @NamedQuery(name = "Loginuser.findByIduser", query = "SELECT l FROM Loginuser l WHERE l.iduser = :iduser"),
    @NamedQuery(name = "Loginuser.findByName", query = "SELECT l FROM Loginuser l WHERE l.name = :name"),
    @NamedQuery(name = "Loginuser.findByPassword", query = "SELECT l FROM Loginuser l WHERE l.password = :password"),
    @NamedQuery(name = "Loginuser.findUserOnInfo", query = "SELECT l FROM Loginuser l WHERE l.password = :password and l.name = :name")})
public class Loginuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iduser")
    private Integer iduser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "password")
    private String password;

    public Loginuser() {
    }

    public Loginuser(Integer iduser) {
        this.iduser = iduser;
    }

    public Loginuser(Integer iduser, String name, String password) {
        this.iduser = iduser;
        this.name = name;
        this.password = password;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loginuser)) {
            return false;
        }
        Loginuser other = (Loginuser) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sam.Model.Loginuser[ iduser=" + iduser + " ]";
    }
    
}
