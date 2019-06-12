package com.wunian.service.impl;

import com.wunian.dataobject.ProductInfo;
import com.wunian.dto.CartDTO;
import com.wunian.enums.ProductStatusEnum;
import com.wunian.enums.ResultEnum;
import com.wunian.exception.SellException;
import com.wunian.repository.ProductInfoRepository;
import com.wunian.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @author wunian
 * @desc 商品
 * @date 2019/4/16 0016
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode()
        );
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=repository.findOne(cartDTO.getProductId());
            if(productInfo==null){//判断该商品存不存在，不存在则直接抛出异常
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //商品库存=原来的库存+新增的商品数量
            Integer result =productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            //重新保存
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=repository.findOne(cartDTO.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
            }
            //商品库存=原来的库存-取出的商品数量
            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);//商品库存不能为负，有问题
            }
            productInfo.setProductStock(result);
            //重新保存
            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo=repository.findOne(productId);
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
        }
        if(productInfo.getProductStatusEnum()==ProductStatusEnum.UP){//上架商品不需要重新设置
            throw new SellException(ResultEnum.PRODUCR_STATUS_ERROR);//商品状态不正确
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());//商品状态修改为上架
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo=repository.findOne(productId);
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
        }
        if(productInfo.getProductStatusEnum()==ProductStatusEnum.DOWN){//下架商品不需要重新设置
            throw new SellException(ResultEnum.PRODUCR_STATUS_ERROR);//商品状态不正确
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());//商品状态修改为下架
        return repository.save(productInfo);
    }
}
