package com.kimtis.study.twitter.domain.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
public class Tweet2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tweetId;
    @Column
    private String content;
    @Column
    private long memberId;
    @Column
    private Date createAt;

    public Tweet2() {
    }

    public Tweet2(String content, long memberId) {
        this.content = content;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "content='" + content + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
