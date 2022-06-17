package com.zijin.educationaladministration.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Autor: 丁小丁
 * @Desc: 学院
 */
@Entity
@Table(name="college")
public class College {
    @Id
    private String id;
    private String name;
    private String dean;

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

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "College{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dean='" + dean + '\'' +
                '}';
    }
}
