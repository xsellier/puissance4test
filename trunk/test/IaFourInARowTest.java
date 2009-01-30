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
	private IaFourInARow ia7;

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
		ia7 = new IaFourInARow();

		mode1 = 1; // easy mode
		mode2 = 2; // hard mode

		ia1.initialize(grid, mode1);
		ia2.initialize(grid, mode2);
		ia3.initialize(grid_null, mode1);
		ia4.initialize(grid_null, mode2);
		ia5.initialize(big_grid, mode1);
		ia6.initialize(big_grid, mode2);
		ia7.initialize(grid, mode1);

		IaRandom iatest = new IaRandom();
		iatest.initialize(grid, mode2); // initialize a randomIa
		iatest.initialize(grid, mode1); // initialize a switchIa
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
		ia7.play(rule);
		int[] tmp = ia7.getPlayable();
		for ( int i=0 ; i<ia7.getCpuGrid().getWidth();i++)
			assertEquals( 0 , tmp[i]);
		
		ia7.setPlayable(6,6 );
		int[] tmp2 = ia7.getPlayable();
		assertNotNull( tmp2[6]);
	
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
		
		//Empty grid
		
		//figempty
		
		//mode easy standard grid
		//check playable is all at 0 and cpu play at 3
		int Ia1Played = ia1.play(rule);
		assertNotNull(Ia1Played);
		assertTrue(0 <= Ia1Played && Ia1Played < grid.getWidth());
		assertEquals(3, Ia1Played);
		int[] playable1 = ia1.getPlayable();
		for ( int i =0 ; i<ia1.getCpuGrid().getWidth();i++)
		assertEquals(0,playable1[i]);
		
        //mode hard standard grid
		//check playable is all at 0 and cpu play at 3
		int Ia2Played = ia2.play(rule);
		assertNotNull(Ia2Played);
		assertTrue(0 <= Ia2Played && Ia2Played < grid.getWidth());
		assertEquals(3, Ia2Played);
		int[] playable2 = ia2.getPlayable();
		for ( int i =0 ; i<ia2.getCpuGrid().getWidth();i++)
		assertEquals(0,playable2[i]);
		
		//mode easy , grid initialise a null but by convention transform to standard grid
		int Ia3Played = ia3.play(rule);
		assertNotNull(Ia3Played);
		assertTrue(0 <= Ia3Played && Ia3Played < grid_null.getWidth());
		assertEquals(3, Ia3Played);
		
		//mode Hard , grid 100x100
		int Ia6Played =  ia6.play(rule);
		assertNotNull(Ia6Played);
		assertTrue( 0 <= Ia6Played && Ia6Played < big_grid.getWidth());
	
		
		//Winning test
		//figwin
		grid.reset_matrix();
		grid.setValue(5,0,1);
		grid.setValue(5,1,1);
		grid.setValue(4,0,1);
		grid.setValue(4,1,1);
		
		grid.setValue(5,6,2);
		grid.setValue(4,6,2);
		grid.setValue(3,6,2);
		
		//mode easy , standard grid
		//check cpu finish game an win
		int Ia1PlayedForWin = ia1.play(rule);
		assertNotNull(Ia1PlayedForWin);
		assertTrue(0 <= Ia1PlayedForWin && Ia1PlayedForWin < grid.getWidth());
		assertEquals(6, Ia1PlayedForWin);
		int[] playable3 = ia1.getPlayable();
		for ( int i =0 ; i<ia1.getCpuGrid().getWidth();i++)
	    if ( i == 6){
	    	assertEquals(3,playable3[i]);
	    }else{
		assertEquals(0,playable3[i]);
	    }
		grid_null.reset_matrix();
		grid_null.setValue(5,0,1);
		grid_null.setValue(5,1,1);
		grid_null.setValue(4,0,1);
		grid_null.setValue(4,1,1);
		
		grid_null.setValue(5,6,2);
		grid_null.setValue(4,6,2);
		grid_null.setValue(3,6,2);
		
		//mode hard , null grid transform to standard
		//check cpu finish game an win
		int Ia4PlayedForWin = ia4.play(rule);
		assertNotNull(Ia4PlayedForWin);
		assertTrue(0 <= Ia4PlayedForWin && Ia4PlayedForWin < grid_null.getWidth());
		assertEquals(6, Ia4PlayedForWin);
		int[] playable4 = ia4.getPlayable();
		for ( int i =0 ; i<ia4.getCpuGrid().getWidth();i++)
	    if ( i == 6){
	    	assertEquals(3,playable4[i]);
	    }else{
		assertEquals(0,playable4[i]);
	    }
		
		//full grid
		//figfull
		
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
        //mode easy , standard grid
		//check retrun error code
		int Ia1PlayedFullGrid = ia1.play(rule);
		assertFalse(0 <= Ia1PlayedFullGrid && Ia1PlayedFullGrid < grid.getWidth());
		assertEquals(-1, Ia1PlayedFullGrid);
		
        //mode hard, standard grid
		//check retrun error code
		int Ia2PlayedFullGrid = ia2.play(rule);
		assertFalse(0 <= Ia2PlayedFullGrid && Ia2PlayedFullGrid < grid.getWidth());
		assertEquals(-1, Ia2PlayedFullGrid);
		
		
		
		//fig 2
		//check return 1 to colonne 4 and no play on this
		grid.reset_matrix();
		grid.setValue(5, 1, 1);
		
		grid.setValue(5, 2, 2);
		grid.setValue(4, 2, 1);
		grid.setValue(3, 2, 1);
		
		grid.setValue(5, 3, 1);
		grid.setValue(4, 3, 2);
		grid.setValue(3, 3, 1);
		
		grid.setValue(5, 4, 2);
		grid.setValue(4, 4, 2);
		
		
		
		int Ia2Playedfig2 = ia2.play(rule);
		int[] playable5 = ia2.getPlayable();
		
		assertEquals(2 , Ia2Playedfig2);
		assertEquals(1 , playable5[4]);
		
		//fig 3
		//strategy to get not block
		grid.reset_matrix();
		
		grid.setValue(5, 1, 2);
		grid.setValue(4, 1, 1);
		grid.setValue(3, 1, 1);
		grid.setValue(2, 1, 2);
		
		grid.setValue(5, 2, 1);
		
		grid.setValue(5, 3, 1);
		grid.setValue(4, 3, 2);
		
		grid.setValue(5, 4, 2);
		grid.setValue(4, 4, 1);
		
		int Ia2Playedfig3 = ia2.play(rule);
		int[] playable6 = ia2.getPlayable();
		
		assertEquals(3 , Ia2Playedfig3);
		assertEquals(2, playable6[2]);
		
		
		//fig 4
		//win case
		
		grid.reset_matrix();
		
		grid.setValue(5, 1, 2);
		grid.setValue(4 ,1, 1);
		grid.setValue(3, 1, 1);
		grid.setValue(2, 1, 2);
		
		grid.setValue(5, 2, 1);
		grid.setValue(4, 2, 1);
		
		grid.setValue(5, 3, 1);
		grid.setValue(4, 3, 2);
		
		grid.setValue(5, 4, 2);
		
		int Ia2Playedfig4 = ia2.play(rule);
		int[] playable7 = ia2.getPlayable();
		
		assertEquals(2 , Ia2Playedfig4);
		assertEquals(3, playable7[2]);
		
		//fig5
		//mark full colonne
		grid.setValue(5, 1, 1);
		grid.setValue(4 ,1, 2);
		grid.setValue(3, 1, 2);
		grid.setValue(2, 1, 1);
		grid.setValue(1, 1, 1);
		grid.setValue(0, 1, 2);
		
		ia2.play(rule);
		int[] playable8 = ia2.getPlayable();
		assertEquals(4, playable8[1]);
		
		//fig62
		//win in 2hit
		
		grid.reset_matrix();
		
		grid.setValue(5, 0, 1);
		
		grid.setValue(5, 1, 2);
		
		grid.setValue(5, 2, 1);
		grid.setValue(4, 2, 2);
		
		grid.setValue(5, 3, 1);
		grid.setValue(4, 3, 2);
		
		grid.setValue(5, 4, 2);
		
		grid.setValue(5, 5, 1);
		
		int Ia2Playedfig6 = ia2.play(rule);
		int[] playable9 = ia2.getPlayable();
		assertEquals(5 , Ia2Playedfig6);
		assertEquals(5, playable9[1]);
		assertEquals(5, playable9[5]);
		
		//fig7
		//block human strategy
		
		grid.reset_matrix();
		
		grid.setValue(5, 2, 1);
		
		grid.setValue(5, 3, 1);
		grid.setValue(4, 3, 2);
		
		int Ia2Playedfig7 = ia2.play(rule);
		int[] playable10 = ia2.getPlayable();
		
		
		assertEquals(4 , Ia2Playedfig7);
		assertEquals(6, playable10[0]);
		assertEquals(6, playable10[4]);
		
		//fig8
		//block human win
		
		grid.reset_matrix();
		
		grid.setValue(5, 1, 2);
		
		grid.setValue(5,2, 1);
		grid.setValue(4, 2, 2);
		
		grid.setValue(5,3, 1);
		grid.setValue(4, 3, 2);
		
		grid.setValue(5, 5, 1);
		
		grid.setValue(5, 1, 2);
		
		int Ia2Playedfig8 = ia2.play(rule);
		int[] playablefig8 = ia2.getPlayable();
		
		assertEquals(4 , Ia2Playedfig8);
		assertEquals(6, playablefig8[4]);
		
		//fig9
		//Only choice is to less human win, but play
		
		grid.reset_matrix();
		
		grid.setValue(5, 0, 2);
		grid.setValue(4, 0, 2);
		grid.setValue(3, 0, 2);
		grid.setValue(2, 0, 1);
		grid.setValue(1, 0, 2);
		grid.setValue(0, 0, 1);
		

		grid.setValue(5, 1, 1);
		grid.setValue(4, 1, 1);
		grid.setValue(3, 1, 2);
		grid.setValue(2, 1, 1);
		grid.setValue(1, 1, 2);
		grid.setValue(0, 1, 1);
		

		grid.setValue(5, 2, 2);
		grid.setValue(4, 2, 1);
		grid.setValue(3, 2, 2);
		grid.setValue(2, 2, 1);
		grid.setValue(1, 2, 1);
		grid.setValue(0, 2, 1);
		

		grid.setValue(5, 3, 1);
		grid.setValue(4, 3, 2);
		grid.setValue(3, 3, 1);
		grid.setValue(2, 3, 2);

		grid.setValue(5, 4, 2);
		grid.setValue(4, 4, 1);
		grid.setValue(3, 4, 2);
		grid.setValue(2, 4, 1);
		grid.setValue(1, 4, 1);
		grid.setValue(0, 4, 1);
		
		grid.setValue(5, 5, 2);
		grid.setValue(4, 5, 1);
		grid.setValue(3, 5, 2);
		grid.setValue(2, 5, 1);
		grid.setValue(1, 5, 2);
		grid.setValue(0, 5, 1);
		
		grid.setValue(5, 6, 2);
		grid.setValue(4, 6, 2);
		grid.setValue(3, 6, 2);
		grid.setValue(2, 6, 1);
		grid.setValue(1, 6, 2);
		grid.setValue(0, 6, 1);
		
		
		int Ia2Playedfig9 = ia2.play(rule);
		int[] playablefig9 = ia2.getPlayable();
		
		assertEquals(3 , Ia2Playedfig9);
		assertEquals(1, playablefig9[3]);
	}

	

}
