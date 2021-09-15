package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;

import java.util.List;

/**
 * @author YeYaqiao
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/list")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
