package com.storage.implementation.storage1.repository;

import com.storage.implementation.storage1.model.UserBD;
import org.springframework.data.repository.CrudRepository;

public abstract class UserRepository implements CrudRepository<UserBD, Long> {


}
