package com.intellibus.bigparser.api.security.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class SubscriptionInfo {
    private SubscriptionType subscriptionType;
    private String orderGridId;

}
