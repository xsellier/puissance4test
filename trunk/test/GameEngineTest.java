package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.*;

public class GameEngineTest extends TestCase{

	private GameEngine game;
	
	
	@Before
	public void setUp(){
		
		game = new GameEngine();
		
		
	}
	
	@After
	public void tearDown(){
		
		game = null;
		
	
	}


	
	@Test
	public void testModes() {
	
		assertTrue(game.initMode(0));
		assertTrue(game.getMode() == 0);
		assertFalse(game.getMode() == 1);
		assertFalse(game.getMode() == 2);
		
		assertTrue(game.initMode(1));
		assertFalse(game.getMode() == 0);
		assertTrue(game.getMode() == 1);
		assertFalse(game.getMode() == 2);
		
		assertTrue(game.initMode(2));
		assertFalse(game.getMode() == 0);
		assertFalse(game.getMode() == 1);
		assertTrue(game.getMode() == 2);
		
		
	}

	@Test
	public void testHuman2WinHuman1() {
		
		assertTrue(game.initMode(0));
		game.start();
		//run the JUnit test : JUnit test pass if human2 win, else message will be send 
		assertFalse("2 possibilités : \n C'est le joueur humain numéro 1 qui a gagné !!!\n" +
				"ou personne n'a gagné !!", game.getWinPlayer());
		
	}
	
	@Test
	public void testCpu1WinHuman() {
		
		assertTrue(game.initMode(1));
		game.start();
		//run the JUnit test : JUnit test pass if Cpu1 win, else message will be send
		assertFalse("C'est l'humain qui a gagné !", game.getWinPlayer());
		
	}

	@Test
	public void testCpu2WinHuman() {
		assertTrue(game.initMode(2));
		game.start();
		//run the JUnit test : JUnit test pass if Cpu2 win, else message will be send
		assertFalse("C'est l'humain qui a gagné !", game.getWinPlayer());
		
	}
	

}
