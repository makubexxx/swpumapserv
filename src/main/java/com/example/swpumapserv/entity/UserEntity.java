package com.example.swpumapserv.entity;

import java.util.Date;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 14:21
 **/
public class UserEntity {
    private  String id;
    private  String account;
    private  String password;
    private  String studentno;
    private  Date create_date;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreate_date(Date create_date) {

        this.create_date = create_date;
    }
}
