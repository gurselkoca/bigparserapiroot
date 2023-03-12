package com.intellibus.bigparser.api.security.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LoginResponse {
    @NonNull
    private String authId;
    private boolean activationStatus;
    private SubscriptionInfo subscriptionInfo;

    private UserPreference userPreference;

    private String userStatus;

    private UserInfo userInfo;






}
