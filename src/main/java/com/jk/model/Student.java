package com.jk.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ 创建者：赵清顺.
 * @ 创建时间：2018/8/3 0003 16:35
 * @ Description：
 * @ Version:
 */
@Entity
@Table(name="student")
public class Student {

    @Id
    private Integer stuid;

    private String stuname;

    private String stuage;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuage='" + stuage + '\'' +
                '}';
    }
}
