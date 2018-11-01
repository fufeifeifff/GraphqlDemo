package com.igu.developer.demo.util;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igu.developer.demo.ApiConstants;
import com.igu.developer.demo.exception.DataCheckException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by wuxia on 2016/11/7.
 */
public class ParamsCheckUtil {

    /**
     * 非空校验:object
     *
     * @param object
     */
    public static Map<String, String> checkObjectIsNull(Object object, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (object == null) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        }
        return checkMessages;
    }

    /**
     * 非空校验:String
     *
     * @param str
     */
    public static Map<String, String> checkStringIsNull(String str, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(str) || str.equals("null") || str.equals("") || str.equals(null)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        }

        return checkMessages;
    }

    /**
     * 校验密码
     */
    public static Map<String,String> checkPassword(String str, String name){
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(str) || str.equals("null") || str.equals("") || str.equals(null)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        }else{
            if(!str.matches(ApiConstants.PARAMETERS_CHECK_PASSWORD)){
                checkMessages.put("" + name + "","密码必须是6-16位数字和字母的组合  ");
            }
        }
        return checkMessages;
    }

    /**
     * 校验密码
     */
    public static Map<String,String> checkLoginName(String str, String name){
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(str) || str.equals("null") || str.equals("") || str.equals(null)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        }else{
            if(!str.matches(ApiConstants.PARAMETERS_CHECK_LOGIN_NAME)){
                checkMessages.put("" + name + "","登录名必须是3-16位数字和字母的组合  ");
            }
        }
        return checkMessages;
    }

    /**
     * 数字boolean
     *
     * @param number
     */
    public static Map<String, String> checkBoolean(String number, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(number) || number.equals("null")) {
            checkMessages.put("" + name + "", ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!number.equals(ApiConstants.FLG_DELETED_TRUE + "") && !number.equals(ApiConstants.FLG_DELETED_FALSE + "")) {
            checkMessages.put("" + name + "", "必须是0或1");
        }
        return checkMessages;
    }

    /**
     * 数字校验
     *
     * @param number
     */
    public static Map<String, String> checkNumber(String number, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(number) || number.equals("null") || number.equals("") || number.equals(null)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!(StringUtils.isNumeric(number))) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_TYPR + "必须是数字");
        }
        return checkMessages;
    }

    /**
     * 金额校验
     *
     * @param amount
     */
    public static Map<String, String> checkBigDecimal(BigDecimal amount, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (amount == null) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (amount.compareTo(BigDecimal.ZERO) < 0) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_TYPR + "金额不能小于0");
        }
        return checkMessages;
    }

    /**
     * 数字类型校验
     *
     * @param number
     */
    public static Map<String, String> checkNumberType(String number, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (!(StringUtils.isNumeric(number))) {
            checkMessages.put("" + name + "", number + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_TYPR + "必须是数字");
        }
        return checkMessages;
    }

    /**
     * 数字校验:FLOAT
     *
     * @param number
     */
    public static Map<String, String> checkFloatNumber(Float number, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (number == null) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!number.toString().matches(ApiConstants.PARAMETERS_CHECK_FLOAT)) {
            checkMessages.put("" + name + "", name + "必须是float类型");
        }
        return checkMessages;
    }

    /**
     * 数字校验:DOUBLE
     *
     * @param number
     */
    public static Map<String, String> checkDoubleNumber(Double number, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (number == null) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!number.toString().matches(ApiConstants.PARAMETERS_CHECK_DOUBLE)) {
            checkMessages.put("" + name + "", name + "必须是DOUBLE类型");
        }
        return checkMessages;
    }

    /**
     * 数字校验:FLOAT
     *
     * @param number
     */
    public static Map<String, String> checkFloatNumberType(Float number, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (!number.toString().matches(ApiConstants.PARAMETERS_CHECK_FLOAT)) {
            checkMessages.put("" + name + "", name + "必须是float类型");
        }
        return checkMessages;
    }

    /**
     * 手机号校验
     *
     * @param photo
     */
    public static Map<String, String> checkPhotoNumber(String photo, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(photo)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!(StringUtils.isNumeric(photo))|| photo.length() != 11) {
            checkMessages.put("" + name + "", name + "手机号格式不正确");
        }
        return checkMessages;
    }

    /**
     * 性别校验
     *
     * @param sex
     */
    public static Map<String, String> checkSex(String sex, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(sex)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!(sex.equals("1") || sex.equals("2") || sex.equals("3") )) {
            checkMessages.put("" + name + "", name + "性别只能是1或2或3：1:男,2:女,3:保密");
        }
        return checkMessages;
    }

    /**
     * 日期校验（格式:"yyyyMMdd"）
     *
     * @param date
     */
    public static Map<String, String> checkDateNonStandard(String date, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(date)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!StringUtils.isNumeric(date) || date.length() != 8) {
            checkMessages.put("" + name + "", name + "日期格式不正确");
        }
        return checkMessages;
    }

    /**
     * 日期校验（格式:"yyyyMMddHHmmss"）
     *
     * @param date
     */
    public static Map<String, String> checkDateTimeNonStandard(String date, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(date)) {
            checkMessages.put("" + name + "", name + ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!StringUtils.isNumeric(date) || date.length() != 14) {
            checkMessages.put("" + name + "", name + "日期格式不正确");
        }
        return checkMessages;
    }


    /**
     * 日期格式校验:"yyyy-MM-dd"
     *
     * @param date
     */
    public static Map<String, String> checkDateType(String date, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        date = date.replaceAll("-","").replace(" ","").replace(":","");
        if (!StringUtils.isNumeric(date) || date.length() != 8) {
            checkMessages.put("" + name + "", name + "日期格式不正确");
        }
        return checkMessages;
    }

    /**
     * 日期校验（格式:"yyyy-MM-dd HH:mm;ss"）
     *
     * @param date
     */
    public static Map<String, String> checkDateTimeType(String date, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if(StringUtils.isNotBlank(date)){
            date = date.replaceAll("-","").replace(" ","").replace(":","");
        }else{
            checkMessages.put("" + name + "", ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        }

        if (!StringUtils.isNumeric(date) || date.length() != 14) {
            checkMessages.put("" + name + "", name + "日期格式不正确");
        }
        return checkMessages;
    }

    /**
     * 将字符串转化为list<Integer>
     */
    public static List<Integer> stringChangeToIntegerList(String str) throws DataCheckException {
        List<Integer> returnList = new ArrayList<>();
        if(StringUtils.isNotBlank(str)){
            String[] varList = null;
            if (StringUtils.isNotBlank(str)) {
                varList = str.split(",");
            }
            if (varList != null) {
                for (String s : varList) {
                    if (StringUtils.isNumeric(s)) {
                        returnList.add(Integer.valueOf(s));
                    } else {
                        throw new DataCheckException("参数有误;值必须是整形数字");
                    }
                }
            }
        }
        return returnList;
    }

    /**
     * 将字符串转化为list<String>
     */
    public static List<String> stringChangeToStringList(String str) {
        List<String> returnList = new ArrayList<>();
        String[] varList = null;
        if (StringUtils.isNotBlank(str)) {
            varList = str.split(",");
        }
        if (varList != null) {
            for (String s : varList) {
                returnList.add(s);
            }
        }
        return returnList;
    }

    /**
     * 将字符串转化为Set<long>
     */
    public static Set<Long> stringChangeToLongSet(String str) throws DataCheckException {
        Set<Long> returnList = new HashSet<>();
        String[] varList = null;
        if (StringUtils.isNotBlank(str)) {
            varList = str.split(",");
        }
        if (varList != null) {
            for (String s : varList) {
                if (StringUtils.isNumeric(s)) {
                    returnList.add(Long.valueOf(s));
                } else {
                    throw new DataCheckException("参数有误;值必须是整形数字");
                }
            }
        }
        return returnList;
    }
    /**
     * 校验字符长度
     */
    public static Map<String, String> checkStringLength(String value, String name,int lengthMin,int lengthMax) {
        Map<String, String> checkMessages = new HashMap<>();
        if(StringUtils.isNotBlank(value)){
            int valueLength = 0;
            String chinese = "[\u0391-\uFFE5]";
            for (int i = 0; i < value.length(); i++) {
                String temp = value.substring(i, i + 1);
                if (temp.matches(chinese)) {
                    valueLength += 2;
                } else {
                    valueLength += 1;
                }
            }
            if(valueLength < lengthMin){
                checkMessages.put("" + name + "", "长度太短");
            }
            if( valueLength > lengthMax){
                checkMessages.put("" + name + "", "长度太长");
            }
        }
        return checkMessages;
    }

    public static Map<String, String> checkOrderCoinAmount(String coinAmount){
        if(StringUtils.isEmpty(coinAmount)){
            return new HashMap<>(0);
        }else {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> checkMessages = new HashMap<>();
            try {
                JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class);
                List<Map<String, Object>> paramList = objectMapper.readValue(coinAmount, javaType);
                paramList.forEach(param -> {
                    if(param.get("cointType") == null || !StringUtils.isNumeric(param.get("cointType").toString())){
                        checkMessages.put("cointType", "格式错误");
                    }
                    if(param.get("amount") == null || !StringUtils.isNumeric(param.get("amount").toString())){
                        checkMessages.put("amount", "格式错误");
                    }
                });
                return checkMessages;
            }catch (Exception e){
                e.printStackTrace();
                checkMessages.put("coinAmount", "格式错误");
                return checkMessages;
            }
        }
    }
    /**
     * 身份证号验证
     */
    public static Map<String, String> checkIdCardNo(String idCardNo, String name) {
        Map<String, String> checkMessages = new HashMap<>();
        if (StringUtils.isEmpty(idCardNo) || idCardNo.equals("null")) {
            checkMessages.put("" + name + "", ApiConstants.EXCEPTION_ERROR_MESSAGE_PARAMETER_NOT_NULL);
        } else if (!idCardNo.matches("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$")) {
            checkMessages.put("" + name + "", "格式错误");
        }
        return checkMessages;
    }
}
