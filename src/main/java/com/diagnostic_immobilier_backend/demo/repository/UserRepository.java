package com.diagnostic_immobilier_backend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.diagnostic_immobilier_backend.demo.usermodel.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Derived query method
    User findByEmail(String email);

    // Alternatively, using @Query annotation
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User getUserByEmail(String email);
}
