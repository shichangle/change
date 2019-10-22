package com.change.le.student.service;

import com.change.le.student.entity.DO.Student;
import com.change.le.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author shichangle
 * date 2019/10/17 0017 17:43
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;
    public List<Student> findAll() {
        return studentMapper.findAll();
    }
}
