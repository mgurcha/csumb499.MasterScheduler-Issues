package com.csumb.issues.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Room {

    @Id
    private String id;
    private String issueType;
    private int section_num1;
    private String name1;
    private int period_num1;
    private String classRoom1;

    private int section_num2;
    private String name2;
    private int period_num2;
    private String classRoom2;

    public Room(){ }

    public Room(String id, String issueType, int section_num1, String name1, int period_num1, String classRoom1, int section_num2, String name2, int period_num2, String classRoom2) {
        this.id = id;
        this.issueType = issueType;
        this.section_num1 = section_num1;
        this.name1 = name1;
        this.period_num1 = period_num1;
        this.classRoom1 = classRoom1;
        this.section_num2 = section_num2;
        this.name2 = name2;
        this.period_num2 = period_num2;
        this.classRoom2 = classRoom2;
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

    public int getSection_num1() {
        return section_num1;
    }

    public void setSection_num1(int section_num1) {
        this.section_num1 = section_num1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getPeriod_num1() {
        return period_num1;
    }

    public void setPeriod_num1(int period_num1) {
        this.period_num1 = period_num1;
    }

    public String getClassRoom1() {
        return classRoom1;
    }

    public void setClassRoom1(String classRoom1) {
        this.classRoom1 = classRoom1;
    }

    public int getSection_num2() {
        return section_num2;
    }

    public void setSection_num2(int section_num2) {
        this.section_num2 = section_num2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getPeriod_num2() {
        return period_num2;
    }

    public void setPeriod_num2(int period_num2) {
        this.period_num2 = period_num2;
    }

    public String getClassRoom2() {
        return classRoom2;
    }

    public void setClassRoom2(String classRoom2) {
        this.classRoom2 = classRoom2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return section_num1 == room.section_num1 &&
                period_num1 == room.period_num1 &&
                section_num2 == room.section_num2 &&
                period_num2 == room.period_num2 &&
                Objects.equals(id, room.id) &&
                Objects.equals(issueType, room.issueType) &&
                Objects.equals(name1, room.name1) &&
                Objects.equals(classRoom1, room.classRoom1) &&
                Objects.equals(name2, room.name2) &&
                Objects.equals(classRoom2, room.classRoom2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, issueType, section_num1, name1, period_num1, classRoom1, section_num2, name2, period_num2, classRoom2);
    }
}
