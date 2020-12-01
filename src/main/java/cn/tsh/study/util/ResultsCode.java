package cn.tsh.study.util;


public enum ResultsCode {

    SUCCESS("200", "成功"),

    FAIL("-1", "失败"),

    ERROR("500", "服务器异常"),

    UNAUTHORIZED("401", "未认证（签名错误）"),

    NOT_FOUND("404", "接口不存在");



    public String code;
    public String message;

    ResultsCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
