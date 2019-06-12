package com.wunian.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wunian
 * @desc 商品类目
 * @date 2019/4/16 0016
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue//id自增
    private Integer categoryId;//类目id

    private String categoryName;//类目名称

    private Integer categoryType;//类目编号

    //private Date createTime;

    //private Date updateTime;

    public ProductCategory(){

    }

    public ProductCategory(String categoryName,Integer categoryType){
        this.categoryName=categoryName;
        this.categoryType=categoryType;
    }



}
