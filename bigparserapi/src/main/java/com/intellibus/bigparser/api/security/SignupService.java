package com.intellibus.bigparser.api.security;


import com.intellibus.bigparser.api.domain.SignupRequest;

public interface SignupService {
    void signup(SignupRequest signupRequest);
}
