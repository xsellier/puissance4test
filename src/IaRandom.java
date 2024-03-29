package src;

public class IaRandom implements Cpu {

	public int counter;
	private int mode;
	/*
	 * values for mode : 1 - Switch Cpu 2 - Random Cpu
	 */
	private DataStructure grid;
	private int result = -1;

	public void initialize(DataStructure grid, int difficulty) {
		if (this.grid != null)
			counter = difficulty;
		else {
			mode = difficulty;
			this.grid = grid;
		}
	}

	public int play(Rules new_rule) {
		if (mode == 1)
			randomCpu();
		else
			switchCpu();
		return result;
	}

	public void switchCpu() {
		counter++;
		if (counter > grid.getWidth()+1)
			counter = -1;
		result = counter;
		System.out.println("switchCpu try to play " + result);
	}
	
	public void randomCpu() {
		result = (int) (Math.random() * grid.getWidth());
		System.out.println("randomCpu try to play " + result);
	}
}
