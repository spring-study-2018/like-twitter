package com.kimtis.study.twitter.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tweetId;

	@NotNull
	private String content;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;

	@Column(nullable = false, insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
}
