package com.naim.Countrys.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.naim.Countrys.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}