package com.kmlwriter.kjw.myway.const_string;

/**
 * Created by kjw on 2017. 12. 9..
 */

public enum ResponseCode {
    DUPLICATE_CODE(409),
    NOT_FOUND_CODE(404),
    BAD_REQUEST_CODE(400),
    FORBIDDEN_REQUEST_CODE(403),
    INTERNAL_ERROR_CODE(500);
    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
