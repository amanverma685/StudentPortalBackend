package com.student_server.student_portal.Bean;

import jakarta.persistence.*;

import java.util.*;
//
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @Column(name ="course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @Column(name="course_code",nullable = false)
    private String course_code;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;


    @Column(name="year",nullable = false)
    private Integer year;

    @Column(name="team",nullable = false)
    private String team;

    @Column(name="credits",nullable = false)
    private Integer credits;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER)
    private List <Specialisation> spec;

    @Column(name="capacity")
    private Integer capacity;

    @Column(name="faculty")
    private String faculty;


    public Courses() {
    }

    public Courses(int course_id, String course_code, String name, String description, Integer year, String team, Integer credits, Integer capacity, String faculty) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.team = team;
        this.credits = credits;
        this.capacity = capacity;
        this.faculty = faculty;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}