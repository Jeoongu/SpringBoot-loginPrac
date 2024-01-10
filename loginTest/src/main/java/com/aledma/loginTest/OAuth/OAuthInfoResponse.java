package com.aledma.loginTest.OAuth;

import com.aledma.loginTest.domain.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}
