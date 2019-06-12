package com.wunian.VO;

import lombok.Data;

/**
 * @author wunian
 * @desc http请求返回的最外层对象
 * @date 2019/4/16 0016
 */
@Data
public class ResultVO<T> {

    private Integer code;//错误码

    private String msg;//提示信息

    private T data;//具体数据内容
}
