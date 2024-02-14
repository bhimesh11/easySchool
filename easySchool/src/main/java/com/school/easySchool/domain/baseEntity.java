package com.school.easySchool.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class baseEntity {

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;


@LastModifiedDate
@Column(insertable = false)
    private LocalDateTime updateAt;

@LastModifiedDate
@Column(insertable = false)
    private String updateBy;

    /*
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    @CreatedBy
    @Column(updatable = false)
    private LocalDate createAt;

    private String updateBy;
    @Timestamp
    private LocalDateTime updateAt;*/

}
