package com.wunian.repository;

import com.wunian.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wunian
 * @desc 卖家信息
 * @date 2019/5/26 0026
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);
}
