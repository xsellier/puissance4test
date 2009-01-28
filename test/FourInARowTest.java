package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import src.*;

public class FourInARowTest {

	private DataStructure matrix;
	private Rules rule;

	@Before
	public void setUp() throws Exception {
		matrix = new DataStructure(6, 7);
		rule = new FourInARow();
	}

	@Test
	public void testCheckLine() {

		/*
		 * create a 4 in a line
		 */
		assertTrue(matrix.setValue(0, 0, 1));
		assertTrue(matrix.setValue(0, 1, 1));
		assertTrue(matrix.setValue(0, 2, 1));
		assertTrue(matrix.setValue(0, 3, 1));

		/* make a full test  to check line */
		for (int i = -1; i <= matrix.getWidth(); ++i) {
			for (int j = -1; j <= matrix.getHeight(); ++j) {
				if (i == 0 && j>=0 && j < matrix.getWidth()- 2) {
					assertTrue(rule.checkLine(i, j, 1, matrix));
					assertFalse(rule.checkLine(i, j, 2, matrix));
				} else {
					assertFalse(rule.checkLine(i, j, 1, matrix));
					assertFalse(rule.checkLine(i, j, 2, matrix));
				}
			}
		}
	}

	@Test
	public void testCheckCol() {
		
		/*
		 * create a 4 in a column
		 */
		assertTrue(matrix.setValue(0, 1, 2));
		assertTrue(matrix.setValue(1, 1, 2));
		assertTrue(matrix.setValue(2, 1, 2));
		assertTrue(matrix.setValue(3, 1, 2));
		
		/* make a full test  to check column */
		for (int i = -1; i <= matrix.getWidth(); ++i) {
			for (int j = -1; j <= matrix.getHeight(); ++j) {
				if (i>=0 && i < matrix.getHeight()-1 && j == 1) {
					assertFalse(rule.checkCol(i, j, 1, matrix));
					assertTrue(rule.checkCol(i, j, 2, matrix));
				} else {
					assertFalse(rule.checkCol(i, j, 1, matrix));
					assertFalse(rule.checkCol(i, j, 2, matrix));
				}
			}
		}
	}

	@Test
	public void testCheckDiag() {
		
		/*
		 * create an impossible diagonal to our test
		 */
		assertTrue(matrix.setValue(0, 0, 0));
		assertTrue(matrix.setValue(1, 1, 0));
		assertTrue(matrix.setValue(2, 2, 0));
		assertTrue(matrix.setValue(3, 3, 0));

		/* make a full test  to check diagonal */
		for (int i = -1; i <= matrix.getWidth(); ++i) {
			for (int j = -1; j <= matrix.getHeight(); ++j) {
				if (i < matrix.getHeight() && i>= 0 && j < matrix.getWidth() && j>= 0) {
					assertTrue(rule.checkDiag(i, j, 0, matrix));
					assertFalse(rule.checkDiag(i, j, 1, matrix));
					assertFalse(rule.checkDiag(i, j, 2, matrix));
				} else {
					assertFalse(rule.checkDiag(i, j, 0, matrix));
					assertFalse(rule.checkDiag(i, j, 1, matrix));
					assertFalse(rule.checkDiag(i, j, 2, matrix));
				}
			}
		}
	}

	@Test
	public void testIsComplete() {

		/*
		 * create a four in a row
		 */
		assertTrue(matrix.setValue(0, 1, 2));
		assertTrue(matrix.setValue(1, 1, 2));
		assertTrue(matrix.setValue(2, 1, 2));
		assertTrue(matrix.setValue(3, 1, 2));

		assertTrue("la grille est complète", rule.isComplete(matrix));
	}

	@Test
	public void testIsNotComplete() {

		assertTrue(matrix.setValue(0, 0, 0));
		assertTrue(matrix.setValue(1, 2, 0));
		assertTrue(matrix.setValue(2, 5, 0));
		assertTrue(matrix.setValue(0, 4, 0));

		assertFalse("la grille n'est pas complète", rule.isComplete(matrix));
	}

