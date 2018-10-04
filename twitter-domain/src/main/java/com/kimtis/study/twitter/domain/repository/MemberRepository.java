package com.kimtis.study.twitter.domain.repository;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
