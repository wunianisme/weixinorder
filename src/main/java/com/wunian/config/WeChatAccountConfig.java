package com.wunian.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wunian
 * @desc
 * @date 2019/5/26 0026
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {

    //公众号平台id
    private String mpAppId;

    //公众号平台密钥
    private String mpAppSecret;

    //开放平台id
    private String openAppId;

    //开放平台密钥
    private String openAppSecret;

    //商户号
    private String mchId;

    //商户密钥
    private String mchKey;

    //商户证书路径
    private String keyPath;

    //微信支付异步通知地址
    private String notifyUrl;

    //微信模板id
    private Map<String,String> templateId;
}
