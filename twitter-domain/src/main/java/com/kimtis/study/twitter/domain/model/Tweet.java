package com.kimtis.study.twitter.domain.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tweetId;

    @NotNull
    private String content;

    @NotNull
    private long memberId;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;


    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", content='" + content + '\'' +
                ", memberId=" + memberId +
                ", createAt=" + createAt +
                '}';
    }
}
