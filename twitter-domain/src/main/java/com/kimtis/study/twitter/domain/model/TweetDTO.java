package com.kimtis.study.twitter.domain.model;

public class TweetDTO {

    private String content;
    private long memberId;

    public TweetDTO() {
    }

    public TweetDTO(String content, long memberId) {
        this.content = content;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "TweetDTO{" +
                "content='" + this.content + '\'' +
                ", memberId=" + this.memberId +
                '}';
    }
}
