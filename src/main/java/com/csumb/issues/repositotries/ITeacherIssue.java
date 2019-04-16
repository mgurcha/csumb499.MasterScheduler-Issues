package com.csumb.issues.repositotries;

import com.csumb.issues.entities.TeacherIssue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITeacherIssue extends MongoRepository<TeacherIssue,String> {
}
