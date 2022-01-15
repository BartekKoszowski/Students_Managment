package com.example.Controller;

import com.example.Entity.SchoolClass;
import com.example.Entity.Student;
import com.example.Service.SchoolClassService;
import com.example.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
// Adnotacja @Controller żeby moża było zwrócić nazwę widoku, ponieważ chcę żeby odpowiedź do klienta była
// odrazu dokumentem HTML.
// @GetMapping żądanie wysłane pod ścieżkę "/list". Dodajemy metodę, która zwraca łańcuch znaków i zwraca
// nazwę widoku (szablon/template).
// Wstrzykuję zależności przy pomocy konstruktora, więc jeden bean będzie zależny od drugiego i te zależności
// będą przypisywane do pól żeby metody mogły z tego beana skorzystać. Korzystam z konstrukotora bo to jest
// najlepszy sposób wstrzykiwania zależności bo nie da się inaczej stworzyć kontrolera studentów niż z wykorzystanie
// tego konstruktora któemu trzeba zadać repozytorium studentów.

@Controller
@AllArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @GetMapping("/student-list")
    public String getList(ModelMap modelMap) {
        List<Student> students = studentService.getAll();
        modelMap.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/student-add")
    public String getForm(@ModelAttribute("student") Student student) {
        return "student-form";
    }

    @PostMapping("/student-add")
    public String create(@Validated Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        studentService.create(student);
        return "redirect:/student-list";

    }

    @GetMapping("/delete-student/{studentId}")
    public String delete(@PathVariable("studentId") int id, ModelMap modelMap) {
        Student student = studentService.getById(id);
        modelMap.addAttribute("student", student);
        return "student-delete";
    }

    @PostMapping("delete-student/{studentId}")
    public String delete(Student student) {
        studentService.delete(student);
        return "redirect:/student-list";
    }

    @GetMapping("/test-view")
    public String testView() {
        return "view-test";
    }

    @GetMapping("/update-student/{studentId}")
    public String getUpdateForm(@PathVariable("studentId") int id, ModelMap modelMap) {
        Student student = studentService.getById(id);
        modelMap.addAttribute("student", student);
        return "student-update";
    }

    @PostMapping("/update-student/{studentId}")
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/student-list";
    }

    @GetMapping("/result-student")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        return "student-list";
    }

}


