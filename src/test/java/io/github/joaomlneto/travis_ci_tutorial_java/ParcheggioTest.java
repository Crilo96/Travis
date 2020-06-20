package io.github.joaomlneto.travis_ci_tutorial_java;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class ParcheggioTest {
	
	@Test
	public void testMCDC() {
	
		//Creo l'oggetto e controllo che non sia nullo
		Parcheggio p = new Parcheggio();
		assertNotNull(p);
		
		//Riempiamo il parcheggio 2 e poi proviamo 0
		assertTrue(p.scegliPosto(2));
		assertFalse(p.scegliPosto(0));
		//Poi libera posto 2
		assertTrue(p.scegliPosto(2));
		
		//Riempiamo il parcheggio 2 e poi proviamo 1
		assertTrue(p.scegliPosto(2));
		assertFalse(p.scegliPosto(1));
		//Poi libera posto 2
		assertTrue(p.scegliPosto(2));
		
		//Controllo che il garage non sia pieno
		assertFalse(p.pieno());
		
		//Controllo le altre situazioni in cui il garage non è pieno
		assertTrue(p.scegliPosto(0));
		assertFalse(p.pieno());
		assertTrue(p.scegliPosto(1));
		assertFalse(p.pieno());
		
		//Libero il garage
		assertTrue(p.scegliPosto(1));
		assertTrue(p.scegliPosto(0));
		
		//Scelgo un posto che non esiste
		assertFalse(p.scegliPosto(3));
		assertFalse(p.scegliPosto(-1));
		
		//Lo riempo male con un auto nel posto 2 e il resto vuoto, poi libero
		assertTrue(p.scegliPosto(2));
		assertTrue(p.malRiempito());
		assertTrue(p.scegliPosto(2));
		
		//Lo riempo male con un auto nel posto 1 e posto 0 vuoto, poi libero
		assertTrue(p.scegliPosto(1));
		assertTrue(p.malRiempito());
		assertTrue(p.scegliPosto(1));
		
		//Riempo il parcheggio controllando di non creare nel mentre situazioni di mal riempito
		assertTrue(p.scegliPosto(0));
		assertFalse(p.malRiempito());
		
		assertTrue(p.scegliPosto(1));
		assertFalse(p.malRiempito());
		
		//Provo a modificare il posto 0
		assertFalse(p.scegliPosto(0));
		
		//Stampo lo stato intermedio del garage
		assertEquals(p.toString(), "**O");
		
		assertTrue(p.scegliPosto(2));
		assertFalse(p.malRiempito());
		
		//Controllo che il parcheggio sia pieno
		assertTrue(p.pieno());
	
	}

}
