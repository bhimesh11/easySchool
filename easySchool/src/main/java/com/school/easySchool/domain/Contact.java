package com.school.easySchool.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table(name="contact_msg")
public class Contact extends baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    @Column(name = "contact_id")
    private int contactId;

    @NotBlank(message = "name must not be blank")
    @Size(min = 3,message = "name must be more than 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number should not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
    private String mobileNum;

    @NotBlank(message = "email must not be blank")
    @Email(message = "please provide valid email address")
    private String email;

    @NotBlank(message = "Subject not be blank")
    @Size(min = 5 , message = "Subject should not be blank" )
    private String subject;

    @NotBlank(message = "Message should not be blank")
    @Size(min = 15 , message = "Message should be more than 15 characters")
    private String message;

    private String status;

}
