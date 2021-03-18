package cn.bestlang.invitation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public UrlMatcher urlMatcher() {
        SimpleUrlMatcher simpleUrlMatcher = new SimpleUrlMatcher();
        simpleUrlMatcher.addPathPattern("/invitation/comment/**");

        return simpleUrlMatcher;
    }
}
