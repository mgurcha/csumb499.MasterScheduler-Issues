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
            //student without 6 classes; can use !=
            if(s.getSchedule().size()<6) {
                errors.add("Does not have 6 classes: " + s.getId());
            }
        }
        return errors;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("sectionErrors")
    public List<Issue> sectionErrors(){
        List<Section> sections = sectionRepository.findAll();
        List<String> errors = new ArrayList<>();
//        for(Section s: sections){
//            //section has no teacher
//            try {
//                if (s.getTeacherID().equals("")) {
//                    issueRepository.insert(new Issue(s.getId(), "No Teacher", s.getSection_num(), s.getClassName(), s.getPeriod_num(), s.getClassRoom()));
//                    //                errors.add("No Teacher: " +
//                    //                        "   Class Name = " + s.getClassName()
//                    //                        +", Period = " + s.getPeriod_num()
//                    //                        +", ID: " + s.getId());
//                    //            }
//
//                }
//            }
//            catch (Exception e){
//                return issueRepository.findAll();
//            }
////            Set<String> store = new HashSet<>();
////            String classes = s.getClassRoom();
////            errors.add(classes);
////            int count = Collections.frequency(sections, "432");
////            errors.add("Count = " + count);
//        }
        issueRepository.deleteAll();

        return issueRepository.findAll();
    }



//    @CrossOrigin(origins = "*")
//    @GetMapping("teacherIssues")
//    public List<String> teacherErrors(){
//        List<Teacher> teachers = teacherRepository.findAll();
//        List<String> errors = new ArrayList<>();
//        for(Teacher t: teachers){
//            //Prep period at same time as a class
//            if(t.getPrep() == 1){
//               List<Section> classes = t.getSections();
//               for (Section c: classes){
//                   if(c.getPeriod_num() == t.getPrep()){
//                       String l = Integer.toString(c.getPeriod_num());
//                       errors.add("Cannot have class at same time as prep - ID: " + t.getId() +
//                               ", Name: "+ t.getName() +
//                                       ", Prep Period: "+ Integer.toString(c.getPeriod_num())
//                                + ", Class ID: " + c.getId() +
//                       ", Section Num: " + c.getSection_num() );
//                   }
//               }
//            }
//            //teacher has more students than max allotted
//            if(t.getCurrentNumStudent() == t.getMaxNumStudent()){
//                errors.add("Max # Students Reached: " +
//                        "   Name: " + t.getName()
//                        +"  ,Department: " + t.getDepartment());
//            }
//
//            if(t.getPrep() == -1){
//                //teacher has no prep period
//                errors.add("No Prep Period: " +
//                        "   Name: " + t.getName()
//                        +"  ,Department: " + t.getDepartment());
//            }
//        }
//        return errors;
//    }



    @CrossOrigin(origins = "*")
    @GetMapping("teacherErrors")
    public List<TeacherIssue> teacherErrors(){
        List<Teacher> teachers = teacherRepository.findAll();
        List<String> errors = new ArrayList<>();
        for(Teacher t: teachers) {
            try {
                //Prep period at same time as a class
                if (t.getPrep() == 1) {
                    List<Section> classes = t.getSections();
                    for (Section c : classes) {
                        if (c.getPeriod_num() == t.getPrep()) {
                            String l = Integer.toString(c.getPeriod_num());
                            teacherIssueRepository.insert(new TeacherIssue(t.getId(), "Prep Period at class time", c.getSection_num(), t.getName(), c.getClassName(), c.getId(), c.getPeriod_num(), c.getClassRoom(), t.getDepartment(), null));
                        }
                    }
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
    public List<String> roomErrors(){
         List<Section> sections = sectionRepository.findAll();
         List<Section> sections2 = sectionRepository.findAll();
         List<String> errors = new ArrayList<>();


         for(Section c: sections){
             for(Section a: sections2){
                 if(c.getClassRoom().equals(a.getClassRoom()) && c.getPeriod_num() == a.getPeriod_num()){
                     //same room was issue for two classes in the same period
                     if(c.getId() == a.getId()){
                         errors.add("Same room number: " + " Section number: " + c.getSection_num()
                                 + " Period: " + c.getPeriod_num()  + "Room: " +c.getClassRoom() + " Section number: "  + a.getSection_num()
                                 + " Period: " + a.getPeriod_num() + "Room: " +a.getClassRoom());
                     }

                 }
             }

        }

        return errors;
    }

}
