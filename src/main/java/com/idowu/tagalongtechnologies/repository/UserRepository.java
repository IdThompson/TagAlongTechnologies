package com.idowu.tagalongtechnologies.repository;

import com.idowu.tagalongtechnologies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users u where u.email= ?1 and u.password = ?2",
            nativeQuery = true)
    Optional<User> findByEmailAndPassword(String email, String password);
}
