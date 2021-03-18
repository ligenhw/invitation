package cn.bestlang.invitation.authentication.api;

import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class WxApi {

    private static final String URL_AUTH_CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    public WxApi(String appId, String appSecret, RestTemplate restTemplate) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.restTemplate = restTemplate;
    }

    private String appId;
    private String appSecret;
    private RestTemplate restTemplate;

    public AuthCode2SessionResp code2Session(String code) {
        String url = String.format(URL_AUTH_CODE2SESSION, appId, appSecret, code);
        String result = restTemplate.getForObject(url, String.class);
        log.info(result);
        AuthCode2SessionResp resp = JsonUtil.fromJson(result, AuthCode2SessionResp.class);
        resp.checkAndThrow();

        return resp;
    }

}
