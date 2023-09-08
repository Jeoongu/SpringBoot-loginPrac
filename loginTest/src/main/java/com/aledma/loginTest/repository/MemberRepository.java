package com.aledma.loginTest.repository;

import com.aledma.loginTest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByloginId(String loginId);
}
