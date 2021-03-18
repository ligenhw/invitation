package cn.bestlang.invitation.security;

import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SimpleUrlMatcher implements UrlMatcher {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    private List<MvcPattern> patterns = new ArrayList<>();

    @Override
    public void addPathPattern(String pathPattern, HttpMethod method) {
         MvcPattern mvcPattern = new MvcPattern();
         mvcPattern.setPattern(pathPattern);
         mvcPattern.setMethod(method);
         patterns.add(mvcPattern);
    }

    @Override
    public boolean match(HttpServletRequest request) {
         for(MvcPattern mvcPattern : patterns) {
             String pattern = mvcPattern.getPattern();
             String method = mvcPattern.getMethod().name();
             if (pathMatcher.match(pattern, getRequestPath(request))) {
                 if (method != null) {
                     return request.getMethod().equals(method);
                 }
                 return true;
             }
         }
        return false;
    }

    private String getRequestPath(HttpServletRequest request) {
        if (this.urlPathHelper != null) {
            return this.urlPathHelper.getPathWithinApplication(request);
        }
        String url = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            url = StringUtils.hasLength(url) ? url + pathInfo : pathInfo;
        }
        return url;
    }

    @Data
    private static class MvcPattern {
         private String pattern;
         private HttpMethod method;
    }
}
