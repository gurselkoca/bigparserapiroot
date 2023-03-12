package com.intellibus.bigparser.api.security;

import com.intellibus.bigparser.api.domain.AuthIdToken;
import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.impl.AuthIdManagerImpl;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthIdManagerIT {

    private static final Logger logger  = LoggerFactory.getLogger(AuthIdManagerIT.class);
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
    public void validToken_validTokenExists_sameTokenReturned(){
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertEquals(authIdToken,secondAuthIdToken);
    }

    @Test
    public void validToken_tokenExpired_newTokenReturned() throws InterruptedException {
        when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
        //logger.info("invalidation second : {}",bigParserProperties.getTokenInvalidSeconds());
        authIdManager.clearToken();
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        assertFalse(authIdToken.tokenExpired());
        //long begin = System.currentTimeMillis();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(()->authIdToken.tokenExpired());
//        long end = System.currentTimeMillis();
//        logger.info("Wait time (ms):{}",(end-begin));
        assertTrue(authIdToken.tokenExpired());
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertNotEquals(authIdToken,secondAuthIdToken);
    }

}
