package com.example.swpumapserv.utils;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 12:02
 **/
public class CyWebException extends CyException {

    private static final long serialVersionUID = -1944206179214394839L;

    private String errCode;
    private String errMsg;
    private String[] args;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        if (args != null) {
            for (int i = 1; i <= args.length; i++) {
                errMsg = errMsg.replace("{" + i + "}", args[i - 1]);
            }
        }
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public CyWebException(String errCode, String errMsg, String... args) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.args = args;
    }

    public CyWebException(String[] err, String... args) {
        this.errCode = err[0];
        this.errMsg = err[1];
        this.args = args;
    }

    public CyWebException(String errMsg) {
        this("1000", errMsg);
    }
}
