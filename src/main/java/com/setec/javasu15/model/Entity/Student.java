package com.setec.javasu15.model.Entity;


import com.setec.javasu15.model.response.StudentResponse;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    @Column(unique = true,nullable = false)
    private String email;
    private String phone_number;
    private String address;
    private String password;
    private String photo;

    public StudentResponse toResponse() {
       return new StudentResponse(id, first_name, last_name, email, phone_number);
    }
}
