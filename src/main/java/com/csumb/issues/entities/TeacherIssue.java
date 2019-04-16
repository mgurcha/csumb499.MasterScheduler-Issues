package com.csumb.issues.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class TeacherIssue {

    @Id
    private String id;
    private String issueType;
    private int section_num;
    private String name;
    private String className;
    private String classId;
    private int period_num;
    private String classRoom;
    private String department;
    private String teacherId;

    public TeacherIssue(){ }

    public TeacherIssue(String id, String issueType, int section_num, String name, String className, String classId, int period_num, String classRoom, String department, String teacherId) {
        this.id = id;
        this.issueType = issueType;
        this.section_num = section_num;
        this.name = name;
        this.className = className;
        this.classId = classId;
        this.period_num = period_num;
        this.classRoom = classRoom;
        this.department = department;
        this.teacherId = teacherId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public int getSection_num() {
        return section_num;
    }

    public void setSection_num(int section_num) {
        this.section_num = section_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public int getPeriod_num() {
        return period_num;
    }

    public void setPeriod_num(int period_num) {
        this.period_num = period_num;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherIssue that = (TeacherIssue) o;
        return section_num == that.section_num &&
                period_num == that.period_num &&
                Objects.equals(id, that.id) &&
                Objects.equals(issueType, that.issueType) &&
                Objects.equals(name, that.name) &&
                Objects.equals(className, that.className) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(classRoom, that.classRoom) &&
                Objects.equals(department, that.department) &&
                Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, issueType, section_num, name, className, classId, period_num, classRoom, department, teacherId);
    }
}
