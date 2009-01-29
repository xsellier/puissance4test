package test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import src.*;

public class IaFourInARowTest extends TestCase {

	private int mode1;
	private int mode2;

	private DataStructure grid;
	private DataStructure grid_null;
	private DataStructure big_grid;


	private IaFourInARow ia1;
	private IaFourInARow ia2;
	private IaFourInARow ia3;
	private IaFourInARow ia4;
	private IaFourInARow ia5;
	private IaFourInARow ia6;

	private Rules rule;

	@Before
	public void setUp() throws Exception {
		grid = new DataStructure(6, 7);
		grid_null = new DataStructure(0, 0);
		big_grid = new DataStructure(100, 100);
		

		rule = new FourInARow();

		ia1 = new IaFourInARow();
		ia2 = new IaFourInARow();
		ia3 = new IaFourInARow();
		ia4 = new IaFourInARow();
		ia5 = new IaFourInARow();
		ia6 = new IaFourInARow();

		mode1 = 1; // easy mode
		mode2 = 2; // hard mode

		ia1.initialize(grid, mode1);
		ia2.initialize(grid, mode2);
		ia3.initialize(grid_null, mode1);
		ia4.initialize(grid_null, mode2);
		ia5.initialize(big_grid, mode1);
		ia6.initialize(big_grid, mode2);

		IaRandom iatest = new IaRandom();
		iatest.initialize(grid, mode2); // initialize a randomIa
		iatest.initialize(grid, mode1); // initialize a switchIa
	}

	@Test
	public void testGetPlayable() {
		// System.out.println("");
	}

	@Test
	public void testGetCpuGrid() {
		assertNotNull(ia1.getCpuGrid());
		assertEquals(6, ia1.getHeight());
		assertEquals(7, ia1.getWidth());
		assertSame(grid, ia1.getCpuGrid());

	}

	@Test
	public void testGetHeight() {
		assertEquals(6, ia1.getHeight());
		assertEquals(6, ia2.getHeight());
		assertEquals(6, ia3.getHeight());
		assertEquals(100, ia5.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(7, ia1.getWidth());
		assertEquals(7, ia3.getWidth());
		assertEquals(100, ia6.getWidth());
	}

	@Test
	public void testGetMode() {
		assertEquals(1, ia1.getMode());
		assertEquals(2, ia2.getMode());
	}

	@Test
	public void testSetPlayable() {
		/*
		 * to change
		 */
		assertEquals(6, grid_null.getHeight());
		assertEquals(7, grid_null.getWidth());
	}

	@Test
	public void testInitialize() {
		assertNotNull(ia1.getCpuGrid());
		assertNotNull(ia1.getWidth());
		assertNotNull(ia1.getHeight());
		assertNotNull(ia1.getMode());
		assertSame(ia1.getCpuGrid(),grid);
		assertEquals(7,ia1.getWidth());
		assertEquals(6,ia1.getHeight());
		assertEquals(1,ia1.getMode());

	}

	@Test
	public void testPlay() {
		int Ia1Played = ia1.play(rule);
		assertNotNull(Ia1Played);
		assertTrue(0 <= Ia1Played && Ia1Played < grid.getWidth());
		assertEquals(3, Ia1Played);
		
		int Ia3Played = ia3.play(rule);
		assertNotNull(Ia3Played);
		assertTrue(0 <= Ia3Played && Ia3Played < grid_null.getWidth());
		assertEquals(3, Ia3Played);
		
		int Ia6Played =  ia6.play(rule);
		assertNotNull(Ia6Played);
		assertTrue( 0 <= Ia6Played && Ia6Played < big_grid.getWidth());
		System.out.println(Ia6Played);
		
		//Winning test
		grid.reset_matrix();
		grid.setValue(0,4,1);
		grid.setValue(0,5,1);
		grid.setValue(1,4,1);
		grid.setValue(1,5,1);
		
		grid.setValue(0,0,2);
		grid.setValue(0,2,2);
		grid.setValue(0,3,2);
		
		int Ia1PlayedForWin = ia1.play(rule);
		assertNotNull(Ia1PlayedForWin);
		assertTrue(0 <= Ia1PlayedForWin && Ia1PlayedForWin < grid.getWidth());
		assertEquals(1, Ia1PlayedForWin);
		
		grid_null.reset_matrix();
		grid_null.setValue(0,4,1);
		grid_null.setValue(0,5,1);
		grid_null.setValue(1,4,1);
		grid_null.setValue(1,5,1);
		
		grid_null.setValue(0,0,2);
		grid_null.setValue(0,2,2);
		grid_null.setValue(0,3,2);
		
		int Ia4PlayedForWin = ia4.play(rule);
		assertNotNull(Ia4PlayedForWin);
		assertTrue(0 <= Ia4PlayedForWin && Ia4PlayedForWin < grid_null.getWidth());
		assertEquals(1, Ia4PlayedForWin);
		
		//full grid
		
		grid.reset_matrix();
		int old_color = 2;
		for ( int i =0 ; i < grid.getHeight(); i++){
			for ( int j=0 ; j < grid.getWidth(); j++){
				if ( old_color == 1){
					grid.setValue(i, j, 2);
					old_color= 2;
				}else{
					grid.setValue(i, j,1);
					old_color=1;
				}
				
			}
		}

		int Ia1PlayedFullGrid = ia1.play(rule);
		assertFalse(0 <= Ia1PlayedFullGrid && Ia1PlayedFullGrid < grid.getWidth());
		assertEquals(-1, Ia1PlayedFullGrid);
		
		
		int Ia2PlayedFullGrid = ia2.play(rule);
		assertFalse(0 <= Ia2PlayedFullGrid && Ia2PlayedFullGrid < grid.getWidth());
		assertEquals(-1, Ia2PlayedFullGrid);
		
		
		
		
		
	}

	

}
