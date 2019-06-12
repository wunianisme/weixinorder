package com.wunian.dataobject;

import com.sun.javafx.beans.IDProperty;
import com.wunian.enums.OrderStatusEnum;
import com.wunian.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wunian
 * @desc 订单主表
 * @date 2019/4/19 0019
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;//订单id

    private String buyerName;//买家名称

    private String buyerPhone;//买家手机号

    private String buyerAddress;//买家地址

    private String buyerOpenid;//买家微信Openid

    private BigDecimal orderAmount;//订单总金额

    //订单状态，默认为0新下单
    private Integer orderStatus =OrderStatusEnum.NEW.getCode();

    //支付状态，默认为0未支付
    private Integer payStatus=PayStatusEnum.WAIT.getCode();

    //创建时间
    //private Date createTime;

    //更新时间
    //private Date updateTime;

}
