package com.setec.javasu15.repository;

import com.setec.javasu15.model.Entity.Student;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

//domnang entity rbos student

@Repository //ensure that this ensure is repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsById(@Valid @PathVariable Long id);
    boolean existsByEmail(@Valid @PathVariable String email);
    Page<Student> findByEmail(String email, Pageable pageable);

    @Query("select s from Student s where lower(s.first_name) like lower(concat('%', :firstName, '%'))")
    Page<Student> findByFirstNameContaining(@Param("firstName") String firstName, Pageable pageable);

    @Query("select s from Student s where lower(s.last_name) like lower(concat('%', :lastName, '%'))")
    Page<Student> findByLastNameContaining(@Param("lastName") String lastName, Pageable pageable);
}
