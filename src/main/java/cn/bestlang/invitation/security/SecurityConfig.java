package cn.bestlang.invitation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    @Bean
    public UrlMatcher urlMatcher() {
        SimpleUrlMatcher simpleUrlMatcher = new SimpleUrlMatcher();
        simpleUrlMatcher.addPathPattern("/invitation/comment", HttpMethod.POST);

        return simpleUrlMatcher;
    }
}