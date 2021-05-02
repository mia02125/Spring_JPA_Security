package com.security.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByUserId(String userId);
    Boolean existsUserByUserIdAndUserPassword(String userId, String userPassword);
}
