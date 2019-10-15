package edu.mum.cs.cs425.eregistrar.eregistrar.service.impl;

import edu.mum.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.eregistrar.repository.StudentRepo;

import edu.mum.cs.cs425.eregistrar.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

//    @Override
//    public void saveStudent(Student student) {
//        studentRepo.save(student);
//    }



    @Override
    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepo.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(containsDecimalPoint(searchString) && isResult(searchString)){
            return studentRepo.findAllByCgpaEquals(Double.parseDouble(searchString));
        }else if(isDate(searchString)){
            return studentRepo.findAllByDateOfEnrollmentEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        }else {
            return studentRepo.findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrdeOrderByStudentNumber(searchString, searchString, searchString);
        }

    }



    private boolean isResult(String searchString){
        boolean isParseableAsResult = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsResult = true;
        }catch (Exception e) {
            if(e instanceof ParseException){
                isParseableAsResult = false;
            }
        }
        return isParseableAsResult;
    }

    private boolean isDate(String searchString){
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        }catch (Exception e) {
            if(e instanceof DateTimeParseException){
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString){
        return searchString.contains(".");
    }

}
