package com.psk.bugtracking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psk.bugtracking.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
