package com.codingdojo.habits.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.habits.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	// this method retrieves all the books from the database
    Optional <User> findByEmail(String email);
}