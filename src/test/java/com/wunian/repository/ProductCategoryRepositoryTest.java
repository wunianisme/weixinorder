package com.wunian.repository;

import com.wunian.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wunian
 * @desc
 * @date 2019/4/16 0016
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory =repository.findOne(1);
        System.out.print(productCategory);
        Assert.assertNotNull(productCategory);
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory category=new ProductCategory("男生喜欢",4);
        ProductCategory result=repository.save(category);
        System.out.print(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(1,2,3);
        List<ProductCategory> result=repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }




}