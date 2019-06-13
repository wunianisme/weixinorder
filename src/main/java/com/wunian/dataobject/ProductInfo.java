package com.wunian.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wunian.enums.ProductStatusEnum;
import com.wunian.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wunian
 * @desc 商品
 * @date 2019/4/15 0015
 */
@Entity
@Data
@DynamicUpdate  //保证updateTime时间自动更新 只更新同一个session里面，同一个对象有改变的字段
public class ProductInfo {

    @Id
    private String productId;

    private String productName;//名字

    private BigDecimal productPrice;//单价

    private Integer productStock;//库存

    private String productDescription;//描述

    private String productIcon; //图片地址
    //状态 0正常 1下架
    private Integer productStatus=ProductStatusEnum.UP.getCode();

    private Integer categoryType;//类目编号

    private Date createTime;

    private Date updateTime;


    @JsonIgnore //一般标记在属性或者方法上，返回的json数据即不包含该属性
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }


}
