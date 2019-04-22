package com.csumb.issues.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class StudentIssue {
    @Id
    private String issueType;
    private String id;
    private String name;
    private int grade;
    private List<String> schedule;

    public StudentIssue(){ }

    public StudentIssue(String issueType, String id, String name, int grade, List<String> schedule) {
        this.issueType = issueType;
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.schedule = schedule;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentIssue that = (StudentIssue) o;
        return grade == that.grade &&
                Objects.equals(issueType, that.issueType) &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(schedule, that.schedule);
    }

    @Override
    public int hashCode() {

        return Objects.hash(issueType, id, name, grade, schedule);
    }
}
