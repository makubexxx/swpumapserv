package com.example.swpumapserv.base;

import java.io.Serializable;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 12:19
 **/
public class CommResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    public final static int STATUS_ERROR=1;
    public final static int STATUS_TOKEN_EXPIRED=2;
    public final static int STATUS_SUCCESS=0;

    private String serialno;
    private int status;
    private T body;
    private String errorMessage;
    private String successMessage;
    private String warnMessage;

    public String getSerialno() {
        return serialno;
    }
    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public T getBody() {
        return body;
    }
    public void setBody(T body) {
        this.body = body;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getSuccessMessage() {
        return successMessage;
    }
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getWarnMessage() {
        return warnMessage;
    }
    public void setWarnMessage(String warnMessage) {
        this.warnMessage = warnMessage;
    }
    @Override
    public String toString() {
        return "CommResponse [status=" + status + ", body=" + body + ", errorMessage=" + errorMessage
                + ", successMessage=" + successMessage + ", warnMessage=" + warnMessage + "]";
    }

}
