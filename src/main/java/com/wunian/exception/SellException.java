package com.wunian.exception;

import com.wunian.enums.ResultEnum;

/**
 * @author wunian
 * @desc
 * @date 2019/4/16 0016
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code=code;
    }


}
