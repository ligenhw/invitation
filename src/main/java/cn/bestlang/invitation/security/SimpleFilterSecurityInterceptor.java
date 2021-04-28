package cn.bestlang.invitation.security;

import cn.bestlang.invitation.exception.CommonErrorResp;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Order(SessionRepositoryFilter.DEFAULT_ORDER + 10) // after SessionRepositoryFilter
@Component
public class SimpleFilterSecurityInterceptor extends GenericFilterBean {

    @Autowired
    private UrlMatcher urlMatcher;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 跳过预检请求
        if (!requiresAuthentication(request) || CorsUtils.isPreFlightRequest(request)) {
            chain.doFilter(request, response);
            return;
        }

        if (attemptAuthentication(request, response)) {
            chain.doFilter(request, response);
        } else {
            handleAccessDenied(request, response);
        }
    }

    private boolean requiresAuthentication(HttpServletRequest request) {
        if (this.urlMatcher.match(request)) {
            return true;
        }

        return false;
    }

    private boolean attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null && SimpleSecurityContext.getAuthentication(session) != null) {
            log.info("attemptAuthentication : {}", SimpleSecurityContext.getAuthentication(session));
            return true;
        }

        return false;
    }

    private void handleAccessDenied(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        CommonErrorResp commonErrorResp = new CommonErrorResp("Unauthorized", "请登陆");
        response.getWriter().write(JsonUtil.toJson(commonErrorResp));
    }
}
