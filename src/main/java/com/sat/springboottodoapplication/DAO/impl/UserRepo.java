package com.sat.springboottodoapplication.DAO.impl;

import com.sat.springboottodoapplication.DAO.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
