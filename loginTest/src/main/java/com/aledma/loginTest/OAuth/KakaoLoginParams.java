package com.aledma.loginTest.OAuth;

import com.aledma.loginTest.domain.OAuthProvider;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class KakaoLoginParams implements OAuthLoginParams{
    private String authorizationCode;

    @Override
    public OAuthProvider oAuthProvider(){
        return OAuthProvider.KAKAO;
    }

    @Override
    public MultiValueMap<String, String> makeBody(){
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        return body;
    }
}
