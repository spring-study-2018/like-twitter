package com.kimtis.study.twitter.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @NotNull
    @Column(unique = true, nullable = false, updatable = false)
    private String id;

    @NotNull
    private String password;

    @NotNull
    private String displayName;

    @NotNull
    private String email;

    @Column(nullable = false, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
