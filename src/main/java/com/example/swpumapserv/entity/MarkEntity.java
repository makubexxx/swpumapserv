package com.example.swpumapserv.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-27 07:37
 **/
public class MarkEntity {
    private  String id;
    private  String account;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private  String location_desc;
    private  String  text_desc;
    private Date  create_date;

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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getLocation_desc() {
        return location_desc;
    }

    public void setLocation_desc(String location_desc) {
        this.location_desc = location_desc;
    }

    public String getText_desc() {
        return text_desc;
    }

    public void setText_desc(String text_desc) {
        this.text_desc = text_desc;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
