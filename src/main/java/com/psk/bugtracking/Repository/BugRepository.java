package com.psk.bugtracking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psk.bugtracking.entity.Bug;
import com.psk.bugtracking.entity.User;

public interface BugRepository extends JpaRepository<Bug, Long> {

	List<Bug> findByUser(User user);

}
