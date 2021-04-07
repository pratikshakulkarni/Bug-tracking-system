package com.psk.bugtracking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psk.bugtracking.Repository.BugRepository;
import com.psk.bugtracking.entity.Bug;
import com.psk.bugtracking.entity.User;

@Service
public class BugService {

	@Autowired
	private BugRepository bugRepository;
	
	public void addBug(Bug bug, User user) {
		bug.setUser(user);
		bugRepository.save(bug);
	}
	
	public List<Bug> findUserBug(User user){
		return bugRepository.findByUser(user);
	}
}
