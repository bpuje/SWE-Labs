package edu.mum.cs.cs425.eregister.versionone.service.impl;

import edu.mum.cs.cs425.eregister.versionone.model.Student;
import edu.mum.cs.cs425.eregister.versionone.repository.StudentRepository;
import edu.mum.cs.cs425.eregister.versionone.service.StudentService;
import org.apache.tomcat.jni.Local;
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
    private StudentRepository studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>)studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepo.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(containsDecimalPoint(searchString) && isResult(searchString)){
            return studentRepo.findAllByCgpaEquals(Double.parseDouble(searchString));
        }else if(isDate(searchString)){
            return studentRepo.findAllByEnrollmentDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        }else {
            return studentRepo.findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrderByFirstName(searchString, searchString, searchString);
        }
    }

    private boolean isResult(String searchString){
        boolean isParseableAsResult = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsResult = true;
        }catch (Exception e){
            if (e instanceof ParseException){
                isParseableAsResult = false;
            }
        }
        return isParseableAsResult;
    }

    private boolean isDate(String searchString){
        boolean isParseableAsDate = true;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        }catch (Exception e){
            if (e instanceof DateTimeParseException){
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString){
        return searchString.contains(".");
    }
}
