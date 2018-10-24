package com.kimtis.study.twitter.app.auth.security;

import com.kimtis.study.twitter.app.auth.jwt.JwtManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class PreLoginSucessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JwtManager jwtManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        log.info("onAuthenticationSuccess()!");

        //TODO Change Redis
//        session get
        HttpSession session = request.getSession();
        session.setAttribute("userId", authentication.getName());

        if(session.getAttribute("token") == null) {
            String token = jwtManager.createToken(authentication.getName());
            session.setAttribute("token", token);
        }

        response.setStatus(HttpServletResponse.SC_OK);

        boolean admin = false;

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            log.info(auth.getAuthority());
            if ("ROLE_ADMIN".equals(auth.getAuthority())) {
                log.info("This User Role is {}." , auth.getAuthority());
                admin = true;
            }
        }

        if (admin) {
            response.sendRedirect("/aadmin/");
        }else {
            response.sendRedirect("/hello");
        }
    }

}