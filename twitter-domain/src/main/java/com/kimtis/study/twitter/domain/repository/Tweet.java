package com.kimtis.study.twitter.domain.repository;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@AllArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tweetId;
    @Column
    private String content;
    @Column
    private long memberId;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;

    public Tweet() {
    }

    public Tweet(String content, long memberId) {
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
