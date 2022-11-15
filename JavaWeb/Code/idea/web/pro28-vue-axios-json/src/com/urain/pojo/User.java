package com.urain.pojo;

/**
 * @author: urain
 * @date: 2022/4/19 16:20
 * @description:
 * @version: 1.0
 */
public class User {
    private String uname;
    private String pwd;

    public User() {
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
            "uname='" + uname + '\'' +
            ", pwd='" + pwd + '\'' +
            '}';
    }
}
