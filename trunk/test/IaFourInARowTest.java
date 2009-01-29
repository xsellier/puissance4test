package test;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

import src.*;

public class IaFourInARowTest {

	private int mode1;
	private int mode2;
	private DataStructure grid;
	private DataStructure gridNull;
	private IaFourInARow Ia1;
	private IaFourInARow Ia2;
	private IaFourInARow Ia3;
	private IaFourInARow Ia4;
	private Rules rule;
	private int HGrid;
	private int WGrid;
	private int HGridNull;
	private int WGridNull;
	private int HIa1;
	private int HIa2;
	private int HIa3;
	private int WIa1;
	private int WIa3;
	private int modeAi1;
	private int modeAi2;
	private DataStructure gridAi1;
	private int HGridAi1;
	private int WGridAi1;
	private DataStructure gridAi3;

	
	
	@Before
	public void setUp() throws Exception {
		DataStructure grid = new DataStructure(6,7);
		DataStructure gridNull = new DataStructure(0,0);
		
		Rules rule = new FourInARow();
		
		IaFourInARow Ia1 = new IaFourInARow();
		IaFourInARow Ia2 = new IaFourInARow();
		IaFourInARow Ia3 = new IaFourInARow();
		IaFourInARow Ia4 = new IaFourInARow();
		
		mode1 = 1; // easy mode
		mode2 = 2; // hard mode
		
		Ia1.initialize(grid, mode1);
		Ia2.initialize(grid, mode2);
		Ia3.initialize(grid , mode2);
		
		
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
		
		gridAi1 = Ia1.getCpuGrid();
		HGridAi1 = gridAi1.getHeight();
		WGridAi1 = gridAi1.getWidth();
		
	}
	

	

	
	@Test
	public void testGetPlayable() {
		System.out.println("");
	}
	
	@Test
	public void testGetCpuGrid(){
		assertNotNull(gridAi1);
		assertEquals( HGridAi1, HGrid);
		assertEquals( WGridAi1, WGrid);
		
	}

	@Test
	public void testGetHeight() {
		int plop = Ia1.getHeight();
		//assertNotNull( plop);
		//assertNotNull( HIa2);
		//assertNotNull( HIa3);
		//assertEquals(HGrid , HIa1);
		//assertEquals(HGrid , HIa2);
		//assertEquals(HGridNull , HIa3);
		assertEquals(0,plop);
		
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
		Ia4.initialize(grid, mode1);
		int result = Ia4.getHeight();
		System.out.println("");
		
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
