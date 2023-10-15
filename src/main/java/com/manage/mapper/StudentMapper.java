package com.manage.mapper;

import com.manage.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select name,sex,grade from db_student")
    List<Student> getStudentList();

}
