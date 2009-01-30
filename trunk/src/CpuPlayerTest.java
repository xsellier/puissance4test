package src;

public class CpuPlayerTest implements Player {

	private int mode;
	/*
	 * 1 - Cpu Random 
	 * 2 - Cpu Switch 
	 */
	
	private int currently_played=-2;
	private Rules rule; // rule of 4 in a row
	
	public CpuPlayerTest(int mode, Rules rule) {
		this.mode = mode;
		this.rule = rule;
	}

	public int play(DataStructure grid, GUI gui) {
		Cpu cpu1 = new IaRandom();
		cpu1.initialize(grid, mode);
		if(mode == 1)
			currently_played = cpu1.play(rule);
		else
			cpu1.initialize(grid, currently_played);
			currently_played = cpu1.play(rule);
		return currently_played;
	}
}
