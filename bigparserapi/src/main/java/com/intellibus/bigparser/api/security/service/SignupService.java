package com.intellibus.bigparser.api.security.service;


import com.intellibus.bigparser.api.security.domain.SignupRequest;

public interface SignupService {
    void signup(SignupRequest signupRequest);
}
