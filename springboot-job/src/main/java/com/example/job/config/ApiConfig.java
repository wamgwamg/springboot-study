package com.example.job.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @author pasta
 * @date 2019-03-03
 */
@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "standard-api")
public class ApiConfig {

    public StandardApi idgen;

    public StandardApi passport;

    public StandardApi smsApi;

    public StandardApi paygentNewApi;

    public StandardApi payApi;

    public StandardApi windApi;

    public StandardApi companyApi;

    public StandardApi aucApi;

    public StandardApi productApi;

    public StandardApi loanApi;

    public StandardApi noticeApi;

    public StandardApi jdbPayGateApi;

    public StandardApi friendApi;

    public StandardApi billingApi;

    public StandardApi tradeApi;

    public StandardApi purchase;

    public StandardApi appcontract;

    public StandardApi opuiApi;

    public StandardApi cashierApi;

    public StandardApi datagentApi;

    public StandardApi phoneListApi;

    public StandardApi sessionApi;

    public StandardApi weChatApi;

    public StandardApi jiouApi;

    public StandardApi qyWechatApi;

    public StandardApi syApi;

    @Data
    public static class StandardApi {

        public String appKey;

        public String domain;

        public String appId;

        public String signKey;

        public String accessToken;

        private Map<String, String> bizUriMap;

        private Map<String, String> extParamMap;

        public String getBizUrl(String bizKey) {
            if (MapUtils.isNotEmpty(bizUriMap)) {
                String bizUrl;
                if (null != (bizUrl = bizUriMap.get(bizKey))) {
                    return domain.concat(bizUrl);
                }
                throw new RuntimeException(String.format("un found biz url from key %s!", bizKey));
            }
            throw new RuntimeException("biz-uri-map is empty!");
        }

        public String getExtParams(String extKey) {

            if (MapUtils.isNotEmpty(extParamMap)) {
                String extParam;
                if (null != (extParam = extParamMap.get(extKey))) {

                    return extParam;
                }
                throw new RuntimeException(String.format("un found ext param from key %s!", extKey));
            }
            throw new RuntimeException("ext-param-map is empty!");
        }

    }


}
