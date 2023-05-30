package com.example.SpringAppTestJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.SpringAppTestJunit.model.User;

class UserTest {
	
	User u;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("beforeAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		u = new User("Antonio", "Bianchi", "a.bianchi@example.com", "querty");
		System.out.println("beforeTest");
	}

	@Test
	void testGetEmail() {
		//User u = new User("Antonio", "Bianchi", "a.bianchi@example.com", "querty");
		assertEquals("a.bianchi@example.com", u.getEmail());
		System.out.println("testEmail");
	}

	@Test
	void testGetPassword() {
		//User u = new User("Antonio", "Bianchi", "a.bianchi@example.com", "querty");
		assertTrue(u.getPassword().length() > 5);
		System.out.println("testPassword");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		u = null;
		System.out.println("afterTest");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("afterAll");
	}
	

}
