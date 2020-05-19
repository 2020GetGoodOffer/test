package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
