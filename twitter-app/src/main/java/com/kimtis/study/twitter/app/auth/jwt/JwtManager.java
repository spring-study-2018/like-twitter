package com.kimtis.study.twitter.app.auth.jwt;

import com.kimtis.study.twitter.app.auth.jwt.constant.Header;
import com.kimtis.study.twitter.app.auth.jwt.constant.Payload;
import com.kimtis.study.twitter.app.auth.jwt.exception.PayloadMismatchException;
import com.kimtis.study.twitter.app.service.MemberDetailsService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

@Component
public class JwtManager {


    @Autowired
    MemberDetailsService memberDetailsService;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h


    /**
     * creating new Json Web Token
     *
     * @return Token
     */
    public String createToken(String id) {

        long curruent_time = System.currentTimeMillis();

         Token token = Token.builder()
                            .header(Header.builder().build())
                            .payload(Payload.builder()
                                    .userID(id)
                                    .iss("com.twitter")
                                    .jti(UUID.randomUUID().toString())
                                    .iat(curruent_time)
                                    .exp(curruent_time + validityInMilliseconds)
                                    .build()).build();

        String createToken = null;
        try {
            createToken = token.encode();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (PayloadMismatchException e) {
            e.printStackTrace();
        }

        return createToken;
    }

    public String substractToken(HttpServletRequest req){
            String bearerToken = req.getHeader("Authorization");
            if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                return bearerToken.substring(7, bearerToken.length());
            }
            return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = memberDetailsService.loadUserByUsername(new Token().decode(token).getPayload().getUserID());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    /**
     * refreshing new Json Web Token
     *
     * @return Token
     */
    public String refreshToken(String token) {

        long current_time = System.currentTimeMillis();

        Token tokenObj = new Token().decode(token);
        tokenObj.getPayload().setIat(current_time);
        tokenObj.getPayload().setExp(current_time + validityInMilliseconds);


        try {
          token = tokenObj.encode();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (PayloadMismatchException e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * check the expire date
     *
     * @return validation
     */
    public boolean verify(String token) {
        long current_time = System.currentTimeMillis();
        long exp_time = new Token().decode(token).getPayload().getExp();

        if(current_time > exp_time){
            return false;
        }

        return true;
    }

}
