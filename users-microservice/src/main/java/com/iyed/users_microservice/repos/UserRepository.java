package com.iyed.users_microservice.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iyed.users_microservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);
		Optional<User> findByEmail(String email);

}
