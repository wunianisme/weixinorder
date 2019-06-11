package com.wunian.utils;

import java.util.Random;

/**
 * @author wunian
 * @desc 键值工具类
 * @date 2019/5/4 0004
 */
public class KeyUtil {
    /**
     * 生成唯一主键 （时间+随机数）
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random=new Random();
        Integer number =random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
