package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.*;

public class IaFourInARowTest {

	int mode;
	DataStructure grid;
	Rules rule;
	Cpu Ia;
	
	@Before
	public void setUp() throws Exception {

		grid = new DataStructure(6,7);
		rule = new FourInARow();
		Ia = new IaFourInARow();
		mode = 1; // easy mode
		mode = 2; // hard mode
		Ia.initialize(grid, mode);
}
	@Test
	public void testInitialize() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testEasyCpu() {
		fail("Not yet implemented");
	}

	@Test
	public void testPerfectCpu() {
		fail("Not yet implemented");
	}

}
