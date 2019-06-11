package com.wunian.service;

import com.wunian.dataobject.ProductCategory;

import java.util.List;

/**
 * @author wunian
 * @desc 类目
 * @date 2019/4/16 0016
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
