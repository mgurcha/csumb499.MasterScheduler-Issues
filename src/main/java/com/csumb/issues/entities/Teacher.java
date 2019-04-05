package com.csumb.issues.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Teacher {

    @Id
    private String id;
    private String name;
    private String department;
    private int prep;
    private String preferred_room;
    private boolean is80Percent;
    private String academy; 
    private int maxNumStudent;
    private int currentNumStudent;
    private List<Section> sections;
    private String className;

    public Teacher( ) {
        this.name = "";
        this.department = "";
        this.prep = 0;
        this.preferred_room = "";
        this.is80Percent = false;
        this.academy = "";
        this.maxNumStudent = 160;
        this.currentNumStudent = 0;
        this.sections = new ArrayList<>();
        this.className = "";
    }

    public Teacher(String id, String name, String department, boolean is80Percent,
                   String academy, int maxNumStudent, String className) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.is80Percent = is80Percent;
        this.academy = academy;
        this.maxNumStudent = maxNumStudent;
        this.currentNumStudent = 0;
        this.className = className;
        this.sections = new ArrayList<>();
    }

    public Teacher(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.maxNumStudent = 160;
        this.currentNumStudent = 0;
        this.sections = new ArrayList<>();
    }

    public Teacher(String id, String name, String department, String className) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.className = className;
        this.maxNumStudent = 160;
        this.currentNumStudent = 0;
        this.sections = new ArrayList<>();
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPrep() {
        return prep;
    }

    public void setPrep(int prep) {
        this.prep = prep;
    }

    public String getPreferred_room() {
        return preferred_room;
    }

    public void setPreferred_room(String preferred_room) {
        this.preferred_room = preferred_room;
    }

    public boolean isIs80Percent() {
        return is80Percent;
    }

    public void setIs80Percent(boolean is80Percent) {
        this.is80Percent = is80Percent;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getMaxNumStudent() {
        return maxNumStudent;
    }

    public void setMaxNumStudent(int maxNumStudent) {
        this.maxNumStudent = maxNumStudent;
    }

    public int getCurrentNumStudent() {
        return currentNumStudent;
    }

    public void setCurrentNumStudent(int currentNumStudent) {
        this.currentNumStudent = currentNumStudent;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addClass(Section section){
        this.sections.add(section);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", prep=" + prep +
                ", preferred_room='" + preferred_room + '\'' +
                ", is80Percent=" + is80Percent +
                ", academy='" + academy + '\'' +
                ", maxNumStudent=" + maxNumStudent +
                ", currentNumStudent=" + currentNumStudent +
                ", sections=" + sections +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return prep == teacher.prep &&
                is80Percent == teacher.is80Percent &&
                maxNumStudent == teacher.maxNumStudent &&
                currentNumStudent == teacher.currentNumStudent &&
                id.equals(teacher.id) &&
                name.equals(teacher.name) &&
                department.equals(teacher.department) &&
                Objects.equals(preferred_room, teacher.preferred_room) &&
                academy.equals(teacher.academy) &&
                Objects.equals(sections, teacher.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, prep, preferred_room, is80Percent, academy, maxNumStudent, currentNumStudent, sections);
    }
}
