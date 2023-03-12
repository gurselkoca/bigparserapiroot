package com.intellibus.bigparser.api.security.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserPreference {
    private String id;
    private List<String> emailList = new ArrayList<>();

    private String userId;

    private NotificationType notificationType;


}