	@Test
	public void testCheckPlay() {

		/*
		 * fill line on top
		 */
		assertTrue(matrix.setValue(0, 0, 1));
		assertTrue(matrix.setValue(0, 1, 1));
		assertTrue(matrix.setValue(0, 2, 1));
		assertTrue(matrix.setValue(0, 3, 1));
		assertTrue(matrix.setValue(0, 4, 1));
		assertTrue(matrix.setValue(0, 5, 1));
		assertTrue(matrix.setValue(0, 6, 0));
		
		/*
		 * fill colum 6
		 */
		assertTrue(matrix.setValue(1, 6, 1));
		assertTrue(matrix.setValue(2, 6, 0));
		assertTrue(matrix.setValue(3, 6, 1));
		assertTrue(matrix.setValue(4, 6, 0));
		assertTrue(matrix.setValue(5, 6, 1));

		/*
		 * test if we can play in a fully column
		 */
		assertFalse(rule.checkPlay(0, matrix));
		
		/*
		 * test if we can play in a uncompleted column
		 */
		assertTrue(rule.checkPlay(6, matrix));
		/*
		 * assertTrue(matrix.setValue(1, 0, 1)); assertTrue(matrix.setValue(1,
		 * 1, 1)); assertTrue(matrix.setValue(1, 2, 1));
		 * assertTrue(matrix.setValue(1, 3, 1)); assertTrue(matrix.setValue(1,
		 * 4, 1)); assertTrue(matrix.setValue(1, 5, 1));
		 * assertTrue(matrix.setValue(1, 6, 1));
		 * 
		 * assertFalse(matrix.setValue(1, 7, 0));
		 * 
		 * assertTrue(matrix.setValue(2, 0, 1)); assertTrue(matrix.setValue(2,
		 * 1, 1)); assertTrue(matrix.setValue(2, 2, 1));
		 * assertTrue(matrix.setValue(2, 3, 1)); assertTrue(matrix.setValue(2,
		 * 4, 1)); assertTrue(matrix.setValue(2, 5, 1));
		 * assertTrue(matrix.setValue(2, 6, 1)); assertTrue(matrix.setValue(3,
		 * 0, 1)); assertTrue(matrix.setValue(3, 1, 1));
		 * assertTrue(matrix.setValue(3, 2, 1)); assertTrue(matrix.setValue(3,
		 * 3, 1)); assertTrue(matrix.setValue(3, 4, 1));
		 * assertTrue(matrix.setValue(3, 5, 1)); assertTrue(matrix.setValue(3,
		 * 6, 1)); assertTrue(matrix.setValue(4, 0, 1));
		 * assertTrue(matrix.setValue(4, 1, 1)); assertTrue(matrix.setValue(4,
		 * 2, 1)); assertTrue(matrix.setValue(4, 3, 1));
		 * assertTrue(matrix.setValue(4, 4, 1)); assertTrue(matrix.setValue(4,
		 * 5, 1)); assertTrue(matrix.setValue(4, 6, 1));
		 * assertTrue(matrix.setValue(5, 0, 1)); assertTrue(matrix.setValue(5,
		 * 1, 1)); assertTrue(matrix.setValue(5, 2, 1));
		 * assertTrue(matrix.setValue(5, 3, 1)); assertTrue(matrix.setValue(5,
		 * 4, 1)); assertTrue(matrix.setValue(5, 5, 1));
		 * assertTrue(matrix.setValue(5, 6, 1));
		 */

		/*
		 * assertTrue(matrix.setValue(0, 1, 1)); assertTrue(check_play(0,
		 * matrix)); assertTrue(check_play(1, matrix)); assertTrue(check_play(2,
		 * matrix)); assertTrue(check_play(6, matrix));
		 * 
		 * assertTrue(matrix.setValue(1, 4, 2)); assertTrue(check_play(1,
		 * matrix));
		 * 
		 * assertTrue(matrixW2.setValue(0, 1, 2)); assertTrue(check_play(1,
		 * matrixW2));
		 * 
		 * assertTrue(matrixW6.setValue(0, 2, 0));
		 * 
		 * assertFalse(matrixW7.setValue(0, 8, 0));
		 * 
		 * assertTrue(matrix.setValue(0, 6, 0));
		 */
	}

}
