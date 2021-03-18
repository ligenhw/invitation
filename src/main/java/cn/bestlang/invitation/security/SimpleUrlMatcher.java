package cn.bestlang.invitation.security;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SimpleUrlMatcher implements UrlMatcher {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    private List<String> patterns = new ArrayList<>();

     @Override
    public void addPathPattern(String pathPattern) {
         patterns.add(pathPattern);
    }

    @Override
    public boolean match(HttpServletRequest request) {
         for(String pattern : patterns) {
             if (pathMatcher.match(pattern, getRequestPath(request))) {
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
}
