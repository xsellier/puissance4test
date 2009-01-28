package src;

public interface Cpu {

	/* 
	 * We make an interface to may change Cpu IA
	 * int play(...);
	 * initialize and makes play Cpu
	 * 
	 * void initialize(...)
	 * choose IA difficulty
	 */
	
	public int play(int played, Rules new_rule);

	public void initialize(DataStructure grid, int difficulty);
}

