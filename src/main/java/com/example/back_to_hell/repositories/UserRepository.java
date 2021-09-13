package com.example.back_to_hell.repositories;

import com.example.back_to_hell.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
