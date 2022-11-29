package com.student_server.student_portal.Bean;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "specialisation")
public class Specialisation {
    @Id
    @Column(name ="specialisation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialisation_id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Courses> courses;


    @Column(name="code",nullable = false,unique = true)
    private String code;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="year",nullable = false)
    private long year;

    @Column(name="credits_required",nullable = false)
    private long credits_required;

    @Column(name = "image_url")
    private String image_url;

    public Specialisation( String code, String name, String description, long year, long credits_required,String image_url) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits_required = credits_required;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Specialisation() {

    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public int getSpecialisation_id() {
        return specialisation_id;
    }

    public void setSpecialisation_id(int specialisation_id) {
        this.specialisation_id = specialisation_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getCredits_required() {
        return credits_required;
    }

    public void setCredits_required(long credits_required) {
        this.credits_required = credits_required;
    }
}