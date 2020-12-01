package cn.tsh.study.util;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public String code;

    private String msg;

    public String getStatus() {
        return status;
    }

    public Result<T> setStatus(String status) {
        this.status = status;
        return  this;
    }

    private String status;

    private T bodyData;
    private T commData;

    public T getCommData() {
        return commData;
    }

    public Result<T> setCommData(T commData) {
        this.commData = commData;
        return this;
    }

    public void Result() {
        this.code = ResultsCode.SUCCESS.code;
        this.msg = ResultsCode.SUCCESS.message;
    }

    public Result<T> setCode(ResultsCode resultsCode) {
        this.code = resultsCode.code;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getBodyData() {
        return bodyData;
    }

    public Result<T> setBodyData(T bodyData) {
        this.bodyData = bodyData;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "\"C-response-Desc\":"+ '\"'+msg+ '\"'+","
                + "\"C-response-Body\":"+"{"+"\"respCommonCom\":{"+ commData +"}"+","
                 +"\"respBodyCom\":{"+ bodyData +"}"+"}"+","
                + "\"C-response-Code\":"+ '\"'+code+ '\"'+","
                + "\"C-API-Status\":"+ '\"'+status+ '\"'+

        '}';



    }


}
