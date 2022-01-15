package com.example.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> studentList = new ArrayList<>();

    public SchoolClass(String name) {
        this.name = name;
    }

    public SchoolClass() {
    }
}
