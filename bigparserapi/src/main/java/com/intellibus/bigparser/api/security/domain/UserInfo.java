package com.intellibus.bigparser.api.security.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserInfo {
    private String id;
    private String fullName;
    private String emailId;

    private String mobileNumber;

    private String dataStreamId;

    private String gridStreamId;

    private String role;


}
