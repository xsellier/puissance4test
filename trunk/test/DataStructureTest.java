package test;

//import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Before;
import org.junit.Test;

import src.DataStructure;

public class DataStructureTest extends TestCase{

	private DataStructure matrix;
	private DataStructure zero_matrix;
	private DataStructure negative_matrix;
	private DataStructure big_matrix;
	
	@Before
	public void setUp(){
		matrix = new DataStructure(6,7);
		zero_matrix = new DataStructure(0,0);
		negative_matrix = new DataStructure(-1,-3);
		big_matrix = new DataStructure(100,100);
	}

	

	@Test
	public void testGetHeight() {
		int result = matrix.getHeight();
		assertEquals("Le test de la hauteur a réussi", result , 6);
	}

	@Test
	public void testGetWidth() {
		int result = matrix.getWidth();
		assertEquals("Le test de la largeur a réussi",result , 7);
	}

	@Test
	public void testZeroMatrix() {
		int resultZH = zero_matrix.getHeight();
		assertEquals("la hauteur d'une matrice_zero est 0", resultZH , 0);
		
		int resultZW = zero_matrix.getWidth();
		assertEquals("la largeur d'une matrice_zero est 0", resultZW , 0);
	}
	
	@Test
	public void testBigMatrix() {
		int resultZH = big_matrix.getHeight();
		assertEquals("la hauteur d'une matrice 100*100 est 100", 100, resultZH);
		
		int resultZW = big_matrix.getWidth();
		assertEquals("la largeur d'une matrice 100*100 est 100", 100 , resultZW);
	}

	@Test
	public void testNegativeMatrix() {
		int resultNH = negative_matrix.getHeight();
		assertEquals("la hauteur d'une negative_matrix est 6",resultNH , 6);
		
		int resultNW = negative_matrix.getWidth();
		assertEquals("la largeur d'une negative_matrix est 6",resultNW , 7);
	}
	
	public String print() {
		String result = "";
		for (int i = 0; i < matrix.getHeight(); i++) {
			result +="Ligne : " + i + " | ";
			for (int j = 0; j < matrix.getWidth(); j++) {
				result +=matrix.getValue(i,j) + " ";
			}
			result += "\n";
		}
		return result;
	}
	
	@Test
	public void testPrint() {
		String result = "Ligne : 0 | 0 0 0 0 0 0 0\nLigne : 1 | 0 0 0 0 0 0 0\nLigne : 2 | 0 0 0 0 0 0 0\nLigne : 3 | 0 0 0 0 0 0 0\nLigne : 4 | 0 0 0 0 0 0 0\nLigne : 5 | 0 0 0 0 0 0 0\n";
		String resulttmp = print();
		assert(result.equals(resulttmp));
	}


	@Test
	public void testAddingValue() {
		assertTrue(matrix.setValue(1, 2, 3));
		int result = matrix.getValue(1, 2);
		assertEquals("Test de rajout d'une valeur à la matrice" ,result, 3);
		

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

		assertFalse("Test de rajout d'une 43 ème valeur à la matrice" ,matrix.setValue(6, 0, 0));
	
	
		assertTrue("Test de la hauteur : Toujours égale à 6 malgré le rajout d'une 43 ème valeur", matrix.getHeight() == 6);	
		
	
		assertTrue("Test de la largeur : Toujours égale à 7 malgré le rajout d'une 43 ème valeur",matrix.getWidth() == 7);	
		
		int result = matrix.getValue(5, 5);
		assertEquals("Test de valeurs après rajout : les valeurs stockées dans la matrice n'ont pas été éronnées suite au rajout d'une 43 ème valeur", result, 0);

	}
	
	public static junit.framework.Test suite(){
		junit.framework.TestSuite suite =
		new TestSuite(DataStructureTest.class);
		return suite;
	}
	
}


