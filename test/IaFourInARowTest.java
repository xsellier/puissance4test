package test;

//import static org.junit.Assert.*;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import src.*;

public class IaFourInARowTest extends TestCase {

	private int mode1;
	private int mode2;
	
	private DataStructure grid;
	private DataStructure gridNull;
	private DataStructure bigGrid;
	
	private IaFourInARow Ia1;
	private IaFourInARow Ia2;
	private IaFourInARow Ia3;
	private IaFourInARow Ia4;
	private IaFourInARow Ia5;
	private IaFourInARow Ia6;

	private Rules rule;


	
	
	@Before
	public void setUp() throws Exception {
		grid = new DataStructure(6,7);
	    gridNull = new DataStructure(0,0);
	    bigGrid = new DataStructure(100,100);
		
		rule = new FourInARow();
		
		Ia1 = new IaFourInARow();
		Ia2 = new IaFourInARow();
		Ia3 = new IaFourInARow();
		Ia4 = new IaFourInARow();
		Ia5 = new IaFourInARow();
		Ia6 = new IaFourInARow();
		
		mode1 = 1; // easy mode
		mode2 = 2; // hard mode
		
		Ia1.initialize(grid, mode1);
		Ia2.initialize(grid, mode2);
		Ia3.initialize(gridNull , mode1);
		Ia4.initialize(gridNull , mode2);
		Ia5.initialize(bigGrid, mode1);
		Ia6.initialize(bigGrid, mode2 );
		

		
	}
	

	

	
	@Test
	public void testGetPlayable() {
		System.out.println("");
	}
	
	@Test
	public void testGetCpuGrid(){
		assertNotNull(Ia1.getCpuGrid());
		assertEquals( grid.getHeight(), Ia1.getHeight());
		assertEquals( grid.getWidth(), Ia1.getWidth());
		assertSame( grid , Ia1.getCpuGrid());
		
	}

	@Test
	public void testGetHeight() {
		assertNotNull( Ia1.getHeight());
		assertNotNull( Ia2.getHeight());
		assertNotNull( Ia3.getHeight());
		assertNotNull( Ia5.getHeight());
		assertEquals(grid.getHeight() , Ia1.getHeight());
		assertEquals(grid.getHeight() , Ia2.getHeight());
		assertEquals(gridNull.getHeight() , Ia3.getHeight());
		assertEquals(bigGrid.getHeight() , Ia5.getHeight());
	}

	
	@Test
	public void testGetWidth() {
		assertNotNull( Ia1.getWidth());
		assertNotNull( Ia3.getWidth());
		assertNotNull( Ia6.getWidth());
		assertEquals( grid.getWidth(),Ia1.getWidth());
		assertEquals( gridNull.getWidth(), Ia3.getWidth());
		assertEquals( bigGrid.getWidth(), Ia6.getWidth());
	}

	@Test
	public void testGetMode() {
		assertNotNull( Ia1.getMode());
		assertNotNull( Ia2.getMode());
		assertEquals( 1 , Ia1.getMode());
		assertEquals( 2 , Ia2.getMode());
	}

	@Test
	public void testSetPlayable() {
		System.out.println("plop"+ gridNull.getHeight() +" plus "+ gridNull.getWidth());
	}

	@Test
	public void testInitialize() {
		assertNotNull( Ia1.getCpuGrid());
		assertNotNull( Ia1.getWidth());
		assertNotNull( Ia1.getHeight());
		assertNotNull( Ia1.getMode());
		assertSame( Ia1.getCpuGrid(), grid );
		assertEquals( Ia1.getWidth(), grid.getWidth());
		assertEquals( Ia1.getHeight(), grid.getHeight());
		assertEquals( Ia1.getMode(), mode1);
			
	}
	

	@Test
	public void testPlay() {
		int Ia1Played = Ia1.play(rule);
		assertNotNull( Ia1Played);
		assertTrue( 0 <= Ia1Played || Ia1Played <= grid.getWidth());
		assertEquals( 3, Ia1Played);
		int Ia3Played = Ia3.play(rule);
		assertTrue( 0 <= Ia3Played || Ia3Played <= grid.getWidth());
		assertEquals( 3, Ia3Played);
		
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
