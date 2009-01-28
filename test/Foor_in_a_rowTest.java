package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.DataStructure;


public class Foor_in_a_rowTest {
	
	
	private DataStructure matrix;
	
	/*matrices utilisés dans la méthode testCheck_play()
	private DataStructure matrixW_1;
	private DataStructure matrixW1;
	private DataStructure matrixW2;
	private DataStructure matrixW6;
	private DataStructure matrixW7;*/
	
	
	
	@Before
	public void setUp() throws Exception {
		
		matrix = new DataStructure(6,7);
		/*matrixW_1 = new DataStructure(6, -1);
		matrixW1 = new DataStructure(6, 1);
		matrixW2 = new DataStructure(6, 2);
		matrixW6 = new DataStructure(6, 7);
		matrixW7 = new DataStructure(6, 8);*/
		
	}

	public boolean check_line(int i, int j, int color, DataStructure grid) {
		int count_left = 0;
		int count_right = 0;

		int real_j = j;

		if (j > 0) {
			j = real_j - 1;
			while ((j >= 0) && (j > (real_j - 4))
					&& (grid.getValue(i, j) == color)) {
				count_left++;
				j--;
			}
		}

		if (j < 6) {
			j = real_j + 1;
			while ((j < grid.getWidth()) && (j < (real_j + 4))
					&& (grid.getValue(i, j) == color)) {
				count_right++;
				j++;
			}
		}
		if ((count_left + count_right) >= 3)
			return true;
		else
			return false;
	}

	
	@Test
	public void testCheck_line() {
		
		
		assertTrue(matrix.setValue(0, 0, 1));
		assertTrue(matrix.setValue(0, 1, 1));
		assertTrue(matrix.setValue(0, 2, 1));
		assertTrue(matrix.setValue(0, 3, 1));
		 
		assertTrue(check_line(0, -1, 1, matrix));
		assertTrue(check_line(0, 0, 1, matrix));
		assertTrue(check_line(0, 1, 1, matrix));
		assertTrue(check_line(0, 2, 1, matrix));
		assertTrue(check_line(0, 3, 1, matrix));
		assertTrue(check_line(0, 4, 1, matrix));
		
		assertFalse(check_line(0, 5, 1, matrix));
		assertFalse(check_line(0, 6, 1, matrix));
		assertFalse(check_line(0, 7, 1, matrix));
	}

