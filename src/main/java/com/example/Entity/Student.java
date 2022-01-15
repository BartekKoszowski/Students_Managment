package com.example.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.websocket.OnMessage;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 20, message = "Value from 2 to 20")
    private String firstName;

    @Size(min = 2, max = 20, message = "Value from 2 to 20")
    private String lastName;

    @NotEmpty(message = "Field cannot be empty")
    private String address;

    private Integer phone;

    @NotEmpty(message = "Field cannot be empty")
    private String email;

    @ManyToOne
    @JoinColumn(name = "schoolClass_id")
    private SchoolClass schoolClass;

    public Student() {
    }

    public Student(String firstName, String lastName, String address, Integer phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
