package com.kimtis.study.twitter.app.configuration;

import com.kimtis.study.twitter.app.auth.jwt.JwtConfigAdapter;
import com.kimtis.study.twitter.app.auth.jwt.JwtManager;
import com.kimtis.study.twitter.app.auth.security.PreLoginSucessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private static final String LOGIN_ENTRY_POINT = "/auth/login";
    private static final String ADMIN_ENTRY_POINT = "/admin";
    private static final String ERROR_ENTRY_POINT = "/error";
    private static final String ROOT_ENTRY_POINT = "/**";

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new PreLoginSucessHandler();
    }



    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //@formatter:off
            http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers(ROOT_ENTRY_POINT).permitAll()
                .antMatchers(HttpMethod.GET, ADMIN_ENTRY_POINT).hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
             .and()
                .formLogin()
                .loginPage(LOGIN_ENTRY_POINT)
                .loginProcessingUrl(LOGIN_ENTRY_POINT + "/process")
                .usernameParameter("id")
                .passwordParameter("password")
                .failureUrl(LOGIN_ENTRY_POINT + "/fail")
                .defaultSuccessUrl("/hello")
                .successHandler(successHandler())
                .permitAll()
             .and()
                .apply(new JwtConfigAdapter());
        //@formatter:on
    }


}