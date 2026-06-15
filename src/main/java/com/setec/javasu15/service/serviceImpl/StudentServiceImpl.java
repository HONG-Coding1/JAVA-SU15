package com.setec.javasu15.service.serviceImpl;

import com.setec.javasu15.model.Entity.Student;
import com.setec.javasu15.model.request.StudentRequest;
import com.setec.javasu15.model.response.StudentResponse;
import com.setec.javasu15.repository.StudentRepository;
import com.setec.javasu15.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> list() {
        return studentRepository.findAll()
                .stream()
                .map(Student::toResponse)
                .toList();
    }

    @Override
    public StudentResponse get(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found"))
                .toResponse();

    }

    @Override
    public StudentResponse create(StudentRequest request) {
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email Already Exists");
        }
        return studentRepository.save(request.toStudent(null)).toResponse();
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
         studentRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found"));

        return studentRepository.save(request.toStudent(id)).toResponse();
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        studentRepository.deleteById(id);
    }
}
