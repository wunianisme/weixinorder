package com.wunian.enums;

import lombok.Getter;

import javax.management.loading.MLetContent;

/**
 * @author wunian
 * @desc 商品状态
 * @date 2019/4/15 0015
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }



}
