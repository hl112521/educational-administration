package com.zijin.educationaladministration.domain;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Year;


/**
 * @Autor: 丁小丁
 * @Desc: 专业
 */
@Entity
@Table(name="classes")
public class Classes {
    private String id;
    private String name;
    private Year grade;
    private String instructor;
    private String college;
    private String major;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getGrade() {
        return grade;
    }

    public void setGrade(Year grade) {
        this.grade = grade;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", instructor='" + instructor + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
