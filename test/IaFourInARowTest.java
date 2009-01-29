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
	private DataStructure full_grid;

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
		full_grid = new DataStructure( 6, 7);

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
		assertTrue(0 <= Ia1Played || Ia1Played < grid.getWidth());
		assertEquals(3, Ia1Played);
		
		int Ia3Played = ia3.play(rule);
		assertNotNull(Ia3Played);
		assertTrue(0 <= Ia3Played || Ia3Played < grid_null.getWidth());
		assertEquals(3, Ia3Played);
		
		int Ia6Played =  ia6.play(rule);
		assertNotNull(Ia6Played);
		assertTrue( 0 <= Ia6Played || Ia6Played < big_grid.getWidth());
		System.out.println(Ia6Played);

	}

	@Test
	public void testEasyCpu() {
		// fail("Not yet implemented");
	}

	@Test
	public void testPerfectCpu() {
		// fail("Not yet implemented");
	}

}
