package com.intellibus.bigparser.api.security.service;

import com.intellibus.bigparser.api.security.domain.LoginResponse;
import com.intellibus.bigparser.api.security.domain.SignupRequest;
import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.service.impl.SignupServiceImpl;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SignupServiceTest {

    @InjectMocks
    SignupServiceImpl signupService;

    @Mock
    BigParserProperties bigParserProperties;

    @Mock
    RestTemplate restTemplate;

    private LoginResponse loginResponse;
    private SignupRequest signupRequest;
    @BeforeEach
    public void init(){
        Faker faker = new Faker(new Random(System.currentTimeMillis()));
//        when(bigParserProperties.getEmailId()).thenReturn(faker.bothify("??????##@gmail.com"));
//        when(bigParserProperties.getPassword()).thenReturn(faker.bothify("??????##"));
//
//        when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
//        when(bigParserProperties.getLogin()).thenReturn(faker.internet().ipV4Address());
//        signupRequest = new SignupRequest(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
//        loginResponse = new LoginResponse(faker.bothify("???##??##???"));
//        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatusCode.valueOf(200));
//        when(restTemplate.postForEntity(anyString(),any(LoginRequest.class),any(Class.class))).thenReturn(responseEntity);

    }

    @Test
    public void signup_userNotExists_userCreated(){
             //signupService.signup();
        //assertNotNull(authIdToken);
        //assertEquals(loginResponse.getAuthId(),authIdToken.authId());
    }

//    @Test
//    public void validToken_validTokenExists_sameTokenReturned(){
//        AuthIdToken authIdToken = authIdManager.validToken();
//        assertNotNull(authIdToken);
//        AuthIdToken secondAuthIdToken = authIdManager.validToken();
//        assertEquals(loginResponse.getAuthId(),authIdToken.authId());
//        assertEquals(authIdToken,secondAuthIdToken);
//    }
//
//    @Test
//    public void validToken_tokenExpired_newTokenReturned() throws InterruptedException {
//     //   when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
//        AuthIdToken authIdToken = authIdManager.validToken();
//        assertNotNull(authIdToken);
//        assertFalse(authIdToken.tokenExpired());
//        Thread.sleep(1100);
//        assertTrue(authIdToken.tokenExpired());
//        AuthIdToken secondAuthIdToken = authIdManager.validToken();
//        assertNotEquals(authIdToken,secondAuthIdToken);
//    }

}
