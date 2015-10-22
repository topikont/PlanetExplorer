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
	
	@Test
	public void testExecuteCommandExplorerLandingAtPosition0_0_N() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("");
		
		assertEquals("0,0,N", position);
	}
	
	@Test
	public void testExecuteCommandMoveExplorerForward1CellFromStartTo1_0_N() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("f");
		
		assertEquals("1,0,N", position);
	}
	
	@Test
	public void testExecuteCommandTurnExplorerRightFromStartTo0_0_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("r");
		
		assertEquals("0,0,E", position);
	}
	
	@Test
	public void testExecuteCommandTurnExplorerRightAndMove1CellForwardTo0_1_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		explorer.executeCommand("r");
		String position = explorer.executeCommand("f");
		
		assertEquals("0,1,E", position);
	}
}
