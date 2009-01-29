package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import src.CpuPlayer;
import src.DataStructure;
import src.GUI;
import src.GUIOwn;
import src.GameEngine;
import src.HumanPlayer;
import src.Player;
import src.Rules;

public class GameEngineTest extends TestCase{

	private GameEngine game;
	private DataStructure grid;
	private GUI app;
	
	@Before
	public void setUp(){
		
		game = new GameEngine();
		grid = new DataStructure(6,7);
		
	}
	
	@Before
	public void tearDown(){
		
		game = null;
		grid = null;
	
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
		game.initMode(0);
		
		assertFalse("2 possibilités : C'est le joueur humain numéro 1 qui a gagné !!!" +
				"ou personne n'a gagné !!", game.getWinPlayer());
		
	}
	
	@Test
	public void testCpu1WinHuman() {
		game.initMode(1);
		
		assertFalse("C'est l'humain qui a gagné !", game.getWinPlayer());
		
	}

	@Test
	public void testCpu2WinHuman() {
		game.initMode(2);
		
		assertFalse("C'est l'humain qui a gagné !", game.getWinPlayer());
		
	}
	
	@Test
	public void testUpdatePlay() {	
		game.initMode(0);
		game.start();
		
		game.updatePlay();
		assertTrue("Test de mise à jour du jeu", game.getWinPlayer());
	}

	@Test
	public void testCheck_grid() {

	}

}
