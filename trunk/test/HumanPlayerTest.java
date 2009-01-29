package test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.DataStructure;
import src.GUI;
import src.GUIOwn;
import src.HumanPlayer;


public class HumanPlayerTest {

	
	private HumanPlayer human;
	private DataStructure matrix;
	public GUI app;
	public int played;
	
	@Before
	public void setUp() throws Exception {
		human= new HumanPlayer();
		
		matrix = new DataStructure(6,7);
		app = new GUIOwn(); // create GUI, you can change this line to use another GUI
		 // app = new GUIAnotherOne();
		app.initGui(matrix); // initialize GUI with grid
		app.setSize(500, 550);
		app.setLocation(100, 100);
		app.show();
	}
	

	@After
	public void tearDown(){
		human = null;
		matrix = null;
		app = null;
	}
	
	@Test
	public void testPlay() {
		played = human.play(matrix,app);
		assertNotNull(played);
		assertTrue( 0 <= played && played < matrix.getWidth());
	}

}
