package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.DataStructure;

public class DataStructureTest {

	DataStructure matrix;
	@Test
	public void testDataStructure() {
		matrix = new DataStructure(6,7);
		matrix.print();
	}

}
