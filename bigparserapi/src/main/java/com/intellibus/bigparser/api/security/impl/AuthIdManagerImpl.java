package com.intellibus.bigparser.api.security.impl;

import com.intellibus.bigparser.api.domain.AuthIdToken;
import com.intellibus.bigparser.api.domain.LoginRequest;
import com.intellibus.bigparser.api.domain.LoginResponse;
import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.AuthIdManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class AuthIdManagerImpl implements AuthIdManager {
    private AuthIdToken currentToken;

    private final RestTemplate restTemplate;
    private final BigParserProperties bigParserProperties;


    public AuthIdManagerImpl(RestTemplate restTemplate, BigParserProperties bigParserProperties) {
        this.restTemplate = restTemplate;
        this.bigParserProperties = bigParserProperties;
    }

    @Override
    public AuthIdToken validToken(){
        if (null == currentToken || currentToken.tokenExpired()) {
            currentToken = newToken();
        }
        return currentToken;
    }

    @Override
    public void clearToken()    {
        currentToken = null;
    }
    private AuthIdToken newToken(){
        LoginRequest loginRequest = new LoginRequest(bigParserProperties.getEmailId(), bigParserProperties.getPassword());
        ResponseEntity<LoginResponse>  loginResponseEntity = restTemplate.postForEntity(bigParserProperties.getLogin(),loginRequest, LoginResponse.class);
        LoginResponse loginResponse = loginResponseEntity.getBody();
        AuthIdToken authIdToken = new AuthIdToken(loginResponse.getAuthId(),System.currentTimeMillis(),bigParserProperties.getTokenInvalidSeconds());
        return authIdToken;

    }

}
