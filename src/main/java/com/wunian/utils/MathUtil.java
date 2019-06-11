package com.wunian.utils;

/**
 * @author wunian
 * @desc 数学计算工具类
 * @date 2019/5/26 0026
 */
public class MathUtil {
    private static final Double MONEY_RANGE=0.01;

    /**
     * 比较2个金额是否相等（存在精度的问题，误差在0.01以内算相等）
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1,Double d2){
        Double result=Math.abs(d1-d2);
        if(result<MONEY_RANGE){
            return true;
        }else{
            return false;
        }

    }

}
