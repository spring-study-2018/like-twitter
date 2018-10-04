package com.kimtis.study.twitter.domain.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@Builder
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tweetId;

    @NotNull
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

}
