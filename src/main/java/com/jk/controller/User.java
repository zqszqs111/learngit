package com.jk.controller;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ 创建者：赵清顺.
 * @ 创建时间：2018/8/3 0003 22:32
 * @ Description：
 * @ Version:
 */
@Document(collection = "classs")
public class User {

    private Integer userid;

    private String username;

    private String userage;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userage='" + userage + '\'' +
                '}';
    }
}
