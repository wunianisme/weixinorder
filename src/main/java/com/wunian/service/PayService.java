package com.wunian.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.wunian.dto.OrderDTO;

/**
 * @author wunian
 * @desc 支付
 * @date 2019/5/26 0026
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
