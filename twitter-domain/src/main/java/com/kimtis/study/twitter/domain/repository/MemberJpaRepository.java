package com.kimtis.study.twitter.domain.repository;

import com.kimtis.study.twitter.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    //?1 = first parameter
    @Query(
     value = "select * from Member m where m.id = :memberId",
     nativeQuery = true
    )
    Member findByMemberId(@Param("memberId") String memberId);
}
