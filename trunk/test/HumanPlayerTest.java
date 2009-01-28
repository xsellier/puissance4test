package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import src.DataStructure;
import src.GUI;
import src.GUIOwn;
import src.HumanPlayer;


public class HumanPlayerTest {

	
	private HumanPlayer Human;
	private DataStructure Matrix;
	public GUI app;
	public int played;
	
	@Before
	public void setUp() throws Exception {
		Human= new HumanPlayer();
		
		Matrix = new DataStructure(6,7);
		app = new GUIOwn(); // create GUI, you can change this line to use another GUI
		 // app = new GUI_another_one();
		app.initGui(Matrix); // initialize GUI with grid
		app.setSize(500, 550);
		app.setLocation(100, 100);
		app.show();
	}
	

	@Test
	public void testPlay() {
		played = Human.play(Matrix,app);
		assertTrue( 0 <= played && played <= 6);
	}

}
