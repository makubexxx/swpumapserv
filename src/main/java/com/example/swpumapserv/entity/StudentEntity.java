package com.example.swpumapserv.entity;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-23 15:07
 **/
public class StudentEntity {

    private String studentno;
    private  int is_bind;
    private  String is_bindstr;
    private  String account;

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public int getIs_bind() {
        return is_bind;
    }

    public void setIs_bind(int is_bind) {
        this.is_bind = is_bind;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIs_bindstr() {
        return is_bindstr;
    }

    public void setIs_bindstr(String is_bindstr) {
        this.is_bindstr = is_bindstr;
    }
}
