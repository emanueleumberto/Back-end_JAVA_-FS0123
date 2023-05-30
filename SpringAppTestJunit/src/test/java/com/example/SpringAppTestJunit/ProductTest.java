package com.example.SpringAppTestJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.SpringAppTestJunit.model.Product;

class ProductTest {
	
	Product p;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		p = new Product("Apple", "Iphone", 999);
	}
	
	@Test
	void testGetPrezzo() {
		assertTrue(p.getPrezzo()> 599);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
