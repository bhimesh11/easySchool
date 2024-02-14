package com.school.easySchool.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "holidays")
public class holiday extends baseEntity {
    @Id
    private  String day;
    private  String reason;
    @Enumerated(EnumType.STRING)
    private  Type type;
    public enum Type
    {
        FESTIVAL, FEDERAL
    }
}
