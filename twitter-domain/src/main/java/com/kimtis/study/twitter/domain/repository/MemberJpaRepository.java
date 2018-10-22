package com.kimtis.study.twitter.domain.repository;

import com.kimtis.study.twitter.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
	Member findMemberById(String id);
}
