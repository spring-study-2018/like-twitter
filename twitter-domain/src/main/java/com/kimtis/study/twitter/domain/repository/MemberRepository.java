package com.kimtis.study.twitter.domain.repository;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(String id);

    Integer countById(String id);
}
