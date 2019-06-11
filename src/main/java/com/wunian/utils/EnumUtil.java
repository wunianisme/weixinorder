package com.wunian.utils;

import com.wunian.enums.CodeEnum;

/**
 * @author wunian
 * @desc 枚举工具类
 * @date 2019/4/15 0015
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
