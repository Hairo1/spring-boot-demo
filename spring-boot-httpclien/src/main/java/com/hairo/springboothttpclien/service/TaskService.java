package com.hairo.springboothttpclien.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hairo
 */
@Service
@Slf4j
public class TaskService {


    /**
     * 向目的URL发送post请求
     *
     * @param url      目的url
     * @param body     发送的参数 (JSON串)
     * @param apiToken 令牌
     * @return BaseResponse
     */
    public String sendPostRequest(String url, String body, String apiToken) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //Headers
        headers.add("apiToken", "hairo-apiToken");
        headers.add("clientId", "hairo-clientId");
        //请求方式
        HttpMethod method = HttpMethod.POST;
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        //将请求头部和参数合成一个请求
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        //执行HTTP请求，将返回的结构使用BaseResponse类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }
}
