package edu.mum.cs.cs425.eregistrar.eregistrar.controller;

import edu.mum.cs.cs425.studentmgmt.studentapp.model.Student;
import edu.mum.cs.cs425.studentmgmt.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentMgmtApp {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String showStudent(Model model){
        List<Student> studentList = studentService.getAllStudents();

//        for(Student stu : studentList) {
//            System.out.println("test: " + stu.getDateOfEnrollment());
//        }
        model.addAttribute("students", studentList);
        return "list";
    }

    @GetMapping("/newStudent")
    public String showAddForm(){
        return "add";
    }

    @PostMapping("/newStudent")
    public String addNewStudent(Student student){

        studentService.saveStudent(student);

        return "redirect:/students";
    }
}
