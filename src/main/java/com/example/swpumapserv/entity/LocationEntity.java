package com.example.swpumapserv.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 13:49
 **/
public class LocationEntity {

    private  String id;
    private  String account;
    private  String studentno;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private  String location_desc;
    private Date collect_date;

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

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
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

    public Date getCollect_date() {
        return collect_date;
    }

    public void setCollect_date(Date collect_date) {
        this.collect_date = collect_date;
    }
}
