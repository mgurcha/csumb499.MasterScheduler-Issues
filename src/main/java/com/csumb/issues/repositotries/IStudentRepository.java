package com.csumb.issues.repositotries;

import com.csumb.issues.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends MongoRepository<Student,String> {

}

