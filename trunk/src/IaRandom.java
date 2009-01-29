package src;

public class IaRandom implements Cpu {

	private int counter = 0;
	private int mode;
	/*
	 * values for mode :
	 * 1 - Switch Cpu
	 * 2 - Random Cpu
	 */
	private DataStructure grid;
	private int result = -1;
	
	public void initialize(DataStructure grid, int difficulty) {
		mode = difficulty;
		this.grid = grid;
	}

	
	public int play(Rules new_rule) {
		if(mode == 1)
			switchCpu();
		else
			randomCpu();
		return result;
	}
	
	public void switchCpu(){
		result = (counter % grid.getWidth()+2) -1;
		counter++;
	}
	
	public void randomCpu(){
		result = (int)(Math.random() * grid.getWidth());
	}
}
