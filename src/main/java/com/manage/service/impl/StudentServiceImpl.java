package com.manage.service.impl;

import com.manage.entity.Student;
import com.manage.mapper.StudentMapper;
import com.manage.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public void updateStudent(Integer sid, String name, String sex, String grade) {
        studentMapper.UpdateStudent(sid, name, sex, grade);
    }

}
