package com.example.caveatemptorv2.repository;

import com.example.caveatemptorv2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM User WHERE user_name = ?1", nativeQuery = true)
    User getUserByUserName(String username);
}
