package com.example.swpumapserv.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 12:00
 **/
public class StatusEntity implements Serializable {

    private static final long serialVersionUID = 1289069067581342888L;

    private Boolean status;

    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
