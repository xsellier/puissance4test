package src;

public class CpuPlayer implements Player {

	private int mode;
	/*
	 * 0 - Human vs Human 
	 * 1 - Human vs Cpu Easy 
	 * 2 - Human vs Cpu Hard
	 */
	
	public int currently_played; // actual player
	private rules rule; // rule of 4 in a row

	public CpuPlayer(int mode, rules rule) {
		this.mode = mode;
		this.rule = rule;
	}

	public int play(DataStructure grid, GUI gui) {
		Cpu cpu1 = new Ia_foor_in_a_row();
		cpu1.initialize(grid, mode);
		currently_played = cpu1.play(gui.get_Choice(), rule);
		return currently_played;
	}
}
