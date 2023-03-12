package com.intellibus.bigparser.api.security.service;

import com.intellibus.bigparser.api.security.domain.AuthIdToken;
import com.intellibus.bigparser.api.security.domain.LoginResponse;

public interface AuthIdManager {
    AuthIdToken validToken();
    LoginResponse login();
}
