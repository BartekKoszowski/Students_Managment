package com.example.Repository;

import com.example.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
// Tworzymy repozytorium springowe, rozszeżamy odpowieni interface, rozszeżany będzie interface
// JpaRepository, który będzie oferował najwięcej i będzie najwygodniejszy. Typ sparametryzowany pierwszy
// to jest typ encji drugi to typ identyfikatora encji. I tak uzyskujemy repozytorium. Będzie utworzony
// bean tego typu, który będzie implementował metody tego interface'u.

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

