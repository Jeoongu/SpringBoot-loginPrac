package com.aledma.loginTest.service;

import com.aledma.loginTest.Jwt.AuthTokens;
import com.aledma.loginTest.Jwt.AuthTokensGenerator;
import com.aledma.loginTest.OAuth.OAuthInfoResponse;
import com.aledma.loginTest.OAuth.OAuthLoginParams;
import com.aledma.loginTest.OAuth.RequestOAuthInfoService;
import com.aledma.loginTest.domain.Member;
import com.aledma.loginTest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    
    /*
    1. 카카오/네이버와 같은 OAuth 플랫폼에 인증 후 프로필 정보 가져오기
    2. email 정보로 사용자 확인 (없으면 새로 가입처리)
    3. Access Token 생성 후 내려주기
     */
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(Member::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(member).getId();
    }
}