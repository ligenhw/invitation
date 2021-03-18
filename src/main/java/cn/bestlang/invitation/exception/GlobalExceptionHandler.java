package cn.bestlang.invitation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-rest-exceptions
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public final ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
        CommonErrorResp resp = new CommonErrorResp(ex.getCode(), ex.getMsg());
        HttpStatus status = HttpStatus.valueOf(ex.getStatus());
        return new ResponseEntity(resp, status);
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, HttpServletRequest request) {
        log.error("{}", ex);

        CommonErrorResp resp = new CommonErrorResp();
        resp.setMsg(ex.getMessage());
        HttpStatus status = getStatus(request);
        return new ResponseEntity(resp, status);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("{}", ex);

        CommonErrorResp resp = new CommonErrorResp();
        resp.setMsg(ex.getMessage());
        return new ResponseEntity(resp, headers, status);
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception var4) {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
    }
}
