package com.csumb.issues.repositotries;

import com.csumb.issues.entities.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository  extends MongoRepository<Section,String> {

}
