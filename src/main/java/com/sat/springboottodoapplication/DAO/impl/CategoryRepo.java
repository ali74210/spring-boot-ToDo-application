package com.sat.springboottodoapplication.DAO.impl;

import com.sat.springboottodoapplication.DAO.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
