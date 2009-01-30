package test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.DataStructure;

public class DataStructureTest extends TestCase {

	private DataStructure matrix;
	private DataStructure zero_matrix;
	private DataStructure negative_matrix;
	private DataStructure big_matrix;
	private DataStructure high_matrix;

	@Before
	public void setUp() {
		matrix = new DataStructure(6, 7);
		zero_matrix = new DataStructure(0, 0);
		negative_matrix = new DataStructure(-1, -3);
		big_matrix = new DataStructure(100, 100);
		high_matrix = new DataStructure(8, 9);

	}

	@After
	public void tearDown() {
		matrix = null;
		zero_matrix = null;
		negative_matrix = null;
		big_matrix = null;
		high_matrix = null;

	}

	@Test
	public void testGetHeight() {
		int result = matrix.getHeight();
		assertEquals("Le test de la hauteur n'a pas r�ussi", result, 6);
	}

	@Test
	public void testGetWidth() {
		int result = matrix.getWidth();
		assertEquals("Le test de la largeur n'as pas r�ussi", result, 7);
	}

	@Test
	public void testZeroMatrix() {
		int resultZH = zero_matrix.getHeight();
		assertEquals("la hauteur d'une matrice_zero n'est pas 6", resultZH, 6);

		int resultZW = zero_matrix.getWidth();
		assertEquals("la largeur d'une matrice_zero n'est pas  7", resultZW, 7);

	}

	@Test
	public void testHighMatrix() {
		int resultHH = high_matrix.getHeight();
		assertEquals("la hauteur d'une high_matrix n'est pas  8", 8, resultHH);

		int resultHW = high_matrix.getWidth();
		assertEquals("la largeur d'une high_matrix n'est pas  9", 9, resultHW);

		assertTrue(
				"Stockage d'une valeur � la position (0,8) de la high_matrix impossible",
				high_matrix.setValue(0, 8, 0));
		assertFalse(
				"Stockage d'une valeur � la position (0,9) de la high_matrix possible",
				high_matrix.setValue(0, 9, 0));
	}

	@Test
	public void testBigMatrix() {
		int resultZH = big_matrix.getHeight();
		assertEquals("la hauteur d'une matrice 100*100 n'est pas  100", 100,
				resultZH);

		int resultZW = big_matrix.getWidth();
		assertEquals("la largeur d'une matrice 100*100 n'est pas  100", 100,
				resultZW);
	}

	@Test
	public void testNegativeMatrix() {
		int resultNH = negative_matrix.getHeight();
		assertEquals("la hauteur d'une negative_matrix n'est pas  6", resultNH,
				6);

		int resultNW = negative_matrix.getWidth();
		assertEquals("la largeur d'une negative_matrix n'est pas  6", resultNW,
				7);
	}

	@Test
	public void testInvalidSetValues() {
		assertFalse(matrix.setValue(10, 1, 0));
		assertFalse(matrix.setValue(1, 10, 1));
		assertFalse(matrix.setValue(10, 10, 2));
	}

	@Test
	public void testToString() {
		
		String result = "Ligne : 0 | 0 0 0 0 0 0 0 \nLigne : 1 | 0 0 0 0 0 0 0 \nLigne : 2 | 0 0 0 0 0 0 0 \nLigne : 3 | 0 0 0 0 0 0 0 \nLigne : 4 | 0 0 0 0 0 0 0 \nLigne : 5 | 0 0 0 0 0 0 0 \n";
		assertEquals(result, zero_matrix.toString());
	}

	@Test
	public void testAddingValue() {
		assertTrue(matrix.setValue(1, 2, 3));
		int result = matrix.getValue(1, 2);
		assertEquals("Test de rajout d'une valeur � la matrice", result, 3);

	}

	@Test
	public void testAddingMoreThan42Values() {
		assertTrue(matrix.setValue(0, 0, 0));
		assertTrue(matrix.setValue(0, 1, 1));
		assertTrue(matrix.setValue(0, 2, 0));
		assertTrue(matrix.setValue(0, 3, 1));
		assertTrue(matrix.setValue(0, 4, 0));
		assertTrue(matrix.setValue(0, 5, 1));
		assertTrue(matrix.setValue(0, 6, 0));
		assertTrue(matrix.setValue(1, 0, 1));
		assertTrue(matrix.setValue(1, 1, 0));
		assertTrue(matrix.setValue(1, 2, 1));
		assertTrue(matrix.setValue(1, 3, 0));
		assertTrue(matrix.setValue(1, 4, 1));
		assertTrue(matrix.setValue(1, 5, 0));
		assertTrue(matrix.setValue(1, 6, 1));
		assertTrue(matrix.setValue(2, 0, 0));
		assertTrue(matrix.setValue(2, 1, 1));
		assertTrue(matrix.setValue(2, 2, 0));
		assertTrue(matrix.setValue(2, 3, 1));
		assertTrue(matrix.setValue(2, 4, 0));
		assertTrue(matrix.setValue(2, 5, 1));
		assertTrue(matrix.setValue(2, 6, 0));
		assertTrue(matrix.setValue(3, 0, 1));
		assertTrue(matrix.setValue(3, 1, 0));
		assertTrue(matrix.setValue(3, 2, 1));
		assertTrue(matrix.setValue(3, 3, 0));
		assertTrue(matrix.setValue(3, 4, 1));
		assertTrue(matrix.setValue(3, 5, 0));
		assertTrue(matrix.setValue(3, 6, 1));
		assertTrue(matrix.setValue(4, 0, 0));
		assertTrue(matrix.setValue(4, 1, 1));
		assertTrue(matrix.setValue(4, 2, 0));
		assertTrue(matrix.setValue(4, 3, 1));
		assertTrue(matrix.setValue(4, 4, 0));
		assertTrue(matrix.setValue(4, 5, 1));
		assertTrue(matrix.setValue(4, 6, 0));
		assertTrue(matrix.setValue(5, 0, 1));
		assertTrue(matrix.setValue(5, 1, 0));
		assertTrue(matrix.setValue(5, 2, 1));
		assertTrue(matrix.setValue(5, 3, 0));
		assertTrue(matrix.setValue(5, 4, 1));
		assertTrue(matrix.setValue(5, 5, 0));
		assertTrue(matrix.setValue(5, 6, 1));

		assertFalse("Test aux limites : borne inf", matrix
				.setValue(-1, -1, 0));
		
		assertFalse("Test aux limites : borne sup", matrix
				.setValue(6, 0, 0));

		assertTrue(
				"Test de la hauteur : Toujours �gale � 6 malgr� le rajout d'une 43 �me valeur",
				matrix.getHeight() == 6);

		assertTrue(
				"Test de la largeur : Toujours �gale � 7 malgr� le rajout d'une 43 �me valeur",
				matrix.getWidth() == 7);

		int result = matrix.getValue(5, 5);
		assertEquals(
				"Test de valeurs apr�s rajout : les valeurs stock�es dans la matrice n'ont pas �t� �ronn�es suite au rajout d'une 43 �me valeur",
				result, 0);

	}

	

}
