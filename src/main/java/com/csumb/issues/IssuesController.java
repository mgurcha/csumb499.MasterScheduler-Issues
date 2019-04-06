package com.csumb.issues;

import com.csumb.issues.entities.Student;
import com.csumb.issues.repositotries.IClassRepository;
import com.csumb.issues.repositotries.ISectionRepository;
import com.csumb.issues.repositotries.IStudentRepository;
import com.csumb.issues.repositotries.ITeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IssuesController {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IClassRepository classRepository;

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    private ISectionRepository sectionRepository;

    //http://localhost:8084/test
    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public String test(){
        return "works";
    }

    //This is an example of how you should work with the repos and
    //an example of how to use that date
    //THIS STILL NEEDS TO BE REFACTORED
    @CrossOrigin(origins = "*")
    @GetMapping("studentErrors")
    public List<String> studentErrors(){
        List<Student> students = studentRepository.findAll();
        List<String> errors = new ArrayList<>();
        for(Student s: students){
            if(s.getSchedule().size()<6){
                errors.add(s.getId());
            }
        }
        return errors;
    }

}
