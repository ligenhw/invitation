package cn.bestlang.invitation.security;

import javax.servlet.http.HttpSession;

public class SimpleSecurityContext {

    public final static String AUTHENTICATION_KEY = "AUTHENTICATION_KEY";

    public static void saveAuthentication(HttpSession httpSession, Object authentication) {
        httpSession.setAttribute(AUTHENTICATION_KEY, authentication);
    }

    public static String getAuthentication(HttpSession httpSession) {
        return (String) httpSession.getAttribute(AUTHENTICATION_KEY);
    }
}
