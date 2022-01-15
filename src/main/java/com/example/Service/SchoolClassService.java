package com.example.Service;

import com.example.Entity.SchoolClass;
import com.example.Entity.Student;
import com.example.Repository.SchoolClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    public void create(SchoolClass klasa) {
        if (klasa.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Class of the specified identifier already exist");
            log.error("Write Failed", exception);
            throw exception;
        }
        schoolClassRepository.save(klasa);
    }

    public List<SchoolClass> getAll() {
        return schoolClassRepository.findAll();
    }

    public SchoolClass getById(Integer id) {
        return schoolClassRepository.getById(id);
    }

    public void delete(SchoolClass klasa) {
        if (klasa.getId() != null) {
            schoolClassRepository.delete(klasa);
        }
    }

    public void update(SchoolClass schoolClass) {
        if (schoolClass.getId() != null) {
            SchoolClass updateSchoolClass = schoolClassRepository.getById(schoolClass.getId());
            updateSchoolClass.setName(schoolClass.getName());
        }
        schoolClassRepository.save(schoolClass);
    }
}



