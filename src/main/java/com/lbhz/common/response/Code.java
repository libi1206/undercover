package com.lbhz.common.response;

/**
 * Created by superlee on 2017/11/6.
 */
public enum Code {
    //通用部分
    UNDEFINED(-1, "未定义"),
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),

    TOKEN_NOT_EXIST(1009, "令牌不存在"),
    TOKEN_TIME_OUT(1010, "令牌超时"),
    USER_NOT_EXIST(1011,"用户不存在"),
    INCORRECT_PASSWORD(1012, "密码错误"),

    //管理端异常
    ADMIN_AUTH_ERROR(10001,"用户名或密码错误"),
    ANNO_ID_NOT_FIND(10002,"公告id不存在"),
    STUDY_ID_NOT_FIND(10003, "学习园地id不存在"),
    NOTARIZE_ID_NOT_FIND(10004, "出证id不存在");

    private int code;
    private String msg;

    // 构造方法
    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public static String getMsgByCodeInt(int codeInt) {
        for (Code e : Code.values()) {
            if (e.getCode() == codeInt) {
                return e.msg;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

    public static Code getCodeByCodeInt(int codeInt) {
        for (Code code : Code.values()) {
            if (code.getCode() == codeInt) {
                return code;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

}
