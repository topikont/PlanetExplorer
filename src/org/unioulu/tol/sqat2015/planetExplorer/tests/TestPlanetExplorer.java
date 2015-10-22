package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testCreatePlanetReturnPlanetSize100x100() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String grid = explorer.getPlanetGridSize();
		
		assertEquals("100x100", grid);
	}
	
}
