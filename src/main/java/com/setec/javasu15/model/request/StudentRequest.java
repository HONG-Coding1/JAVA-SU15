package com.setec.javasu15.model.request;


import com.setec.javasu15.model.Entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class StudentRequest {

    @NotBlank(message = "First name is required")
    private String first_name;

    @NotBlank(message = "Last name is required")
    private String last_name;

    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be 8 to 15 digits")
    private String phone_number;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Password is required")
    private String password;

    public Student toStudent(Long id) {
    return new Student(
            id,
            first_name,
            last_name,
            email,
            phone_number,
            address,
            password,
            null);
    }
}
