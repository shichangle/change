package com.change.le.student.conreoller;


import com.change.le.student.entity.DO.Student;
import com.change.le.student.mapper.StudentMapper;
import com.change.le.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/listStudent")
    public String listStudent(Model m){
        List<Student> list = studentService.findAll();
        m.addAttribute("list",list);
        return "listStudent";
    }
}
