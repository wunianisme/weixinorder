package com.wunian.dto;

import lombok.Data;

/**
 * @author wunian
 * @desc 购物车
 * @date 2019/4/16 0016
 */
@Data
public class CartDTO {


    private String productId;//商品id

    private Integer productQuantity;//数量

    public CartDTO(String productId,Integer productQuantity){
        this.productId=productId;
        this.productQuantity=productQuantity;
    }
}
