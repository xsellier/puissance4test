package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.*;

public class IaFourInARowTest {

	public int mode1;
	public int mode2;
	public DataStructure grid;
	public DataStructure gridNull;
	public Cpu Ia1;
	public Cpu Ia2;
	public Cpu Ia3;
	public Cpu Ia4;
	public Rules rule;
	public int HIa1;
	
	
	
	@Before
	public void setUp() throws Exception {
		DataStructure grid = new DataStructure(6,7);
		DataStructure gridNull = new DataStructure(0,0);
		
		Rules rule = new FourInARow();
		
		Cpu Ia1 = new IaFourInARow();
		Cpu Ia2 = new IaFourInARow();
		Cpu Ia3 = new IaFourInARow();
		Cpu Ia4 = new IaFourInARow();
		
		mode1 = 1; // easy mode
		mode2 = 2; // hard mode
		
		Ia1.initialize(grid, mode1);
		Ia2.initialize(grid, mode2);
		Ia3.initialize(grid , mode2);
		HIa1 = Ia1.getHeight();
		
		
		
	}
	

	

	
	@Test
	public void testGetPlayable() {
		System.out.println("");
	}

	@Test
	public void testGetHeight() {
		
		assertEquals(6 , HIa1 );
	}

	
	@Test
	public void testGetWidth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMode() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlayable() {
		fail("Not yet implemented");
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