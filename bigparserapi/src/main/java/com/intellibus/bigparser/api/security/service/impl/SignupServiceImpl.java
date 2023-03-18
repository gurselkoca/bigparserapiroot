package com.intellibus.bigparser.api.security.service.impl;

import com.intellibus.bigparser.api.security.domain.SignupRequest;
import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.service.SignupService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SignupServiceImpl implements SignupService {

    private final RestTemplate restTemplate;
    private final BigParserProperties bigParserProperties;

    public SignupServiceImpl(RestTemplate restTemplate, BigParserProperties bigParserProperties) {
        this.restTemplate = restTemplate;
        this.bigParserProperties = bigParserProperties;
    }

    @Override
    public void signup(SignupRequest signupRequest) {
        ResponseEntity responseEntity= restTemplate.postForEntity(bigParserProperties.getSignup(),signupRequest,String.class);
        assert  responseEntity.getStatusCode()== HttpStatusCode.valueOf(200);

    }
}
