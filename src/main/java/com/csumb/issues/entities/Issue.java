package com.csumb.issues.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Issue {

    @Id
    private String id;
    private String issueType;
    private int section_num;
    private String name;
    private int period_num;
    private String classRoom;

    public Issue(){ }

    public Issue(String issueType, int section_num, String name, int period_num, String classRoom ){
        this.issueType = issueType;
        this.section_num = section_num;
        this.name = name;
        this.period_num = period_num;
        this.classRoom = classRoom;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return section_num == issue.section_num &&
                period_num == issue.period_num &&
                Objects.equals(id, issue.id) &&
                Objects.equals(issueType, issue.issueType) &&
                Objects.equals(name, issue.name) &&
                Objects.equals(classRoom, issue.classRoom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, issueType, section_num, name, period_num, classRoom);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", issueType='" + issueType + '\'' +
                ", section_num=" + section_num +
                ", name='" + name + '\'' +
                ", period_num=" + period_num +
                '}';
    }

}
