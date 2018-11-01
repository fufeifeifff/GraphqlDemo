package com.igu.developer.demo.vo;

import com.igu.developer.demo.ApiConstants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class ResponseVo<T> {
    private static final int RESULT_STATUS_CODE_VALUE_NOT_LOGIN = -999;
    private Integer code;
    private  String msg;

    private T resultValue;

    public ResponseVo() {
    }

    public ResponseVo(T t) {
        this.resultValue = t;
    }

    public ResponseVo<T> ok(T resultValue) {
        return ok(resultValue, null);
    }

    public ResponseVo<T> ok(T resultValue, String message) {
        this.setCode(ApiConstants.RESPONSE_CODE_OK);
        this.setMsg(StringUtils.isBlank(message) ? "操作成功" : message);
        this.resultValue = resultValue;
        return this;
    }


    public ResponseVo<T> error(T resultValue) {
        return error(resultValue, null);
    }

    public ResponseVo<T> error(T resultValue, String msg) {
        this.setCode(ApiConstants.RESPONSE_CODE_ERROR);
        this.setMsg(StringUtils.isBlank(msg) ? "操作失败" : msg);
        this.resultValue = resultValue;
        return this;
    }

    public ResponseVo<T> error(T resultValue, String msg,Integer errCode) {
        this.setCode(errCode);
        this.setMsg(StringUtils.isBlank(msg) ? "操作失败" : msg);
        this.resultValue = resultValue;
        return this;
    }



    public ResponseVo<T> SignError(T resultValue, String msg) {
        this.setCode(ApiConstants.RESPONSE_CODE_SIGN_ERROR);
        this.setMsg(StringUtils.isBlank(msg) ? "操作失败" : msg);
        this.resultValue = resultValue;

        return this;
    }

    public ResponseVo<T> TokenError(T resultValue, String msg) {
        this.setCode(ApiConstants.RESPONSE_CODE_TOKEN_INVALIDATE);
        this.setMsg(StringUtils.isBlank(msg) ? "操作失败" : msg);
        this.resultValue = resultValue;

        return this;
    }

    public ResponseVo<T> notLogin(T resultValue, String msg) {
        this.setCode(RESULT_STATUS_CODE_VALUE_NOT_LOGIN);
        this.setMsg(StringUtils.isBlank(msg) ? "请登录" : msg);
        this.resultValue = resultValue;

        return this;
    }
}
