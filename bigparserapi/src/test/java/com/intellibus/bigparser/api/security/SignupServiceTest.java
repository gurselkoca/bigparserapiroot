package com.intellibus.bigparser.api.security;

import com.intellibus.bigparser.api.domain.AuthIdToken;
import com.intellibus.bigparser.api.domain.LoginRequest;
import com.intellibus.bigparser.api.domain.LoginResponse;
import com.intellibus.bigparser.api.domain.SignupRequest;
import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.impl.AuthIdManagerImpl;
import com.intellibus.bigparser.api.security.impl.SignupServiceImpl;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SignupServiceTest {

    @InjectMocks
    SignupServiceImpl signupService;

    @Mock
    BigParserProperties bigParserProperties;

    @Mock
    RestTemplate restTemplate;


    private SignupRequest signupRequest;
    @BeforeEach
    public void init(){
        Faker faker = new Faker(new Random(System.currentTimeMillis()));
          signupRequest = new SignupRequest(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
         ResponseEntity<String> responseEntity = new ResponseEntity("", HttpStatusCode.valueOf(200));
        when(bigParserProperties.getSignup()).thenReturn(faker.internet().ipV4Address());
      //  doReturn(responseEntity).when(restTemplate).postForEntity(anyString(),any(SignupRequest.class),any(Class.class));
        when(restTemplate.postForEntity(anyString(),any(SignupRequest.class),any(Class.class))).thenReturn(responseEntity);

    }

    @Test
    public void signup_userNotExists_userCreated(){
        assertDoesNotThrow(()-> signupService.signup(signupRequest));

    }



}
