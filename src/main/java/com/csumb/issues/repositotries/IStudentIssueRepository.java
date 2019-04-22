package com.csumb.issues.repositotries;

import com.csumb.issues.entities.StudentIssue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentIssueRepository extends MongoRepository<StudentIssue,String> {

}
