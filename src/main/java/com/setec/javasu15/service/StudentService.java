package com.setec.javasu15.service;

import com.setec.javasu15.model.request.StudentRequest;
import com.setec.javasu15.model.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> list(int page, int size, String email, String firstName, String lastName);

    StudentResponse get(Long id);

    StudentResponse create(StudentRequest request);

    StudentResponse update(Long id, StudentRequest request);

    void delete(Long id);
}
