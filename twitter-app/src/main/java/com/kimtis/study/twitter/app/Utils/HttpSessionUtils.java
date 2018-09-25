package com.kimtis.study.twitter.app.Utils;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {

    // set session key
    public static final String USER_SESSION_KEY = "user_session";

    // validate login session
    //The Object return type should be replaced with a member class.
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