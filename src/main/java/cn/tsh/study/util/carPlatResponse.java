package cn.tsh.study.util;
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


    public static <T> Result<T> success() {
        return new Result<T>().setCode(ResultsCode.SUCCESS).setMsg(SUCCESS).setStatus(SUCCESSSTATUE);
    }


    public static <T> Result<T> success(T bodyData, T commData) {
        return new Result<T>().setCode(ResultsCode.SUCCESS).setMsg(SUCCESS).setBodyData(bodyData).setStatus(SUCCESSSTATUE).setCommData(commData);
    }
    public static <T> Result<T> success(T bodyData) {
        return new Result<T>().setCode(ResultsCode.SUCCESS).setMsg(SUCCESS).setBodyData(bodyData).setStatus(SUCCESSSTATUE);
    }


    public static <T> Result<T> error(ResultsCode resultsCode) {
        return new Result<T>().setCode(resultsCode.code).setMsg(resultsCode.message).setStatus(FAILEDSTATUS);
    }


    public static <T> Result<T> error(String mesage) {
        return new Result<T>().setMsg(mesage).setCode(ResultsCode.FAIL).setStatus(FAILEDSTATUS);
    }


    public static <T> Result<T> error(String mesage, ResultsCode resultsCode) {
        return new Result<T>().setMsg(mesage).setCode(resultsCode.code).setStatus(FAILEDSTATUS);
    }

    public static <T> Result<T> error() {
        return new Result<T>().setCode(ResultsCode.FAIL).setMsg(FAILED).setStatus(FAILEDSTATUS);
    }


}
