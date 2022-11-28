package com.student_server.student_portal.Bean;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name ="admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(name="fname",nullable = false)
    private String fname;

    @Column(name="lname")
    private String lname;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private  String password;

    public Admin() {
    }

    public Admin(int adminId, String fname, String lname,String email,String password) {
        this.adminId = adminId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}