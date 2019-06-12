package com.wunian.controller;

import com.wunian.VO.ProductInfoVO;
import com.wunian.VO.ProductVO;
import com.wunian.VO.ResultVO;
import com.wunian.dataobject.ProductCategory;
import com.wunian.dataobject.ProductInfo;
import com.wunian.service.CategoryService;
import com.wunian.service.ProductService;
import com.wunian.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wunian
 * @desc  买家商品
 * @date 2019/4/16 0016
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架的商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        //查询类目（一次性查询）
        //传统方法
//        List<Integer> categoryTypeList=new ArrayList<>();
//        for(ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（Java8 lambda表达式）
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼装
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory category:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(category.getCategoryType());
            productVO.setCategoryName(category.getCategoryName());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if(productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}
