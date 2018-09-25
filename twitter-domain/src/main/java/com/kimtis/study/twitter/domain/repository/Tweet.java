package com.kimtis.study.twitter.domain.repository;

import lombok.*;

import javax.persistence.*;

/*
 * @Data including @getter, @setter, @Tostring, @RequiredArgsConstructor, @EqualsAndHashCode
 * @Builder Design Pattern
 */

@NoArgsConstructor
@Data
@Entity
public class Tweet extends AbstractEntity {

    @Id
    @Column(name="tweetId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tweetId;

    @Column(name="content", columnDefinition = "TEXT", nullable = false)
    private String content;

//    @ManyToOne(targetEntity=Member.class, fetch=FetchType.LAZY)
//    @JoinColumn(name="memberId")
//    private Member member;

    @Column
    private long memberId;


    @Builder
    public Tweet(String content, long memberId){
        this.content = content;
        this.memberId = memberId;
    }
}
