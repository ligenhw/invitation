package cn.bestlang.invitation.security;

import javax.servlet.http.HttpServletRequest;

public interface UrlMatcher {

    void addPathPattern(String pathPattern);

    boolean match(HttpServletRequest request);
}
