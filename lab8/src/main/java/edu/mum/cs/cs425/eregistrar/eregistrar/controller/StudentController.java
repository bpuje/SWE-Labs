package edu.mum.cs.cs425.eregistrar.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String showStudent(Model model){
        List<Student> studentList = studentService.getAllStudents();
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

    // This method will be using into Lab8
//    @GetMapping("/students")
//    public String displayAllStuds(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("studs", studentService);
//        modelAndView.setViewName("studs/list");
//        return "list";
//    }

//    @GetMapping(value = {"/students/{studentId}"})
//    public String deleteStudent(@PathVariable Long studentId, Model model){
//        studentService.deleteStudentById(studentId);
//        return "redirect:/students";
//    }

    @GetMapping(value = {"/student/edit/{studentId}"})
    public String studentEditForm(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        //student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = {"/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        System.out.println("deleteStudent");
        studentService.deleteStudentById(studentId);
        return "redirect:/student/list";
    }

}
