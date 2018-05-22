package com.activemeasure.note.repository;

import com.activemeasure.note.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
