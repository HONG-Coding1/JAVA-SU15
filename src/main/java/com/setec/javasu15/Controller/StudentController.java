package com.setec.javasu15.Controller;
import com.setec.javasu15.model.request.StudentRequest;
import com.setec.javasu15.model.response.StudentResponse;
import com.setec.javasu15.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/students")
@RequiredArgsConstructor //constructor injection



//a place that receive http from client side
//do not write business logic nv ng te


public class StudentController {

    private final StudentService studentService;

    //constructor injection
    @GetMapping
    public ResponseEntity<List<StudentResponse>> list(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName
    ) {
        return ResponseEntity.ok(studentService.list(page, size, email, firstName,lastName));
    }


    //Get Student By id
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> get(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(studentService.get(id));
    }


    //Create Student
    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.create(request));
    }

    //Update Student
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@Valid @PathVariable Long id, @RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.update(id,request));
    }

    //Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
