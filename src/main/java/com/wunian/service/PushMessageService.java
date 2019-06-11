package com.wunian.service;

import com.wunian.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wunian
 * @desc 推送消息
 * @date 2019/5/26 0026
 */

public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    public void orderStatus(OrderDTO orderDTO);


}
