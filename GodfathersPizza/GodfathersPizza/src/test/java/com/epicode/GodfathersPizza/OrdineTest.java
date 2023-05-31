package com.epicode.GodfathersPizza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epicode.GodfathersPizza.model.Tavolo;
import com.epicode.GodfathersPizza.model.DrinkLemonade;
import com.epicode.GodfathersPizza.model.DrinkWater;
import com.epicode.GodfathersPizza.model.Ordine;
import com.epicode.GodfathersPizza.model.PizzaMargherita;
import com.epicode.GodfathersPizza.model.PizzaSalami;

class OrdineTest {
	
	Tavolo t;
	Ordine o;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("--- Test Ordine ---");
	}

	@BeforeEach
	void setUp() throws Exception {
		t = new Tavolo(1, 4);
		o = new Ordine(1, t, 5, 0.5);
		o.getOrdinato().add(new PizzaMargherita());
		o.getOrdinato().add(new PizzaSalami());
		o.getOrdinato().add(new DrinkLemonade());
		o.getOrdinato().add(new DrinkWater());
	}

	@Test
	void testOrdine() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotale() {
		assertEquals(15.059999999999999, o.getTotale());
		System.out.println("testGetTotale");
	}

	@Test
	void testGetNumeroOrdine() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNewTavolo() {
		t = new Tavolo(1, 4);
		assertFalse( t.isOccupato());
		System.out.println("testGetNewTavolo: " + t.isOccupato());
	}
	
	@Test
	void testGetTavoloOrdine() {
		assertTrue(t.isOccupato());
		System.out.println("testGetTavoloOrdine: " + t.isOccupato());
	}

	@Test
	void testGetStato() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNumeroCoperti() {
		//o.setNumeroCoperti(5);
		assertTrue(t.getNumeroCoperti() >= o.getNumeroCoperti());
		System.out.println("testGetNumeroCoperti: " );
	}
	
	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("--- Fine Test Ordine ---");
	}

}
