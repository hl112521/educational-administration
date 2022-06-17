package com.zijin.educationaladministration.domain;


import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @Autor: 丁小丁
 * @Desc: 专业
 */
@Entity
@Table(name="major")
public class Major {
    private String id;
    private String name;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}
