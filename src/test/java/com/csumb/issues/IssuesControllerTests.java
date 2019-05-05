package com.csumb.issues;

import com.csumb.issues.entities.Student;
import com.csumb.issues.entities.StudentIssue;
import com.csumb.issues.entities.Room;
import com.csumb.issues.entities.Issue;
import com.csumb.issues.entities.Class;
import com.csumb.issues.entities.Section;
import com.csumb.issues.entities.Teacher;
import com.csumb.issues.entities.TeacherIssue;

import com.csumb.issues.repositotries.IClassRepository;
import com.csumb.issues.repositotries.IIssueRepository;
import com.csumb.issues.repositotries.IRoomRepository;
import com.csumb.issues.repositotries.IStudentIssueRepository;
import com.csumb.issues.repositotries.ISectionRepository;
import com.csumb.issues.repositotries.IStudentRepository;
import com.csumb.issues.repositotries.ITeacherIssue;
import com.csumb.issues.repositotries.ITeacherRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssuesControllerTests {
    @Autowired
    private IssuesController issuesController;

    @MockBean
    private IStudentRepository studentRepository;

    @MockBean
    private IClassRepository classRepository;

    @MockBean
    private ITeacherRepository teacherRepository;

    @MockBean
    private ISectionRepository sectionRepository;

    @MockBean
    private IIssueRepository issueRepository;

    @MockBean
    private ITeacherIssue teacherIssueRepository;

    @MockBean
    private IRoomRepository roomRepository;

    @MockBean
    private IStudentIssueRepository studentIssueRepository;

    @Test
    public void studentErrors(){
        List<Student> students = new ArrayList<>(Arrays.asList(new Student("123", "Test", 10),
                new Student("100", "Test2", 11)));
        when(studentRepository.findAll()).thenReturn(students);

        StudentIssue studentIssue = new StudentIssue("Does not have 6 classes", students.get(0).getId(), students.get(0).getName(), students.get(0).getGrade(), students.get(0).getSchedule());
        when(studentIssueRepository.insert(studentIssue)).thenReturn(studentIssue);

        StudentIssue studentIssue2 = new StudentIssue("Does not have 6 classes", students.get(1).getId(), students.get(1).getName(), students.get(1).getGrade(), students.get(1).getSchedule());
        when(studentIssueRepository.insert(studentIssue2)).thenReturn(studentIssue2);

        List<StudentIssue> studentIssues = new ArrayList<>(Arrays.asList(studentIssue, studentIssue2));
        when(studentIssueRepository.findAll()).thenReturn(studentIssues);

        Assert.assertEquals(studentIssues,issuesController.studentErrors());

    }



}
