package com.csumb.issues;

import com.csumb.issues.entities.Section;
import com.csumb.issues.entities.Student;
import com.csumb.issues.entities.Teacher;
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
            //student without 6 classes
            if(s.getSchedule().size()<6) {
                errors.add("Does not have 6 classes: " + s.getId());
            }
        }
        return errors;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("sectionErrors")
    public List<String> sectionErrors(){
        List<Section> sections = sectionRepository.findAll();
        List<String> errors = new ArrayList<>();
        for(Section s: sections){
            //section has no teacher
            if(s.getTeacherID().equals("")){
                errors.add("No Teacher: " +
                        "   Class Name = " + s.getClassName()
                        +"  ,Period = " + s.getPeriod_num()
                        +"  ,ID: " + s.getId());
            }
        }
        return errors;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("teacherErrors")
    public List<String> teacherErrors(){
        List<Teacher> teachers = teacherRepository.findAll();
        List<String> errors = new ArrayList<>();
        for(Teacher t: teachers){
            if(t.getPrep() == 0){
                //teacher has no prep period
                errors.add("No Prep Period: " +
                        "   Name: " + t.getName()
                        +"  ,Department: " + t.getDepartment());
            }
            //teacher has more students than max allotted
            if(t.getCurrentNumStudent() == t.getMaxNumStudent()){
                errors.add("Max # Students Reached: " +
                        "   Name: " + t.getName()
                        +"  ,Department: " + t.getDepartment());
            }
        }
        return errors;
    }
}
