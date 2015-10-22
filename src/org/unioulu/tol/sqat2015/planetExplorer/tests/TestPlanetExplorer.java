package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

import sun.net.www.content.text.plain;

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
	public void testExecuteCommandMoveExplorerForward1CellFromStartTo0_1_N() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("f");
		
		assertEquals("0,1,N", position);
	}
	
	@Test
	public void testExecuteCommandTurnExplorerRightFromStartTo0_0_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("r");
		
		assertEquals("0,0,E", position);
	}
	
	@Test
	public void testExecuteCommandTurnExplorerRightAndMove1CellForwardTo1_0_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		explorer.executeCommand("r");
		String position = explorer.executeCommand("f");
		
		assertEquals("1,0,E", position);
	}
	
	@Test
	public void testExecuteCommandTurnExplorerRight5TimesTo0_0_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		//explorer.executeCommand("r");
		//explorer.executeCommand("r");
		//explorer.executeCommand("r");
		//explorer.executeCommand("r");
		String position = explorer.executeCommand("rrrrr");
		
		assertEquals("0,0,E", position);
	}
	
	@Test
	public void testExecuteCommand_FFBRFLFFFRF_To2_4_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("ffbrflfffrf");
		
		assertEquals("2,4,E", position);
	}
	
	@Test
	public void testExecuteCommand_BB_FromStartTo0_98_N() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String position = explorer.executeCommand("bb");
		
		assertEquals("0,98,N", position);
	}
	
	@Test
	public void testExecuteCommand_FF_FromStartTo0_1_N_WithEncounteringObstacleAt0_2() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "(0,2)");
		
		String position = explorer.executeCommand("ff");
		
		assertEquals("(0,1,N)(0,2)", position);
	}
}
