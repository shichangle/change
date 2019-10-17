package com.change.le.student.mapper;

import com.change.springbootes.student.entity.DO.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM t_student")
    List<Student> findAll();
}
