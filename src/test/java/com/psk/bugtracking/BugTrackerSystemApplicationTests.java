package com.psk.bugtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psk.bugtracking.Service.BugService;
import com.psk.bugtracking.Service.UserService;
import com.psk.bugtracking.entity.Bug;
import com.psk.bugtracking.entity.User;

@SpringBootTest
class BugTrackerSystemApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BugService bugService;
	
	@Before
	public void initDb() {
		{
			User newUser = new User("testuser@bts.com","user","user@123");
			userService.createUser(newUser);
		}
		{
			User newAdmin = new User("testadmin@bts.com","user","admin@123");
			userService.createUser(newAdmin);
		}
		
		Bug userBug = new Bug("Test_Bug","This is a test Bug");
		User user = userService.findByEmail("testuser@bts.com");
		bugService.addBug(userBug, user);
	}
	
	@Test
	public void testUser() {
		User user = userService.findByEmail("testuser@bts.com");
		assertNotNull(user);
		User admin = userService.findByEmail("testadmin@bts.com");
		assertEquals(admin.getEmail(),"testadmin@bts.com");
		
	}
	
	@Test
	public void testBug() {
		User user = userService.findByEmail("testuser@bts");
		List<Bug> bug = bugService.findUserBug(user);
		assertNotNull(bug);
	}
}
