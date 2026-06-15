package com.setec.javasu15.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentResponse {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    public StudentResponse toResponse() {
        return new StudentResponse(id,first_name,last_name,email,phone_number);
    }
}
