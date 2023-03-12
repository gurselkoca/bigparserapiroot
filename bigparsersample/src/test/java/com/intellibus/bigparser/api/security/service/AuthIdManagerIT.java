package com.intellibus.bigparser.api.security.service;

import com.intellibus.bigparser.api.security.domain.AuthIdToken;
import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.domain.LoginResponse;
import com.intellibus.bigparser.api.security.service.impl.AuthIdManagerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthIdManagerIT {
    @Autowired
    AuthIdManagerImpl authIdManager;

    @SpyBean
    BigParserProperties bigParserProperties;

    @Test
    public void validToken_tokenNotExists_newTokenCreated(){
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
    }

    @Test
    public void login_success(){
        LoginResponse loginResponse =  authIdManager.login();
        assertNotNull(loginResponse);
        assertNotNull(loginResponse.getSubscriptionInfo());
        assertNotNull(loginResponse.getSubscriptionInfo().getSubscriptionType());
        assertNotNull(loginResponse.getUserPreference());
        assertNotNull(loginResponse.getUserPreference().getNotificationType());
    }

    @Test
    public void validToken_validTokenExists_sameTokenReturned(){
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertEquals(authIdToken,secondAuthIdToken);
    }

    @Test
    public void validToken_tokenExpired_newTokenReturned() throws InterruptedException {
        when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        assertFalse(authIdToken.tokenExpired());
        Thread.sleep(1500);

        assertTrue(authIdToken.tokenExpired());
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertNotEquals(authIdToken,secondAuthIdToken);
    }

}
