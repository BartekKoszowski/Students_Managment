package com.example.Repository;

import com.example.Entity.SchoolClass;
import com.example.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolClassRepository extends JpaRepository<SchoolClass,Integer> {
}
