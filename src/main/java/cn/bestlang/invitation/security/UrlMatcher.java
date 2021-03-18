package cn.bestlang.invitation.security;

import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

public interface UrlMatcher {

    void addPathPattern(String pathPattern, HttpMethod method);

    boolean match(HttpServletRequest request);
}
