package com.csumb.issues;


import com.csumb.issues.entities.Class;
import com.csumb.issues.entities.Section;
import com.csumb.issues.entities.Student;
import com.csumb.issues.entities.Teacher;
import com.csumb.issues.repositotries.IClassRepository;
import com.csumb.issues.repositotries.ISectionRepository;
import com.csumb.issues.repositotries.IStudentRepository;
import com.csumb.issues.repositotries.ITeacherRepository;

import com.csumb.issues.entities.*;
import com.csumb.issues.repositotries.*;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @Autowired
    private IIssueRepository issueRepository;

    @Autowired
    private ITeacherIssue teacherIssueRepository;

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IStudentIssueRepository studentIssueRepository;

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
    public List<StudentIssue> studentErrors(){
        List<Student> students = studentRepository.findAll();
        List<String> errors = new ArrayList<>();
        studentIssueRepository.deleteAll();
        for(Student s: students){
            try{
                //student without 6 classes; can use !=
                if(s.getSchedule().size()<6) {
                    studentIssueRepository.insert(new StudentIssue("Does not have 6 classes",s.getId(),s.getName(), s.getGrade(), s.getSchedule()));
//                    errors.add("Does not have 6 classes: " + s.getId());
                }
                if(s.getSchedule().contains("No Class")){
                    studentIssueRepository.insert(new StudentIssue("Does not have 6 classes",s.getId(),s.getName(), s.getGrade(), s.getSchedule()));
                }
            }
            catch (Exception e){
                return studentIssueRepository.findAll();
            }
//            //student without 6 classes; can use !=
//            if(s.getSchedule().size()<6) {
//                errors.add("Does not have 6 classes: " + s.getId());
//            }
        }
        return studentIssueRepository.findAll();
//        return errors;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("sectionErrors")
    public List<Issue> sectionErrors(){
        List<Section> sections = sectionRepository.findAll();
        List<String> errors = new ArrayList<>();
        List<Issue> sectionIssues = issueRepository.findAll();
        issueRepository.deleteAll();
        for(Section s: sections) {
            //section has no teacher
                try {
                    if (s.getTeacherID().equals("")) {
                        issueRepository.insert(new Issue(s.getId(), "No Teacher", s.getSection_num(), s.getClassName(), s.getPeriod_num(), s.getClassRoom()));
                    }
                }
                catch (Exception e) {
                    return issueRepository.findAll();
                }
            }
        return issueRepository.findAll();
    }


    @CrossOrigin(origins = "*")
    @GetMapping("teacherErrors")
    public List<TeacherIssue> teacherErrors(){
        List<Teacher> teachers = teacherRepository.findAll();
        List<String> errors = new ArrayList<>();
        teacherIssueRepository.deleteAll();
        for(Teacher t: teachers) {
            try {
                //Prep period at same time as a class
                if (t.getPrep() == 1) {
                    List<Section> classes = t.getSections();
                    for (Section c : classes) {
                        if (c.getPeriod_num() == t.getPrep()) {
                            String l = Integer.toString(c.getPeriod_num());
                            teacherIssueRepository.insert(new TeacherIssue(null, "Prep Period at class time", c.getSection_num(), t.getName(), c.getClassName(), c.getId(), c.getPeriod_num(), c.getClassRoom(), t.getDepartment(), t.getId()));
                        }
                    }
                }

                //teacher has more students than max allotted
            if(t.getCurrentNumStudent() == t.getMaxNumStudent()){
                teacherIssueRepository.insert(new TeacherIssue(null, "Max # Students Reached", 0, t.getName(), null, null, 0, null, t.getDepartment(), t.getId()));
//                errors.add("Max # Students Reached: " +
//                        "   Name: " + t.getName()
//                        +"  ,Department: " + t.getDepartment());
            }

            //teacher has no prep period
            if(t.getPrep() == -1){
                teacherIssueRepository.insert(new TeacherIssue(null, "No Prep Period", 0, t.getName(), null, null, 0, null, t.getDepartment(), t.getId()));
//                errors.add("No Prep Period: " +
//                        "   Name: " + t.getName()
//                        +"  ,Department: " + t.getDepartment());
            }
            }
            catch (Exception e){
                return teacherIssueRepository.findAll();
            }

        }
        return teacherIssueRepository.findAll();
    }


    @CrossOrigin("*")
    @GetMapping("roomErrors")
    public List<Room> roomErrors(){
         List<Section> sections = sectionRepository.findAll();
         List<Section> sections2 = sectionRepository.findAll();
         List<String> errors = new ArrayList<>();

        roomRepository.deleteAll();
        for(Section c: sections){
            try{
                for(Section a: sections2){
                    if(c.getClassRoom().equals(a.getClassRoom()) && c.getPeriod_num() == a.getPeriod_num()){
                        //same room was issue for two classes in the same period
                        if(c.getId() == a.getId()){
                            roomRepository.insert(new Room("Same Room Number",
                                    c.getId(), c.getSection_num(), c.getClassName(), c.getPeriod_num(), c.getClassRoom(),
                                    a.getId(),a.getSection_num(), a.getClassName(), a.getPeriod_num(), a.getClassRoom() ));

//                            errors.add("Same room number: " + " Section number: " + c.getSection_num()
//                                    + " Period: " + c.getPeriod_num()  + "Room: " +c.getClassRoom() + " Section number: "  + a.getSection_num()
//                                    + " Period: " + a.getPeriod_num() + "Room: " +a.getClassRoom());
                        }

                    }
                }
            }

            catch (Exception e){
                return roomRepository.findAll();
            }
        }

        return roomRepository.findAll();

    }



}
