package com.wunian.service;

import com.wunian.dataobject.SellerInfo;

/**
 * @author wunian
 * @desc 卖家端
 * @date 2019/5/26 0026
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
