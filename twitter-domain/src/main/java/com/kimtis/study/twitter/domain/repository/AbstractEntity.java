package com.kimtis.study.twitter.domain.repository;

import Utils.LocalDateTimePersistenceConverter;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
//JPA Entity 클래스들이 이 클래스를 상속할 경우 필드들을 컬럼으로 인식하도록 설정
@MappedSuperclass
//Auditing 기능을 포함
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @CreatedDate
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public String getFormattedCreateDate() {
        return getFormattedDate(createdAt, "yyyy.MM.dd HH:mm:ss");
    }

    private String getFormattedDate(LocalDateTime dateTime, String format) {
        if (dateTime == null) {
            return "";
        }
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }
}
