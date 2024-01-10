package com.aledma.loginTest.OAuth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NaverTokens {

    /*
    Authorization Code 를 기반으로
    타플랫폼 Access Token 을 받아오기 위한 Response Model 입니다.
     */

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private String expiresIn;
}
