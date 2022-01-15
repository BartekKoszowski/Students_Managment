package com.example.Service;

import com.example.Entity.Student;
import com.example.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// Bean warstwy serwisowej. Chodzi o to, że to będzie warstwa pośredniczące między Controllerem a
// Repozytorium. W moim przykładzie Controller bezpośrednio korzysta z repozytorium. Repozytorium jest to
// już warstwa końcowa aplikacji, która komunikuje się z serwerem baz danych. A w tej warstwie będzie
// podstawowa logika. Tutaj się pojawi np. metoda zapisz studenta.
@Service
// @Slf4j sprawia że mam wygenerwowane z automatu (Logger log).
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void create(Student student) {
        if (student.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException(
                    "Student of the specified identifier already exist");
            log.error("Write Failed", exception);
            throw exception;
        }
        studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Integer id) {
        return studentRepository.getById(id);
    }

    public void delete(Student student) {
        if (student.getId() != null) {
            studentRepository.delete(student);
        }
    }

    public void update(Student student) {
        if (student.getId() != null) {
            Student updateStudent = studentRepository.getById(student.getId());
            updateStudent.setFirstName(student.getFirstName());
            updateStudent.setLastName(student.getLastName());
            updateStudent.setEmail(student.getEmail());
        }
        studentRepository.save(student);
    }

}
