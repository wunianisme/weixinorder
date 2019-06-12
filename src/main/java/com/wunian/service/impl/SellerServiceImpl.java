package com.wunian.service.impl;

import com.wunian.dataobject.SellerInfo;
import com.wunian.repository.SellerInfoRepository;
import com.wunian.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wunian
 * @desc
 * @date 2019/5/26 0026
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {

        return repository.findByOpenid(openid);
    }
}
