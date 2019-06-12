package com.wunian.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wunian.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * @author wunian
 * @desc  商品（包含类目）
 * @date 2019/4/16 0016
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;




}
