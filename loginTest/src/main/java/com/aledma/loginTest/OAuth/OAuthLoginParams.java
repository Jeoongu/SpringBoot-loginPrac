package com.aledma.loginTest.OAuth;

import com.aledma.loginTest.domain.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {
    /*
    OAuth 요청을 위한 파라미터 값들을 갖고 있는 인터페이스입니다.

    이 인터페이스의 구현체는 Controller 의 @RequestBody 로도 사용하기 때문에
    getXXX 라는 네이밍을 사용하지 않아야 합니다.
     */
    OAuthProvider oAuthProvider();
    MultiValueMap<String , String> makeBody();
}
