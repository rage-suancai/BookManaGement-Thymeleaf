package com.manage.service;

import com.manage.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    void updateStudent(Integer sid, String name, String sex, String grade);

}
