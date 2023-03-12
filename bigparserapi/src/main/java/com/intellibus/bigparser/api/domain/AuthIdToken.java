package com.intellibus.bigparser.api.domain;



import java.util.Date;
import java.util.Objects;


public record AuthIdToken (String authId, Long timeInMilis, Integer validityDuration) {

    public AuthIdToken {
        Objects.requireNonNull(authId);
        Objects.requireNonNull(timeInMilis);
        Objects.requireNonNull(validityDuration);
    }

    public boolean tokenExpired(){
       long expirationTime =  timeInMilis+validityDuration*1000;
       long current = System.currentTimeMillis();
//       System.out.println("currentDate : "+current+"  expire date "+ new Date(expirationTime)+" expiration : "+expirationTime+
//               " result "+(current-expirationTime)+" validatity "+validityDuration);

       return current>=expirationTime;
    }

}