	public boolean check_col(int i, int j, int color, DataStructure grid) {
		int count_up = 0;
		int count_down = 0;

		int real_i = i;

		if (i > 0) {
			i = real_i - 1;
			while ((i >= 0) && (i > (real_i - 4))
					&& (grid.getValue(i, j) == color)) {
				count_down++;
				i--;
			}
		}
		if (i < (grid.getHeight()-1)) {
			i = real_i + 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4))
					&& (grid.getValue(i, j) == color)) {
				count_up++;
				i++;
			}
		}

		if ((count_up + count_down) >= 3)
			return true;
		else
			return false;

	}

	
	@Test
	public void testCheck_col() {
		assertTrue(matrix.setValue(0, 1, 2));
		assertTrue(matrix.setValue(1, 1, 2));
		assertTrue(matrix.setValue(2, 1, 2));
		assertTrue(matrix.setValue(3, 1, 2));
		
		
		
		assertTrue(check_col(-1, 1, 2, matrix));   // attention à partir de i = -1 ca marche
		assertTrue(check_col(0, 1, 2, matrix));
		assertTrue(check_col(1, 1, 2, matrix));
		assertTrue(check_col(2, 1, 2, matrix));
		assertTrue(check_col(4, 1, 2, matrix));    // et jusqu'à i = 4;
		
		assertFalse(check_col(5, 1, 2, matrix));   // Le test ne passe plus
	}

	public boolean check_diag(int i, int j, int color, DataStructure grid) {

		int count1 = 0;
		int count2 = 0;

		int real_i = i;
		int real_j = j;

		if ((i > 0) && (j > 0)) {
			i = real_i - 1;
			j = real_j - 1;
			while ((i >= 0) && (i > (real_i - 4)) && (j >= 0)
					&& (j > (real_j - 4)) && (grid.getValue(i, j) == color)) {
				count1++;
				i--;
				j--;
			}
		}

		if ((i < (grid.getHeight()-1)) && (j < (grid.getWidth()-1))) {
			i = real_i + 1;
			j = real_j + 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4)) && (j < grid.getWidth())
					&& (j < (real_j + 4)) && (grid.getValue(i, j) == color)) {
				count2++;
				i++;
				j++;
			}
		}

		if ((count1 + count2) >= 3)
			return true;

		count1 = 0;
		count2 = 0;

		if ((i > 0) && (j < (grid.getWidth()-1))) {
			i = real_i - 1;
			j = real_j + 1;
			while ((i >= 0) && (i > (real_i - 4)) && (j < grid.getWidth())
					&& (j < (real_j + 4)) && (grid.getValue(i, j) == color)) {
				count1++;
				i--;
				j++;
			}
		}

		if ((i < (grid.getHeight()-1)) && (j > 0)) {
			i = real_i + 1;
			j = real_j - 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4)) && (j >= 0)
					&& (j >= (real_j - 4)) && (grid.getValue(i, j) == color)) {
				count2++;
				i++;
				j--;
			}
		}

		if ((count1 + count2) >= 3)
			return true;

		return false;
	}

	@Test
	public void testCheck_diag() { // à revoir
		assertTrue(matrix.setValue(0, 0, 0));
		assertTrue(matrix.setValue(1, 1, 0));
		assertTrue(matrix.setValue(2, 2, 0));
		assertTrue(matrix.setValue(3, 3, 0));
		 
		assertTrue(check_diag(0, 0, 0, matrix));
		assertTrue(check_diag(1, 1, 0, matrix));
		assertTrue(check_diag(2, 2, 0, matrix));
		assertTrue(check_diag(3, 3, 0, matrix));
		assertTrue(check_diag(4, 4, 0, matrix));
		assertTrue(check_diag(-1, 7, 0, matrix));
	}

	public boolean isComplete(DataStructure grid) {
		int color;
		int i, j;
		for (i = 0; i < grid.getHeight(); i++) {
			for (j = 0; j < grid.getWidth(); j++) {
				color = grid.getValue(i, j);
				if (color != 0) {
					if (check_line(i, j, color, grid))
						return true;
					if (check_col(i, j, color, grid))
						return true;
					if (check_diag(i, j, color, grid))
						return true;
				}
			}
		}
		return false;
	}
	
	@Test
	public void testIsComplete() {

		assertTrue(matrix.setValue(0, 1, 2));
		assertTrue(matrix.setValue(1, 1, 2));
		assertTrue(matrix.setValue(2, 1, 2));
		assertTrue(matrix.setValue(3, 1, 2));
		
		boolean result = isComplete(matrix);
		assertTrue("la grille est complète", result);
	}

	@Test
	public void testIsNotComplete() {

		assertTrue(matrix.setValue(0, 0, 0));
		assertTrue(matrix.setValue(1, 2, 0));
		assertTrue(matrix.setValue(2, 5, 0));
		assertTrue(matrix.setValue(0, 4, 0));
		
		boolean result = isComplete(matrix);
		assertFalse("la grille n'est pas complète", result);
	}
	
	public boolean check_play(int play, DataStructure grid){
		if (grid.getValue(0, play) == 0)
			return true;
		if(play>=0 && play < grid.getWidth())
			return true;
		return false;
	}
	
	@Test
	public void testCheck_play() { // un doute , voir avec dorian
		
		assertTrue(matrix.setValue(0, 0, 1));
		assertTrue(matrix.setValue(0, 1, 1));
		assertTrue(matrix.setValue(0, 2, 1));
		assertTrue(matrix.setValue(0, 3, 1));
		assertTrue(matrix.setValue(0, 4, 1));
		assertTrue(matrix.setValue(0, 5, 1));
		assertTrue(matrix.setValue(0, 6, 1));
		assertTrue(matrix.setValue(1, 6, 0));
		assertTrue(matrix.setValue(2, 6, 1));
		assertTrue(matrix.setValue(3, 6, 0));
		assertTrue(matrix.setValue(4, 6, 1));
		assertTrue(matrix.setValue(5, 6, 0));
		
		assertTrue(check_play(6, matrix)); /// ici !!!!
		
		/*assertTrue(matrix.setValue(1, 0, 1));
		assertTrue(matrix.setValue(1, 1, 1));
		assertTrue(matrix.setValue(1, 2, 1));
		assertTrue(matrix.setValue(1, 3, 1));
		assertTrue(matrix.setValue(1, 4, 1));
		assertTrue(matrix.setValue(1, 5, 1));
		assertTrue(matrix.setValue(1, 6, 1));
		
		assertFalse(matrix.setValue(1, 7, 0));
		
		assertTrue(matrix.setValue(2, 0, 1));
		assertTrue(matrix.setValue(2, 1, 1));
		assertTrue(matrix.setValue(2, 2, 1));
		assertTrue(matrix.setValue(2, 3, 1));
		assertTrue(matrix.setValue(2, 4, 1));
		assertTrue(matrix.setValue(2, 5, 1));
		assertTrue(matrix.setValue(2, 6, 1));
		assertTrue(matrix.setValue(3, 0, 1));
		assertTrue(matrix.setValue(3, 1, 1));
		assertTrue(matrix.setValue(3, 2, 1));
		assertTrue(matrix.setValue(3, 3, 1));
		assertTrue(matrix.setValue(3, 4, 1));
		assertTrue(matrix.setValue(3, 5, 1));
		assertTrue(matrix.setValue(3, 6, 1));
		assertTrue(matrix.setValue(4, 0, 1));
		assertTrue(matrix.setValue(4, 1, 1));
		assertTrue(matrix.setValue(4, 2, 1));
		assertTrue(matrix.setValue(4, 3, 1));
		assertTrue(matrix.setValue(4, 4, 1));
		assertTrue(matrix.setValue(4, 5, 1));
		assertTrue(matrix.setValue(4, 6, 1));
		assertTrue(matrix.setValue(5, 0, 1));
		assertTrue(matrix.setValue(5, 1, 1));
		assertTrue(matrix.setValue(5, 2, 1));
		assertTrue(matrix.setValue(5, 3, 1));
		assertTrue(matrix.setValue(5, 4, 1));
		assertTrue(matrix.setValue(5, 5, 1));
		assertTrue(matrix.setValue(5, 6, 1));
		*/
		
		
		
		/*assertTrue(matrix.setValue(0, 1, 1));
		assertTrue(check_play(0, matrix));
		assertTrue(check_play(1, matrix));
		assertTrue(check_play(2, matrix));
		assertTrue(check_play(6, matrix));
		
		assertTrue(matrix.setValue(1, 4, 2));
		assertTrue(check_play(1, matrix));
		
		assertTrue(matrixW2.setValue(0, 1, 2));
		assertTrue(check_play(1, matrixW2));
		
		assertTrue(matrixW6.setValue(0, 2, 0));
		
		assertFalse(matrixW7.setValue(0, 8, 0));
		
		assertTrue(matrix.setValue(0, 6, 0));*/
	}

	

}
