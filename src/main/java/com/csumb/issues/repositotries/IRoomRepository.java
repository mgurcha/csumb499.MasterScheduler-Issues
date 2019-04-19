package com.csumb.issues.repositotries;

import com.csumb.issues.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRoomRepository extends MongoRepository<Room,String> {
}
