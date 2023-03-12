package com.intellibus.bigparser.api.security.domain;

import java.util.Objects;

public record SignupRequest(String fullName, String emailId, String password, String mobileNumber) {

    public SignupRequest {
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(emailId);
        Objects.requireNonNull(password);
    }
    public SignupRequest(String fullName, String emailId, String password){
        this(fullName,emailId, password,null);
    }


}
