package com.example.Controller;


import com.example.Entity.User;
import com.example.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/user-list")
    public String getUserList(ModelMap modelMap) {
        List<User> userList = userService.getAll();
        modelMap.addAttribute("users", userList);
        return "user-list";
    }



}