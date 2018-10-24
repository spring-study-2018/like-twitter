package com.kimtis.study.twitter.app.auth.jwt.constant;


public enum Claim {
    /**
     * 비공개 클레임
     *
     * @value 유저 아이디
     */

    userID,

    /**
     * 등록된 클레임
     *
     * @value 토큰 발급자
     */

    iss,

    /**
     * 등록된 클레임
     *
     * @value 토큰 식별자 - uuid
     */

    jti,

    /**
     * 등록된 클레임
     *
     * @value 토큰 발급 시간
     */

    iat,

    /**
     * 등록된 클레임
     *
     * @value 토큰 만료 시간
     */

    exp;

}
