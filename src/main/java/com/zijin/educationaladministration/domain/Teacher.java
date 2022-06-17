package com.zijin.educationaladministration.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;
import java.util.Date;


/**
 * @Autor: 丁小丁
 * @Desc: 专业
 */
@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    private String id;
    private String name;
    private String sex;
    private Date birthday;
    private String title;
    private String phone;
    private String college;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}
