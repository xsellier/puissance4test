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
	public int HGrid;
	public int WGrid;
	public int HGridNull;
	public int WGridNull;
	public int HIa1;
	public int HIa2;
	public int HIa3;
	public int WIa1;
	public int WIa3;
	public int modeAi1;
	public int modeAi2;

	
	
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
		Ia4.initialize(grid, mode1);
		
		HGrid = grid.getHeight();
		WGrid = grid.getWidth();
		
		HGridNull = gridNull.getHeight();
		WGridNull = gridNull.getWidth();
		
		HIa1 = Ia1.getHeight();
		HIa2 = Ia2.getHeight();
		HIa3 = Ia3.getHeight();
		
		WIa1 = Ia1.getWidth();
		WIa3 = Ia3.getWidth();
		
		modeAi1 = Ia1.getMode();
		modeAi2 = Ia2.getMode();
		
	}
	

	

	
	@Test
	public void testGetPlayable() {
		System.out.println("");
	}

	@Test
	public void testGetHeight() {
		assertNotNull( HIa1);
		assertNotNull( HIa2);
		assertNotNull( HIa3);
		assertEquals(HGrid , HIa1);
		assertEquals(HGrid , HIa2);
		assertEquals(HGridNull , HIa3);
		
	}

	
	@Test
	public void testGetWidth() {
		assertNotNull( WIa1);
		assertNotNull( WIa3);
		assertEquals( WGrid ,WIa1);
		assertEquals( WGridNull, WIa3);
	}

	@Test
	public void testGetMode() {
		assertNotNull( modeAi1);
		assertNotNull( modeAi2);
		assertEquals( 1 , modeAi1);
		assertEquals( 2 , modeAi2);
	}

	@Test
	public void testSetPlayable() {
		System.out.println("");
	}

	@Test
	public void testInitialize() {
		assertNotNull( Ia1);
		
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
