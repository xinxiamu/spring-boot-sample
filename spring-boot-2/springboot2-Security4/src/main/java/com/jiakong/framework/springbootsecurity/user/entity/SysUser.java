package com.jiakong.framework.springbootsecurity.user.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SysUser
 *
 * @author yangpeng
 * @date 2018-05-22-16
 */
@Entity
@Table(name = "s_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", length = 120)
    private String name;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password", length = 120)
    private String password;
    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")

    /**
     *  所对应的角色集合
     */
    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);

    public SysUser() {
    }

    public SysUser(String name, String email, String password, Date dob, Set<SysRole> SysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.SysRoles = SysRoles;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
    public Set<SysRole> getSysRoles() {
        return this.SysRoles;
    }

    public void setSRoles(Set<SysRole> SysRoles) {
        this.SysRoles = SysRoles;
    }
}
