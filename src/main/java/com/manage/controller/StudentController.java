package com.manage.controller;

import com.manage.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/student")
    public String student(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("student_list", studentService.getStudentList());
        return "student";

    }
    @GetMapping("/up-student")
    public String Student() {
        return "";
    }
    @PostMapping("/up-student")
    public String updateStudent(Integer sid, String name, String sex, String grade) {
        studentService.updateStudent(sid, name, sex, grade); return "redirect:/student";
    }

}
