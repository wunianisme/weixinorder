package com.wunian.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wunian.dataobject.OrderDetail;
import com.wunian.dto.OrderDTO;
import com.wunian.enums.ResultEnum;
import com.wunian.exception.SellException;
import com.wunian.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjb
 * @desc
 */
@Slf4j
public class OrderForm2OrderDTOConverter {


    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){

            }.getType());
        }catch(Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
