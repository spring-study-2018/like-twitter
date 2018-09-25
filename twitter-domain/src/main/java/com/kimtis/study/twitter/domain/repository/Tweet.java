package com.kimtis.study.twitter.domain.repository;

import lombok.*;

import javax.persistence.*;

/*
 * @Data including @getter, @setter, @Tostring, @RequiredArgsConstructor, @EqualsAndHashCode
 * @Builder Design Pattern
 */

@NoArgsConstructor
@Data
@Entity(name="TWEET")
public class Tweet extends AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long tweetId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

//    @ManyToOne(targetEntity=Member.class, fetch=FetchType.LAZY)
//    @JoinColumn(name="memberId")
//    private Member member;

    @Column(nullable=false)
    private long memberId;

    @Builder
    public Tweet(String content, long memberId){
        this.content = content;
        this.memberId = memberId;
    }
}
