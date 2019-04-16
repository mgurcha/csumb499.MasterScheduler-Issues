package com.csumb.issues.repositotries;

import com.csumb.issues.entities.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IIssueRepository extends MongoRepository<Issue,String> {

}
