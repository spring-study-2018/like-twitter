package com.kimtis.study.twitter.domain.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail implements UserDetails {

    private Long memberId;

    private String id;

    private String password;

    private String displayName;

    private String email;

    private Date createdAt;

    private List<String> roles;

//    private boolean accountNonExpired, accountNonLocked, credentialsNonExpired, enabled;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void grantAuthority(String authority) {
        if (roles == null) roles = new ArrayList<>();
        roles.add(authority);
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
