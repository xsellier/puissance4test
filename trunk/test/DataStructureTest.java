package test;

import org.junit.Test;

import src.DataStructure;

public class DataStructureTest{

	DataStructure matrix;
	@Test
	public void testDataStructure() {
		matrix = new DataStructure(6,7);
		String result = "Ligne : 0 | 0 0 0 0 0 0 0\nLigne : 1 | 0 0 0 0 0 0 0\nLigne : 2 | 0 0 0 0 0 0 0\nLigne : 3 | 0 0 0 0 0 0 0\nLigne : 4 | 0 0 0 0 0 0 0\nLigne : 5 | 0 0 0 0 0 0 0\n";
		String resulttmp = print();
		assert(result.equals(resulttmp));
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
}
