package com.wunian.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wunian.dataobject.OrderDetail;
import com.wunian.enums.OrderStatusEnum;
import com.wunian.enums.PayStatusEnum;
import com.wunian.utils.Date2LongSerialize;
import com.wunian.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wunian
 * @desc 订单数据传输对象
 * @date 2019/5/4 0004
 */
@Data
public class OrderDTO {

    //订单ID
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信Openid
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态，默认为0新下单
    private Integer orderStatus;
    //支付状态，默认为0未支付
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using=Date2LongSerialize.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using=Date2LongSerialize.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    //不进行JSON序列化
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
      return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }



}
