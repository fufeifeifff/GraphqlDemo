package com.igu.developer.demo;

import java.util.HashMap;

/**
 * Created by lijinlei on 2016/10/17.
 */
public class ApiConstants {

    /**
     * appInfo
     */
    public static HashMap<String, String> APP_INFO = new HashMap<String, String>();


    static {
        APP_INFO.put("B272F43387B8504C", "70BAE8B491362AB39042B77C7653199D");
    }

    /**
     * Response Status Code
     */
    public static final Integer RESPONSE_CODE_OK = 0;  //成功
    public static final Integer RESPONSE_CODE_ERROR = -1; //失败
    public static final Integer RESPONSE_CODE_VERIFYCODE_EXPIRE = 1; //验证码过期
    public static final Integer RESPONSE_CODE_VERIFYCODE_ERROR = 2; //验证码错误
    public static final Integer RESPONSE_CODE_VERIFYCODE_MOBIL_EEROR = 3; //手机号
    public static final Integer RESPONSE_CODE_SIGN_ERROR = 103; //签名验证失败
    public static final Integer RESPONSE_CODE_TOKEN_INVALIDATE = 101;//token无效
    public static final Integer RESPONSE_CODE_TOKEN_OUTTIME = -999;//token过期
    public static final Integer RESPONSE_CODE_TOKEN_DUPLOGIN = -990;//token已经登录

    public static final Integer RESPONSE_CODE_REPEAT_OBJ = 11000;//无法添加重复对象
    public static final Integer RESPONSE_CODE_PARAMETER_INVALID = 14000;//参数无效
    public static final Integer RESPONSE_CODE_PARAMETER_ERR = 14001;//参数有误
    public static final Integer RESPONSE_CODE_DB_OPERATE_ERR = 14003;//数据库操作有误
    public static final Integer RESPONSE_CODE_INSIDE_ERR = 15000;//内部错误
    public static final Integer RESPONSE_CODE_DATASE_NOT_EXIST = 15006;//记录不存在
    public static final Integer RESPONSE_CODE_METHOD_NOT_EXIST = 15007;//方法未实现
    public static final Integer RESPONSE_CODE_AUTHORITY_ERR = 15014;//权限受限
    public static final Integer RESPONSE_CODE_PASSWORD_ERR = 15016; //密码错误

    public static final Integer RESPONSE_CODE_SMSCODE_ERR = 15017;//短信验证码错误
    public static final Integer RESPONSE_CODE_ILLEGAL_OPERATIONOR = 15018;
    public static final Integer RESPONSE_CODE_THIRDLOGIN_ALREADY_EXIST = 15019;//对应类型的第三登录账号已绑定过

    public static final Integer RESPONSE_CODE_USER_TYPE = 15020;//用户登陆类型错误

    /**
     * 常用异常报错信息
     */
    public static final String EXCEPTION_ERROR_MESSAGE_INDSIDE_ERR = "系统繁忙，请稍后再试！";
    public static final String EXCEPTION_ERROR_MESSAGE_PARAMETER_ERR = "参数错误";
    public static final String EXCEPTION_ERROR_MESSAGE_PARAMETER_TYPR = "类型错误";
    public static final String EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL = "不能为空";
    public static final String EXCEPTION_ERROR_MESSAGE_DB_OPERATE_ERR = "数据库操作异常";
    public static final String EXCEPTION_ERROR_MESSAGE_IS_NULL = "没有数据";
    public static final String EXCEPTION_ERROR_MESSAGE_ILLEGAL_OPERATIONOR = "非法操作";

    /**
     * app类型：1:ios,2:andriod
     */
    public static final String APP_TYPE_IOS = "1";
    public static final String APP_TYPE_ANDRIOD = "2";
    public static final String APP_TYPE_OTHER = "3";

    /**
     * 分页默认参数值
     */
    public static final String DEFAULT_PAGE_NUMBER = "1";
    public static final String DEFAULT_PAGE_PAGE_SIZE = "10"; //默认每页数据的条数

    /**
     * Api处理错误时使用的日志名称
     */
    public static final String LOG_NAME_ERROR = "api_error";
    /**
     * Api数据编码
     */
    public static final String ENCODING_REQUEST = "UTF-8";
    /**
     * 参数正则校验
     */
    public static final String PARAMETERS_CHECK_PHOTO = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";//手机号
    public static final String PARAMETERS_CHECK_FLOAT = "^((0)|([1-9][0-9]*))\\.[0-9]+$";//浮点型
    public static final String PARAMETERS_CHECK_DOUBLE = "^((0)|([1-9][0-9]*))(\\.[0-9]+)?$";//double
    public static final String PARAMETERS_CHECK_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";//6-16位数字和字母的组合
    public static final String PARAMETERS_CHECK_LOGIN_NAME = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{3,16}$";//3-16位数字和字母的组合
    /**
     * 删除标识
     */
    public static final int FLG_DELETED_TRUE = 1;
    public static final int FLG_DELETED_FALSE = 0;

    /**
     * 验证码类型 1.注册，2。登录，3.修改密码，4.修改手机号 5.修改个人信息 6.第三方登录注册,7-扫码绑定
     */
    public static final String SMSCODE_TYPE_REGISTER = "1";
    public static final String SMSCODE_TYPE_LOGIN = "2";
    public static final String SMSCODE_TYPE_MODIFY_PASSWORD = "3";
    public static final String SMSCODE_TYPE_UP_PHONE = "4";
    public static final String SMSCODE_TYPE_BIDING_WECHAT = "5";

    public static final String SMSCODE_USER_TYPE_MALL = "1";
    public static final String SMSCODE_USER_TYPE_DRIVER = "2";
    /**
     * 验证码有效期
     */
    public static final int SMSCODE_OUT_TIME_RANGE = 10 * 60 * 1000;

    public static final int STRING_MIN_LENGTH = 1;//输入字符最短长度
    public static final int NICK_NAME_MAX_LENGTH = 20;//昵称最长长度
    public static final int SIGN_MAX_LENGTH = 240;//个性签名最长长度


    /** 二维码不存在*/
    public static final int QRCODE_STAT_NO = -1;
    /** 出库追溯码 重复*/
    public static final int QRCODE_STAT_AGAIN = -2;
    /** 出库不是当前商家 */
    public static final int QRCODE_STAT_MERCHAN = -3;



    /**
     * 证件类型 1身份证
     */
    public static final int IDENTITY_CATEGORY = 1;
    /*
    * 缩略图
    * */
    public  static final String DEFAULT_PREFIX = "thumb_";
    public  static final Boolean DEFAULT_FORCE = false;

    /*
    * 商户类型
    * */
    public static final String MERCHANT_TYPE_WHOLESALER = "80001";              //批发商
    public static final String MERCHANT_TYPE_CATERING_ENTERPRISE = "80002";    //餐饮企业
    public static final String MERCHANT_TYPE_TRADERS = "80003";                  //小商贩


    /*
    * 商户的审核状态
    * */
    public static final Integer MERCHANT_WAITING_AUDITING = 0;   //待审核
    public static final Integer MERCHANT_AUDITING_SUCCESS = 1;    //审核通过
    public static final Integer MERCHANT_AUDITING_FAIL = 2;       //审核不通过
    public static final Integer MERCHANT_SIGN_NO_LONGER_USER = 3;  //标记为不在使用商户

    /*
    * 图片的使用状态
    * */
    public static final Integer MERCHANT_EMPLOYEE_PHOTO_USED = 1;  //正在使用
    public static final Integer MERCHANT_EMPLOYEE_PHOTO_NO_USED = 2;  //已经删除
}
