package com.wunian.enums;

import lombok.Getter;

/**
 * @author wunian
 * @desc 支付状态
 * @date 2019/4/19 0019
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }



}
