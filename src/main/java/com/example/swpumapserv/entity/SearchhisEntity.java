package com.example.swpumapserv.entity;

import java.util.Date;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-27 10:08
 **/
public class SearchhisEntity {

    private  String id;
    private  String account;
    private  String search_cotent;
    private Date create_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSearch_cotent() {
        return search_cotent;
    }

    public void setSearch_cotent(String search_cotent) {
        this.search_cotent = search_cotent;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
