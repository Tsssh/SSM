package cn.tsh.study.util;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public String code;

    private String msg;

    public String getStatus() {
        return status;
    }

    public Result setStatus(String status) {
        this.status = status;
        return  this;
    }

    private String status;

    private HashMap bodyData;
    private HashMap commData;

    public HashMap getCommData() {
        return commData;
    }

    public Result setCommData(HashMap commData) {
        this.commData = commData;
        return this;
    }

    public void Result() {
        this.code = ResultsCode.SUCCESS.code;
        this.msg = ResultsCode.SUCCESS.message;
    }

    public Result setCode(ResultsCode resultsCode) {
        this.code = resultsCode.code;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public HashMap getBodyData() {
        return bodyData;
    }

    public Result setBodyData(HashMap bodyData) {
        this.bodyData = bodyData;
        return this;
    }

    @Override
    public String toString() {

          String common=commData==null? "\"respCommonCom\":"+"{ }":
            "\"respCommonCom\":"+ new Gson().toJson(commData);
          String body=bodyData==null?"\"respBodyCom\": "+"{ }":
            "\"respBodyCom\": "+new Gson().toJson(bodyData);
           return "{" +
                "\"C-response-Desc\":"+ '\"'+msg+ '\"'+","
                + "\"C-response-Body\":"
                + "{"+ body+","
                + common+"}"+","
                + "\"C-response-Code\":"+ '\"'+code+ '\"'+","
                + "\"C-API-Status\":"+ '\"'+status+ '\"'+
        '}';
    }
  public static void main(String[] args) {
    HashMap<String, String> para = new HashMap<String, String>();
    para.put("C-response-Desc","success");
    para.put("C-API-Status","00");
    para.put("C-response-Code","1111");

    String a= carPlatResponse.success();
    System.out.println(a);
    }

}
