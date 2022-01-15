package com.example.Controller;

import com.example.Entity.SchoolClass;
import com.example.Entity.Student;
import com.example.Repository.SchoolClassRepository;
import com.example.Service.SchoolClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @GetMapping("/schoolClass-list")
    public String getList(ModelMap modelMap){
        List<SchoolClass> schoolClasses = schoolClassService.getAll();
        modelMap.addAttribute("schoolClasses",schoolClasses);
        return "schoolClass-list";
    }

    @GetMapping("/schoolClass-add")
    public String getForm(@ModelAttribute("schoolClass") SchoolClass schoolClass) {
        return "schoolClass-form";
    }

    @PostMapping("/schoolClass-add")
    public String create(SchoolClass schoolClass){
        schoolClassService.create(schoolClass);
        return "redirect:/schoolClass-list";
    }

    @GetMapping("/delete-schoolClass/{schoolClassId}")
    public String delete(@PathVariable("schoolClassId") int id, ModelMap modelMap) {
        SchoolClass schoolClass = schoolClassService.getById(id);
        modelMap.addAttribute("schoolClass", schoolClass);
        return "schoolClass-delete";
    }

    @PostMapping("delete-schoolClass/{schoolClassId}")
    public String delete(SchoolClass schoolClass) {
        schoolClassService.delete(schoolClass);
        return "redirect:/schoolClass-list";
    }

    @GetMapping("/update-schoolClass/{schoolClassId}")
    public String getUpdateForm(@PathVariable("schoolClassId") int id, ModelMap modelMap) {
        SchoolClass schoolClass = schoolClassService.getById(id);
        modelMap.addAttribute("schoolClass", schoolClass);
        return "schoolClass-update";
    }

    @PostMapping("/update-schoolClass/{schoolClassId}")
    public String update(SchoolClass schoolClass) {
        schoolClassService.update(schoolClass);
        return "redirect:/schoolClass-list";
    }


}

