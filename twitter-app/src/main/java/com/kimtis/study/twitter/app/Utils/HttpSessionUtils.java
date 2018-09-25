package com.kimtis.study.twitter.app.Utils;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {

    // session 의 key 값을 상수로 설정
    public static final String USER_SESSION_KEY = "user_session";

    // 로그인된 유저 판별
    public static boolean isLogin(HttpSession session) {

        Object sessionUser = session.getAttribute(USER_SESSION_KEY);
        if (sessionUser == null) {
            return false;
        }
        return true;
    }

    public static Object getUserFromSession(HttpSession session) {
        if (!isLogin(session)) {
            return null;
        }

        return session.getAttribute(USER_SESSION_KEY);
    }

}