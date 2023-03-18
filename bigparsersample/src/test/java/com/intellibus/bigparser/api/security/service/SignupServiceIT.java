package com.intellibus.bigparser.api.security.service;


import com.intellibus.bigparser.api.property.BigParserProperties;
import com.intellibus.bigparser.api.security.domain.SignupRequest;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class SignupServiceIT {

    private static final Logger logger  = LoggerFactory.getLogger(SignupServiceIT.class);
    @Autowired
    SignupService signupService;

    @SpyBean
    BigParserProperties bigParserProperties;

    private SignupRequest signupRequest;

    @BeforeEach
    public void init(){

    }


    @Test
    @Disabled // do not pollute db
    public void signup_userNotExists_userCreated(){
        Faker faker = new Faker(new Random(System.currentTimeMillis()));
        signupRequest = new SignupRequest(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());

        assertDoesNotThrow(()-> signupService.signup(signupRequest));

    }



    @Test
    public void signup_userExists_400Returned(){
        Faker faker = new Faker(new Random(System.currentTimeMillis()));
        signupRequest = new SignupRequest(faker.name().fullName(), bigParserProperties.getEmailId(),faker.internet().password());

        HttpClientErrorException.BadRequest badRequest =assertThrows(HttpClientErrorException.BadRequest.class,()->
         signupService.signup(signupRequest));
        assertTrue( badRequest.getMessage().contains("Email Id is already present."));
    }


    @Test
    @Disabled //email control shold be added
    public void signup_invalidEmail_400Returned(){
        Faker faker = new Faker(new Random(System.currentTimeMillis()));
        signupRequest = new SignupRequest(faker.name().fullName(), "invalidEmail%eee.com",faker.internet().password());

        HttpClientErrorException.BadRequest badRequest =assertThrows(HttpClientErrorException.BadRequest.class,()->
                signupService.signup(signupRequest));
        assertFalse( badRequest.getMessage().contains("Email Id is already present."));
    }

}
