package cn.bestlang.invitation.authentication.config;

import cn.bestlang.invitation.authentication.api.WxApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class WxApiConfig {

    @Value("${invitation.wxmini.appKey:}")
    private String appKey;
    @Value("${invitation.wxmini.appSecret:}")
    private String appSecret;

    @Bean
    public WxApi wxApi(RestTemplate restTemplate) {
        return new WxApi(appKey, appSecret, restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();
    }
}
