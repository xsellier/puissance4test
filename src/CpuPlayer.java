package src;

public class CpuPlayer implements Player {

	private int mode;
	/*
	 * 0 - Human vs Human 
	 * 1 - Human vs Cpu Easy 
	 * 2 - Human vs Cpu Hard
	 */
	
	public int currently_played; // actual player
	private Rules rule; // rule of 4 in a row

	public CpuPlayer(int mode, Rules rule) {
		this.mode = mode;
		this.rule = rule;
	}

	public int play(DataStructure grid, GUI gui) {
		Cpu cpu1 = new IaFourInARow();
		cpu1.initialize(grid, mode);
		currently_played = cpu1.play(rule);
		return currently_played;
	}
}
