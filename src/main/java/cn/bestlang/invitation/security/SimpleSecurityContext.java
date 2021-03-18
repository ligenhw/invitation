package cn.bestlang.invitation.security;

import javax.servlet.http.HttpSession;

public class SimpleSecurityContext {

    public final static String AUTHENTICATION_KEY = "AUTHENTICATION_KEY";

    public static void saveAuthentication(HttpSession httpSession, Object authentication) {
        httpSession.setAttribute(AUTHENTICATION_KEY, authentication);
    }

    public static Object getAuthentication(HttpSession httpSession) {
        return httpSession.getAttribute(AUTHENTICATION_KEY);
    }
}
