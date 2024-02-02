package com.school.easySchool.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class baseEntity
{
    private String createdBy;
    private LocalDate createAt;

    private String updateBy;
    private LocalDateTime updateAt;

}
