package com.setec.javasu15.repository;

import com.setec.javasu15.model.Entity.Student;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

//domnang entity rbos student

@Repository //ensure that this ensure is repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsById(@Valid @PathVariable Long id);
    boolean existsByEmail(@Valid @PathVariable String email);
}
