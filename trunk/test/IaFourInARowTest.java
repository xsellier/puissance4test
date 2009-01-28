package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.*;

public class IaFourInARowTest {

	int mode;
	
	public int main(int argc, String argv){
		DataStructure grid = new DataStructure(6,7);
		Rules rule = new FourInARow();
		Cpu Ia = new IaFourInARow();
		mode = 1; // easy mode
		mode = 2; // hard mode
		Ia.initialize(grid, mode);
		return 1;
	}
	
	@Test
	public void testInitialize() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testEasyCpu() {
		fail("Not yet implemented");
	}

	@Test
	public void testPerfectCpu() {
		fail("Not yet implemented");
	}

}
