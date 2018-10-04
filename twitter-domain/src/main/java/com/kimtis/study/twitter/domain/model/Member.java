package com.kimtis.study.twitter.domain.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    @NotNull
    @Column(unique = true, nullable = false, updatable = false)
    private String id;
    @NotNull
    private String password;
    @NotNull
    private String displayName;
    @NotNull
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
