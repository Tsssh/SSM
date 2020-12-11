package cn.tsh.study.util;

import java.util.HashMap;

public class carPlatResponse {

    /****
     * 成功响应Msg中的信息
     **/
    private final static String SUCCESS = "success";

    /****
     * 失败响应Msg中的信息
     **/
    private final static String FAILED = "failed";
    /****
     * 失败响应Statue中的信息
     **/
    private final static String FAILEDSTATUS = "01";
    /****
     * 成功响应Statue中的信息
     **/
    private final static String SUCCESSSTATUE = "00";


    public static String success() {
        return new Result().setCode(ResultsCode.SUCCESS).setMsg(SUCCESS).setStatus(SUCCESSSTATUE).toString();
    }


    public static  String success(HashMap bodyData, HashMap commData) {
        return new Result().setCode(ResultsCode.SUCCESS).setMsg(SUCCESS).setBodyData(bodyData).setStatus(SUCCESSSTATUE).setCommData(commData).toString();
    }
    public static String success(HashMap bodyData) {
        return new Result().setCode(ResultsCode.SUCCESS).setMsg(SUCCESS).setBodyData(bodyData).setStatus(SUCCESSSTATUE).toString();
    }


    public static  String error(ResultsCode resultsCode) {
        return new Result().setCode(resultsCode.code).setMsg(resultsCode.message).setStatus(FAILEDSTATUS).toString();
    }


    public static  String error(String mesage) {
        return new Result().setMsg(mesage).setCode(ResultsCode.FAIL).setStatus(FAILEDSTATUS).toString();
    }


    public static  String error(String mesage, ResultsCode resultsCode) {
        return new Result().setMsg(mesage).setCode(resultsCode.code).setStatus(FAILEDSTATUS).toString();
    }

    public static  String error() {
        return new Result().setCode(ResultsCode.FAIL).setMsg(FAILED).setStatus(FAILEDSTATUS).toString();
    }



}
