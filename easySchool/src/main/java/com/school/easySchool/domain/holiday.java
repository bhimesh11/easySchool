package com.school.easySchool.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class holiday
{
    private final String day;
    private final String reason;
    private final Type type;
    public enum Type
    {
        FESTIVAL, FEDERAL
    }
}
