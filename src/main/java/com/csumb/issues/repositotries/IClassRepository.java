package com.csumb.issues.repositotries;

import com.csumb.issues.entities.Class;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClassRepository extends MongoRepository<Class,String> {

    @Override
    Optional<Class> findById(String s);
}
