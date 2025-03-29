package com.devpablo.workshopmongo.repository;

import com.devpablo.workshopmongo.domain.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
