package com.manage.mapper;

import com.manage.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select sid,name,sex,grade from db_student")
    List<Student> getStudentList();

    @Update("update db_student set name=#{name},sex=#{sex},grade=#{grade} where sid=#{sid}")
    void UpdateStudent(@Param("sid") Integer sid,
                       @Param("name") String name,
                       @Param("sex") String sex,
                       @Param("grade") String grade);

}
