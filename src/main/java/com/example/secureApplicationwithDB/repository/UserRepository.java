package com.example.secureApplicationwithDB.repository;

import com.example.secureApplicationwithDB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User , Integer> {

    User findByUsername(String user);

}
