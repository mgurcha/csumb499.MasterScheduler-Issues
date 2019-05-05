# csumb499.MasterScheduler-Issues

# MasterScheduler.Issues

## Table of Contents
1. [Overview](#Overview)
2. [Product Spec](#Product-Spec)
3. [Schema](#Schema)
4. [Networking](#Networking)

## Overview
### Description
California State University Capstone Project, Salinas Union High School District Sponsored. Micro service for the Master Scheduler App.
The Master scheduler app is a tool implemented for the Administrative team. This app makes it easier for the admin team to generate the school schedule.

This issues micro services handles all of the request to find the issues with the generated schedule for the student, classes, teachers, and section objects.
Micro service is deployed on Heroku.  https://master-scheduler-issues.herokuapp.com/

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**
  - [X] User can find student errors, teacher errors, class errors, and section errors

## Schema

### Models
#### Student
|Property|Type|Description|
|---|---|---|
|id|String|Id of the student. Database Primary key|
|name|String|Name of student|
|grade|int|Grade of student|
|preferredClasses|List of String|List of classes student wants to take|
|preferred|List of Boolean|Maps to the classes student want to take and determines if a student has priority to take the class|
|academy|String|Student's academy they are part of [none, green, fast]|
|schedule|List of String|Student's schedule that was generated. A list of the class names|
|scheduleId|List of String|Student's schedule that was generated. A list of class Ids that map to class names|

#### Teacher
|Property|Type|Description|
|---|---|---|
|id|String|Id of the teacher. Database primary key|
|name|String|Name of the teacher|
|department|String|Department teacher is apart of|
|prep|int|Teacher's prep period|
|preferre_room|String|Room teacher wants to teach in|
|is80Percent|boolean|If true teacher teaches 5 sections. If false teacher teaches 4 sections.|
|academy|String|Teacher's academy they are part of [none, green, fast]|
|maxNumStudent|int|Maximum number of students the teacher can teach|
|currentNumStudent|int|Number of students teacher currently has|
|sections|List of Section|Teachers schedule|
|className|String|1rst class teacher can teach|
|className2|String|2nd class teacher can teach|
|className3|String|3rd class teacher can teach|

#### Class
|Property|Type|Description|
|---|---|---|
|id|String|Id of the Class. Database primary key|
|className|String|Name of the class|
|maxNumSections|int|Max number of sections that can be created form this class|
|maxNumStudentPerSection|int|Max number of students for each section|
|numStudentRegistered|int|how many students have registed for the class (in progress)|

#### Section extends Class
|Property|Type|Description|
|---|---|---|
|section_num|int|Section number. Section_num gets used with class id to create primary key|
|periodNum|int|Period when section will be held|
|roster|List of Par of string , string|List of student name and id that will take the class|
|teacherID|String|Teache ID who is teaching the class|
|room|String|how many students have registed for the class (in progress)|

#### Issue (Section)
|Property|Type|Description|
|---|---|---|
|id|String|Id of the Section. Database primary key|
|issueType|String|Type of issue|
|section_num|int|Section number|
|name|String|Name of the class|
|period_num|int|Period number|
|classRoom|String|Room where class is held|

#### StudentIssue
|Property|Type|Description|
|---|---|---|
|id|String|Id of the student. Database primary key|
|issueType|String|Type of issue|
|name|String|Name of the student|
|grade|int|Grade student is in|
|schedule|List of String|Student's schedule that was generated. A list of the class names|

#### TeacherIssue
|Property|Type|Description|
|---|---|---|
|id|String|Id of the issue. Database primary key|
|issueType|String|Type of issue|
|section_num|int|Section number|
|name|String|Name of the teacher|
|className|String|Name of the class|
|id|String|Id of the Class|
|period_num|int|Period number|
|classRoom|String|Room where class is held|
|department|String|Department teacher is apart of|
|id|String|Id of the teacher. Database primary key|

#### Room Issue (Class)
|Property|Type|Description|
|---|---|---|
|issueType|String|Type of issue|
|id|String|Id of the first section. Database primary key|
|section_num1|int|Section number of first section|
|name1|String|Name of the first class|
|period_num1|int|Period number|
|classRoom1|String|Room where class is held|
|id2|String|Id of the second section. Database primary key|
|section_num2|int|Section number of second section|
|name2|String|Name of the second class|
|period_num2|int|Period number|
|classRoom2|String|Room where class is held|

## Networking
## List of network requests
### Students
- Get Student Errors
    - (Read/Get) Gets all of the errors associated with studens in the databse
    - Required: NA
    - Response: List of all student errors present
     ``` java
        @CrossOrigin(origins = "*")
        @GetMapping("/studentErrors")
        public List<StudentIssue> studentErrors() {
            return studentIssueRepository.findAll();
        }
    ```

### Teachers
- Get Teacher Errors
    - (Read/Get) Gets all of the teacher errors in the Database
    - Required: NA
    - Response: List of all teacher errors present
     ``` java
        @CrossOrigin(origins = "*")
        @GetMapping("/teacherErrors")
        public List<TeacherIssue> teacherErrors() {
          return teacherIssueRepository.findAll();
        }
    ```

### Classes/Room
- Get Classe/Room errors
    - (Read/Get) Gets all of the errors associated with Class in the Database
    - Required: NA
    - Response: List of all class errors present
     ``` java
        @CrossOrigin(origins = "*")
        @GetMapping("/roomErrors")
        public List<Room> roomErrors()
          //implementation
          return roomRepository.findAll();
        }
    ```

### Sections
- Get Section Errors
    - (Read/Get) Gets all of the errors associated with Section in the Database
    - Required: NA
    - Response: List of all section errors present
     ``` java
        @CrossOrigin(origins = "*")
        @GetMapping("/sectionErrors")
        public List<Issue> sectionErrors()){
          //implementation
          return issueRepository.findAll();
        }
    ```
