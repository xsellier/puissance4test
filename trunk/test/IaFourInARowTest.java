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
	private IaFourInARow ta6;

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
		ta6 = new IaFourInARow();

		mode1 = 1; // easy mode
		mode2 = 2; // hard mode

		ia1.initialize(grid, mode1);
		ia2.initialize(grid, mode2);
		ia3.initialize(grid_null, mode1);
		ia4.initialize(grid_null, mode2);
		ia5.initialize(big_grid, mode1);
		ta6.initialize(big_grid, mode2);

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
		assertEquals(grid.getHeight(), ia1.getHeight());
		assertEquals(grid.getWidth(), ia1.getWidth());
		assertSame(grid, ia1.getCpuGrid());

	}

	@Test
	public void testGetHeight() {
		assertEquals(grid.getHeight(), ia1.getHeight());
		assertEquals(grid.getHeight(), ia2.getHeight());
		assertEquals(grid_null.getHeight(), ia3.getHeight());
		assertEquals(big_grid.getHeight(), ia5.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(grid.getWidth(), ia1.getWidth());
		assertEquals(grid_null.getWidth(), ia3.getWidth());
		assertEquals(big_grid.getWidth(), ta6.getWidth());
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
		assertSame(ia1.getCpuGrid(), grid);
		assertEquals(ia1.getWidth(), grid.getWidth());
		assertEquals(ia1.getHeight(), grid.getHeight());
		assertEquals(ia1.getMode(), mode1);

	}

	@Test
	public void testPlay() {
		int Ia1Played = ia1.play(rule);
		assertNotNull(Ia1Played);
		assertTrue(0 <= Ia1Played || Ia1Played <= grid.getWidth());
		assertEquals(3, Ia1Played);
		int Ia3Played = ia3.play(rule);
		assertTrue(0 <= Ia3Played || Ia3Played <= grid.getWidth());
		assertEquals(3, Ia3Played);

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
