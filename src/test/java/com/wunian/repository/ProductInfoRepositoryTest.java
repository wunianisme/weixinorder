package com.wunian.repository;

import com.wunian.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wunian
 * @desc
 * @date 2019/4/15 0015
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();

        productInfo.setProductId("123456");
        productInfo.setProductName("八宝粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("良心制作");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);//断言是否为空
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }



}