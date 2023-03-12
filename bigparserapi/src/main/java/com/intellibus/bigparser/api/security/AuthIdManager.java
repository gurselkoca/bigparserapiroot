package com.intellibus.bigparser.api.security;

import com.intellibus.bigparser.api.domain.AuthIdToken;

public interface AuthIdManager {
    AuthIdToken validToken();

    void clearToken();
}
