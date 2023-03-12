package com.intellibus.bigparser.api.security;


import com.intellibus.bigparser.api.domain.SignupRequest;
import org.springframework.http.HttpStatusCode;

public interface SignupService {
    void signup(SignupRequest signupRequest);
}
